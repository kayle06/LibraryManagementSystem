package com.ldm.library.business.admin.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.role.dao.RoleMapper;
import com.ldm.library.business.admin.role.domain.dto.RoleListDto;
import com.ldm.library.business.admin.role.domain.entity.Role;
import com.ldm.library.business.admin.role.service.RoleService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

    @Override
    public ApiResponse<PageInfo<Role>> list(RoleListDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        List<Role> ans = baseMapper.list(reqBody.getRoleName());
        PageInfo<Role> rolePageInfo = new PageInfo<>(ans);
        return ApiResponse.success(rolePageInfo);
    }

    @Override
    public ApiResponse<String> add(Role reqBody) {
        baseMapper.insert(reqBody);
        return ApiResponse.success("新增角色成功");
    }

    @Override
    public ApiResponse<String> update(Role reqBody) {
        baseMapper.updateById(reqBody);
        return ApiResponse.success("更新角色成功");
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        baseMapper.deleteById(id);
        return ApiResponse.success("删除角色成功");
    }

    @Override
    public ApiResponse<List<Role>> listAll() {
        List<Role> list = this.list();
        return ApiResponse.success(list);
    }
}
