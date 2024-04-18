package com.ldm.library.business.admin.role.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.role.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper<Role> {
    /**
     * @param roleName 角色名称
     * @return {@link PageInfo }<{@link Role }>
     * @Description 根据角色名称查询角色列表
     * @Author ldm
     * @Date 2024/04/17
     */
    Page<Role> list(@Param("roleName") String roleName);
}