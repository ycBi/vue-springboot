<template>
  <div v-if="shopList.length === 0">
    暂无接收的订单
  </div>
  <div v-else>
    <div v-for="(item,index) in shopList" :key="index" style="margin-top: 25px">
      <div style="display: flex;flex-direction: column">
      <div style="display:flex;justify-content: flex-start">
        <span style="color: red;font-size: medium">{{index+1}}:</span>
        <span style="margin-left: 5px">订单id: {{item.orderInfo.id}}</span>
        <span style="margin-left: 25px">回收地址:{{item.orderInfo.address}}</span>
        <span style="margin-left: 25px">创建时间:{{item.orderInfo.creationTime}}</span>
        <span style="margin-left: 25px">结束时间:{{item.orderInfo.endTime}}</span>
        <span style="margin-left: 25px">总额：{{item.orderInfo.payment}}</span>
      </div>
        <div style="display:flex;justify-content: flex-start">
          <span>用户名：{{item.userInfo.uname}}</span>
          <span style="margin-left: 25px">用户电话：{{item.userInfo.telphone}}</span>
        </div>
      </div>
      <el-table
        :data="item.commodity"
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
    this.axios.get('/order/getShopInfoByCycleId', {
      params: {
        cycleId: userInfo.id
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
