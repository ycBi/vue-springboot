<template>
  <div>
  <div style="margin-top: 10px;display: flex;justify-content: center">
    <el-input
      placeholder="根据订单id来搜索"
      prefix-icon="el-icon-search"
      v-model="keywords" style="width: 400px" size="small">
    </el-input>
    <el-button type="primary" icon="el-icon-search" size="small" style="margin-left: 3px" @click="searchClick">搜索
    </el-button>
  </div>
  <div v-if = "isShow" style="margin-top: 50px">
  <div style="display: flex;flex-direction: column">
    <div style="display: flex;justify-content: flex-start">
    <span>订单id: {{garbageOrder.id}}</span>
    <span style="margin-left: 25px">回收地址:{{garbageOrder.address}}</span>
    <span style="margin-left: 25px">创建时间:{{garbageOrder.creationTime}}</span>
    <span style="margin-left: 25px">订单回收总额：{{garbageOrder.payment}}</span>
    <span style="margin-left: 25px">订单创建时间：{{garbageOrder.creationTime}}</span>
    </div>
    <div style="display: flex;justify-content: flex-start;margin-top: 10px">
    <span>订单状态：</span>
    <span v-if="garbageOrder.orderStatus==0" style="color: #409eff">等待接收</span>
    <span v-if="garbageOrder.orderStatus==1"  style="color: green">已完成</span>
    <span style="margin-left: 25px">用户名: {{user.uname}}</span>
    <span style="margin-left: 25px">用户电话:{{user.telphone}}</span>
    <span style="margin-left: 25px">回收人员名称:</span>
    <span v-if="cycle== null"  style="color: red">暂无回收人员接单</span>
    <span v-if="cycle != null">{{cycle.uname}}</span>
    <span v-if="cycle != null" style="margin-left: 25px">回收人员电话:{{cycle.telphone}}</span>
    <span v-if="cycle != null" style="margin-left: 25px">订单结束时间：{{garbageOrder.endTime}}</span>
    </div>
  </div>
  <el-table
    :data="commodityLists"
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
  </div>
  </div>
</template>

<script>
export default {
  name: 'Manage',
  data () {
    return {
      isShow: false,
      keywords: '',
      garbageOrder: {},
      commodityLists: [],
      user: {},
      cycle: {}
      // item: {
      //   commodityLists: [
      //     {
      //       id: '0bcdcd27-b2c7-42f9-8d83-70100d8aa3a8',
      //       commodity: '铁',
      //       amount: 2,
      //       gPrice: 12
      //     },
      //     {
      //       id: '4716c1fe-b03a-4551-ac91-d240bd50d317',
      //       commodity: '纸',
      //       amount: 1,
      //       gPrice: 10
      //     },
      //     {
      //       id: '99c8197e-275b-48de-a122-7b57ca0feec9',
      //       commodity: '铜',
      //       amount: 3,
      //       gPrice: 58
      //     }
      //   ],
      //   total: 208,
      //   address: '湖北安陆',
      //   creationTime: '2020-03-20 21:12:42',
      //   orderStatus: 0,
      //   orderId: '3942b371-c665-466f-93b7-7fc149c683b9'
      // }
    }
  },
  methods: {
    searchClick () {
      this.isShow = true
      this.axios.get('/order/getShopInfoByOrderId', {
        params: {
          orderId: this.keywords
        }
      }).then(
        res => {
          console.log(res)
          // this.item = res
          this.garbageOrder = res.data.garbageOrder
          this.commodityLists = res.data.commodityList
          this.user = res.data.user
          this.cycle = res.data.cycle
        }
      ).catch(
        error => {
          console.log(error)
          this.$message.error('无此订单')
        }
      )
    }
  },
  created () { }
}
</script>

<style scoped>

</style>
