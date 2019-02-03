import Vue from 'vue'
import Vuetify from 'vuetify/lib'
import colors from 'vuetify/es5/util/colors'

Vue.use(Vuetify, {
  theme: {
    primary: '#121212',
    accent: colors.grey.darken3,
    secondary: '#cabc4c',
    info: colors.teal.lighten1,
    warning: colors.amber.base,
    error: '#ff4f68',
    success: colors.green.accent3
  }
})
