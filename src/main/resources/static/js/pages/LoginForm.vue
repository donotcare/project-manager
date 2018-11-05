<template>
    <v-container grid-list-md>
        <form action="/" method="post">
            <v-text-field label="Логин" v-model="login"></v-text-field>
            <input name="username" id="username" v-model="login" type="hidden">
            <v-text-field label="Пароль" type="password" v-model="password"></v-text-field>
            <input name="password" id="password" v-model="password" type="hidden">
            <input name="submit" id="submit" value="Login" type="hidden">
            <v-btn color="primary" type="submit" value="Login">Войти</v-btn>
        </form>
    </v-container>
</template>
<script>
    export default {
        data() {
            return {
                login: "",
                password: ""
            }
        }
    }
</script>
