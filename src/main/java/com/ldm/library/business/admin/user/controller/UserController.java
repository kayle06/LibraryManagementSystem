package com.ldm.library.business.admin.user.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.user.domain.dto.UserListDto;
import com.ldm.library.business.admin.user.domain.entity.Users;
import com.ldm.library.business.admin.user.service.UserService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description 用户管理
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 21:46
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @return {@link ApiResponse }<{@link List }<{@link Users }>>
     * @Description 获取所有用户信息
     * @Author ldm
     * @Date 2024/04/16
     */
    @GetMapping("/listAll")
    public ApiResponse<List<Users>> listAll() {
        return userService.listAll();
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link Users }>>
     * @Description 分页查询用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    @GetMapping("/list")
    public ApiResponse<PageInfo<Users>> list(UserListDto reqBody) {
        return userService.list(reqBody);
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 新增用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    @PostMapping("add")
    public ApiResponse<String> add(@RequestBody Users reqBody) {
        return userService.add(reqBody);
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    @PutMapping("update")
    public ApiResponse<String> update(@RequestBody Users reqBody) {
        return userService.update(reqBody);
    }

    @DeleteMapping("delete/{id}")
    public ApiResponse<String> delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }
}
