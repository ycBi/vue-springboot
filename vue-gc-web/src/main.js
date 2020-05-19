import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
// 导入全局样式表
import './assets/css/global.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import BaiduMap from 'vue-baidu-map'

axios.defaults.baseURL = 'http://127.0.0.1:8081'
// Vue.use(axios, VueAxios)
Vue.use(VueAxios, axios)
Vue.use(BaiduMap, {
  ak: 'GWPgqGL4WyTGqqnL6okKtGrZmZcc3F5U' // 官方提供的ak秘钥
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
