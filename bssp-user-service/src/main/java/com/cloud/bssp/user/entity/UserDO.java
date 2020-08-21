package com.cloud.bssp.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Description: 用户表
 * Create Date: 2020-07-23T14:08:34.269
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Data
@TableName(value = "bssp_user")
public class UserDO {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 1男2女0未知
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 证件类型
     */
    private Integer certificatesType;

    /**
     * 证件号码
     */
    private Long certificatesNum;

    /**
     * 地址
     */
    private String address;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 是否删除1是0否
     */
    private Integer isDelete;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}