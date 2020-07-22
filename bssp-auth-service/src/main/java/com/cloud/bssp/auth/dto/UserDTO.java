package com.cloud.bssp.auth.dto;

import com.cloud.bssp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Description: 用户表
 * Create Date: 2020-07-22T17:09:07.105
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Data
@ApiModel(value = "UserDTO", description = "数据传输对象UserDTO")
public class UserDTO extends BaseDTO {

        /**
         * 主键
         */
        @ApiModelProperty(notes = "主键")
            @JsonFormat(shape = JsonFormat.Shape.STRING)
        private Long id;

        /**
         * 昵称
         */
        @ApiModelProperty(notes = "昵称")
        private String nickname;

        /**
         * 真实姓名
         */
        @ApiModelProperty(notes = "真实姓名")
        private String realName;

        /**
         * 性别 1男2女0未知
         */
        @ApiModelProperty(notes = "性别 1男2女0未知")
        private Integer sex;

        /**
         * 手机号
         */
        @ApiModelProperty(notes = "手机号")
        private String phone;

        /**
         * 证件类型
         */
        @ApiModelProperty(notes = "证件类型")
        private Integer certificatesType;

        /**
         * 证件号码
         */
        @ApiModelProperty(notes = "证件号码")
        private Integer certificatesNum;

        /**
         * 地址
         */
        @ApiModelProperty(notes = "地址")
        private String address;

        /**
         * 来源
         */
        @ApiModelProperty(notes = "来源")
        private Integer source;

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