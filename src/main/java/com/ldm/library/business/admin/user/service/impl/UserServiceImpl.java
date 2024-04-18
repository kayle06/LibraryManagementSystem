package com.ldm.library.business.admin.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.user.dao.UserDao;
import com.ldm.library.business.admin.user.domain.dto.UserListDto;
import com.ldm.library.business.admin.user.domain.entity.Users;
import com.ldm.library.business.admin.user.service.UserService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务实现类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 21:49
 */
@Service
public class UserServiceImpl extends ServiceImpl <UserDao, Users> implements UserService {

    @Override
    public ApiResponse<List<Users>> listAll() {
        List<Users> usersList = this.list();
        return ApiResponse.success(usersList);
    }

    @Override
    public ApiResponse<PageInfo<Users>> list(UserListDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        List<Users> usersList = baseMapper.list(reqBody.getStudentNo());
        PageInfo<Users> pageInfo = new PageInfo<>(usersList);
        return ApiResponse.success(pageInfo);
    }

    @Override
    public ApiResponse<String> add(Users reqBody) {
        reqBody.setFlag(1);
        this.save(reqBody);
        return ApiResponse.success("新增用户成功");
    }

    @Override
    public ApiResponse<String> update(Users reqBody) {
        this.updateById(reqBody);
        return ApiResponse.success("更新用户成功");
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        this.removeById(id);
        return ApiResponse.success("删除用户成功");
    }
}
