<template>
    <div>
        <task-filter :createItem="createItem" @input="filterUpdated($event)"></task-filter>
        <v-data-table :headers="headers" :items="tasks" class="elevation-1">
            <template slot="items" slot-scope="props">
                <tr @dblclick="editItem(props.item)">
                    <td>{{ props.item.id }}</td>
                    <td class="text-xs-left">{{ props.item.name }}</td>
                    <td class="text-xs-left">{{ props.item.status }}</td>
                    <td class="text-xs-left">{{props.item.created}}</td>
                    <td class="text-xs-left">{{props.item.taskDate}}</td>
                    <td class="text-xs-left">{{props.item.receiver.name}}</td>
                </tr>
            </template>
        </v-data-table>
        <task-edit-dialog :dialog=dialog :item=item :close="closeDialog" :save="saveDialog"></task-edit-dialog>
    </div>
</template>

<script>
    import TaskFilter from 'components/task/TaskFilter.vue'
    import TaskEditDialog from 'components/task/TaskEditDialog.vue'

    export default {
        data() {
            return {
                tasks: [],
                headers: [{text: 'ID', value: 'id'},
                    {text: 'Задача', value: 'name'},
                    {text: 'Статус', value: 'status'},
                    {text: 'Дата создания', value: 'creationDate'},
                    {text: 'Дата исполнения', value: 'expiringDate'},
                    {text: 'Исполнитель', value: 'receiver'}],
                item: {},
                dialog: false
            }
        },
        mounted() {
            return this.$resource('/task').get().then(result =>
                result.json().then(data => data.forEach(task => this.tasks.push(task))
                )
            )
        },
        components: {
            TaskEditDialog, TaskFilter
        },
        methods: {
            editItem(item) {
                this.$resource('/task/' + item.id).get().then(result =>
                    result.json().then(data => {
                        this.item = data;
                        this.dialog = true;
                    }));
            },
            createItem() {
                this.item = this.getDefaultItem();
                this.dialog = true;
            },
            closeDialog() {
                this.dialog = false;
            },
            saveDialog() {
                this.dialog = false;
                this.$resource('/task/' + this.item.id).update({}, this.item);
            },
            getDefaultItem() {
                return {
                    id: 0,
                    name: '',
                    status: 'Новый',
                    creationDate: '19.10.2018 22:59',
                    expiringDate: '19.10.2018 22:59',
                    receiver: ''
                }
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