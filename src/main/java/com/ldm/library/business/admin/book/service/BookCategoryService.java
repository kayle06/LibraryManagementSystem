package com.ldm.library.business.admin.book.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldm.library.business.admin.book.domain.dto.AddCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.SelectCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.UpdateCategoryDto;
import com.ldm.library.business.admin.book.domain.entity.BookCategories;
import com.ldm.library.framework.result.ApiResponse;

import java.util.List;

/**
 * @ClassName BookCategoryService
 * @Description 图书分类业务逻辑接口
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 13:20
 */
public interface BookCategoryService extends IService<BookCategories> {

    /**
     * @param req@return {@link ApiResponse }<{@link Page }<{@link BookCategories }>>
     * @Description 分页查询图书分类列表
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<Page<BookCategories>> listAll(SelectCategoryDto req);

    /**
     * @param id 图书分类ID
     * @return {@link ApiResponse }<{@link BookCategories }>
     * @Description 根据ID查询图书分类详情
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<BookCategories> detail(Integer id);

    /**
     * @param req 图书分类对象
     * @return {@link ApiResponse }<{@link BookCategories }>
     * @Description 新增图书分类
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<String> add(AddCategoryDto req);

    /**
     * @param req 图书分类对象
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新图书分类
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<String> update(UpdateCategoryDto req);

    /**
     * @param id 图书分类ID
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除图书分类
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<String> delete(Integer id);

    /**
     * @param name 图书分类名称
     * @return {@link ApiResponse }<{@link BookCategories }>
     * @Description 根据名称查询图书分类详情
     * @Author ldm
     * @Date 2024/04/14
     */
    ApiResponse<List<BookCategories>> list(String name);
}
