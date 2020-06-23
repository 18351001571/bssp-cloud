package com.cloud.bssp.data.sysmenu.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * Module: SysMenuDTO.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-06-23
 * @Descriptions: 菜单
 */
@Data
public class SysMenuDTO  {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String label;
    /**
     * 描述
     */
    private String desc;
    /**
     * 公共菜单
True是无需分配所有人就可以访问的
     */
    private Boolean isPublic;
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
    private Boolean isEnable;
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
     * 创建人id
     */
    private Long createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新人id
     */
    private Long updateUser;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}