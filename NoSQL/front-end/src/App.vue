<template>
  <div id="app">
    <header id="header">
      <div>
        <router-link to="/">
          <p v-if="user" @click="logout">Logout<br>{{user.email}}</p>
          <p v-else>Sign Up / Login</p>
        </router-link>
      </div>
    </header>
    <router-view />
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'App',
  computed: {
    user() {
      return this.$root.$data.user;
    }
  },
  methods: {
    async logout() {
      try {
        let time = Date.now();
        await axios.delete("/api/users");
        this.$root.$data.user = null;
        console.log("Logout: " + (Date.now()-time)/1000);
      } catch (error) {
        this.$root.$data.user = null;
        console.log("Logout Failure" + error);
      }
    },
  },
}
</script>

<style>
/* Color scheme: https://paletton.com/#uid=7040u0knHs+edG7jrvYscpiuCk2 */
/* red: #e74c3c
 * blue: #277E8E
 */
* {
  margin:0;
  padding:0;
  box-sizing: border-box;
}
body {
  font-family: 'Work Sans', sans-serif;
  font-weight: 300;
  font-size: 13pt;
  background-color: darkgrey;
}
#header{
  display: flex;
  background-color: azure;
  width: 100%;
  height: 100px;
  flex-direction: row;
  justify-content: space-around;
  align-items: baseline;
  padding-top: 20px;
}

#header a:hover {
  background-color: steelblue;
}


</style>
