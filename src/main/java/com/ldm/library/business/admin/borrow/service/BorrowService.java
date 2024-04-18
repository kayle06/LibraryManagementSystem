package com.ldm.library.business.admin.borrow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.borrow.domain.dto.BorrowListDto;
import com.ldm.library.business.admin.borrow.domain.entity.BookBorrow;
import com.ldm.library.business.admin.borrow.domain.vo.BorrowListVo;
import com.ldm.library.framework.result.ApiResponse;

import java.util.List;

/**
 * @ClassName BorrowService
 * @Description 借阅管理服务层
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 11:14
 */
public interface BorrowService extends IService<BookBorrow> {

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link List }<{@link BookBorrow }>>
     * @Description 借阅列表
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<PageInfo<BorrowListVo>> list(BorrowListDto reqBody);

    /**
     * @param bookBorrow 借阅信息
     * @return {@link ApiResponse }<{@link String }>
     * @Description 借阅添加
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<String> add(BookBorrow bookBorrow);

    /**
     * @param id 借阅id
     * @return {@link ApiResponse }<{@link String }>
     * @Description 归还图书
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<String> returnBook(Integer id);

    /**
     * @param bookBorrow 借阅信息
     * @return {@link ApiResponse }<{@link String }>
     * @Description 借阅更新
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<String> update(BookBorrow bookBorrow);
}
