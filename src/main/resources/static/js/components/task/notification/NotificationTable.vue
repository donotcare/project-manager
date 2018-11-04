<template>
    <v-data-table :headers="headers" :items="value" hide-actions>
        <template slot="items" slot-scope="props">
            <tr>
                <td>{{ props.item.startDate }}</td>
                <td>{{ props.item.repeat }}</td>
                <td>
                    <v-icon small @click="deleteItem(props.item)">
                        delete
                    </v-icon>
                </td>
            </tr>
        </template>
    </v-data-table>
</template>
<script>
    export default {
        props: ["value"],
        data() {
            return {
                headers: [{text: 'Начальная дата', value: 'date'},
                    {text: 'Повторять', value: 'repeat'}, {text: 'Действия', value: 'actions'}],
                notifications: []
            };
        }
    }
</script>