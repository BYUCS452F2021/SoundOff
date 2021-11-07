<template>
  <div>
    <div class="title">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="goBack">&laquo; Previous</button>
      <h1>{{classroom.name}}</h1>
    </div>
    <div class="studentList">
      <div v-if="students.length>0" class="studentList">
        <div v-for="item in students" v-bind:key="item.id" v-on:click="getStudents(item.id)" class="studentBox">
          <p>{{item.name}}</p>
        </div>
      </div>
      <div v-else>
        <p>No Students</p>
      </div>
    </div>
    <div v-if="type==='professor'" class="addStudents">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="addStudents">Add Students</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Classroom.vue",
  data() {
    return {
      type: this.$root.$data.user.accountType,
      classroom: this.$root.$data.currentClass,
      students: this.$root.$data.currentClass.students,
    }
  },
  created() {
    this.getStudents();
  },
  methods: {
    async addStudents() {
      try {
        let time = Date.now();
        // TODO: Add functionality to add students
        console.log("Add Students: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Add Students Failure" + error);
      }
    },
    async getStudents() {
      try {
        let time = Date.now();
        // TODO: Add functionality to get all students
        console.log("Get Students: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Get Students Failure" + error);
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

</style>