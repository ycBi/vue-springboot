import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import login from './modules/login'

Vue.use(Vuex)

const state = {
  adminAndUser: {
  }
}
const mutations = {
  getAdminAndUser (state, data) {
    state.adminAndUser = JSON.parse(data)
  }
}

export default new Vuex.Store({
  state,
  mutations,
  getters,
  modules: {
    login
  }
})
