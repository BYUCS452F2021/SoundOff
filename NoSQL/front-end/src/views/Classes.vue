<template>
  <div style="width: 100%">
    <h1 style="padding-top: 24px">Classes</h1>
    <div class="classList">
      <div v-for="item in classes" v-bind:key="item.id" v-on:click="getClass(item.id)" class="classBox">{{item.name}}</div>
      <div v-if="user.accountType !=='student'" class="classBox"  @click="addClass"> New Class</div>
    </div>
    <div v-if="classes.length == 0">No Classes</div>

  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "Classes",
  data() {
    return {
    }
  },
  computed: {
    user() {
      if(this.$root.$data.user) {
        return this.$root.$data.user
      }
      else if (localStorage['user']) {
        const u = JSON.parse(localStorage['user']) 
        return u
      }
      else {
        return {
          accountType: 'anon'
        }
      }
    },
    classes() {
      if(this.$root.$data.user) {
        return this.$root.$data.user.classes
      }
      else if (localStorage['user']) {
        const u = JSON.parse(localStorage['user']) 
        return u.classes
      }

      return []
    }
  },
  methods: {
    async addClass() {
      try {
        let className = prompt("Please enter your class name", "Fake Class 101 - Section 003");
        if (className === null || className === "" || className === "Fake Class 101 - Section 003" || this.user.accountType !== 'professor') {
          return;
        }
        let time = Date.now();
        let response = await axios.post('/api/classes/', {
          name: className,
          professor: this.user,
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
        let response = await axios.post('/api/classes/class', {
          classId: classID,
        });
        this.$root.$data.currentClass = response.data.queriedClass;
        localStorage['currentClass'] = JSON.stringify(response.data.queriedClass)
        console.log("Get Class: " + (Date.now()-time)/1000);
        await this.$router.push("/classroom");
      } catch (error) {
        console.log("Get Class Failure" + error.message);
      }
    },
  }
}
</script>

<style scoped>  
.classList {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 100%;
}
.classBox {
  box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
  padding: 12px 24px;
  color: #444 ;
  width: 244px;
  height: 144px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: start;
  margin-right: 16px;
  transition: .1s;
  border: 1px solid #eee;
}

.classBox:hover {
  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
  cursor: pointer;
}

button {
  border: none;
  background-color: deepskyblue;
  color: white;
  padding: 8px 24px;
  border-radius: 4px;
}
.row-flex {
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
  width: 100%;
}
</style>