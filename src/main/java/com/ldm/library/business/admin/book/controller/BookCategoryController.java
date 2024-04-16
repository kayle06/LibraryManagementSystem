package com.ldm.library.business.admin.book.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldm.library.business.admin.book.domain.dto.AddCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.SelectCategoryDto;
import com.ldm.library.business.admin.book.domain.dto.UpdateCategoryDto;
import com.ldm.library.business.admin.book.domain.entity.BookCategories;
import com.ldm.library.business.admin.book.service.BookCategoryService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BookCategoryController
 * @Description 图书分类控制器
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 12:59
 */
@RestController
@RequestMapping("/category")
public class BookCategoryController {


    @Resource
    private BookCategoryService bookCategoryService;

    /**
     * @param req 分页参数
     * @return {@link ApiResponse }<{@link Page }<{@link BookCategories }>>
     * @Description 分页查询图书分类列表
     * @Author ldm
     * @Date 2024/04/14
     */
    @GetMapping("/list")
    public ApiResponse<Page<BookCategories>> list(SelectCategoryDto req) {
        return bookCategoryService.list(req);
    }

    @GetMapping("/listAll")

    public ApiResponse<List<BookCategories>> listAll() {
        return bookCategoryService.listAll();
    }


    /**
     * @param id 分类ID
     * @return {@link ApiResponse }<{@link BookCategories }>
     * @Description 查询图书分类详情
     * @Author ldm
     * @Date 2024/04/14
     */
    @GetMapping("/detail/{id}")
    public ApiResponse<BookCategories> detail(@PathVariable Integer id) {
        return bookCategoryService.detail(id);
    }

    /**
     * @param req 图书分类实体类
     * @return {@link ApiResponse }<{@link String }>
     * @Description 新增图书分类
     * @Author ldm
     * @Date 2024/04/14
     */
    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody @Validated AddCategoryDto req) {
        return bookCategoryService.add(req);
    }

    /**
     * @param req 新图书信息
     * @return {@link ApiResponse }<{@link String }>
     * @Description 修改图书分类信息
     * @Author ldm
     * @Date 2024/04/14
     */
    @PutMapping("/update")
    public ApiResponse<String> update(@RequestBody UpdateCategoryDto req) {
        return bookCategoryService.update(req);
    }

    /**
     * @param id 分类ID
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除图书分类
     * @Author ldm
     * @Date 2024/04/14
     */
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable Integer id) {
        return bookCategoryService.delete(id);
    }

    @GetMapping("/search/{name}")
    public ApiResponse<List<BookCategories>> list(@PathVariable String name) {
        return bookCategoryService.list(name);
    }
}
