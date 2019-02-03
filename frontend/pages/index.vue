<template>
  <v-layout
    column
    justify-center
    align-center
  >

  </v-layout>
</template>

<script>
  export default {
    created() {
      this.$router.push(this.$isUser ? '/task' : '/login')
    }
  }
</script>
