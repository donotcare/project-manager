<template>
    <div>
        <v-data-table :headers="headers" :items="tasks" class="elevation-1">
            <template slot="items" slot-scope="props">
                <tr @dblclick="editItem(props.item)">
                    <td>{{ props.item.id }}</td>
                    <td class="text-xs-left">{{ props.item.name }}</td>
                    <td class="text-xs-left">Активна</td>
                    <td class="text-xs-left">19.10.2018 22:59</td>
                    <td class="text-xs-left">19.10.2018 22:59</td>
                    <td class="text-xs-left">Иванов</td>
                </tr>
            </template>
        </v-data-table>
        <task-edit-dialog :dialog=dialog :item=item></task-edit-dialog>
    </div>
</template>

<script>
    import TaskEditDialog from 'components/TaskEditDialog.vue'

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
                item: {
                    id: 0,
                    name: '',
                    status: 'Новый',
                    creationDate: '19.10.2018 22:59',
                    expiringDate: '19.10.2018 22:59',
                    receiver: 'Иванов'
                },
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
            TaskEditDialog
        },
        methods: {
            editItem(item) {
                this.item = item;
                this.dialog = false;
                this.dialog = true;
            }
        }
    }
</script>