<template>
    <v-combobox ref="userPicker" :items=users :label=label :disabled="disabled" item-text="name" v-model="interface"></v-combobox>
</template>
<script>
    export default {
        data() {
            return {
                users: [{id: null, name: ""}]
            }
        },
        mounted() {
            return this.$resource('/api/user').get().then(result =>
                result.json().then(data => data.forEach(user => this.users.push(user))
                )
            )
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