package com.ldm.library.business.admin.book.controller;

import com.ldm.library.business.admin.book.service.BookInfoService;
import com.ldm.library.framework.domain.entity.Books;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName BookInfoController
 * @Description 图书信息控制器
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:29
 */
@RestController
@RequestMapping("/book")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 添加图书
     * @Author ldm
     * @Date 2024/04/03
     */
    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody Books reqBody) {
        return bookInfoService.add(reqBody);
    }

    @DeleteMapping("/del/{id}")
    public ApiResponse<String> del(@PathVariable Long id) {
        return bookInfoService.del(id);
    }
}
