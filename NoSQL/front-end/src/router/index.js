import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Classes from '../views/Classes.vue'


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path: '/classes',
        name: 'classes',
        component: Classes
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router