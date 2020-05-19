<template>
  <div class="mapbox">
    <label>关键词：<input v-model="keyword"></label>
    <label>地区：<input v-model="location"></label>
    <baidu-map :center="center"
               :zoom="zoom"
               :scroll-wheel-zoom="true"
               style="height:100vh"
               @ready="handler"
               @click="getClickInfo">
      <!-- 必须给容器指高度，不然地图将显示在一个高度为0的容器中，看不到 -->
      <!--      <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>-->
      <!--      <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>-->
      <!--      <bm-city-list anchor="BMAP_ANCHOR_TOP_LEFT"></bm-city-list>-->
      <bm-view></bm-view>
      <bm-local-search :keyword="keyword"
                       :auto-viewport="true"
                       :location="location"></bm-local-search>
    </baidu-map>
    <!-- 因为我采用的是全局注册，所以不用再在该页面上注册components -->
  </div>
</template>
<script>
export default {
  name: 'MapSearch',
  data () {
    return {
      center: { lng: 0, lat: 0 }, // 经纬度
      zoom: 12, // 地图展示级别
      location: '武汉市',
      keyword: '废品回收'
    }
  },
  methods: {
    handler ({ BMap, map }) {
      console.log(BMap, map)
      this.center.lng = 113.68
      this.center.lat = 31.27
    },
    getClickInfo (e) {
      console.log(e.point.lng)
      console.log(e.point.lat)
      this.center.lng = e.point.lng
      this.center.lat = e.point.lat
    }
  }
}
</script>
<style scoped></style>
