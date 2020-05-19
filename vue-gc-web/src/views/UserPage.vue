<template>
  <div class="img1">
    <el-header>个人主页</el-header>
    <el-container>
      <el-card class="box-card">
        <el-form :label-position="labelPosition"
                 label-width="80px"
                 :model="formLabelAlign">
          <el-form-item label="用户名">
            <el-input v-model="formLabelAlign.uname"
                      disabled></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="formLabelAlign.telphone"></el-input>
          </el-form-item>
          <el-form-item label="email">
            <el-input v-model="formLabelAlign.email"></el-input>
          </el-form-item>
          <el-form-item label="注册时间">
            <el-input v-model="formLabelAlign.registerTime"
                      disabled></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="formLabelAlign.address"
                      placeholder="请输入真实地址"></el-input>
          </el-form-item>
          <el-form-item label="钱包">
            <el-input v-model="formLabelAlign.money"
                      disabled></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="onSubmit">提交</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-container>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  data () {
    return {
      labelPosition: 'left',
      formLabelAlign: {
        uname: '',
        telphone: '',
        email: '',
        registerTime: '',
        address: '',
        money: 0
      }
    }
  },
  created () {
    this.$alert('如果信息不全，请尽快完善信息，以免影响服务')
    // this.$store.commit('getAdminAndUser', window.localStorage.getItem('adminAndUser'))
    const userInfo = JSON.parse(window.localStorage.getItem('adminAndUser'))
    console.log(userInfo.data)
    // this.formLabelAlign.uname = this.$store.state.adminAndUser.data.uname
    this.formLabelAlign.uname = userInfo.data.uname
    console.log('111' + this.formLabelAlign.uname)
    //   this.formLabelAlign.telphone = this.$store.state.adminAndUser.data.telphone
    //   this.formLabelAlign.email = this.$store.state.adminAndUser.data.email
    //   this.formLabelAlign.registerTime = this.$store.state.adminAndUser.data.registerTime
    //   this.formLabelAlign.address = this.$store.state.adminAndUser.data.address
    //   this.formLabelAlign.money = this.$store.state.adminAndUser.data.money
    this.axios.get('/user/name', { params: { name: this.formLabelAlign.uname } }).then(res => {
      this.formLabelAlign.uname = res.data.uname
      this.formLabelAlign.address = res.data.address
      this.formLabelAlign.telphone = res.data.telphone
      this.formLabelAlign.email = res.data.email
      this.formLabelAlign.registerTime = res.data.registerTime
      this.formLabelAlign.money = res.data.money
    })
  },
  destroyed () {
    // 在页面销毁时将用户新的信息重新放到localStorage
    const userInfo = JSON.parse(window.localStorage.getItem('adminAndUser')).data
    this.axios.get('/user/name', {
      params: {
        name: userInfo.uname
      }
    }).then(res => {
      console.log(res)
      // window.localStorage.removeItem('adminAndUser')
      // localstroage好像并不能重复setItem相同的键，感觉不能覆盖原来的value
      window.localStorage.setItem('adminAndUser', JSON.stringify(res))
    })
  },
  methods: {
    onSubmit () {
      this.axios.put('/user/improveInfo', qs.stringify({
        uname: this.formLabelAlign.uname,
        telphone: this.formLabelAlign.telphone,
        email: this.formLabelAlign.email,
        address: this.formLabelAlign.address
      })).then(res => {
        console.log(res)
        if (res.data === 1) {
          this.$message.success('提交成功')
        }
      }).catch(() => {
        this.$message.error('提交失败')
      })

      // this.axios.get('/user/name', {
      //   params: {
      //     name: this.formLabelAlign.uname
      //   }
      // }).then(res => {
      //   console.log(res)
      //   // localstroage好像并不能重复setItem相同的键，感觉不能覆盖原来的value
      //   window.localStorage.removeItem('adminAndUser')
      //   window.localStorage.setItem('adminAndUser', JSON.stringify(res.data))
      // })
    }
  }

}
</script>

<style scoped>
/* .img1{
      background-size: 100% 100%;
      background: url('../assets/beauty.jpg') center center no-repeat;
      height: 100%;
      position: fixed;
      width: 100%
  } */

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.box-card {
  width: 480px;
  height: 480px;
  margin-top: 50px;
}

.el-header {
  display: flex;
  justify-content: center;
  background-color: #ececec;
  align-content: center;
  margin-top: 20px;
  padding-top: 20px;
  margin-left: 360px;
  margin-right: 360px;
  font-size: 20px;
}

.el-container {
  display: flex;
  justify-content: center;
  background-color: #ececec;
  margin-top: 20px;
  margin-left: 360px;
  margin-right: 360px;
  height: 600px;
}

.el-image {
  width: 100px;
  height: 100px;
}

.img1 {
  height: 100%;
}
</style>
