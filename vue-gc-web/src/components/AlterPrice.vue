<template>
  <el-container>
    <el-header>
      <div style="margin-top: 10px;display: flex;justify-content: center">
        <el-input placeholder="输入垃圾名称搜索并修改"
                  prefix-icon="el-icon-search"
                  clearable
                  v-model="keywords"
                  style="width: 400px"
                  size="small">
        </el-input>
        <el-button type="primary"
                   icon="el-icon-search"
                   size="small"
                   style="margin-left: 3px"
                   @click="searchClick">搜索
        </el-button>
      </div>
    </el-header>
    <el-container class="containerCss">
      <el-form ref="form"
               :model="form"
               label-width="80px">
        <el-form-item label="垃圾名称">
          <el-input v-model="form.gName"
                    style="width:400px"
                    disabled></el-input>
        </el-form-item>
        <el-form-item label="垃圾类型">
          <el-select v-model="form.gType"
                     placeholder="请选择"
                     style="width:400px">
            <el-option label="可回收物"
                       value="可回收物"></el-option>
            <el-option label="有害垃圾"
                       value="有害垃圾"></el-option>
            <el-option label="干垃圾"
                       value="干垃圾"></el-option>
            <el-option label="湿垃圾"
                       value="湿垃圾"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="垃圾价格">
          <el-input v-model="form.gPrice"
                    style="width:400px"></el-input>
        </el-form-item>
        <el-form-item label="垃圾描述">
          <el-input type="textarea"
                    v-model="form.gDesc"
                    style="width:400px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="warning"
                     @click="onSubmit">修改</el-button>
          <el-button type="danger"
                     @click="deleteGc">删除 </el-button>
        </el-form-item>
      </el-form>
    </el-container>
  </el-container>
</template>

<script>
import qs from 'qs'
export default {
  name: 'AlterPrice',
  data () {
    return {
      keywords: '',
      form: {
        id: '',
        gName: '',
        gPrice: 0,
        gType: '',
        gDesc: ''
      }
    }
  },
  methods: {
    searchClick () {
      this.axios.get('/garbage/getName', {
        params: {
          name: this.keywords
        }
      }).then(res => {
        console.log(res)
        if (res.data === null) {
          this.$message.error('暂无该垃圾信息')
          return
        }
        this.form.id = res.data.id
        this.form.gName = res.data.gName
        this.form.gPrice = res.data.gPrice
        this.form.gType = res.data.gType
        this.form.gDesc = res.data.gDesc
        // this.aa = res.data
        // console.log(this.aa)
        // 清空搜索栏
        this.keywords = ''
      })
    },
    onSubmit () {
      this.axios.put('/garbage/updateGarbageInfo', qs.stringify({
        id: this.form.id,
        gName: this.form.gName,
        gPrice: this.form.gPrice,
        gType: this.form.gType,
        gDesc: this.form.gDesc
      })).then(res => {
        console.log(res)
        if (res.data === 1) {
          this.$message.success('修改成功')
        }
      }).catch(() => {
        this.$message.error('修改失败')
      })
    },
    deleteGc () {
      this.axios.delete('/garbage/delete', {
        params: {
          gName: this.form.gName
        }
      }).then(res => {
        console.log(res)
        if (res.data === true) {
          this.$message.success('删除成功')
          this.form = []
        }
      }).catch(() => {
        this.$message.error('删除失败')
      })
    }
  }
}
</script>

<style scoped>
.el-header {
  background-color: #ececec;
}
.containerCss {
  display: flex;
  background-color: #ececec;
  margin-top: 20px;
  padding-top: 10px;
  justify-content: center;
}
</style>
