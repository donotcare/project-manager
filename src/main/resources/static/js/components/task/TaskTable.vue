<template>
    <div>
        <task-filter :createItem="createItem" @input="filterUpdated($event)"></task-filter>
        <v-data-table :headers="headers" :items="tasks" class="elevation-1">
            <template slot="items" slot-scope="props">
                <tr @dblclick="editItem(props.item)">
                    <td>{{ props.item.id }}</td>
                    <td class="text-xs-left">{{ props.item.name }}</td>
                    <td class="text-xs-left">{{ props.item.status.name }}</td>
                    <td class="text-xs-left">{{props.item.created}}</td>
                    <td class="text-xs-left">{{props.item.taskDate}}</td>
                    <td class="text-xs-left">{{props.item.receiver.name}}</td>
                </tr>
            </template>
        </v-data-table>
    </div>
</template>

<script>
    import TaskFilter from 'components/task/TaskFilter.vue'

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
        created() {
            return this.$resource('/task').get().then(result =>
                result.json().then(data => data.forEach(task => this.tasks.push(task))
                )
            )
        },
        components: {
           TaskFilter
        },
        methods: {
            editItem(item) {
                const id = item.id;
                this.$router.push({ name: 'task', params: {id}})
            },
            createItem() {
                this.$router.push({ name: 'task'})
            },
            filterUpdated(event) {
                this.tasks = [];
                let path = "/task";
                if(event.id != null)
                    path += '?receiver=' + event.id;
                this.$resource(path).get().then(result =>
                    result.json().then(data => data.forEach(task => this.tasks.push(task))));
            }
        }
    }
</script>