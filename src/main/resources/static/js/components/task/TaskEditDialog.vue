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
                        <v-flex xs12 sm6 md6>
                            <user-combo label="Исполнитель" v-model="item.receiver"></user-combo>
                        </v-flex>
                        <v-flex xs12 sm6 md6>
                            <user-combo label="Автор" disabled v-model="item.author"></user-combo>
                        </v-flex>
                    </v-layout>
                    <v-layout row>
                        <v-flex xs12 sm6 md6>
                            <date-picker label="Дата исполнения" v-model="item.taskDate"></date-picker>
                        </v-flex>
                        <v-flex xs12 sm6 md6 d-inline-flex>
                            <v-text-field label="Следующее напоминание" disabled></v-text-field>
                            <v-btn color="primary">Настроить напоминания</v-btn>
                        </v-flex>
                    </v-layout>
                    <v-textarea name="input-7-1" box label="Описание" auto-grow v-model="item.name">
                    </v-textarea>
                    <v-divider></v-divider>
                    <uploader @change="onChange"><v-btn >Загрузить файл</v-btn></uploader>
                    <task-chat :taskId="item.id"></task-chat>
                </v-container>
            </v-card>
        </v-card>
    </v-dialog>
</template>

<script>
    import DatePicker from 'components/common/DatePicker.vue'
    import UserCombo from 'components/common/UserCombo.vue'
    import Uploader from 'components/common/Uploader.vue'
    import TaskChat from 'components/task/TaskChat.vue'

    export default {
        components: {
            DatePicker, UserCombo, TaskChat, Uploader
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