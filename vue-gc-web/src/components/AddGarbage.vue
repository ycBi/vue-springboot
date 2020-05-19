<template>
  <el-container>
    <el-header class="add_header">
      <el-form :inline="true"
               :model="formInline"
               class="demo-form-inline">
        <el-form-item label="垃圾名称">
          <el-input v-model="formInline.garbageName"
                    placeholder="垃圾名称"
                    clearable></el-input>
        </el-form-item>
        <el-form-item label="垃圾类型">
          <el-select v-model="formInline.garbageType"
                     placeholder="垃圾类型"
                     clearable>
            <el-option label="可回收物"
                       value="可回收物"></el-option>
            <el-option label="干垃圾"
                       value="干垃圾"></el-option>
            <el-option label="有害垃圾"
                       value="有害垃圾"></el-option>
            <el-option label="湿垃圾"
                       value="湿垃圾"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="垃圾价格">
          <el-input v-model="formInline.garbagePrice"
                    placeholder="垃圾价格"
                    clearable></el-input>
        </el-form-item>
        <el-form-item label="垃圾描述">
          <!--          <el-input v-model="formInline.garbagePrice" placeholder="垃圾描述"></el-input>-->
          <el-input type="textarea"
                    autosize
                    placeholder="请输入垃圾描述"
                    clearable
                    v-model="formInline.textarea1">
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"
                     @click="addNewGarbage">添加</el-button>
        </el-form-item>
      </el-form>
    </el-header>
    <el-main class="add_main">
      <el-table ref="multipleTable"
                :data="categories"
                tooltip-effect="dark"
                style="width: 100%"
                @selection-change="handleSelectionChange">
        <el-table-column type="selection"
                         width="55"
                         align="left">
        </el-table-column>
        <el-table-column label="垃圾名称"
                         prop="gName"
                         width="120"
                         align="left">
        </el-table-column>
        <el-table-column label="垃圾类型"
                         prop="gType"
                         width="120"
                         align="left">
        </el-table-column>
        <el-table-column prop="gPrice"
                         width="120"
                         label="垃圾价格"
                         align="left">
          <!--          <template slot-scope="scope">{{ scope.row.date }}</template>-->
        </el-table-column>
        <el-table-column prop="gDesc"
                         label="垃圾描述"
                         width="200"
                         align="left">
        </el-table-column>
        <el-table-column label="操作"
                         align="right">
          <template slot-scope="scope">
            <el-button size="mini"
                       @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button size="mini"
                       type="danger"
                       @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="danger"
                 :disabled="this.selItems.length==0"
                 style="margin-top: 10px;width: 100px;"
                 @click="deleteAll"
                 v-if="this.categories.length>0">批量删除
      </el-button>
    </el-main>
  </el-container>
</template>

<script>
import qs from 'qs'
export default {
  name: 'AddGarbage',
  data () {
    return {
      formInline: {
        garbageName: '',
        garbageType: '',
        garbagePrice: '',
        textarea1: ''
      },
      categories: [],
      selItems: []
    }
  },
  created () {
    this.axios.get('/garbage/getPartGarbageInfo').then(res => {
      console.log(res)
      this.categories = res.data
    })
  },
  methods: {
    addNewGarbage () {
      this.axios.post('/garbage/addNewGarbage', qs.stringify({
        gName: this.formInline.garbageName,
        gType: this.formInline.garbageType,
        gPrice: this.formInline.garbagePrice,
        gDesc: this.formInline.textarea1,
        image: 'http://127.0.0.1:9090/noPicture.jpg'
      })).then(res => {
        console.log(res)
        if (res.data === true) {
          this.$message.success('添加成功')
        }
        this.formInline = {}
        this.refresh()
      }).catch(() => {
        this.$message.error('添加失败')
      })
    },
    handleSelectionChange (val) {
      this.selItems = val
      console.log(val)
    },
    handleEdit (index, row) {
      this.$prompt('请输入新名称', '编辑', {
        confirmButtonText: '更新',
        inputValue: row.gName,
        cancelButtonText: '取消'
      }).then(value => {
        // value就是输入值
        if (value == null || value.length === 0) {
          this.$message({
            type: 'info',
            message: '数据不能为空!'
          })
        } else {
          this.axios.put('/garbage/updateGarbageName', qs.stringify({ id: row.id, gName: value.value })).then(res => {
            console.log(res.data)
            if (res.data === 1) {
              this.$message.success('编辑成功')
            }
            this.refresh()
          })
          console.log('aa')
        }
      })
    },
    handleDelete (index, row) {
      this.axios.delete('/garbage/delete', {
        params: {
          gName: row.gName
        }
      }).then(res => {
        console.log(res.data)
        if (res.data === true) { this.$message.success('删除成功') }
        this.refresh()
      })
    },
    deleteAll () {
      console.log(this.selItems)
      const len = this.selItems.length
      this.$confirm('确认删除这 ' + this.selItems.length + ' 条数据?', '提示', {
        type: 'warning',
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(() => {
        for (let i = 0; i < len; i++) {
          console.log(this.selItems)
          this.deleteGarbage(this.selItems[i].id)
        }
        // 在这里调用并不会刷新该页面，因为这前面调用异步的方法，可能这里refresh（）先执行导致删除后界面并没变化
        // this.refresh()
      })
      // 因为前面是异步方法，这个方法可能会提前把数组清空执行导致前面的报错
      // this.refresh()
    },
    refresh () {
      this.axios.get('/garbage/getPartGarbageInfo').then(res => {
        console.log(res)
        this.categories = res.data
      })
    },
    deleteGarbage (ids) {
      // 删除
      this.axios.delete('/garbage/deleteById', {
        params: {
          id: ids
        }
      }).then(res => {
        console.log(res)
        this.refresh()
      })
    }
  }
}
</script>

<style scoped>
.add_header {
  background-color: #ececec;
  margin-top: 20px;
  padding-left: 5px;
  padding-top: 10px;
  display: flex;
  justify-content: flex-start;
}

.add_main {
  /*justify-content: flex-start;*/
  display: flex;
  flex-direction: column;
  padding-left: 5px;
  background-color: #ececec;
  margin-top: 20px;
  padding-top: 10px;
}
</style>
