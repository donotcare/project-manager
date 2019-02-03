<template>
  <v-combobox ref="userPicker" :items=statuses :label=label :disabled="disabled" item-text="name" v-model="interface"
              item-></v-combobox>
</template>
<script>
  export default {
    data() {
      return {
        statuses: [{id: 'NONE', name: 'Нет'},
          {id: 'ONCE_AN_HOUR', name: 'Раз в час'},
          {id: 'ONCE_A_DAY', name: 'Раз в день'}]
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
