package com.ldm.library.business.admin.role.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`role`")
public class Role {
    /**
     * 角色主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     *  角色描述
     */
    @TableField(value = "role_description")
    private String roleDescription;
}