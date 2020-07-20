package com.cloud.bssp.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
/**
 * Module: GenerateRulesDO.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-17T10:00:32.925
 * @Descriptions: 
 */
@Data
@TableName(value = "bssp_generate_rules")
public class GenerateRulesDO  {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 作者
     */
    private String author;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 服务名
     */
    private String serviceName;
    /**
     * 是否忽略前缀 1是0否
     */
    private String isIgnorePrefix;
    /**
     * 表前缀
     */
    private String tablePrefix;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}