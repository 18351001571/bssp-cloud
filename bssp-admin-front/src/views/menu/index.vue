<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.label" placeholder="菜单名称" style="width: 200px;" class="filter-item"
                @keyup.enter.native="handleFilter"/>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        搜索
      </el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">
        添加
      </el-button>
      <el-button v-loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"
                 @click="handleDownload">
        导出
      </el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      style="width: 100%;"
    >
      <el-table-column label="菜单名称">
        <template slot-scope="scope">
          {{ scope.row.label }}
        </template>
      </el-table-column>
      <el-table-column label="路径" align="left">
        <template slot-scope="scope">
          <span>{{ scope.row.path }}</span>
        </template>
      </el-table-column>
      <el-table-column label="页面组件路径" align="left">
        <template slot-scope="scope">
          {{ scope.row.component }}
        </template>
      </el-table-column>
      <el-table-column label="图标" align="left">
        <template slot-scope="scope">
          {{ scope.row.icon }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="公共菜单" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.isPublic | statusFilter">{{ isPublicNames[scope.row.isPublic] }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="启用状态" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.isEnable | statusFilter">{{isEnableNames[scope.row.isEnable]}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>
          <el-button v-if="row.status!='deleted'" size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit"
                @pagination="getList"/>

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="70px"
               style="width: 400px; margin-left:50px;">
        <el-form-item :label="columnLabel.label">
          <el-input v-model="temp.label" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.isPublic">
          <el-select v-model="temp.isPublic" placeholder="Please select">
            <el-option v-for="item in isPublicOptions" :key="item.value" :label="item.label" :value="item.value"/>
          </el-select>
        </el-form-item>
        <el-form-item :label="columnLabel.path">
          <el-input v-model="temp.path" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.component">
          <el-input v-model="temp.component" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.isEnable">
          <el-select v-model="temp.isEnable" placeholder="Please select">
            <el-option v-for="item in isEnableOptions" :key="item.value" :label="item.label" :value="item.value"/>
          </el-select>
        </el-form-item>
        <el-form-item :label="columnLabel.sortValue">
          <el-input v-model="temp.sortValue" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.icon">
          <el-input v-model="temp.icon" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.parentId">
          <el-input v-model="temp.parentId" type="text"/>
        </el-form-item>
        <el-form-item :label="columnLabel.desc">
          <el-input v-model="temp.desc" type="text"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
          确认
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import Pagination from '@/components/Pagination' // secondary package based on el-pagination
  import {create, getPageMenu, update} from "@/api/menu";

  export default {
    components: {Pagination},
    filters: {
      statusFilter(status) {
        const statusMap = {
          1: 'success',
          2: 'info',
          0: 'danger'
        }
        return statusMap[status]
      }
    },
    data() {
      return {
        list: null,
        listLoading: true,
        downloadLoading: false,
        isEnableOptions: [{
          label: '启用',
          value: 1
        }, {
          label: '禁用',
          value: 0
        }],
        isPublicOptions: [{
          label: '是',
          value: 1
        }, {
          label: '否',
          value: 0
        }],
        isEnableNames: {
          1: '启用',
          0: '禁用'
        },
        isPublicNames: {
          1: '是',
          0: '否'
        },
        total: 0,
        listQuery: {
          page: 1,
          limit: 10,
          importance: undefined,
          label: undefined,
          type: undefined,
          sort: 'id'
        },
        dialogFormVisible: false,
        dialogStatus: '',
        textMap: {
          update: 'Edit',
          create: 'Create'
        },
        dialogPvVisible: false,
        temp: {
          label: '',
          isPublic: 0,
          path: '',
          component: '',
          isEnable: 1,
          sortValue: undefined,
          icon: '',
          parentId: 0,
          desc: '',
        },
        columnLabel: {
          label: '菜单名称',
          isPublic: '公共菜单',
          path: '接口地址',
          component: '页面地址',
          isEnable: '启用状态',
          sortValue: '排序',
          icon: '图标',
          parentId: '父id',
          desc: '描述',
        },
        rules: {
          type: [{required: true, message: 'type is required', trigger: 'change'}],
          timestamp: [{type: 'date', required: true, message: 'timestamp is required', trigger: 'change'}],
          title: [{required: true, message: 'title is required', trigger: 'blur'}]
        },
      }
    },
    created() {
      this.getList()
    },
    methods: {
      getList() {
        this.listLoading = true
        getPageMenu(this.listQuery).then(response => {
            this.total = response.data.total
            this.list = response.data.records
            // Just to simulate the time of the request
            setTimeout(() => {
              this.listLoading = false
            }, 1 * 1000)
          },
          error => {
          })
      },
      handleFilter() {
        this.listQuery.page = 1
        this.getList()
      },
      statusFilter(status) {
        const statusMap = {
          1: '启用',
          0: '禁用'
        }
        return statusMap[status]
      },
      resetTemp() {
        this.temp = {
          label: '',
          isPublic: 0,
          path: '',
          component: '',
          isEnable: 1,
          sortValue: undefined,
          icon: '',
          parentId: 0,
          desc: '',
        }
      },
      handleCreate() {
        this.resetTemp(),
          this.dialogStatus = 'create'
        this.dialogFormVisible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].clearValidate()
        })
      },
      createData() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            create(this.temp).then(() => {
              this.list.unshift(this.temp)
              this.dialogFormVisible = false
              this.$notify({
                title: '成功',
                message: '创建成功',
                type: 'success',
                duration: 2000
              }),
                this.getList()
            })
          }
        });
      },
      handleUpdate(row) {
        this.temp = Object.assign({}, row) // copy obj
        this.dialogStatus = 'update'
        this.dialogFormVisible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].clearValidate()
        })
      },
      updateData() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            const tempData = Object.assign({}, this.temp)
            update(tempData).then(() => {
              const index = this.list.findIndex(v => v.id === this.temp.id)
              this.list.splice(index, 1, this.temp)
              this.dialogFormVisible = false
              this.$notify({
                title: '成功',
                message: '更新成功',
                type: 'success',
                duration: 2000
              }),
                this.getList()
            })
          }
        })
      },
      handleDelete(row) {
        const h = this.$createElement;
        this.$msgbox({
          title: '消息',
          message: h('p', null, [
            h('span', null, '确认要删除当前记录吗？ ')
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(action => {
          const tempData = {'id': row.id, 'isDelete': 1}
          update(tempData).then(() => {
            const index = this.list.findIndex(v => v.id === this.temp.id)
            this.list.splice(index, 1, this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            }),
              this.getList()
          })
        });
      },
      handleDownload() {
        // this.downloadLoading = true
        // import('@/vendor/Export2Excel').then(excel => {
        //   const tHeader = ['timestamp', 'title', 'type', 'importance', 'status']
        //   const filterVal = ['timestamp', 'title', 'type', 'importance', 'status']
        //   const data = this.formatJson(filterVal)
        //   excel.export_json_to_excel({
        //     header: tHeader,
        //     data,
        //     filename: 'table-list'
        //   })
        //   this.downloadLoading = false
        // })
      },
    }
  }
</script>
