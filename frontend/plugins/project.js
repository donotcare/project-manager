import Vue from 'vue'

const ProjectManager = {
  install(Vue) {
    Vue.prototype.$apiURL = process.env.api;

    Vue.mixin({
      computed: {
        $user() {
          return this.$store.state.user
        },
        $isUser() {
          return !!this.$store.state.user.username
        },
        $isAppInit() {
          return !!this.$store.state.appInit
        }
      }
    })
  }
};

Vue.use(ProjectManager);
