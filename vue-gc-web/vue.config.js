module.exports = {
  devServer: {
    open: false, // 是否自动弹出浏览器页面
    host: 'localhost',
    port: '8080',
    https: false,
    hotOnly: false,
    disableHostCheck: true,
    clientLogLevel: 'info',
    proxy: {
      '/': { // 给代理的地址取别名
        target: 'http://127.0.0.1:8081', // API服务器的地址
        ws: true, // 代理websockets
        changeOrigin: true
        // pathRewrite: { // 重写路径 比如'/api/aaa/ccc'重写为'/aaa/ccc'
        //   '^/api': ''
        // }
      }
      // '/baiduApi': {
      //   target: 'https://aip.baidubce.com', // API服务器的地址
      //   ws: true, // 代理websockets
      //   changeOrigin: true
      // }
    }
  }
}
