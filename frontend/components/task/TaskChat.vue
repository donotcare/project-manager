<template>
  <div>
    <v-layout row>
      <v-text-field ref="message" label="Новое сообщение" v-model="text"></v-text-field>
      <v-btn color="primary" @click="create()">Отправить</v-btn>
    </v-layout>
    <v-list>
      <template v-for="message in orderedUsers">
        <v-list-tile>
          <v-list-tile-content>
            <v-list-tile-title>{{message.created}} {{message.author.name}}</v-list-tile-title>
            <v-list-tile-sub-title>{{message.text}}</v-list-tile-sub-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-divider></v-divider>
      </template>
    </v-list>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        messages: [],
        text: ""
      }
    },
    props: ['taskId'],
    methods: {
      async create() {
        console.log(this.text);
        await this.$api.post(`/api/task/${this.taskId}/message`, {body: this.text});
        this.text = "";
        const [messages] = await this.$api.get(`/api/task/${this.taskId}/message`);
        this.messages = messages;

      }
    },
    computed: {
      orderedUsers: function () {
        return this.messages.sort((a, b) => b.id - a.id);
      }
    }
  }
</script>
