import Vuex from 'vuex'

const createStore = () => {
  return new Vuex.Store({
    state: {
      user: {
        roles: []
      },
      appInit: false
    },

    mutations: {
      setUser(state, user) {
        state.user = user
      },
      setAppInit(state, s = true) {
        state.appInit = s
      }
    }
  })
}

export default createStore
