<template>
  <div id="app">
    <header id="header">
      <h2>Sound Off</h2>
      <div>
        <router-link to="/">
          {{user ? 'Sign Out' : 'Home'}}
        </router-link>
      </div>
    </header>
    <div id="router-container">
      <router-view />
    </div>
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
        localStorage.clear()
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
}
#header{
  display: flex;
  width: 100vw;  
  justify-content: space-between;
  align-items: center;
  padding: 16px 24px;
  background-color: #444;
  color: white;
}

#header h2 {
  margin: 0px;
}

#header a {
  color: deepskyblue;
  text-decoration: none;
}

#app {
  display: flex;
  min-width: 100vw;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  min-height: 100vh;
}

#router-container {
  max-width: 1200px;
  width: 100vw;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
}


</style>
