<template>
  <div>
    <div class="title">
      <h1>Classes</h1>
    </div>
    <div class="classList">
      <div v-if="classes.length>0" class="classList">
        <div v-for="item in classes" v-bind:key="item.id" v-on:click="getClass(item.id)" class="classBox">
          <p>{{item.name}}</p>
        </div>
      </div>
      <div v-else>
        <p>No Classes</p>
      </div>
    </div>
    <div v-if="type==='professor'" class="addClass">
      <button type="submit" class="pure-button pure-button-primary" @click.prevent="addClass">Add Class</button>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "Classes",
  data() {
    return {
      type: this.$root.$data.user.accountType,
      classes: this.$root.$data.user.classes,
    }
  },
  methods: {
    async addClass() {
      try {
        let className = prompt("Please enter your class name", "Fake Class 101 - Section 003");
        if (className === null || className === "" || className === "Fake Class 101 - Section 003" || this.type !== 'professor') {
          return;
        }
        let time = Date.now();
        console.log(this.$root.$data.user);
        let response = await axios.post('/api/classes/', {
          name: className,
          professor: this.$root.$data.user,
        });
        this.$root.$data.user = response.data.user;
        console.log("Add Class: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Add Class Failure" + error);
      }
    },
    async getClass(classID) {
      try {
        let time = Date.now();
        console.log(classID);
        let response = await axios.post('/api/classes/class', {
          classId: classID,
        });
        this.$root.$data.currentClass = response.data.queriedClass;
        console.log("Get Class: " + (Date.now()-time)/1000);
        await this.$router.push({path: 'classroom'});
      } catch (error) {
        console.log("Get Class Failure" + error.message);
      }
    },
  }
}
</script>

<style scoped>
.title, .classList{
  text-align: center;
  padding-top: 30px;
}
.addClass {
  align-content: center;
  text-align: center;
}
.classList {
  display: flex;
  align-content: space-around;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  flex-direction: column;
  padding: 10px;
}
.classBox {
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
.classBox:hover {
  transform: scale(1.1);
  transition-duration: 100ms;
}
</style>