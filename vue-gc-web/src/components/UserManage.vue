<template>
  <div>
    <div style="margin-top: 10px;display: flex;justify-content: center">
      <el-input
        placeholder="默认展示部分用户信息，通过用户名进行搜索"
        prefix-icon="el-icon-search"
        v-model="keywords" style="width: 400px" size="small">
      </el-input>
      <el-button type="primary" icon="el-icon-search" size="small" style="margin-left: 3px" @click="searchClick">搜索
      </el-button>
    </div>
    <div style="display: flex;justify-content: space-around;flex-wrap: wrap" v-if="isSearch">
      <el-card style="width:330px;margin-top: 10px;" v-for="(user,index) in users" :key="index"
              >
        <div slot="header" style="text-align: left">
          <span>{{user.uname}}</span>
          <el-button style="float: right; padding: 3px 0;color: #ff0509" type="text" icon="el-icon-delete"
                     @click="deleteUser(user.uname)">删除
          </el-button>
        </div>
        <div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>电话:</span><span>{{user.telphone}}</span>
          </div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>邮箱:</span><span>{{user.email}}</span>
          </div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>注册时间:</span><span>{{user.registerTime}}</span>
          </div>
          <div
            style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px;display: flex;align-items: center">
            <span>用户状态:</span>
            <el-switch
              v-model="user.userStatus"
              :active-value="1"
              :inactive-value="0"
              active-text="启用"
              active-color="#13ce66"
              @change="enabledChange(user.userStatus,user.id)"
              inactive-text="禁用" style="font-size: 12px">
            </el-switch>
          </div>
        </div>
      </el-card>
    </div>
    <div style="display: flex;justify-content: space-around;flex-wrap: wrap" v-if="!isSearch">
      <el-card style="width:330px;margin-top: 10px;">
        <div slot="header" style="text-align: left">
          <span>{{user.uname}}</span>
          <el-button style="float: right; padding: 3px 0;color: #ff0509" type="text" icon="el-icon-delete"
                     @click="deleteUser(user.uname)">删除
          </el-button>
        </div>
        <div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>电话:</span><span>{{user.telphone}}</span>
          </div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>邮箱:</span><span>{{user.email}}</span>
          </div>
          <div style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px">
            <span>注册时间:</span><span>{{user.registerTime}}</span>
          </div>
          <div
            style="text-align: left;color:#20a0ff;font-size: 12px;margin-top: 13px;display: flex;align-items: center">
            <span>用户状态:</span>
            <el-switch
              v-model="user.userStatus"
              :active-value="1"
              :inactive-value="0"
              inactive-color="0"
              active-text="启用"
              active-color="#13ce66"
              @change="enabledChange(user.userStatus,user.id)"
              inactive-text="禁用" style="font-size: 12px">
            </el-switch>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  name: 'UserManage',
  data () {
    return {
      users: [],
      user: {},
      keywords: '',
      isSearch: true
    }
  },
  beforeCreate () {
    this.axios.get('/user/getPartInfo').then(res => {
      console.log(res.data)
      this.users = res.data
    })
  },
  methods: {
    searchClick () {
      this.isSearch = false
      this.axios.get('/user/name', {
        params: {
          name: this.keywords
        }
      }).then(res => {
        console.log(res)
        this.user = res.data
      })
    },
    deleteUser (name) {
      this.axios.delete('/user/deleteUserInfo', {
        params: {
          uname: name
        }
      }).then(res => {
        console.log(res)
        this.$message.success('删除成功')
        this.getPartUser()
      })
    },
    enabledChange (userStatus, id) {
      this.axios.put('/user/status', qs.stringify({
        status: userStatus,
        id: id
      })).then(res => {
        console.log(res)
      })
    },
    getPartUser () {
      this.isSearch = true
      this.axios.get('/user/getPartInfo').then(res => {
        console.log(res.data)
        this.users = res.data
      })
    }
  }
}
</script>

<style scoped>

</style>
