<template>
  <div>
    <div style="margin-top: 10px;display: flex;justify-content: center">
      <el-input
        placeholder="通过垃圾名称进行搜索"
        prefix-icon="el-icon-search"
        v-model="input3" style="width: 400px" size="small"
        @keyup.enter.native="getResultList"
      >
      </el-input>
      <el-button type="primary" icon="el-icon-search" size="small" style="margin-left: 3px" @click="getResultList">搜索
      </el-button>
    </div>
    <el-table v-if="isShow"
              :data="queryInfo"
              style="width: 100%">
      <el-table-column type="index"
                       width="80"></el-table-column>
      <el-table-column prop="image"
                       label="图片"
                       width="180">
        <template slot-scope="scope">
          <img :src="scope.row.image"
               alt=""
               style="width: 60px;height: 60px">
        </template>
      </el-table-column>
      <el-table-column prop="gName"
                       label="名称"
                       width="180">
      </el-table-column>
      <el-table-column prop="gType"
                       label="垃圾类型"
                       width="180">
      </el-table-column>
      <el-table-column prop="gPrice"
                       label="回收价格"
                       width="180">
      </el-table-column>
      <el-table-column prop="gDesc"
                       label="描述">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'Search',
  data () {
    return {
      // 获取用户列表的参数对象
      queryInfo: [],
      input3: '',
      isShow: false

    }
  },
  created () {
    // this.getResultList()
  },
  methods: {
    getResultList () {
      // 将上次的搜索结果清空
      this.queryInfo = []
      if (this.input3 === '') {
        this.$message.error('请输入搜索关键字')
        return
      }
      this.axios.get('/garbage/getGarbageInfoByFuzzyName', {
        params: {
          name: this.input3
        }
      }).then(res => {
        // this.queryInfo = res.data
        console.log(res)
        if (res.data === undefined || res.data.length === 0) {
          this.$message.error('暂无搜索结果')
          return
        }

        // this.queryInfo.push(res.data)
        this.isShow = true
        this.queryInfo = res.data
      }).catch(error => {
        console.log(error)
        this.$message.error('结果为空，请更换搜索关键词')
      })
    }

  }
}
</script>

<style scoped>
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
  width: 100%;
}
</style>
