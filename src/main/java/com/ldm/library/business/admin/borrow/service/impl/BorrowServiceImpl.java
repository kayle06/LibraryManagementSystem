package com.ldm.library.business.admin.borrow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.borrow.dao.BookBorrowDao;
import com.ldm.library.business.admin.borrow.domain.dto.BorrowListDto;
import com.ldm.library.business.admin.borrow.domain.entity.BookBorrow;
import com.ldm.library.business.admin.borrow.domain.vo.BorrowListVo;
import com.ldm.library.business.admin.borrow.service.BorrowService;
import com.ldm.library.framework.enumerate.ResponseEnum;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName BorrowServiceImpl
 * @Description 借阅管理服务层实现类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 11:14
 */
@Service
public class BorrowServiceImpl extends ServiceImpl<BookBorrowDao, BookBorrow> implements BorrowService {

    @Resource
    private BookBorrowDao bookBorrowDao;

    @Override
    public ApiResponse<PageInfo<BorrowListVo>> list(BorrowListDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        PageInfo<BorrowListVo> ans = new PageInfo<>(bookBorrowDao.list(reqBody.getTitle(), reqBody.getBorrowerName()));
        return ApiResponse.success(ans);
    }

    @Override
    public ApiResponse<String> add(BookBorrow bookBorrow) {
        Date date = new Date();
        // 延后 15 天
        date.setTime(date.getTime() + 15 * 24 * 60 * 60 * 1000);
        bookBorrow.setDueDate(date);
        int insertCount = bookBorrowDao.insert(bookBorrow);

        if (insertCount > 0) {
            return ApiResponse.success(ResponseEnum.SUCCESS_TO_ADD_CATEGORY.getMessage());
        }
        return ApiResponse.error(ResponseEnum.FAILED_TO_ADD_BOOK.getCode(),
                ResponseEnum.FAILED_TO_ADD_BOOK.getMessage());
    }

    @Override
    public ApiResponse<String> returnBook(Integer id) {
        BookBorrow bookBorrow = bookBorrowDao.selectById(id);
        if (bookBorrow == null) {
            return ApiResponse.error(ResponseEnum.BOOK_NOT_FOUND.getCode(),
                    ResponseEnum.BOOK_NOT_FOUND.getMessage());
        }
        BookBorrow entity = new BookBorrow();
        entity.setBorrowId(id);
        entity.setStatus(1);
        updateById(entity);
        return ApiResponse.success(ResponseEnum.SUCCESS_TO_RETURN_BOOK.getMessage());
    }

    @Override
    public ApiResponse<String> update(BookBorrow bookBorrow) {
        int updateCount = bookBorrowDao.updateById(bookBorrow);
        return ApiResponse.success(ResponseEnum.SUCCESS_TO_UPDATE_CATEGORY.getMessage());
    }

}
