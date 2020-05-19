import axios from 'axios'
// import store from "../store";

const service = axios.create({
  baseURL: 'http://localhost:8081',
  timeout: 1000
})

// // 拦截器
// service.interceptors.request.use(
//   // 展示进读条
//   config => {
//     // if (store.getters.token) {
//     //     // 为请求头对象，添加 Token 验证的 Authorization 字段
//     //     config.headers.Authorization = store.getters.token
//     // }
//     return config
//   },
//   error => {
//     return Promise.reject(error)
//   }
// )
// service.interceptors.response.use(
//   response => {
//     const res = response.data
//     return res
//   },
//   error => {
//     return Promise.reject(error)
//   }
// )

export default service
