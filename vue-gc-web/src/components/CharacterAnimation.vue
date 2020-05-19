<template>
  <div style="position: absolute">
    <el-container>
      <el-upload
        class="upload-demo"
        action=""
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeUpload"
        :limit="1"
        :on-exceed="handleExceed"
        :file-list="fileList">
        <el-button size="small" type="primary" @click="submit">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
      <img :src="tableData.image" width="100" height="100">
    </el-container>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  data () {
    return {
      fileList: [],
      imgBase64Array: '',
      tableData: [],
      fullscreenLoading: false
    }
  },
  methods: {
    submit () {
      this.fullscreenLoading = true
    },
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    handlePreview (file) {
      console.log(file)
    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    // 获取action访问URl获取的值
    handleAvatarSuccess (res, file) {
      // this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeRemove (file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`)
    },
    beforeUpload (file) {
      console.log(1)
      console.log(file)
      // 注意：图片需要base64编码、去掉编码头（data:image/jpg;base64,）后，再进行urlencode,类型为string，这是百度接口参数要求
      const reader = new FileReader()
      let imgFile
      let imgFile2
      reader.readAsDataURL(file)
      reader.onload = async e => {
        imgFile = e.target.result
        const arr = imgFile.split(',')
        imgFile2 = arr[1]
        this.axios.post('https://aip.baidubce.com/rest/2.0/image-process/v1/selfie_anime',
          qs.stringify({
            access_token: '24.3cb9b473c0f46ea6c0bef7e832220bb4.2592000.1592446322.282335-19860919',
            image: imgFile2
          })).then(
          res => {
            console.log(res)
            this.tableData = res.data.result
            if (this.tableData === undefined || this.tableData.length === 0) {
              this.$message.error('图片识别失败')
              console.log('图片识别失败')
            }
            this.fullscreenLoading = false
          }
        )
        // console.log('file 转 base64结果：' + reader.result)
        // console.log(this.imgBase64Array)
        // this.imgBase64Array = reader.result
        // console.log('1' + typeof reader.result)
        // console.log('2' + typeof this.imgBase64Array)
        // console.log(this.imgBase64Array)
        // this.imgBase64Array = this.imgBase64Array.replace('data:image/jpeg;base64,', '')
        // // this.imgBase64Array = this.imgBase64Array.slice(1)
        // // this.imgBase64Array = this.imgBase64Array.split(',').slice(1).join(',')
        // console.log('截取' + this.imgBase64Array)
        // // console.log('62' + this.imgBase64Array)
        // // this.imgBase64Array = encodeURI(this.imgBase64Array)
        // console.log()
        // // this.imgBase64Array = 'image=' + this.imgBase64Array
        // this.imgBase64Array = decodeURIComponent(this.imgBase64Array)
      }
      reader.onerror = function (error) {
        console.log('Error: ', error)
      }
      // this.axios.post('https://aip.baidubce.com/rest/2.0/image-process/v1/selfie_anime?access_token=24.1d933d95a27e509639c087d7db474aef.2592000.1591953454.282335-19860919',
      //   qs.stringify({ image: this.imgBase64Array })).then(
      //   res => {
      //     console.log(res)
      //     this.tableData = res.data.result
      //     if (this.tableData === undefined || this.tableData.length === 0) {
      //       this.$message.error('图片识别失败')
      //       console.log('图片识别失败')
      //     }
      //     this.fullscreenLoading = false
      //   }
      // )
    }
  }
}
</script>

<style scoped>
  .el-container {
    display: flex;
    /*justify-content: center;*/
    flex-direction: column;
    /*margin-left:50%;*/
    transform:translateX(50%);
    position: relative;
  }
  /*.el-table{*/
  /*  margin-left:20%;*/
  /*  translatex: 50%;*/
  /*}*/
  body {
    margin: 0;
  }
</style>
