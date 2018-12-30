import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'App.vue'
import VueRouter from "vue-router";
import Vuetify from 'vuetify/lib'
import 'vuetify/src/stylus/app.styl'
import 'vuetify/dist/vuetify.min.css'

const TaskView = () => import('pages/TaskView.vue');
const TaskEditDialog = () => import('components/task/TaskEditDialog.vue');

Vue.use(Vuetify, {
    theme: {
        primary: "#5B3C67",
        secondary: "#febf6f",
        accent: "#9c27b0",
        error: "#f44336",
        warning: "#ffeb3b",
        info: "#2196f3",
        success: "#4caf50"
    }
});

Vue.use(VueResource);

Vue.use(VueRouter);
const router = new VueRouter({
    routes: [
        {
            path: '/tasks',
            name: 'home',
            component: TaskView
        },
        {
            path: '/task/:id?',
            name: 'task',
            component: TaskEditDialog
        }
    ]
});

new Vue({
        el: '#app',
        router: router,
        render: c => c(App)
    }
);


