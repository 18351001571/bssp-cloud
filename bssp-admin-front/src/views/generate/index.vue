<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.label" placeholder="表名称" style="width: 200px;" class="filter-item"
                @keyup.enter.native="handleFilter"/>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        搜索
      </el-button>

      <el-button class="filter-item" type="primary" icon="el-icon-s-tools" @click="generateRules">
        生成规则设置
      </el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-download" @click="batchGenerate">
        批量生成
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
        @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          width="40"
          align="center">
      </el-table-column>
      <el-table-column label="表名称">
        <template slot-scope="scope">
          {{ scope.row.tableName }}
        </template>
      </el-table-column>
      <el-table-column label="存储引擎" align="left">
        <template slot-scope="scope">
          <span>{{ scope.row.engine }}</span>
        </template>
      </el-table-column>
      <el-table-column label="描述" align="left">
        <template slot-scope="scope">
          {{ scope.row.tableComment }}
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="left">
        <template slot-scope="scope">
          {{ scope.row.createTime }}
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" icon="el-icon-search" @click="preview(row)">
            预览
          </el-button>
          <el-button v-if="row.status!='deleted'" icon="el-icon-download" size="mini" type="danger"
                     @click="generate(row,$index)">
            生成
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit"
                @pagination="getList"/>

    <el-dialog title="代码生成规则设置" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="right" label-width="80px"
               style="width: 500px; margin-left:100px;">
        <el-form-item label="作者" prop="author">
          <el-input v-model="temp.author" type="text"/>
        </el-form-item>
        <el-form-item label="包名" prop="packageName">
          <el-input v-model="temp.packageName" type="text"/>
        </el-form-item>
        <el-form-item label="服务名" prop="serviceName">
          <el-input v-model="temp.serviceName" type="text"/>
        </el-form-item>
        <el-form-item label="忽略前缀" prop="isIgnorePrefix">
          <el-radio :label="1" v-model="radio">是</el-radio>
          <el-radio :label="0" v-model="radio">否</el-radio>
        </el-form-item>
        <el-form-item label="前缀" prop="tablePrefix">
          <el-input v-model="temp.tablePrefix" type="text"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="confirmRules()">
          确认
        </el-button>
      </div>
    </el-dialog>

    <el-dialog title="预览" :visible.sync="previewVisible">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane v-for="item in templateList" :label="item.key" :name="item.key">
          <textarea readonly style="width: 100%; height: 400px; border: #99a9bf;resize:none;">{{item.value}}</textarea>
        </el-tab-pane>
      </el-tabs>
      <div slot="footer" class="dialog-footer">
        <el-button @click="previewVisible = false">
          关闭
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import Pagination from '@/components/Pagination' // secondary package based on el-pagination
import {generateCode, getPageList, getRules, previewCode, saveRules} from "@/api/generate";

export default {
  components: {Pagination},
  data() {
    return {
      templateList: '',
      activeName: 'Entity.java',
      radio: 1,
      rulesId: '',
      list: null,
      listLoading: true,
      downloadLoading: false,
      total: 0,
      listQuery: {
        page: 1,
        limit: 10,
        tableName: ''
      },
      dialogStatus: '',
      // textMap: {
      //   generateCode: '代码生成规则设置',
      //   preview: '预览',
      //   generateRules: '生成规则'
      // },
      temp: {},
      dialogFormVisible: false,
      previewVisible: false,
      tableNames: undefined,
      rules: {
        author: [{required: true, message: '请输入作者', trigger: 'change'}],
        packageName: [{required: true, message: '请输入包名', trigger: 'change'}],
        serviceName: [{required: true, message: '请输入服务名', trigger: 'change'}],
        tablePrefix: [{required: false, message: '请输入前缀', trigger: 'change'}]
      },
      activeTab: 'basic',
      tableTabs: undefined
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      getPageList(this.listQuery).then(response => {
            this.total = response.data.total
            this.list = response.data.records
            // Just to simulate the time of the request
            setTimeout(() => {
              this.listLoading = false
            }, 1.5 * 1000)
          },
          error => {
          })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleSelectionChange(val) {
      this.tableNames = val;
    },
    handleClick() {
      if (!this.temp.packageName || !this.temp.author) {
        this.$refs['dataForm'].validate();
        return false;
      }
    },
    resetTemp() {
      this.temp = {};
    },
    generate(row) {
      let names = new Array(1);
      names[0] = row.tableName;
      this.temp.tableNames = names;
      this.generateCode();
      this.resetTemp();
    },
    batchGenerate() {
      if (!this.tableNames) {
        this.$notify({
          title: '失败',
          message: '请至少选择一条记录',
          type: 'error',
          duration: 2000
        });
        return;
      }
      let names = new Array();
      let tables = this.tableNames;
      for (let i = 0; i < tables.length; i++) {
        names[i] = tables[i].tableName;
      }
      this.temp.tableNames = names;
      this.generateCode();
      this.resetTemp();
    },
    generateCode() {
      generateCode(this.temp).then((res) => {
        if (!res) {
          this.$notify({
            title: '失败',
            message: '请先设置生成规则',
            type: 'error',
            duration: 2000
          });
          return;
        }
        let blob = new Blob([res], {
          type: 'application/zip'
        })
        let fileName = Date.parse(new Date()) + '.zip'
        if (window.navigator.msSaveOrOpenBlob) {
          navigator.msSaveBlob(blob, fileName)
        } else {
          let link = document.createElement('a')
          link.href = window.URL.createObjectURL(blob)
          link.download = fileName
          link.click()
          this.dialogFormVisible = false
          //释放内存
          window.URL.revokeObjectURL(link.href)
        }
      })
    },
    /**
     * 生成规则设置页面
     */
    generateRules() {
      this.dialogStatus = 'generateRules'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      });
      getRules().then((res) => {
        if (res.code == 0) {
          let data = res.data;
          this.temp = {
            id: data.id,
            tableNames: '',
            author: data.author,
            packageName: data.packageName,
            serviceName: data.serviceName,
            tablePrefix: data.tablePrefix,
            isIgnorePrefix: data.isIgnorePrefix,
          }
        }
      })
    },
    confirmRules() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.temp.isIgnorePrefix = this.radio;
          saveRules(this.temp).then((res) => {
            if (res.code == 0) {
              this.dialogFormVisible = false;
              this.$notify({
                title: '成功',
                message: '设置成功',
                type: 'success',
                duration: 2000
              })
            }
          })
        }
      })
    },
    preview(row) {
      previewCode(row.tableName).then((res) => {
        this.templateList = res.data;
        console.log(this.templateList);
        this.previewVisible = true;
      })
    }
  }
}
</script>
