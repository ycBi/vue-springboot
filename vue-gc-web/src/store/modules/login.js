import service from '../../utils/request'
import qs from 'qs'

const login = {
  namespaced: true,
  actions: {
    // 管理员登陆
    // async adminLogin (context, payload) {
    //   const response = await service.post('/manage/user/login', qs.stringify(payload.data))
    //   return response
    // },
    // 普通用户或管理员登陆
    async userLogin (context, payload) {
      const response = await service.post('/user/login', qs.stringify(payload.data))
      return response
    },
    // 用户注册
    async userRegister (context, payload) {
      const response = await service.post('user/register', qs.stringify(payload.data))
      return response
    },
    // 用户退出
    async userLogout () {
      const response = await service.post('/user/logout')
      return response
    }
  }
}
export default login
