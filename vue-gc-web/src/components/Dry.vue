<template>
  <el-card class="box-card">
  <el-table
    :data="dryList"
    style="width: 100%">
    <el-table-column type="index" width="80"></el-table-column>
    <el-table-column
      prop="image"
      label="图片"
      width="180">
      <template slot-scope="scope">
        <img  :src="scope.row.image" alt="" style="width: 60px;height: 60px">
      </template>
    </el-table-column>
    <el-table-column
      prop="gName"
      label="名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="gDesc"
      label="描述">
    </el-table-column>
  </el-table>

    <el-pagination
      background
      :page-size = 6
      layout="prev, pager, next"
      :page-count=pages
      @current-change="handleCurrentChange"
      @prev-click = "handlePreviousClick"
      @next-click = "handleNextClick">
    </el-pagination>
  </el-card>
</template>

<script>
export default {
  name: 'Dry',
  data () {
    return {
      dryList: [],
      pages: 0
    }
  },
  created () {
    this.getWetList()
  },
  methods: {
    getWetList () {
      this.axios.get('/garbage/getInfo', {
        params: {
          type: '干垃圾'
        }
      }).then(
        res => {
          console.log(res)
          this.dryList = res.data.list
          this.pages = res.data.pages
        }
      ).catch(function (error) {
        console.log(error)
      })
    },
    handleCurrentChange (val) {
      this.axios.get('/garbage/getInfo', {
        params: {
          type: '可回收物',
          page: val
        }
      }).then(
        res => {
          console.log(res)
          this.dryList = res.data.list
        }
      ).catch(function (error) {
        console.log(error)
      })
    },
    handlePreviousClick () {},
    handleNextClick () {}
  }
}
</script>

<style scoped>

</style>
