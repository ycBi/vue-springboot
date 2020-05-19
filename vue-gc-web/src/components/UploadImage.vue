<template>
  <div>
    <div>
    <i>上传垃圾名称：</i>
    <el-input placeholder="请输入上传垃圾名称"
              v-model="input"
              style="width: 400px;margin-left: 20px"
              clearable>
    </el-input>
  </div>
    <div style="margin-top: 30px">
    <i>上传垃圾图片图片</i>
    <el-upload class="avatar-uploader"
               action="/garbage/uploadImage"
               :show-file-list="false"
               :data="data1"
               :on-success="handleAvatarSuccess"
               :before-upload="beforeAvatarUpload">
      <img v-if="imageUrl"
           :src="imageUrl"
           class="avatar">
      <i v-else
         class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    </div>
    <div>
      <el-button type="primary" @click="submit">添加</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      imageUrl: '',
      input: '',
      data1: {
        gName: ''
      }
    }
  },
  methods: {
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
      console.log(res)
      if (res.error === 0) {
        this.$message.success('上传成功')
        return
      }
      this.$message.error('垃圾名称不存在，请先添加垃圾名称')
    },
    beforeAvatarUpload (file) {
      this.data1.gName = this.input
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    submit () {
      this.$router.push('/AddGarbage')
    }
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
  margin-left: 20px;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
