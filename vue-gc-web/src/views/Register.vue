<template>
  <div class="login_container">
    <div><h1 style="color: pink">注册界面</h1></div>
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
        <el-form-item prop="password">
          <el-input v-model="loginForm.password1" prefix-icon="el-icon-lock" type="password"></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button type="success" @click="finish">完成</el-button>
          <el-button type="primary" @click="back">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  data () {
    return {
      // 登录表单的数据绑定对象
      loginForm: {
        username: '',
        password: '',
        password1: ''

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
        ],
        password1: [
          { required: true, message: '确认密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度为6到30个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    finish () {
      if (this.loginForm.password !== this.loginForm.password1) {
        this.$message.error('密码不一致')
        return
      }
      // 长度为0不符合表单验证规则
      // if (this.loginForm.username === null) {
      //   this.$message.error('用户名不许为空')
      //   return
      // }
      // this.axios.post('/user/register', qs.stringify({
      //   username: this.loginForm.username
      // }))
      // check form rules
      this.$refs.loginFormRef.validate((valid) => {
        if (!valid) return
        this.$store.dispatch({
          type: 'login/userRegister',
          data: {
            username: this.loginForm.username
          }
        })
          .then(res => {
            console.log(res)
            if (res.data.status === 2) {
              this.$message.error('用户名已存在')
            } else {
              this.axios.post('/user/insert', qs.stringify({
                username: this.loginForm.username,
                password: this.loginForm.password
              })).then(res => {
                console.log(res)
                this.$message.success('注册成功')
                this.$router.push('/login')
              })
            }
          })
          .catch(function (error) {
            console.log(error)
          })
      })
      // console.log(res)
      // console.log(res.data.status)
      // if (res.data.status === 0) {
      //   this.$message.success('注册成功')
      //   this.$router.push('/home')
      // }
      // if (res.data.status === 1) {
      //   this.$message.error(res.data.msg)
      // }
    },
    back () {
      this.$router.push('/login')
    }
  }

}
</script>

<style lang="less" scoped>
  .login_container {
    background-color: #2b4b6b;
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
    height: 80px;
    width: 80px;
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
</style>
