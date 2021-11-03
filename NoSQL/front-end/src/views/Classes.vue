<template>
  <div>
    <div class="title">
      <h1>Classes</h1>
    </div>
    <div class="classList">
      <p v-if="classes.length>0">class</p>
      <p v-else>No Classes</p>
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
        let response = await axios.post('/api/classes/post', {
          name: className,
          professor: this.$root.$data.user,
        });
        this.$root.$data.user = response.data.user;
        console.log("Add Class: " + (Date.now()-time)/1000);
      } catch (error) {
        console.log("Add Class Failure" + error);
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
</style>