package com.ldm.library.business.admin.user.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class Users {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 学号
     */
    private java.lang.String studentNo;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private java.lang.String username;

    /**
     * 加密密码
     */
    @TableField(value = "`password`")
    private java.lang.String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private java.lang.String email;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private java.lang.String phone;

    /**
     * 权限（0: 管理员, 1: 学生）
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 状态（0: 禁用, 1: 激活）
     */
    @TableField(value = "flag")
    @TableLogic(value = "1", delval = "0")
    private Integer flag;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}