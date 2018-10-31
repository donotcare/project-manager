<template>
    <v-card-title grid-list-md>
        <v-flex xs12 sm6 md2>
            <user-combo label="Исполнитель" v-model="interface"></user-combo>
        </v-flex>
        <v-btn slot="activator" color="secondary" dark @click.native="createItem">
            Создать задачу
            <v-icon right dark>create</v-icon>
        </v-btn>
    </v-card-title>
</template>

<script>
    import UserCombo from 'components/common/UserCombo.vue'

    export default {
        components: {
            UserCombo
        },
        props: ['createItem'],
        data() {
            return {
                item: {id: null, name: ""}
            }
        },
        computed: {
            interface: {
                get() {
                    return this.item
                },
                set(val) {
                    this.$emit('input', val)
                }
            }
        }
    }
</script>