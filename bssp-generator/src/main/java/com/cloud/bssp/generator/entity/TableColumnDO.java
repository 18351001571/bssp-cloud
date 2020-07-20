package com.cloud.bssp.generator.entity;

import lombok.Data;

/**
 * Description: 表字段DO
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Data
public class TableColumnDO {
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String dataType;
    /**
     * 字段描述
     */
    private String columnComment;
    /**
     * 字段键值
     */
    private String columnKey;
    /**
     * 表扩展信息
     */
    private String extra;
}
