<template>
  <v-layout>
    <v-flex v-if="!$isUser" offset-md3 offset-lg4 md6 lg4 xs12>
      <v-card>
        <v-form class="pt-3 px-3" v-model="valid">
          <v-text-field :disabled="loading" :rules="rules" @keypress.enter="login()" v-model="username" label="Логин"
                        required></v-text-field>
          <v-text-field
            :disabled="loading"
            @click:append="showPassword = !showPassword"
            @keypress.enter="login()"
            :type="showPassword ? 'text' : 'password'"
            :append-icon="showPassword ? 'visibility_off' : 'visibility'"
            :rules="rules"
            v-model="password"
            label="Пароль"
            required
          ></v-text-field>
        </v-form>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="login()" :disabled="!valid" color="primary" flat>Войти</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
  export default {
    watch: {
      $isUser() {
        if (this.$isUser) {
          this.$router.push("/task");
        }
      }
    },
    data() {
      return {
        username: "",
        password: "",
        showPassword: false,
        valid: false,
        rules: [v => !!v || "Требуется заполнить поле"],
        hide: true,

        loading: false
      }
    },
    created() {
      if (this.$isUser) {
        this.$router.push('/task')
      }
    },
    methods: {
      async login() {
        this.loading = true;

        let formData = new FormData();
        formData.set('username', this.username);
        formData.set('password', this.password);
        formData.set('remember-me', true);
        let [user] = await this.$api.post('/api/login', {
          body: formData
        });
        this.$store.commit('setUser', user);
        this.loading = false;
      }
    }
  }
</script>
