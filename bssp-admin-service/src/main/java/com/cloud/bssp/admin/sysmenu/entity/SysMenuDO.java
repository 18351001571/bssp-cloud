package com.cloud.bssp.admin.sysmenu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
/**
 * Module: SysMenuDO.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-14
 * @Descriptions: 菜单
 */
@Data
@TableName(value = "bssp_sys_menu")
public class SysMenuDO  {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private String label;
    /**
     * 描述
     */
    @TableField("`desc`")
    private String desc;
    /**
     * 公共菜单True是无需分配所有人就可以访问的
     */
    private Integer isPublic;
    /**
     * 路径
     */
    private String path;
    /**
     * 组件
     */
    private String component;
    /**
     * 状态
     */
    private Integer isEnable;
    /**
     * 排序
     */
    private Integer sortValue;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 父级菜单ID
     */
    private Long parentId;
    /**
     * 删除标记，1是0否
     */
    private Integer isDelete;
    /**
     * 创建人id
     */
    private Long createUser;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新人id
     */
    private Long updateUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}