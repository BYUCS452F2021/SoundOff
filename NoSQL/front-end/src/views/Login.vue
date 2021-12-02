<template>
  <div id="login-container">
    <Card>
      <h2 slot="header" style="width: 528px">{{showSignUp ? 'Sign Up': 'Login'}}</h2>
      <div slot="body" class="col-flex">
        <TextField v-model="email" label="Email"></TextField>
        <br>
        <TextField :hidden="true"  v-model="password" label="Password"></TextField>
        <br v-if="showSignUp">
        <div class="row-flex" v-if="showSignUp"> 
          <TextField v-model="name" label="Name"></TextField>
          <div style="width: 16px" ></div>
          <vue-single-select
              v-model="type"
              :options="['student','professor']"
              placeholder="Role"
          ></vue-single-select>
        </div>
      </div>
      <div class="row-flex" style="justify-content: flex-end; align-items: center" slot="actions">
        <div style="color: red; font-size: 12px">{{errorLogin}}</div>
        <div style="color: red; font-size: 12px">{{error}}</div>
        <div style="width: 48px"></div> 
        <button class="accent-button" @click="signUpClick">Sign Up</button>
        <div style="width: 8px"></div> 
        <button @click="login">Login</button>
      </div>
    </Card>
  </div>
</template>


<script>
import axios from 'axios';
import VueSingleSelect from "vue-single-select";
import TextField from '../components/TextField.vue'
import Card from '../components/Card.vue'
export default {
  name: 'HomePage',
  components: {
    VueSingleSelect,
    TextField,
    Card
  },
  data() {
    return {
      name: '',
      email: '',
      type: '',
      password: '',
      error: '',
      errorLogin: '',
      showSignUp: false
    }
  },
  methods: {
    async register() {
      this.error = '';
      this.errorLogin = '';
      if (!this.name || !this.email || !this.type || !this.password)
        return;
      try {
        let time = Date.now();
        let response = await axios.post('/api/users', {
          name: this.name,
          email: this.email,
          type: this.type,
          password: this.password,
        });
        this.$root.$data.user = response.data.user;
        console.log("Register: " +(Date.now()-time)/1000);
        await this.$router.push({path: 'classes'});
      } catch (error) {
        this.error = error.response.data.message;
        this.$root.$data.user = null;
        console.log("Registration Failure" + error);
      }
    },
    async login() {
      console.log('login up')
      this.showSignUp = false
      this.error = '';
      this.errorLogin = '';
      if (!this.email || !this.password)
        return;
      try {
        let time = Date.now();
        let response = await axios.post('/api/users/login', {
          email: this.email,
          password: this.password,
        });
        this.$root.$data.user = response.data.user;
        console.log("Login: " + (Date.now()-time)/1000);
        localStorage['user'] = JSON.stringify(response.data.user)
        await this.$router.push({path: 'classes'});
      } catch (error) {
        this.errorLogin = "Error: " + error.response.data.message;
        this.$root.$data.user = null;
        console.log("Login Failure" + error);
      }
    },
    signUpClick() {
      if(!this.showSignUp) 
        this.showSignUp = true
      else {
        console.log('register')
        this.register()
      }
    }
  }

}
</script>

<style scoped>
.space-above {
  margin-top: 50px;
}

h1 {
  font-size: 28px;
  font-variant: capitalize;
}

.hero {
  padding: 120px;
  display: flex;
  justify-content: center;
}

.heroBox {
  text-align: center;
}

.hero form {
  font-size: 14px;
}

.hero form legend {
  font-size: 20px;
}

input {
  margin-right: 10px;
}

.error {
  margin-top: 10px;
  display: inline;
  padding: 5px 20px;
  border-radius: 30px;
  font-size: 10px;
  background-color: #d9534f;
  color: #fff;
}

#login-container {
  display: flex;
  height: 84vh;
  width: 100%;
  background-color: white;
  justify-content: center;
  align-items: center;
}

.row-flex {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: flex-start;
  width: 100%;
}

.col-flex {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 100%;
}

.accent-button {
  background-color: #444;
  color: white;
}

button {
  border: none;
  background-color: deepskyblue;
  color: white;
  padding: 8px 24px;
  border-radius: 4px;
}
</style>