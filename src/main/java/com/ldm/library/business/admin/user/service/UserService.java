package com.ldm.library.business.admin.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.user.domain.dto.UserListDto;
import com.ldm.library.business.admin.user.domain.entity.Users;
import com.ldm.library.framework.result.ApiResponse;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户管理业务接口
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 21:48
 */
public interface UserService extends IService<Users> {

    /**
     * @return {@link ApiResponse }<{@link List }<{@link Users }>>
     * @Description 获取所有用户信息
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<List<Users>> listAll();

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link Users }>>
     * @Description 分页查询用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<PageInfo<Users>> list(UserListDto reqBody);

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link Users }>
     * @Description 新增用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> add(Users reqBody);

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> update(Users reqBody);

    /**
     * @param id 需要删除的用户id
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<String> delete(Integer id);
}
