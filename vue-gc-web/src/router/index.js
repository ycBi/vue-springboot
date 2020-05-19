import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Home from '../views/Home'
import Register from '../views/Register'
import Wet from '../components/Wet'
import Dry from '../components/Dry'
import Recycle from '../components/Recycle'
import Harmful from '../components/Harmful'
import Search from '../components/Search'
import Cart from '../components/Cart'
import WatchOrder from '../components/WatchOrder'
import AlterPrice from '../components/AlterPrice'
import AddGarbage from '../components/AddGarbage'
import Manage from '../components/Manage'
import UserManage from '../components/UserManage'
import MapGeo from '../components/MapGeo'
import MapSearch from '../components/MapSearch'
import UserPage from '../views/UserPage.vue'
import ImageIdentify from '../components/ImageIdentify'
import UploadImage from '../components/UploadImage.vue'
import BrowseOrder from '../components/BrowseOrder'
import ManageOrder from '../components/ManageOrder'
import Chat from '../components/Chat'
import CharacterAnimation from '../components/CharacterAnimation'

Vue.use(VueRouter)

const routes = [{
  path: '/',
  redirect: '/login',
  hidden: true
},
{
  path: '/login',
  component: Login,
  hidden: true
},
{
  path: '/register',
  component: Register,
  hidden: true
},
{
  path: '/home',
  name: '',
  component: Home,
  hidden: true
},
{
  path: '/home',
  name: '垃圾展示',
  component: Home,
  iconCls: 'el-icon-s-grid',
  children: [{
    path: '/wet',
    name: '湿垃圾',
    component: Wet,
    meta: {
      keepAlive: true
    }
  },
  {
    path: '/dry',
    name: '干垃圾',
    component: Dry,
    meta: {
      keepAlive: false
    }
  },
  {
    path: '/harmful',
    name: '有害垃圾',
    component: Harmful,
    meta: {
      keepAlive: false
    }
  },
  {
    path: '/recycle',
    name: '可回收垃圾',
    component: Recycle,
    meta: {
      keepAlive: false
    }
  }
  ]
},
{
  path: '/home',
  name: '用户功能',
  component: Home,
  iconCls: 'el-icon-menu',
  children: [{
    path: '/search',
    name: '垃圾搜索',
    component: Search
  },
  {
    path: '/Cart',
    name: '回收车',
    component: Cart
  },
  {
    path: '/watchOrder',
    name: '订单查看',
    component: WatchOrder
  },
  {
    path: '/map',
    name: '地图',
    component: MapGeo
  },
  {
    path: '/mapSearch',
    name: '回收点搜索',
    component: MapSearch
  },
  {
    path: '/imageIdentify',
    name: '图片识别',
    component: ImageIdentify
  },
  {
    path: '/chat',
    name: '聊天',
    component: Chat
  },
  {
    path: '/anime',
    name: '动漫化',
    component: CharacterAnimation
  }
  ]
},
{
  path: '/home',
  name: '管理员功能',
  component: Home,
  iconCls: 'el-icon-s-order',
  children: [{
    path: '/userManage',
    name: '用户管理',
    component: UserManage
  },
  {
    path: '/addGarbage',
    name: '添加垃圾',
    component: AddGarbage
  },
  {
    path: '/alter',
    name: '回收价格修改',
    component: AlterPrice
  },
  {
    path: '/manage',
    name: '管理订单',
    component: Manage
  },
  {
    path: '/uploadImage',
    name: '上传图片',
    component: UploadImage
  }
  ]
},
{
  path: '/home',
  name: '回收人员功能',
  component: Home,
  iconCls: 'el-icon-s-data',
  children: [{
    path: '/browseOrder',
    name: '接收订单',
    component: BrowseOrder
  },
  {
    path: '/manageOrder',
    name: '订单查看',
    component: ManageOrder
  }]
},
{
  path: '/userPage',
  name: '用户主页',
  component: UserPage,
  hidden: true
}
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    return next()
  }
  // 应该使用后台的token来验证，此处使用本地的localStroage来验证
  const tokenStr = window.localStorage.getItem('adminAndUser')
  if (!tokenStr) return next('/login')
  next()
})
export default router
