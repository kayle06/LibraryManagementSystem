package com.ldm.library.business.admin.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.role.domain.dto.RoleListDto;
import com.ldm.library.business.admin.role.domain.entity.Role;
import com.ldm.library.framework.result.ApiResponse;

import java.util.List;

public interface RoleService extends IService<Role>{


    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link Role }>>
     * @Description 分页查询角色列表
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<PageInfo<Role>> list(RoleListDto reqBody);

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 新增角色
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> add(Role reqBody);

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新角色
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> update(Role reqBody);

    /**
     * @param id 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除角色
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> delete(Integer id);

    /**
     * @return {@link ApiResponse }<{@link PageInfo }<{@link Role }>>
     * @Description 查询所有角色列表
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<List<Role>> listAll();
}
