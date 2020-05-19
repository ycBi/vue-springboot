<template>
  <div v-if="shopList.length === 0">
    暂无订单
  </div>
  <div v-else>
    <div v-for="(item,key) in shopList" :key="key" style="margin-top: 25px">
      <div style="display: flex;flex-direction: column">
        <div style="display: flex;justify-content: flex-start">
          <span style="color: red;font-size: medium">{{key+1}}:</span>
          <span style="margin-left: 5px">订单id: {{item.garbageOrder.id}}</span>
          <span style="margin-left: 25px">回收地址:{{item.garbageOrder.address}}</span>
          <span style="margin-left: 25px">创建时间:{{item.garbageOrder.creationTime}}</span>
          <span style="margin-left: 25px">订单回收总额：{{item.garbageOrder.payment}}</span>
          <span style="margin-left: 25px">订单创建时间：{{item.garbageOrder.creationTime}}</span>
        </div>
        <div style="display: flex;justify-content: flex-start;margin-top: 10px">
<!--          <span>订单状态：</span>-->
<!--          <span v-if="shopList.garbageOrder.orderStatus==0" style="color: #409eff">等待接收</span>-->
<!--          <span v-if="shopList.garbageOrder.orderStatus==1"  style="color: green">已完成</span>-->
          <span>用户名: {{item.user.uname}}</span>
          <span style="margin-left: 25px">用户电话:{{item.user.telphone}}</span>
        </div>
      </div>
      <el-table
        :data="item.commodity"
        style="width: 800px"
      >
        <el-table-column type="index" width="80"></el-table-column>
        <el-table-column
          prop="commodity"
          label="回收物名称"
          width="180">
        </el-table-column>
        <el-table-column
          prop="gPrice"
          label="回收价格"
          width="180">
        </el-table-column>
        <el-table-column
          prop="amount"
          label="数量"
        >
        </el-table-column>
      </el-table>
      <div style="display: flex;justify-content: flex-start">
<!--      <el-popconfirm-->
<!--        title="是否确定接单"-->
<!--      >-->
<!--        <el-button type="primary"  slot="reference" style="margin-left: 25px" plain @click="submit(item.garbageOrder.id)">接单</el-button>-->
<!--      </el-popconfirm>-->
        <el-button type="primary" @click="dialogVisible = true">接单</el-button>

        <el-dialog
          title="提示"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
          <span>是否接单？</span>
          <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submit(item.garbageOrder.id)">确 定</el-button>
  </span>
        </el-dialog>
    </div>
  </div>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  data () {
    return {
      shopList: [
      ],
      dialogVisible: false
    }
  },
  methods: {
    handleClose (done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    formatter (row, column) {
      return row.address
    },
    submit (orderId) {
      this.dialogVisible = false
      const userInfo = JSON.parse(window.localStorage.getItem('adminAndUser'))
      console.log(userInfo)
      // console.log(id)
      this.axios.put('/order/receiveOrder', qs.stringify({
        id: orderId,
        userId: userInfo.data.id
      })).then(
        res => {
          console.log(res)
          this.$message.success('接单成功')
          // 刷新数据
          setTimeout(this.axios.get('/order/getOrderInfoForCycle', {
            params: {
              status: 0
            }
          }).then(res => {
            console.log(res)
            console.log(res.data)
            this.shopList = res.data
            // this.tableData = res.data[0].commodityLists
            // this.id = res.data[0].orderId
          }), 2000)
          // setTimeout(window.reload(), 2000)
          // window.reload()
        }
      ).catch(() => {
        this.$message.error('接单失败')
      })
      // setTimeout(window.reload(),
    }
  },
  created () {
    this.axios.get('/order/getOrderInfoForCycle', {
      params: {
        status: 0
      }
    }).then(res => {
      console.log(res)
      console.log(res.data)
      this.shopList = res.data
      // this.tableData = res.data[0].commodityLists
      // this.id = res.data[0].orderId
    })
  }
}
</script>
