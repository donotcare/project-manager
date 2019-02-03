<template>
  <v-combobox ref="userPicker" :items=users :label=label :disabled="disabled" item-text="name"
              v-model="interface"></v-combobox>
</template>
<script>
  export default {
    data() {
      return {
        users: []
      }
    },
    async mounted() {
      let [users] = await this.$api.get('/api/user');
      users.unshift({id: null, name: ""});
      this.users = users;

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
