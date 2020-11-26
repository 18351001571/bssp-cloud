<template>
  <div class="app-container">
    <div class="filter-container">
      <el-button v-loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"
                 @click="reportExport">
        导出
      </el-button>

      <el-button v-loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"
                 @click="exportHtml">
        导出HTML
      </el-button>

      <!--      <el-button v-loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"-->
      <!--                 @click="exporPdf">-->
      <!--        导出PDF-->
      <!--      </el-button>-->

      <!--      <el-button v-loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download"-->
      <!--                 @click="exportWord">-->
      <!--        导出WORD-->
      <!--      </el-button>-->
    </div>
    <template>
      <editor ref="toastuiEditor"/>
    </template>
  </div>
</template>

<script>
import {report} from "@/api/report";
import 'codemirror/lib/codemirror.css';
import '@toast-ui/editor/dist/toastui-editor.css';

import {Editor} from '@toast-ui/vue-editor';

export default {
  components: {
    editor: Editor
  },
  data() {
    return {
      downloadLoading: false,
      content: null,
      html: '',
    }
  },
  created() {

  },
  methods: {
    scroll() {
      this.$refs.toastuiEditor.invoke('scrollTop', 10);
    },
    moveTop() {
      this.$refs.toastuiEditor.invoke('moveCursorToStart');
    },
    getHtml() {
      let html = this.$refs.toastuiEditor.invoke('getHtml');
      return html;
    },
    reportExport() {
      this.downloadLoading = true,
          report().then((res) => {
            if (!res) {
              this.$notify({
                title: '失败',
                message: '报表生成失败',
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
              this.downloadLoading = false
            }
          })
    },

    exportHtml() {
      var a = document.createElement("a");
      var url = window.URL.createObjectURL(
          new Blob([this.generateHtml()], {
            type: ''
          })
      );
      a.href = url;
      a.download = "file.html";
      a.click();
      window.URL.revokeObjectURL(url);
    },

    generateHtml() {
      const template = this.getHtml();
      let html = `<!DOCTYPE html>
            <html>
            <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width,initial-scale=1.0">
            <title>HTML报表</title>
            <link rel="stylesheet" href="https://cdn.bootcss.com/iview/2.14.0/styles/iview.css" />

            </head>
            <body>
            <div class="resume_preview_page" style="margin:0 auto;width:1200px">
            ${template}
            </div>
            </body>
            </html>`;
      return html;
    }

  }
}
</script>

