package com.cloud.bssp.generator.dto;

import com.cloud.bssp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Module: GenerateRulesDTO.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-17T10:00:32.925
 * @Descriptions:
 */
@Data
@ApiModel(value = "GenerateRulesDTO", description = "数据传输对象GenerateRulesDTO")
public class GenerateRulesDTO extends BaseDTO {

    /**
     * 主键
     */
    @ApiModelProperty(notes = "主键")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 作者
     */
    @ApiModelProperty(notes = "作者")
    private String author;
    /**
     * 包名
     */
    @ApiModelProperty(notes = "包名")
    private String packageName;
    /**
     * 服务名
     */
    @ApiModelProperty(notes = "服务名")
    private String serviceName;
    /**
     * 是否忽略前缀 1是0否
     */
    @ApiModelProperty(notes = "是否忽略前缀 1是0否")
    private Integer isIgnorePrefix;
    /**
     * 表前缀
     */
    @ApiModelProperty(notes = "表前缀")
    private String tablePrefix;
    /**
     * 创建时间
     */
    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(notes = "更新时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}