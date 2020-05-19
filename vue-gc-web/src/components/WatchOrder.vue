<template>
  <div>
  <div v-for="(item,index) in shopList" :key="index">
    <el-steps :active=item.orderStatus+2 finish-status="success" simple style="margin-top: 50px">
      <el-step title="已提交" ></el-step>
      <el-step title="等待接单" ></el-step>
      <el-step title="已接单" ></el-step>
    </el-steps>
  <div style="display:flex;justify-content: flex-start;flex-direction: row">
    <span>订单id: {{item.orderId}}</span>
    <span style="margin-left: 25px">回收地址:{{item.address}}</span>
    <span style="margin-left: 25px">创建时间:{{item.creationTime}}</span>
    <span style="margin-left: 25px">总额：{{item.total}}</span>
  </div>
  <el-table
    :data="item.commodityLists"
    style="width: 500px"
  >
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
  data () {
    return {
      shopList: [
      ]
    }
  },
  methods: {
    formatter (row, column) {
      return row.address
    }
  },
  created () {
    const userInfo = JSON.parse(window.localStorage.getItem('adminAndUser')).data
    this.axios.get('/order/getShopInfo', {
      params: {
        userId: userInfo.id
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
