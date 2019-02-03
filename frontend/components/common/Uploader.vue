<template>
  <div class="v-file">
    <input ref="inputFile" type="file" :name="name" :accept="accept" :multiple="multiple" @input="change"/>
    <slot/>
    <v-list>
      <template v-for="item in items">
        <v-list-tile>
          <v-list-tile-content v-html="item.name"></v-list-tile-content>
        </v-list-tile>
      </template>
    </v-list>
  </div>
</template>

<script>
  export default {
    name: 'v-file',
    props: {
      accept: {
        type: String,
        default: '*',
      },
      multiple: {
        type: Boolean,
        default: false,
      },
      name: {
        type: String,
        default: 'file',
      },
    },
    methods: {
      change(e) {
        if (this.multiple) {
          this.$emit('change', e.target.files)
        } else {
          this.items.push(e.target.files[0]);
          this.$emit('change', e.target.files[0])
        }
        this.$refs.inputFile.value = ''
      },
    },
    mounted() {
      try {
        const btn = this.$children[0]
        btn.$on('click', () => {
          this.$refs.inputFile.click()
        })
      } catch (error) {
        console.log(error)
      }
    },
    data() {
      return {
        items: [{name: 'image.jpeg'}, {name: 'text.txt'}]
      }
    }
  }
</script>

<style scoped>
  .v-file input[type='file'] {
    display: none;
  }
</style>
