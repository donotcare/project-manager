<template>
  <span>
     <task-filter :createItem="createItem" @input="filterUpdated($event)"></task-filter>
    <v-data-table :headers="headers" :items="tasks" class="elevation-1">
      <template slot="items" slot-scope="props">
        <tr @dblclick="editItem(props.item.id)">
          <td>{{ props.item.id }}</td>
          <td class="text-xs-left">{{ props.item.name }}</td>
          <td class="text-xs-left">{{ props.item.status.name}}</td>
          <td class="text-xs-left">{{props.item.created}}</td>
          <td class="text-xs-left">{{props.item.taskDate}}</td>
          <td class="text-xs-left">{{props.item.receiver.name}}</td>
        </tr>
      </template>
    </v-data-table>
    <v-dialog :value="currentId" fullscreen hide-overlay transition="dialog-bottom-transition">
      <nuxt-child @reload-tasks="getData(params)" :id="currentId" v-if="currentId"/>
    </v-dialog>
  </span>
</template>

<script>
  import TaskFilter from '~/components/task/TaskFilter.vue'

  export default {
    data() {
      return {
        tasks: [],
        headers: [{text: 'ID', value: 'id'},
          {text: 'Задача', value: 'name'},
          {text: 'Статус', value: 'status'},
          {text: 'Дата создания', value: 'creationDate'},
          {text: 'Дата исполнения', value: 'expiringDate'},
          {text: 'Исполнитель', value: 'receiver'}]
      }
    },
    async created() {
      let [tasks] = await this.$api.get('/api/task');
      this.tasks = tasks;
    },
    components: {
      TaskFilter
    },
    computed: {
      currentId() {
        return this.$route.params.id;
      }
    },
    methods: {
      editItem(id) {
        this.$router.push(`/task/${id}`);
      },
      createItem() {
        this.$router.push({name: 'task'})
      },
      async filterUpdated(event) {
        const params = {receiver: null};
        params.receiver = event.id;
        const [tasks] = await this.$api.get('/api/task', {params});
        this.tasks = tasks;
      }
    }
  }
</script>
