<template>
    <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
        <v-card>
            <v-toolbar dark color="primary">
                <v-btn icon dark @click.native="dialog = false">
                    <v-icon>close</v-icon>
                </v-btn>
                <v-toolbar-title>Задача</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-toolbar-items>
                    <v-btn dark flat @click.native="dialog = false">Save</v-btn>
                </v-toolbar-items>
            </v-toolbar>
            <v-card>
                <v-layout row wrap>
                    <v-flex xs12 sm6 md2>
                        <v-select :items="['Иванов', 'Петров']" label="Исполнитель" box></v-select>
                    </v-flex>
                    <v-spacer></v-spacer>
                    <v-flex xs12 sm6 md2>
                        <v-select :items="['Иванов', 'Петров']" label="Автор" box></v-select>
                    </v-flex>
                </v-layout>
                <v-textarea
                        name="input-7-1"
                        box
                        label="Описание"
                        auto-grow
                        :value="item.name">
                </v-textarea>
            </v-card>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        data() {
            return {
                item: {
                    id: 0,
                    name: '',
                    status: 'Новый',
                    creationDate: '19.10.2018 22:59',
                    expiringDate: '19.10.2018 22:59',
                    receiver: 'Иванов'
                }
            }
        },
        props: ['dialog', 'item']
    }
</script>