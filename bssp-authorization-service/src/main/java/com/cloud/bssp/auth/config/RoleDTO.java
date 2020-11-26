package com.cloud.bssp.auth.config;

import com.cloud.bssp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;

/**
 * Description:
 * Create Date: 2020-07-23T14:38:24.769
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Data
@ApiModel(value = "RoleDTO", description = "数据传输对象RoleDTO")
public class RoleDTO extends BaseDTO implements GrantedAuthority {

    /**
     * 主键
     */
    @ApiModelProperty(notes = "主键")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 角色名称
     */
    @ApiModelProperty(notes = "角色名称")
    private String roleName;

    /**
     * 描述
     */
    @ApiModelProperty(notes = "描述")
    private String roleDesc;

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

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
