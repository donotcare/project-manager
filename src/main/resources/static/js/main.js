import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'App.vue'
import TaskView from 'pages/TaskView.vue'
import TaskEditDialog from 'components/task/TaskEditDialog.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import VueRouter from "vue-router";

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
            path: '/',
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


