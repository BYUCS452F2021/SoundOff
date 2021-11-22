<template>
  <div style="width: 100%">
    <div class="title">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="goBack">&laquo; Previous</button>
      <h1>{{classroom.name}}</h1>
    </div>
    <div class="studentList">
      <div v-if="students.length>0 && user.accountType==='professor'" class="studentList">
        <div v-for="item in students" v-bind:key="item.id" class="studentBox">
          <p>{{item.name}}</p>
          <p>{{item.email}}</p>
          <button type="submit" class="pure-button pure-button-primary" @click.prevent="downloadStudentReport(item._id)">Download Attendance</button>
          <br>
          <button class="pure-button pure-button-primary" @click="removeStudent(item)">Remove From Class</button>
          <!--<p>Lectures Present: {{item.attendances.length}}/{{lectures.length}} ({{(item.attendances.length/lectures.length)*100}}%)</p>-->
        </div>
      </div>
      <div v-else>
        <p>No Students</p>
      </div>
    </div>
    <div v-if="user.accountType==='professor'" class="addStudents">
      <multiselect id="multi" class="selector" v-model="studentsToAdd" :options="possibleStudents" placeholder="Select Students" label="email" track-by="id" :multiple="true" :clear-on-select="false" :close-on-select="false"></multiselect>
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="addStudents">Add Students</button>
    </div>

    <div class="LectureList">
      <p v-if="user.accountType==='student'">Lectures Present: {{presentLectures}}/{{lectures.length}} ({{(presentLectures/lectures.length)*100}}%)</p>
      <div v-if="lectures.length>0" class="studentList">
        <div v-for="item in lectures" v-bind:key="item.code" class="studentBox">
          <p>{{moment(item.startTime)}} - {{moment(item.endTime)}}</p>
          <p v-if="user.accountType==='professor'">Code: {{item.code}}</p>
        </div>
      </div>
      <div v-else>
        <p>No Students</p>
      </div>
    </div>

    <div v-if="user.accountType==='professor'" class="addStudents">
      <Datepicker class="dateBox" placeholder="Select a Lecture Date" v-model="lectureDate"></Datepicker>
      <vue-timepicker placeholder="Start Time" v-model="startTime"></vue-timepicker>
      <vue-timepicker placeholder="End Time" v-model="endTime"></vue-timepicker>
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="createLecture">Create Lecture</button>
    </div>

    <div v-if="user.accountType==='student'" class="addStudents">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="attendLecture">Attend Lecture</button>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import Multiselect from 'vue-multiselect';
import Datepicker from 'vuejs-datepicker';
import VueTimepicker from 'vue2-timepicker';
import moment from 'moment';

