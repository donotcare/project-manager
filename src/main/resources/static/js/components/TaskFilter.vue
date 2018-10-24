<template>
    <v-card-title grid-list-md>
        <v-flex xs12 sm6 md2>
            <v-select :items="['Иванов', 'Петров']" label="Исполнитель"></v-select>
        </v-flex>
        <v-btn slot="activator" color="primary" dark class="mb-2">Создать задачу</v-btn>
    </v-card-title>
</template>