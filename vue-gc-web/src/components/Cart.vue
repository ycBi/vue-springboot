<template>
  <div>
    <div style="margin-top: 10px;display: flex;justify-content: center">
      <el-input
        placeholder="默认展示部分回收垃圾，请输入可回收垃圾"
        prefix-icon="el-icon-search"
        v-model="keywords" style="width: 400px" size="small">
      </el-input>
      <el-button type="primary" icon="el-icon-search" size="small" style="margin-left: 3px" @click="searchClick">搜索
      </el-button>
    </div>
    <div style="display: flex;justify-content: space-around;flex-direction: column" v-if="isSearch">
      <el-table
        ref="multipleTable"
        :rule="rules"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          :selectable="isDisabled"
          width="100">
        </el-table-column>
        <el-table-column
          prop="image"
          label="图片"
          width="200">
          <template slot-scope="scope">
            <img  :src="scope.row.image" alt="" style="width: 60px;height: 60px">
          </template>
        </el-table-column>
        <el-table-column
          prop="gName"
          label="名称"
          width="200">
        </el-table-column>
        <el-table-column
          prop="gPrice"
          label="价格"
          width="200">
        </el-table-column>
        <el-table-column
          prop="gDesc"
          label="描述"
          width="300">
        </el-table-column>
        <el-table-column label="数量" width="180">
          <template slot-scope="scope">
            <el-form  ref="form" :model="scope.row" :rules="rules">
              <el-form-item prop="amount">
          <el-tooltip class="item" effect="red" content="请输入回收重量（单位为千克）" placement="right-start">
          <el-input v-model="scope.row.amount" style="width: 100px" type="number"></el-input>
          </el-tooltip>
              </el-form-item>
            </el-form>
          </template>
<!--          <template slot-scope="scope">-->
<!--            <el-button-->
<!--              size="mini"-->
<!--              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
<!--            <el-button-->
<!--              size="mini"-->
<!--              type="danger"-->
<!--              @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--        <el-table-column label="操作">-->
<!--          <template>-->
<!--            <el-button-->
<!--              size="mini"-->
<!--              :disabled="amount === 1"-->
<!--              @click="decrease"-->
<!--             >-</el-button>{{amount}}-->
<!--            <el-button-->
<!--              size="mini"-->
<!--              @click="add"-->
<!--            >+</el-button>-->
<!--          </template>-->
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px;justify-content: flex-start">
        <el-button type="warning" @click="toggleSelection()">取消选择</el-button>
        <el-button type="primary" @click="add()">添加到购物车</el-button>
      </div>
    </div>
<!--    展示搜索-->
    <div style="display: flex;justify-content: space-around;flex-direction: column" v-if="!isSearch">
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
         :selectable="isDisabled"
          width="100">
        </el-table-column>
        <el-table-column
          prop="image"
          label="图片"
          width="200">
          <template slot-scope="scope" ref="form">
            <img  :src="scope.row.image" alt="" style="width: 60px;height: 60px">
          </template>
        </el-table-column>
        <el-table-column
          prop="gName"
          label="名称"
          width="200">
        </el-table-column>
        <el-table-column
          prop="gPrice"
          label="价格"
          width="200">
        </el-table-column>
        <el-table-column
          prop="gDesc"
          label="描述"
          width="300">
        </el-table-column>
        <el-table-column label="数量" width="180">
          <template slot-scope="scope">
            <el-form ref="form" :model="scope.row" :rules="rules">
              <el-form-item prop="amount">
                <el-tooltip class="item" effect="red" content="请输入回收重量（单位为千克）" placement="right-start">
                  <el-input v-model="scope.row.amount" style="width: 100px" type="number"></el-input>
                </el-tooltip>
              </el-form-item>
            </el-form>
          </template>
          <!--          <template slot-scope="scope">-->
          <!--            <el-button-->
          <!--              size="mini"-->
          <!--              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
          <!--            <el-button-->
          <!--              size="mini"-->
          <!--              type="danger"-->
          <!--              @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
          <!--          </template>-->
          <!--        </el-table-column>-->
          <!--        <el-table-column label="操作">-->
          <!--          <template>-->
          <!--            <el-button-->
          <!--              size="mini"-->
          <!--              :disabled="amount === 1"-->
          <!--              @click="decrease"-->
          <!--             >-</el-button>{{amount}}-->
          <!--            <el-button-->
          <!--              size="mini"-->
          <!--              @click="add"-->
          <!--            >+</el-button>-->
          <!--          </template>-->
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px;justify-content: flex-start">
        <el-button type="warning" @click="toggleSelection()">取消选择</el-button>
        <el-button type="primary" @click="add()">添加到购物车</el-button>
      </div>
    </div>
  </div>
</template>

<script>
// import qs from 'qs'
export default {
  name: 'Cart',
  data () {
    const validateAmountInput = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('数量必填！'))
      } else if (parseFloat(value) < 0) {
        return callback(new Error('重量必须大于0'))
      } else {
        callback()
      }
    }
    return {
      keywords: '',
      isSearch: true,
      tableData: [],
      multipleSelection: [],
      rules: {
        amount: [{ validator: validateAmountInput, trigger: 'blur' }]
      }
    }
  },
  created () {
    this.getList()
  },
  methods: {
    getList () {
      this.axios.get('/garbage/getInfo', {
        params: {
          type: '可回收物'
        }
      }).then(
        res => {
          console.log(res)
          this.tableData = res.data.list
        }
      ).catch(function (error) {
        console.log(error)
      })
    },
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    searchClick () {
      this.isSearch = false
      this.axios.get('/garbage/getGarbageInfoByFuzzyName', {
        params: {
          name: this.keywords
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data
      })
    },
    isDisabled (row) {
      // console.log(row)
      if (row.gType !== '可回收物') {
        return false
      }
      return true
    },
    add () {
      // console.log(this.$refs.multipleTable)
      // this.$refs.form.validate((valid) => {
      //   if (!valid) return
      // 拿到勾选的商品信息
      const commodities = this.$refs.multipleTable.store.states.selection
      for (const value of commodities) {
        delete value.gType
        delete value.gDesc
        delete value.image
        delete value.isCycle
        if (value.amount < 0) {
          this.$message.error('请检查填写的数据格式')
          return
        }
      }
      console.log(commodities)
      // console.log(window.localStorage.getItem('adminAndUser'))
      const userInfo = JSON.parse(window.localStorage.getItem('adminAndUser')).data
      console.log(userInfo.address)
      // let a = {}
      // this.axios.get('/user/name', {
      //   params: {
      //     name: userInfo.uname
      //   }
      // }).then(res => {
      //   console.log(res)
      //   a = res.data
      //   // if (res.data.address === '') {
      //   //   this.$message.error('请到个人主页补充回收地址！')
      //   // }
      // })
      // console.log('a.address' + a.address)
      if (userInfo.address === '' || userInfo.address === null) {
        this.$message.error('请到个人主页补充回收地址！')
        return
      }
      this.axios.post('/order/generateOrder', {
        commodities: commodities,
        userInfoId: userInfo.id,
        userInfoAddress: userInfo.address
      }).then(res => {
        console.log(res)
        if (res.data === 1) {
          this.$message.success('添加成功')
          return
        }
        this.$message.error('添加失败')
      }).catch((error) => {
        console.log(error)
        // this.$message.error('请到个人主页补充回收地址！')
      })
      // })
    }
  }

}
</script>

<style scoped>
  .item {
    margin: 4px;
  }
</style>
