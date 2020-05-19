<template>
<el-container class="home_container">
  <el-header>
    <div class="home_title" >垃圾分类管理系统</div>
    <div class="home_userinfoContainer">
      <el-dropdown>
                    <span class="el-dropdown-link home_userinfo">
                        {{currentUserName}}<i class="el-icon-arrow-down el-icon--right home_userinfo"></i>
                    </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="MyHome" @click.native="toUserPage">个人主页</el-dropdown-item>
          <el-dropdown-item command="logout" @click.native="leaveSystem" divided>退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </el-header>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px">
      <el-menu
        default-active="0"
        class="el-menu-vertical-demo" align="left" style="background-color: #ECECEC"   router>
        <div v-for="(item,index) in this.$router.options.routes" :key="index">
<!--        <div v-for="(item,index) in gcRouter" :key="index">-->
          <template  v-if="!item.hidden">
            <el-submenu :index="index+''" v-if="item.children!==''" >
              <template slot="title">
                <i :class="item.iconCls"/>
                <span class="font1">{{item.name}}</span>
              </template>
              <div v-for="child in item.children" :key="child.path">
                <el-menu-item  v-if="!child.hidden" :index="child.path">
                  {{child.name}}
                </el-menu-item>
              </div>
            </el-submenu>
            <template v-else>
              <el-menu-item :index="item.children[0].path">
                <i :class="item.children[0].iconCls"></i>
                <span slot="title">{{item.children[0].name}}</span>
              </el-menu-item>
            </template>
          </template>
        </div>
      </el-menu>
    </el-aside>
    <el-container>
      <el-main>
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
        </el-breadcrumb>
<!--        后退路由页面不需要缓存-->
        <keep-alive>
          <router-view v-if="this.$route.meta.keepAlive"></router-view>
        </keep-alive>
        <router-view v-if="!this.$route.meta.keepAlive"></router-view>
        <div v-if="this.$route.path === '/home'">
          <el-carousel indicator-position="outside" height="500px">
            <el-carousel-item v-for="item in imgs" :key="item">
              <img :src="item"/>
            </el-carousel-item>
          </el-carousel>
       <ul style="list-style-position: outside">
         <li><P>垃圾分类，指按一定规定或标准将垃圾分类储存、分类投放和分类搬运，从而转变成公共资源的一系列活动的总称。分类的目的是提高垃圾的资源价值和经济价值，力争物尽其用。垃圾在分类储存阶段属于公众的私有品，垃圾经公众分类投放后成为公众所在小区或社区的区域性准公共资源，垃圾分类驳运到垃圾集中点或转运站后成为没有排除性的公共资源。从国内外各城市对生活垃圾分类的方法来看，大致都是根据垃圾的成分构成、产生量，结合本地垃圾的资源利用和处理方式来进行分类的</P></li>
         <li><p>垃圾分类是对垃圾收集处置传统方式的改革，是对垃圾进行有效处置的一种科学管理方法。人们面对日益增长的垃圾产量和环境状况恶化的局面，通过垃圾分类管理，最大限度地减少垃圾处置量，实现垃圾资源利用，改善生存环境质量。</p></li>
         <li><p>垃圾分类（英文名为Garbage classification），一般是指按一定规定或标准将垃圾分类储存、分类投放和分类搬运，从而转变成公共资源的一系列活动的总称。分类的目的是提高垃圾的资源价值和经济价值，力争物尽其用。垃圾在分类储存阶段属于公众的私有品，垃圾经公众分类投放后成为公众所在小区或社区的区域性准公共资源，垃圾分类搬运到垃圾集中点或转运站后成为没有排除性的公共资源。从国内外各城市对生活垃圾分类的方法来看，大致都是根据垃圾的成分、产生量，结合本地垃圾的资源利用和处理方式来进行分类的</p></li>
        <li><p>进行垃圾分类收集可以减少垃圾处理量和处理设备，降低处理成本，减少土地资源的消耗，具有社会、经济、生态等几方面的效益。
          2019年6月25日，生活垃圾分类制度将入法。 2019年9月，大连在每个垃圾分类投放点设督导员。
          上海成为第一个中国垃圾分类试点城市</p></li>
       </ul>
        </div>
      </el-main>
    </el-container>
  </el-container>
</el-container>
</template>
<script>
export default {
  name: 'Home',
  data () {
    return {
      currentUserName: '',
      isTrue: true,
      gcRouter: [],
      imgs: [
        require('@/assets/virusjpg.jpg'),
        require('@/assets/garbagePropaganda.jpg'),
        require('@/assets/garbagePropaganda2.jpg'),
        require('@/assets/garbagePropaganda3.jpeg')
      ]
    }
  },
  methods: {
    toUserPage () {
      console.log('aaa')
      this.$router.push('/userPage')
    },
    leaveSystem () {
      this.$router.push('/login')
    }
  },
  mounted () {
    // 用于某些人（开发者自己）老喜欢刷新网页获取不到值，必须重新从localStroage中拿取放到vuex中
    this.$store.commit('getAdminAndUser', window.localStorage.getItem('adminAndUser'))
    this.currentUserName = this.$store.state.adminAndUser.data.uname
    const role = this.$store.state.adminAndUser.data.role
    this.axios.get('/router/getRouterInfo', {
      params: {
        permission: role
      }
    }).then(res => {
      console.log(res)
      console.log('res的类型', typeof res)
      console.log(res.data)
      console.log('res.data的类型', typeof res.data)
      // this.gcRouter = JSON.parse(res.data)
      this.gcRouter = res.data
      // this.gcRouter = JSON.parse(res)
      console.log(this.gcRouter)
      console.log(typeof this.gcRouter)
    })
  }
  // beforeRouteLeave (to, from, next) {
  //   this.isTrue = false
  //   next()
  // }
}
</script>
<style lang="less" scoped>
  .home_container {
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }

  .el-header {
    background-color: #20a0ff;
    color: #333;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .el-aside {
    background-color: #ECECEC;
  }

  .el-main {
    background-color: #fff;
    color: #000;
    text-align: center;
  }

  .home_title {
    color: #fff;
    font-size: 22px;
    display: inline;
  }

  .home_userinfo {
    color: #fff;
    cursor: pointer;
  }

  .home_userinfoContainer {
    display: inline;
    margin-right: 20px;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
