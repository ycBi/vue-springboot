<template>
  <div class="mapbox">
    <baidu-map :center="center" :zoom="zoom" :scroll-wheel-zoom="true" style="height:100vh" @ready="handler" @click="getClickInfo" >
<!--       // 必须给容器指高度，不然地图将显示在一个高度为0的容器中，看不到-->
      <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
      <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>
      <bm-city-list anchor="BMAP_ANCHOR_TOP_LEFT"></bm-city-list>
      <bm-marker :position="{lng: center.lng, lat: center.lat}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
        <bm-label content="你在这" :labelStyle="{color: 'red', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
      </bm-marker>
    </baidu-map>
    <!-- 因为我采用的是全局注册，所以不用再在该页面上注册components -->
  </div>
</template>
<script>
export default {
  name: 'MapGeo',
  data () {
    return {
      center: {
        lng: 0,
        lat: 0
      }, // 经纬度
      zoom: 15 // 地图展示级别
    }
  },
  methods: {
    handler ({ BMap, map }) {
      console.log(BMap, map)
      this.center.lng = 113.772667
      this.center.lat = 31.30007
    },
    getClickInfo (e) {
      console.log(e.point.lng)
      console.log(e.point.lat)
      this.center.lng = e.point.lng
      this.center.lat = e.point.lat
    },
    getPosition () {
      return new Promise((resolve, reject) => {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function (position) {
            const latitude = position.coords.latitude
            const longitude = position.coords.longitude
            const data = {
              latitude: latitude,
              longitude: longitude
            }
            resolve(data)
          }, function () {
            reject(arguments)
          })
        } else {
          this.$message.error('你的浏览器不支持当前地理位置信息获取')
        }
      })
    }
  },
  created () {
    // 获取当前经纬度坐标
    this.getPosition().then(result => {
      // 返回结果示例：
      // {latitude: 30.318030999999998, longitude: 120.05561639999999}
      // 一般小数点后只取六位，所以用以下代码搞定
      const queryData = {
        longtitude: String(result.longitude).match(/\d+\.\d{0,6}/)[0],
        latitude: String(result.latitude).match(/\d+\.\d{0,6}/)[0],
        channelType: '00'
      }
      this.center.lat = queryData.latitude
      this.center.lng = queryData.longtitude
      console.log(queryData)
      // 以下放置获取坐标后你要执行的代码:
      // ...
    }).catch(err => {
      console.log(err)
    })
  }
}
</script>
<style scoped></style>
