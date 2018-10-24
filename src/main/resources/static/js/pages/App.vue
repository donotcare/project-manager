<template>
    <v-app id="inspire">
        <v-toolbar color="deep-purple darken-4" dark>
            <v-toolbar-items class="hidden-sm-and-down">
                <v-btn flat>Задачи</v-btn>
                <v-btn flat>
                    <v-badge right>
                        <span slot="badge">2</span>
                        Лента сообщений
                    </v-badge>
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <task-table/>
    </v-app>
</template>

<script>
    import TaskTable from 'components/TaskTable.vue'

    export default {
        components: {
            TaskTable
        }
    }
</script>

