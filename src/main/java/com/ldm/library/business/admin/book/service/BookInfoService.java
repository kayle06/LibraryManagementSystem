package com.ldm.library.business.admin.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldm.library.framework.domain.entity.Books;
import com.ldm.library.framework.result.ApiResponse;

/**
 * @ClassName BookInfoService
 * @Description 图书信息服务
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:36
 */
public interface BookInfoService extends IService<Books> {
    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 添加图书信息
     * @Author ldm
     * @Date 2024/04/03
     */
    ApiResponse<String> add(Books reqBody);

    /**
     * @param id 图书主键
     * @return {@link ApiResponse }<{@link String }>
     * @Description 逻辑删除图书
     * @Author ldm
     * @Date 2024/04/03
     */
    ApiResponse<String> del(Long id);
}
