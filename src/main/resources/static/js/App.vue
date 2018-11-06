<template>
    <v-app id="inspire">
        <v-toolbar dark color="primary">
            <v-toolbar-items>
                <v-btn flat>Задачи</v-btn>
                <v-btn flat>
                    <v-badge right color="secondary">
                        <span slot="badge">2</span>
                        Лента сообщений
                    </v-badge>
                </v-btn>
            </v-toolbar-items>
            <v-spacer></v-spacer>
            <v-toolbar-items>
                <v-btn flat right>{{login}}</v-btn>
                <v-btn flat right href="/logout">Выйти</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <v-container grid-list-md v-if="loggedOut">
            <form action="/" method="post">
                <v-text-field label="Логин" v-model="username"></v-text-field>
                <input name="username" id="username" v-model="username" type="hidden">
                <v-text-field label="Пароль" type="password" v-model="password"></v-text-field>
                <input name="password" id="password" v-model="password" type="hidden">
                <input name="submit" id="submit" value="Login" type="hidden">
                <v-btn color="primary" type="submit" value="Login">Войти</v-btn>
            </form>
        </v-container>
        <router-view v-else="loggedOut"></router-view>
    </v-app>
</template>

<script>
    import TaskTable from 'components/task/TaskTable.vue'

    export default {
        components: {
            TaskTable
        },
        data() {
            return {
                login: "",
                username: "",
                password: ""
            }
        },
        render: function (h) {
            return h(this);
        },
        created() {
            return this.getUsername();
        },
        methods: {
            getUsername() {
                this.$resource("/api/username").get().then(result => this.login = result.bodyText);
            }
        },
        computed: {
            loggedOut: {
                get() {
                    return this.login === 'Неизвестно'
                }
            }
        }
    }
</script>

