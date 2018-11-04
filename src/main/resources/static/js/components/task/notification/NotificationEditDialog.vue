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
                            <v-combobox label="Повторять" :items="repeatStatuses" v-model="repeat"></v-combobox>
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
    import NotificationTable from "components/task/notification/NotificationTable.vue"

    export default {
        components: {DateTimePicker, NotificationTable},
        props: ['value'],
        data() {
            return {
                repeat: 'Нет',
                startDate: new Date().toISOString().slice(0, 10) + " 12:00",
                notifications: [],
                repeatStatuses: [
                    'Нет',
                    'Раз в час',
                    'Раз в день',
                ]
            };
        }, created() {
            console.log('create');
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
        methods: {
            addNotification() {
                this.notifications.push({startDate: this.startDate, repeat: this.repeat});
            }
        }
    }
</script>