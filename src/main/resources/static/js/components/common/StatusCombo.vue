<template>
    <v-combobox ref="userPicker" :items=users :label=label :disabled="disabled" item-text="name" v-model="interface"></v-combobox>
</template>
<script>
    export default {
        data() {
            return {
                statuses: [{id: null, name: ""}]
            }
        },
        props: ['label', 'disabled', 'value'],
        computed: {
            interface: {
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