export default {
  name: "Classroom.vue",
  components: {
    Multiselect,
    Datepicker,
    VueTimepicker,
  },
  data() {
    return {
      possibleStudents: [],
      studentsToAdd: [],
      lectureDate: moment(this.lectureDate).format('MM/DD/YYYY'),
      startTime: {
        HH: '00',
        mm: '00',
      },
      endTime: {
        HH: '01',
        mm: '00',
      }
    }
  },
  created() {
    this.getStudents();
  },
  computed: {
    user() {
      if(this.$root.$data.user) {
        return this.$root.$data.user
      }
      else if (localStorage['user']) {
        return JSON.parse(localStorage['user'])
      }
      
      return {}
    },
    classroom() {
      if(this.$root.$data.currentClass) {
        return this.$root.$data.currentClass
      }
      else if(localStorage['currentClass']) {
        return JSON.parse(localStorage['currentClass'])
      } 

      return {}
    },
    students() {
      if(this.$root.$data.currentClass) {
        return this.$root.$data.currentClass.students
      }
      else if(localStorage['currentClass']) {
        return JSON.parse(localStorage['currentClass']).students
      }

      return []
    },
    lectures() {
      if(this.$root.$data.currentClass) {
        return this.$root.$data.currentClass.lectures
      }
      else if(localStorage['currentClass']) {
        return JSON.parse(localStorage['currentClass']).lectures
      }
      
      return []
    },
    presentLectures() {
      if(this.$root.$data.user) {
        return this.$root.$data.user.attendances.length
      }
      else if (localStorage['user']) {
        return JSON.parse(localStorage['user']).attendances.length
      }
      
      return []

    }
  },
  methods: {
    async addStudents() {
      try {
        let time = Date.now();
        if(!this.studentsToAdd || !this.classroom) {
          return;
        }
        let response = await axios.post('/api/classes/addStudents', {
          students: this.studentsToAdd,
          classroom: this.classroom,
        });
        this.$root.$data.currentClass = response.data.queriedClass;
        console.log("Add Students to Class: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Add Students Failure:" + error);
      }
    },
    async getStudents() {
      try {
        let time = Date.now();
        let response = await axios.post('/api/users/students');
        this.possibleStudents = response.data.possibleStudents;
        console.log("Get Students: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Get Students Failure:" + error);
      }
    },
    async goBack() {
      try {
        await this.$router.push({path: 'classes'});
      } catch (error) {
        console.log(error);
      }
    },
    async createLecture() {
      try {
        let date = new Date(this.lectureDate.toString());
        console.log(date);

        let startTime = date.setHours(this.startTime.HH, this.startTime.mm);
        let endTime = date.setHours(this.endTime.HH, this.endTime.mm);

        let time = Date.now();
        if(!startTime || !this.classroom || !endTime) {
          return;
        }
        let response = await axios.post('/api/classes/lecture', {
          classroom: this.classroom,
          startTime: startTime,
          endTime: endTime,
        });
        this.$root.$data.currentClass = response.data.queriedClass;
        let code = response.data.code;
        console.log("Create Lecture: " + (Date.now()-time)/1000);
        window.alert(code.toString());
      } catch (error) {
        console.log("Create Lecture Failure:" + error);
      }
    },
    async attendLecture() {
      try {
        let code = prompt("Please enter your lecture code", "Fake Code: 4356");
        let time = Date.now();
        if(code === 'Fake Code: 4356' || !this.classroom._id || !this.$root.$data.user._id) {
          return;
        }
        let response = await axios.post('/api/classes/addAttendance', {
          classID: this.classroom._id,
          code: code,
          studentID: this.$root.$data.user._id,
        });
        this.$root.$data.user = response.data.student;
        console.log("Attend Lecture: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Attend Lecture Failure:" + error);
      }
    },
    async isPresent(id) {
      try {
        let time = Date.now();
        let attendance = 0;

        // TODO: Calculate a student's attendance (needs to be called by downloadStudentReport and classAttendanceReport)
        for(let student in this.possibleStudents) {
          if(student._id === id) {
            for(let item in student.attendances) {
              for(let lecture in this.lectures) {
                if(item.code === lecture.code) {
                  attendance = attendance + 1;
                }
              }
            }
          }
        }
        console.log("Attendance Calculated: " + (Date.now()-time)/1000);
        return attendance;
      } catch (error) {
        console.log("Attendance Calculation Error: " + error);
      }
    },
    async downloadStudentReport(id) {
      try {
        let time = Date.now();

        let attendance = await this.isPresent(id);
        // TODO: download a student's attendance report
        console.log(id + " Attendance: " + attendance);

        console.log("Download Student Attendance Report: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Download Student Attendance Report Failure:" + error);
      }
    },
    async classAttendanceReport() {
      try {
        let time = Date.now();

        // TODO: Generate class attendance report

        console.log("Class Attendance Report: " + (Date.now()-time/1000))
      } catch (error) {
        console.log("Class Attendance Report Error: " + error);
      }
    },
    moment(time) {
      return moment(time).format('MMMM DD YYYY, h:mm a');
    },
    async removeStudent(student) {

      const resp = await axios.delete(`api/classes/enrollment/${this.classroom._id}/${student._id}`)
      
      if(resp.status === 200) {
        const list = [...this.students]
        const newArr = []

        list.forEach(s => {
          if(s._id != student._id) 
            newArr.push({...s})
        })

        this.students = newArr
      }
    }
  },
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style src="vue2-timepicker/dist/VueTimepicker.css"></style>

<style scoped>
.title, .studentList{
  text-align: center;
  padding-top: 30px;
}
.addStudents {
  align-content: center;
  text-align: center;
}
.studentList {
  display: flex;
  align-content: space-around;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  flex-direction: column;
  padding: 10px;
}
.studentBox {
  background-color: #d9534f;
  width: 80%;
  max-width: 500px;
  display: flex;
  align-content: center;
  justify-content: center;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  border-radius: 10px;
}
.studentBox:hover {
  transform: scale(1.1);
  transition-duration: 100ms;
}
.selector {
  width: 70%;
  margin: 10px;
}

</style>