<template>
    <div>
        <v-layout row>
            <v-text-field ref="message" label="Новое сообщение" v-model="text"></v-text-field>
            <v-btn color="primary" @click="create()">Отправить</v-btn>
        </v-layout>
        <v-list>
            <v-list-tile v-for="item in messages" :key="item.text">
                <v-list-tile-content>
                    <v-list-tile-title v-text="item.text"></v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                messages: [],
                text:""
            }
        },
        props: ['taskId'],
        methods: {
            create() {
                var path = "task/" + this.taskId + "/message";
                console.log(this.text);
                this.$resource(path).save({}, this.text).then(result => this.$resource(path).get().then(result =>
                    result.json().then(data => {this.messages = data; this.text =""})));
            }
        }
    }
</script>