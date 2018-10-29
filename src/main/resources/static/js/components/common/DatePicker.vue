<template>
    <v-menu :close-on-content-click="false" v-model="open" :nudge-right="180" lazy transition="scale-transition"
            offset-y full-width min-width="290px" @click ="open = true">
        <v-text-field slot="activator" v-model="interface" :label="label" prepend-icon="event" readonly></v-text-field>
        <v-date-picker v-model="interface" @input="open = false"></v-date-picker>
    </v-menu>
</template>

<script>
    export default {
        props: ['label', 'value'],
        data() {
            return {
                open: false
            }
        },

        computed: {
            interface: {
                get() {
                    return this.value
                },
                set(val) {
                    this.$emit('input', val)
                }
            },
        }
    }
</script>