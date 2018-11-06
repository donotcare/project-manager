<template>
    <v-layout row justify-center>
        <v-dialog v-model="dialog" max-width="800px" primary-title>
            <v-card>
                <v-container grid-list-md>
                    <v-card-title>
                        <span class="headline">Напоминания</span>
                    </v-card-title>
                    <v-layout row>
                        <v-flex xs12 sm6 md5>
                            <date-time-picker label="Начальная дата" v-model="startDate"></date-time-picker>
                        </v-flex>
                        <v-flex xs12 sm6 md5>
                           <notification-repeat-combo v-model="repeat"></notification-repeat-combo>
                        </v-flex>
                        <v-flex xs12 sm6 md2>
                            <v-btn color="primary" class="text-xs-center" @click="addNotification">Добавить</v-btn>
                        </v-flex>
                    </v-layout>
                    <notification-table v-model="notifications"></notification-table>
                </v-container>
            </v-card>
        </v-dialog>
    </v-layout>
</template>
<script>
    import DateTimePicker from "components/common/DateTimePicker.vue";
    import NotificationRepeatCombo from "components/common/NotificationRepeatCombo.vue";
    import NotificationTable from "components/task/notification/NotificationTable.vue"

    export default {
        components: {DateTimePicker, NotificationTable, NotificationRepeatCombo},
        props: ['value', 'taskId', 'notifications'],
        data() {
            return {
                repeat: {id: 'NONE', name: 'Нет'},
                startDate: new Date().toISOString().slice(0, 10) + " 12:00",
            };
        },
        computed: {
            dialog: {
                get() {
                    return this.value
                },
                set(val) {
                    this.$emit('input', val)
                }
            }
        },
        watch: {"dialog":"getNotifications"},
        methods: {
            addNotification() {
                this.notifications.push({taskId: this.taskId, startDate: this.startDate, repeat: this.repeat});
            },
            getNotifications() {
                if(this.dialog && this.taskId != null) {
                    this.$resource('/api/task/' + this.taskId + '/notification').get().then(result =>
                        result.json().then(data => data.forEach(notification => this.notifications.push(notification))
                        ));
                }
            }
        }
    }
</script>