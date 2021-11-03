<template>
  <div class="hero">
    <div class="heroBox">
      <form class="pure-form">
        <fieldset>
          <legend>Register for an account</legend>
          <input placeholder="Name" v-model="name">
          <input placeholder="Email" v-model="email">
        </fieldset>
        <fieldset>
          <vue-single-select
              v-model="type"
              :options="['student','professor']"
              placeholder="professor or student"
          ></vue-single-select>
          <input type="password" placeholder="password" v-model="password">
        </fieldset>
        <fieldset>
          <button type="submit" class="pure-button pure-button-primary" @click.prevent="register">Register</button>
        </fieldset>
      </form>
      <p v-if="error" class="error">{{error}}</p>
      <form class="pure-form space-above">
        <fieldset>
          <legend>Login</legend>
          <input placeholder="email" v-model="emailLogin">
          <input type="password" placeholder="password" v-model="passwordLogin">
        </fieldset>
        <fieldset>
          <button type="submit" class="pure-button pure-button-primary" @click.prevent="login">Login</button>
        </fieldset>
      </form>
      <p v-if="errorLogin" class="error">{{errorLogin}}</p>
    </div>
  </div>
</template>


<script>
import axios from 'axios';
import VueSingleSelect from "vue-single-select";
export default {
  name: 'HomePage',
  components: {
    VueSingleSelect
  },
  data() {
    return {
      name: '',
      email: '',
      type: '',
      password: '',
      emailLogin: '',
      passwordLogin: '',
      error: '',
      errorLogin: '',
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
      this.error = '';
      this.errorLogin = '';
      if (!this.emailLogin || !this.passwordLogin)
        return;
      try {
        let time = Date.now();
        let response = await axios.post('/api/users/login', {
          email: this.emailLogin,
          password: this.passwordLogin,
        });
        this.$root.$data.user = response.data.user;
        console.log("Login: " + (Date.now()-time)/1000);
        await this.$router.push({path: 'classes'});
      } catch (error) {
        this.errorLogin = "Error: " + error.response.data.message;
        this.$root.$data.user = null;
        console.log("Login Failure" + error);
      }
    },
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
</style>