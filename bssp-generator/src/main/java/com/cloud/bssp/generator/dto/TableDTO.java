package com.cloud.bssp.generator.dto;

import com.cloud.bssp.util.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 表DTO
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Data
@ApiModel(value = "TableDTO",description = "表DTO")
public class TableDTO extends BaseDTO {

    /**
     * 表名称
     */
    @ApiModelProperty(notes  = "表名称")
    private String tableName;
    /**
     * 存储引擎
     */
    @ApiModelProperty(notes  = "存储引擎")
    private String engine;
    /**
     * 表描述
     */
    @ApiModelProperty(notes  = "表描述")
    private String tableComment;
    /**
     * 创建时间
     */
    @ApiModelProperty(notes  = "创建时间")
    private String createTime;
    /**
     * 表名称数组
     */
    @ApiModelProperty(notes  = "创建时间")
    private String[] tableNames;
}
