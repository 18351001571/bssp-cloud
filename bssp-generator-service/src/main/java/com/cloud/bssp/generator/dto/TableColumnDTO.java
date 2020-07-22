package com.cloud.bssp.generator.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 表字段DTO
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Data
@ApiModel(value = "TableColumnDTO", description = "表字段DTO")
public class TableColumnDTO {
    /**
     * 字段名称
     */
    @ApiModelProperty(notes = "字段名称")
    private String columnName;
    /**
     * 字段类型
     */
    @ApiModelProperty(notes = "字段类型")
    private String dataType;
    /**
     * 字段描述
     */
    @ApiModelProperty(notes = "字段描述")
    private String columnComment;
    /**
     * 字段键值
     */
    @ApiModelProperty(notes = "字段键值")
    private String columnKey;
    /**
     * 表扩展信息
     */
    @ApiModelProperty(notes = "表扩展信息")
    private String extra;
}
