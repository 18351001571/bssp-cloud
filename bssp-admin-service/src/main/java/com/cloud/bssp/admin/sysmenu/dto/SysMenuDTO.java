package com.cloud.bssp.admin.sysmenu.dto;

import com.cloud.bssp.util.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * Module: SysMenuDTO.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-13
 * @Descriptions: 菜单
 */
@Data
@ApiModel(value = "SysMenuDTO",description = "数据传输对象SysMenuDTO")
public class SysMenuDTO extends BaseDTO{

    /**
     * 主键
     */
    @ApiModelProperty(notes  = "主键")
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty(notes  = "名称")
    private String label;
    /**
     * 描述
     */
    @ApiModelProperty(notes  = "描述")
    private String desc;
    /**
     * 公共菜单True是无需分配所有人就可以访问的
     */
    @ApiModelProperty(notes  = "公共菜单True是无需分配所有人就可以访问的")
    private Boolean isPublic;
    /**
     * 路径
     */
    @ApiModelProperty(notes  = "路径")
    private String path;
    /**
     * 组件
     */
    @ApiModelProperty(notes  = "组件")
    private String component;
    /**
     * 状态
     */
    @ApiModelProperty(notes  = "状态")
    private Boolean isEnable;
    /**
     * 排序
     */
    @ApiModelProperty(notes  = "排序")
    private Integer sortValue;
    /**
     * 菜单图标
     */
    @ApiModelProperty(notes  = "菜单图标")
    private String icon;
    /**
     * 父级菜单ID
     */
    @ApiModelProperty(notes  = "父级菜单ID")
    private Long parentId;
    /**
     * 创建人id
     */
    @ApiModelProperty(notes  = "创建人id")
    private Long createUser;
    /**
     * 创建时间
     */
    @ApiModelProperty(notes  = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新人id
     */
    @ApiModelProperty(notes  = "更新人id")
    private Long updateUser;
    /**
     * 更新时间
     */
    @ApiModelProperty(notes  = "更新时间")
    private LocalDateTime updateTime;
}