package com.ldm.library.business.admin.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldm.library.business.admin.book.dao.BooksDao;
import com.ldm.library.business.admin.book.domain.vo.TodayDataVo;
import com.ldm.library.business.admin.book.domain.vo.Top5Vo;
import com.ldm.library.business.admin.book.service.BookInfoService;
import com.ldm.library.business.admin.borrow.dao.BookBorrowDao;
import com.ldm.library.business.admin.reservation.dao.BookReservationDao;
import com.ldm.library.business.admin.restitution.dao.BookReturnDao;
import com.ldm.library.business.admin.user.dao.UserDao;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.framework.enumerate.ResponseEnum;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName BookInfoServiceImpl
 * @Description 图书信息服务实现
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:36
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BooksDao, Books> implements BookInfoService {

    @Resource
    private BookBorrowDao borrowDao;
    @Resource
    private BookReturnDao returnDao;
    @Resource
    private BookReservationDao reservationDao;
    @Resource
    private UserDao userDao;

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

    @Override
    public ApiResponse<String> update(Books reqBody) {
        boolean isSuccess = this.updateById(reqBody);
        if (isSuccess) {
            return ApiResponse.success(ResponseEnum.SUCCESS_TO_UPDATE_BOOK.getMessage());
        }
        return ApiResponse.error(ResponseEnum.FAILED_TO_UPDATE_BOOK.getCode(),
                ResponseEnum.FAILED_TO_UPDATE_BOOK.getMessage());
    }

    @Override
    public ApiResponse<List<Books>> select(List<Integer> id) {
        List<Books> booksList;
        if (Objects.isNull(id) || id.isEmpty()) {
            booksList = this.list();
        } else {
            booksList = this.listByIds(id);
        }
        return ApiResponse.success(booksList);
    }

    @Override
    public ApiResponse<List<Top5Vo>> top5() {
        List<Top5Vo> booksList = baseMapper.top5();
        return ApiResponse.success(booksList);
    }

    @Override
    public ApiResponse<TodayDataVo> todayData() {

        // 获取今日进货图书
        int todayPurchaseBooks = baseMapper.todayPurchaseBooks();

        // 获取今日借阅图书
        int todayBorrowBooks = borrowDao.todayBorrowBooks();

        // 获取今日归还图书
        int todayReturnBooks = returnDao.todayReturnBooks();

        // 获取今日预定图书
        int todayBookedBooks = reservationDao.todayBookedBooks();

        // 获取今日逾期图书
        int todayOverdueBooks = borrowDao.todayOverdueBooks();

        // 获取今日新增用户
        int todayNewUsers = userDao.todayNewUsers();

        TodayDataVo answer = TodayDataVo.builder()
                .purchaseCount(todayPurchaseBooks)
                .borrowCount(todayBorrowBooks)
                .returnCount(todayReturnBooks)
                .reserveCount(todayBookedBooks)
                .overdueCount(todayOverdueBooks)
                .newUserCount(todayNewUsers)
                .build();

        return ApiResponse.success(answer);
    }
}
