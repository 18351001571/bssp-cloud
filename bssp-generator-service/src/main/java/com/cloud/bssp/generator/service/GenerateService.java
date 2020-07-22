package com.cloud.bssp.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.entity.TableColumnDO;
import com.cloud.bssp.generator.entity.TableDO;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * Description: 代码生成service
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public interface GenerateService {

    /**
     * Description: 根据表名获取表信息
     * Created date: 2020/7/15
     * @param tableName 表名
     * @return java.util.Map<com.cloud.bssp.generator.entity.TableDO>
     * @author weirx
     */
    TableDO queryTable(String tableName);

    /**
     * Description: 根据表名获取表字段
     * Created date: 2020/7/15
     * @param tableName 表名
     * @return java.util.List<com.cloud.bssp.generator.entity.TableColumnDO>
     * @author weirx
     */
    List<TableColumnDO> queryColumns(String tableName);

    /**
     * Description: 获取全部表
     * Created date: 2020/7/15
     * @return java.util.List<com.cloud.bssp.generator.entity.TableColumnDO>
     * @author weirx
     */
    List<TableDO> queryAllTable();

    /**
     * Description: 分页
     * Created date: 2020/7/15
     * @param page
     * @param tableDO
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.cloud.bssp.generator.entity.TableDO>
     * @author weirx
     */
    Page<TableDO> page(Page<TableDO> page, TableDO tableDO);

    /**
     * Description: 生成代码
     * Created date: 2020/7/16
     * @param tableDO
     * @return com.cloud.bssp.util.R
     * @author weirx
     */
    ByteArrayOutputStream generateCode(TableDO tableDO);

    /**
     * Description: 代码预览
     * Created date: 2020/7/16
     * @param tableName
     * @return com.cloud.bssp.generator.entity.PreviewCodeDO
     * @author weirx
     */
    List<Map<String, String>> previewCode(String tableName);
}
