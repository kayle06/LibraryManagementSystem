package com.ldm.library.business.admin.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldm.library.business.admin.book.service.BookInfoService;
import com.ldm.library.framework.dao.book.BooksDao;
import com.ldm.library.framework.domain.entity.Books;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookInfoServiceImpl
 * @Description 图书信息服务实现
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:36
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BooksDao, Books> implements BookInfoService {
    @Override
    public ApiResponse<String> add(Books reqBody) {
        this.save(reqBody);
        return ApiResponse.success();
    }

    @Override
    public ApiResponse<String> del(Long id) {
        this.removeById(id);
        return ApiResponse.success();
    }
}
