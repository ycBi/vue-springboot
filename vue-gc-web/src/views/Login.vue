<template>
<div class="img1">
  <div><h1 style="color: pink">垃圾信息分类管理系统|欢迎登陆</h1></div>
  <div id="title"><h5 style="color: white">垃圾要分类，资源要利用；积极参与垃圾分类，创优美社区环境；未来人类的文明，将是绿色文明 </h5></div>
  <div class="copyrightmodule">Copyright © 2020-04-10 By biyongcheng. All rights reserved.</div>
    <div class="login_container">
      <div class="login_box">
        <div class="avatar_box">
          <img src="../assets/login.png">
        </div>
        <el-form ref="loginFormRef" :model="loginForm" :rules="loginRule" label-width="0px" class="login_form">
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" prefix-icon="el-icon-user"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="success" @click="login">登录</el-button>
            <el-button type="info" @click="resetLoginForm">重置</el-button>
            <el-button type="primary" @click="register">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
</div>
</template>
<script>
export default {
  data () {
    return {
      // 登录表单的数据绑定对象
      loginForm: {
        username: 'byc',
        password: '123456'
      },
      // 表单验证对象
      loginRule: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 8, message: '长度为3到10个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度为6到30个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 重置按钮方法
    resetLoginForm () {
      this.$refs.loginFormRef.resetFields()
    },
    // 登录方法
    login () {
      // console.log(this.$refs.loginFormRef)
      this.$refs.loginFormRef.validate((valid) => {
        if (!valid) return
        this.$store.dispatch({
          type: 'login/userLogin',
          data: {
            username: this.loginForm.username,
            password: this.loginForm.password
          }
        }).then((res) => {
          //   const res = this.$http.post('/user/login', qs.stringify(this.loginForm))
          console.log(res)
          // console.log(res.data.msg)
          // console.log(res.data.status)
          // res.data.us
          if (res.data.data.userStatus === 0) {
            this.$message.error('你的账户被禁用，请联系管理员')
            return
          }
          if (res.data.status === 0) {
            this.$message.success(res.data.msg)
            window.localStorage.setItem('adminAndUser', JSON.stringify(res.data))
            this.$store.commit('getAdminAndUser', window.localStorage.getItem('adminAndUser'))
            this.$router.push('/home')
          }
          if (res.data.status === 1) {
            this.$message.error(res.data.msg)
          }
        })
      })
    },
    register () {
      this.$router.push('/register')
    }
  }
}
</script>

<style lang="less" scoped>
  .login_container {
    // background-color: #2b4b6b;
    height: 100%;
  }
  .login_box {
    width: 450px;
    height: 300px;
    background-color: #ffffff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
  }
  .avatar_box{
    height: 130px;
    width: 130px;
    border: 1px solid #eeeeee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #dddddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%,-50%);
    background-color: #ffffff;
    img{
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eeeeee;
    }
  }
  .btns{
    display: flex;
    justify-content: center;
  }
  .login_form{
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 30px;
    box-sizing: border-box;
  }
  .img1{
      background-size: 100% 100%;
      background: url('../assets/sight.jpg') center center no-repeat;
      height: 100%;
      position: fixed;
      width: 100%
  }
  .copyrightmodule {
    position: absolute;
    left:35%;
    color: #20a0ff;
    bottom: 44px;
  }
</style>
