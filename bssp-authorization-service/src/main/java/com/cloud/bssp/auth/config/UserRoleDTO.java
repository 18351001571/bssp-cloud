package com.cloud.bssp.auth.config;

import com.cloud.bssp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description: 用户角色关系表
 * Create Date: 2020-07-23T14:46:56.062
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Data
@ApiModel(value = "UserRoleDTO", description = "数据传输对象UserRoleDTO")
public class UserRoleDTO extends BaseDTO {

    /**
     * 主键
     */
    @ApiModelProperty(notes = "主键")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(notes = "用户id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty(notes = "角色id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    /**
     * 是否删除1是0否
     */
    @ApiModelProperty(notes = "是否删除1是0否")
    private Integer isDelete;

    /**
     *
     */
    @ApiModelProperty(notes = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     *
     */
    @ApiModelProperty(notes = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}