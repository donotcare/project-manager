<template>
  <v-combobox ref="userPicker" :items=statuses :label=label :disabled="disabled" item-text="name" item-value="id"
              v-model="interface"></v-combobox>
</template>
<script>
  export default {
    data() {
      return {
        statuses: [{id: 'NEW', name: 'Новая'},
          {id: 'ACTIVE', name: 'Активная'}]
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
