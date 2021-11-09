<template>
  <div>
    <div class="title">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="goBack">&laquo; Previous</button>
      <h1>{{classroom.name}}</h1>
    </div>
    <div class="studentList">
      <div v-if="students.length>0 && type==='professor'" class="studentList">
        <div v-for="item in students" v-bind:key="item.id" v-on:click="getStudents(item.id)" class="studentBox">
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
  </div>
</template>

<script>

import axios from "axios";
import Multiselect from 'vue-multiselect';

export default {
  name: "Classroom.vue",
  components: {
    Multiselect
  },
  data() {
    return {
      type: this.$root.$data.user.accountType,
      classroom: this.$root.$data.currentClass,
      students: this.$root.$data.currentClass.students,
      possibleStudents: [],
      studentsToAdd: [],
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
    }
  },
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>

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