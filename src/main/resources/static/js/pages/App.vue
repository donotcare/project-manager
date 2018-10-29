<template>
    <v-app id="inspire">
        <v-toolbar dark color="primary">
            <v-toolbar-items class="hidden-sm-and-down">
                <v-btn flat>Задачи</v-btn>
                <v-btn flat>
                    <v-badge right color="secondary">
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
    import TaskTable from 'components/task/TaskTable.vue'

    export default {
        components: {
            TaskTable
        }
    }
</script>

