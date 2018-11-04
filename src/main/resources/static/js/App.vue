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
                <v-btn flat right>{{username}}</v-btn>
                <v-btn flat right @click="logout">Выйти</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <router-view></router-view>
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
                username: ""
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
                this.$resource("/username").get().then(result => this.username = result.bodyText);
            },
            logout() {
                this.$resource("/logout").get();
            }
        }
    }
</script>

