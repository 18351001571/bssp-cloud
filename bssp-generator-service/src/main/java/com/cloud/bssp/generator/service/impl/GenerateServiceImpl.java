package com.cloud.bssp.generator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.constants.SystemConstant;
import com.cloud.bssp.generator.dao.GenerateMapper;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.generator.entity.TableColumnDO;
import com.cloud.bssp.generator.entity.TableDO;
import com.cloud.bssp.generator.service.GenerateRulesService;
import com.cloud.bssp.generator.service.GenerateService;
import com.cloud.bssp.generator.util.ColumnEntity;
import com.cloud.bssp.generator.util.CommonMap;
import com.cloud.bssp.generator.util.TableEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Description: 代码生成服务实现类
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class GenerateServiceImpl implements GenerateService {

    /**
     * generateMapper
     */
    private GenerateMapper generateMapper;

    /**
     * 生成规则service
     */
    private GenerateRulesService generateRulesService;

    @Override
    public TableDO queryTable(String tableName) {
        return generateMapper.queryTable(tableName);
    }

    @Override
    public List<TableColumnDO> queryColumns(String tableName) {
        return generateMapper.queryColumns(tableName);
    }

    @Override
    public List<TableDO> queryAllTable() {
        return generateMapper.queryAllTable();
    }

    @Override
    public Page<TableDO> page(Page<TableDO> page, TableDO tableDO) {
        int count;
        List<TableDO> list;
        //count统计
        if (StringUtils.isEmpty(tableDO.getTableName())) {
            count = generateMapper.countAll();
            if (count == 0) {
                return new Page<>();
            }
            list = generateMapper.pageListAll(page.getSize() * (page.getCurrent() - 1), page.getSize());
        } else {
            count = generateMapper.count(tableDO.getTableName());
            if (count == 0) {
                return new Page<>();
            }
            list = generateMapper.pageList(tableDO.getTableName(),
                    page.getSize() * (page.getCurrent() - 1), page.getSize());
        }
        //分页数据
        page.setRecords(list);
        page.setTotal(count);
        return page;
    }

    @Override
    public ByteArrayOutputStream generateCode(TableDO tableDO) {
        List<GenerateRulesDO> list = generateRulesService.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableDO.getTableNames()) {
            TableDO table = generateMapper.queryTable(tableName);
            List<TableColumnDO> columns = generateMapper.queryColumns(tableName);
            this.generatorCode(table, list.get(0), columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream;

    }

    @Override
    public List<Map<String, String>> previewCode(String tableName) {
        List<GenerateRulesDO> list = generateRulesService.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        TableDO table = generateMapper.queryTable(tableName);
        List<TableColumnDO> columns = generateMapper.queryColumns(tableName);
        List<Map<String, String>> listMap = this.previewList(table, list.get(0), columns);
        return listMap;
    }

    private List<Map<String, String>> previewList(
            TableDO table, GenerateRulesDO generateRule, List<TableColumnDO> columns) {
        // 表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.getTableName());
        tableEntity.setComments(table.getTableComment());
        // 表名转换成Java类名,去除表前缀
        String className;
        if (SystemConstant.ONE == generateRule.getIsIgnorePrefix()) {
            className = tableToJava(tableEntity.getTableName(), generateRule.getTablePrefix());
        } else {
            className = tableToJava(tableEntity.getTableName(), null);
        }
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        List<ColumnEntity> columnList = new ArrayList<>();
        for (TableColumnDO tableColumnDO : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(tableColumnDO.getColumnName());
            columnEntity.setDataType(tableColumnDO.getDataType());
            columnEntity.setComments(tableColumnDO.getColumnComment());
            columnEntity.setExtra(tableColumnDO.getExtra());

            // 列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            // 列的数据类型，转换成Java类型
            String attrType = CommonMap.javaTypeMap.get(columnEntity.getDataType());
            attrType = StringUtils.isBlank(attrType) ? "unknownType" : attrType;
            columnEntity.setAttrType(attrType);

            // 是否主键
            if ("PRI".equalsIgnoreCase(tableColumnDO.getColumnKey()) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }
            columnList.add(columnEntity);
        }
        tableEntity.setColumns(columnList);

        // 没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        // 设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        // 封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("package", generateRule.getPackageName());
        map.put("author", generateRule.getAuthor());
        map.put("date", LocalDateTime.now());
        map.put("jdk", CommonMap.javaTypeMap.get("jdk"));
        map.put("version", CommonMap.javaTypeMap.get("version"));
        map.put("serviceName", generateRule.getServiceName());
        VelocityContext context = new VelocityContext(map);

        // 获取模板列表
        List<String> templates = getTemplates();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> dataMap;
        for (String template : templates) {
            dataMap = new LinkedHashMap<>();
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            dataMap.put("key", StringUtils.substringBetween(template, "template/", ".vm"));
            dataMap.put("value", sw.toString());
            list.add(dataMap);
        }
        return list;
    }

    private Map<String, Object> generatorCode(TableDO table, GenerateRulesDO generateRule,
                                              List<TableColumnDO> columns, ZipOutputStream zip) {
        // 表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.getTableName());
        tableEntity.setComments(table.getTableComment());
        // 表名转换成Java类名,去除表前缀
        String className;
        if (SystemConstant.ONE == generateRule.getIsIgnorePrefix()) {
            className = tableToJava(tableEntity.getTableName(), generateRule.getTablePrefix());
        } else {
            className = tableToJava(tableEntity.getTableName(), null);
        }
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        List<ColumnEntity> columnList = new ArrayList<>();
        for (TableColumnDO tableColumnDO : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(tableColumnDO.getColumnName());
            columnEntity.setDataType(tableColumnDO.getDataType());
            columnEntity.setComments(tableColumnDO.getColumnComment());
            columnEntity.setExtra(tableColumnDO.getExtra());

            // 列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            // 列的数据类型，转换成Java类型
            String attrType = CommonMap.javaTypeMap.get(columnEntity.getDataType());
            attrType = StringUtils.isBlank(attrType) ? "unknownType" : attrType;
            columnEntity.setAttrType(attrType);

            // 是否主键
            if ("PRI".equalsIgnoreCase(tableColumnDO.getColumnKey()) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }
            columnList.add(columnEntity);
        }
        tableEntity.setColumns(columnList);

        // 没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        // 设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        // 封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("package", generateRule.getPackageName());
        map.put("author", generateRule.getAuthor());
        map.put("date", LocalDateTime.now());
        map.put("jdk", CommonMap.javaTypeMap.get("jdk"));
        map.put("version", CommonMap.javaTypeMap.get("version"));
        map.put("serviceName", generateRule.getServiceName());
        VelocityContext context = new VelocityContext(map);

        // 获取模板列表
        List<String> templates = getTemplates();
        Map<String, Object> dataMap = new LinkedHashMap<>();
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            dataMap.put(template, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), generateRule.getPackageName())));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }

    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }
        if (template.contains("Entity.java.vm")) {
            return packagePath + "entity" + File.separator + className + "DO.java";
        }
        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }
        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if (template.contains("Mapper.java.vm")) {
            return packagePath + "mapper" + File.separator + className + "Mapper.java";
        }
        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("DTO.java.vm")) {
            return packagePath + "dto" + File.separator + className + "DTO.java";
        }
        if (template.contains("Client.java.vm")) {
            return packagePath + "api" + File.separator + className + "Client.java";
        }
        if (template.contains("Convert.java.vm")) {
            return packagePath + "convert" + File.separator + className + "DoConvert.java";
        }
        return null;
    }

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Mapper.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/DTO.java.vm");
        templates.add("template/Client.java.vm");
        templates.add("template/Convert.java.vm");
        return templates;
    }
}
