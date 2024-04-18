package com.ldm.library.business.admin.role.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.role.domain.dto.RoleListDto;
import com.ldm.library.business.admin.role.domain.entity.Role;
import com.ldm.library.business.admin.role.service.RoleService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link Role }>>
     * @Description 角色列表
     * @Author ldm
     * @Date 2024/04/17
     */
    @GetMapping("/list")
    public ApiResponse<PageInfo<Role>> list(RoleListDto reqBody) {
        return roleService.list(reqBody);
    }

    @GetMapping("/listAll")
    public ApiResponse<List<Role>> listAll() {
        return roleService.listAll();
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 角色新增
     * @Author ldm
     * @Date 2024/04/17
     */
    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody Role reqBody) {
        return roleService.add(reqBody);
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 角色修改
     * @Author ldm
     * @Date 2024/04/17
     */
    @PutMapping("/update")
    public ApiResponse<String> update(@RequestBody Role reqBody) {
        return roleService.update(reqBody);
    }

    /**
     * @param id 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 角色删除
     * @Author ldm
     * @Date 2024/04/17
     */
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable("id") Integer id) {
        return roleService.delete(id);
    }
}
