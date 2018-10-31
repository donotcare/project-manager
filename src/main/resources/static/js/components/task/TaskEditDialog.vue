<template>
    <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
        <v-card>
            <v-toolbar dark color="primary">
                <v-btn icon dark @click.native="close">
                    <v-icon>close</v-icon>
                </v-btn>
                <v-toolbar-title>Задача №{{item.id}} от {{item.created}}</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-toolbar-items>
                    <v-btn dark flat @click.native="save">Сохранить</v-btn>
                </v-toolbar-items>
            </v-toolbar>
            <v-card>
                <v-container grid-list-md>
                    <v-layout row wrap>
                        <v-flex xs12 sm6 md8>
                            <v-layout row wrap>
                                <v-flex xs12 sm6 md4>
                                    <user-combo label="Исполнитель" v-model="item.receiver"></user-combo>
                                </v-flex>
                                <v-flex xs12 sm6 md4>
                                    <user-combo label="Автор" disabled v-model="item.author"></user-combo>
                                </v-flex>
                                <v-flex xs12 sm6 md4>
                                    <user-combo label="Статус" value = "Активная" disabled></user-combo>
                                </v-flex>
                            </v-layout>
                            <v-layout row>
                                <v-flex xs12 sm6 md6>
                                    <date-time-picker label="Дата исполнения" v-model="item.taskDate"></date-time-picker>
                                </v-flex>
                                <v-flex xs12 sm6 md6 d-inline-flex>
                                    <v-text-field label="Следующее напоминание" disabled></v-text-field>
                                    <v-btn color="secondary">Настроить напоминания</v-btn>
                                </v-flex>
                            </v-layout>
                            <v-textarea name="input-7-1" box label="Описание" auto-grow v-model="item.name">
                            </v-textarea>
                            <v-divider></v-divider>
                            <task-chat :taskId="item.id"></task-chat>
                        </v-flex>
                        <uploader @change="onChange">
                            <v-btn color="primary">Загрузить файл</v-btn>
                        </uploader>
                    </v-layout>
                </v-container>
            </v-card>
        </v-card>
    </v-dialog>
</template>

<script>
    import DateTimePicker from 'components/common/DateTimePicker.vue'
    import UserCombo from 'components/common/UserCombo.vue'
    import Uploader from 'components/common/Uploader.vue'
    import TaskChat from 'components/task/TaskChat.vue'

    export default {
        components: {
            DateTimePicker, UserCombo, TaskChat, Uploader
        },
        props: ['dialog', 'item', 'close', 'save'],
        methods: {
            onChange(event) {
                console.log(event);
                var formData = new FormData();
                formData.append('file', event);
                this.$resource('/file/').save({}, formData);
            }
        }
    }
</script>