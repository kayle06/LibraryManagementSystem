package com.ldm.library.business.admin.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldm.library.business.admin.book.dao.BookCategoriesMapper;
import com.ldm.library.business.admin.book.domain.dto.AddCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.SelectCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.UpdateCategoryDto;
import com.ldm.library.business.admin.book.domain.entity.BookCategories;
import com.ldm.library.business.admin.book.service.BookCategoryService;
import com.ldm.library.framework.enumerate.ResponseEnum;
import com.ldm.library.framework.result.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookCategoryServiceImpl
 * @Description 图书分类业务实现类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 13:20
 */
@Service
@Slf4j
public class BookCategoryServiceImpl extends ServiceImpl<BookCategoriesMapper, BookCategories> implements BookCategoryService {
    @Override
    public ApiResponse<Page<BookCategories>> list(SelectCategoryDto req) {
        Page<BookCategories> bookCategoriesPage = new Page<>(req.getPageNum(), req.getPageSize());
        QueryWrapper<BookCategories> desc = new QueryWrapper<BookCategories>()
                .like(req.getCategoryName()!= null, "category_name", req.getCategoryName())
                .orderByDesc("create_time");
        Page<BookCategories> ans = baseMapper.selectPage(bookCategoriesPage, desc);
        return ApiResponse.success(ans);
    }

    @Override
    public ApiResponse<BookCategories> detail(Integer id) {
        BookCategories bookCategories = baseMapper.selectById(id);
        return ApiResponse.success(bookCategories);
    }

    @Override
    public ApiResponse<String> add(AddCategoryDto req) {
        BookCategories categories = new BookCategories();
        BeanUtils.copyProperties(req, categories);
        int insertCount = baseMapper.insert(categories);
        if (insertCount > 0) {
            return ApiResponse.success(ResponseEnum.SUCCESS_TO_ADD_CATEGORY.getMessage());
        }
        return ApiResponse.error(ResponseEnum.FAILED_TO_ADD_CATEGORY.getCode(),
                ResponseEnum.FAILED_TO_ADD_CATEGORY.getMessage());
    }

    @Override
    public ApiResponse<String> update(UpdateCategoryDto req) {
        BookCategories categories = new BookCategories();
        BeanUtils.copyProperties(req, categories);
        int updateCount = baseMapper.updateById(categories);
        if (updateCount > 0) {
            return ApiResponse.success(ResponseEnum.SUCCESS_TO_UPDATE_CATEGORY.getMessage());
        }
        return ApiResponse.error(ResponseEnum.FAILED_TO_UPDATE_CATEGORY.getCode(),
                ResponseEnum.FAILED_TO_UPDATE_CATEGORY.getMessage());
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        int deleteCount = baseMapper.deleteById(id);
        if (deleteCount > 0) {
            return ApiResponse.success(ResponseEnum.SUCCESS_TO_DELETE_CATEGORY.getMessage());
        }
        return ApiResponse.error(ResponseEnum.FAILED_TO_DELETE_CATEGORY.getCode(),
                ResponseEnum.FAILED_TO_DELETE_CATEGORY.getMessage());
    }

    @Override
    public ApiResponse<List<BookCategories>> list(String name) {
        QueryWrapper<BookCategories> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("category_name", name)
                .orderByDesc("create_time");
        List<BookCategories> list = list(queryWrapper);
        return ApiResponse.success(list);
    }

    @Override
    public ApiResponse<List<BookCategories>> listAll() {
        List<BookCategories> list = list();
        return ApiResponse.success(list);
    }
}
