package com.cloud.bssp.generator.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 表DO
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Data
public class TableDO {

    /**
     * 表名称
     */
    private String tableName;
    /**
     * 存储引擎
     */
    private String engine;
    /**
     * 表描述
     */
    private String tableComment;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 表名称数组
     */
    private String[] tableNames;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 作者
     */
    private String author;
    /**
     * 服务名称
     */
    private String serviceName;
}
