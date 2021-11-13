<template>
  <div>
    <div class="title">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="goBack">&laquo; Previous</button>
      <h1>{{classroom.name}}</h1>
    </div>
    <div class="studentList">
      <div v-if="students.length>0 && type==='professor'" class="studentList">
        <div v-for="item in students" v-bind:key="item.id" class="studentBox">
          <p>{{item.name}}</p>
        </div>
      </div>
      <div v-else>
        <p>No Students</p>
      </div>
    </div>
    <div v-if="type==='professor'" class="addStudents">
      <multiselect id="multi" class="selector" v-model="studentsToAdd" :options="possibleStudents" placeholder="Select Students" label="email" track-by="id" :multiple="true" :clear-on-select="false" :close-on-select="false"></multiselect>
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="addStudents">Add Students</button>
    </div>

    <div class="LectureList">
      <p v-if="type==='student'">{{presentLectures}}/{{lectures.length}}</p>
      <div v-if="lectures.length>0" class="studentList">
        <div v-for="item in lectures" v-bind:key="item.code" class="studentBox">
          <p>{{item.startTime}}</p>
          <p v-if="type==='professor'">{{item.code}}</p>
          <p v-if="type==='student'">{{item.present}}/1</p>
        </div>
      </div>
      <div v-else>
        <p>No Students</p>
      </div>
    </div>


    <div v-if="type==='professor'" class="addStudents">
      <Datepicker class="dateBox" placeholder="Select a Lecture Date" v-model="lectureDate"></Datepicker>
      <vue-timepicker placeholder="Start Time" v-model="startTime"></vue-timepicker>
      <vue-timepicker placeholder="End Time" v-model="endTime"></vue-timepicker>
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="createLecture">Create Lecture</button>
    </div>

    <div v-if="type==='student'" class="addStudents">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="attendLecture">Attend Lecture</button>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import Multiselect from 'vue-multiselect';
import Datepicker from 'vuejs-datepicker';
import VueTimepicker from 'vue2-timepicker'

export default {
  name: "Classroom.vue",
  components: {
    Multiselect,
    Datepicker,
    VueTimepicker,
  },
  data() {
    return {
      type: this.$root.$data.user.accountType,
      classroom: this.$root.$data.currentClass,
      students: this.$root.$data.currentClass.students,
      possibleStudents: [],
      studentsToAdd: [],
      lectures: this.$root.$data.currentClass.lectures,
      presentLectures: 0,
      lectureDate: '',
      startTime: {
        hh: '',
        mm: '',
      },
      endTime: {
        hh: '',
        mm: '',
      }
    }
  },
  created() {
    this.getStudents();
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
        await this.$router.push({path: 'classroom'});
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
        let endTime = this.lectureDate + this.endTime;
        let startTime = this.lectureDate + this.startTime;
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
        console.log("Get Students: " + (Date.now()-time)/1000);
        window.alert(code.toString());
      } catch (error) {
        console.log("Get Students Failure:" + error);
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
        console.log("Get Students: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Get Students Failure:" + error);
      }
    },
    async isPresent() {
      let totalLectures = this.lectures.length;
      let presentLectures = 0;
      if (this.type === "student" && totalLectures > 0) {
        try {
          for (let i = 0; i < totalLectures; i++) {
            if(this.lectures[i].code) {
              let found = this.$root.$data.user.attendances.find(this.lectures[i].code);
              if(found) {
                this.lectures.present = 1;
                presentLectures += 1;
              }
              else {
                this.lectures.present = 0;
              }
            }
          }
        } catch (error) {
          console.log("Attendance Calculation Error:" + error);
        }
      }
      this.presentLectures = presentLectures;

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