<template>
    <v-menu ref="menu" :close-on-content-click="false" v-model="open" :nudge-right="180" lazy
            transition="scale-transition" full-width @click="open = true">
        <v-text-field slot="activator" v-model="datetime" :label="label" prepend-icon="event" readonly></v-text-field>
        <v-layout row wrap>
            <v-date-picker v-model="date" no-title></v-date-picker>
            <v-time-picker format="24hr" v-model="time" no-title @change="open = false" :key="open"></v-time-picker>
        </v-layout>
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
            date: {
                get() {
                    if(this.value == null) return;
                    return this.value.split(" ")[0]
                },
                set(val) {
                    this.datetime = val + " " + this.value.split(" ")[1]
                },

            },
            time: {
                get() {
                    if(this.value == null) return;
                    return this.value.split(" ")[1]
                },
                set(val) {
                    this.datetime = this.value.split(" ")[0] + " " + val;
                }
            },
            datetime: {
                get() {
                    return this.value
                },
                set(val) {
                    this.$emit('input', val)
                }
            }
        }
    }
</script>