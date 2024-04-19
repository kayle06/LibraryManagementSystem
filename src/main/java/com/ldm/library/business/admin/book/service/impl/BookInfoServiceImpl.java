package com.ldm.library.business.admin.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.book.dao.BooksDao;
import com.ldm.library.business.admin.book.domain.dto.SelectBookDto;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.business.admin.book.domain.pojo.BookCirculationPojo;
import com.ldm.library.business.admin.book.domain.pojo.BookReservationPojo;
import com.ldm.library.business.admin.book.domain.vo.*;
import com.ldm.library.business.admin.book.service.BookInfoService;
import com.ldm.library.business.admin.borrow.dao.BookBorrowDao;
import com.ldm.library.business.admin.reservation.dao.BookReservationDao;
import com.ldm.library.business.admin.restitution.dao.BookReturnDao;
import com.ldm.library.business.admin.user.dao.UserDao;
import com.ldm.library.framework.enumerate.ResponseEnum;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Autowired
    private BooksDao booksDao;

    @Override
    public ApiResponse<String> add(Books reqBody) {
        reqBody.setStatus(1);
        reqBody.setFlag(0);
        save(reqBody);
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
    public ApiResponse<PageInfo<BookCategoryNameVo>> select(SelectBookDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        PageInfo<BookCategoryNameVo> pageInfo = new PageInfo<>(booksDao.list(reqBody.getTitle()));
        return ApiResponse.success(pageInfo);
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

    @Override
    public ApiResponse<Books> selectById(Long id) {
        Books book = this.getById(id);
        if (Objects.nonNull(book)) {
            return ApiResponse.success(book);
        }
        return ApiResponse.error(ResponseEnum.BOOK_NOT_EXIST.getCode(),
                ResponseEnum.BOOK_NOT_EXIST.getMessage());
    }

    @Override
    public ApiResponse<List<Books>> selectAll() {
        List<Books> booksList = this.list();
        return ApiResponse.success(booksList);
    }

    @Override
    public ApiResponse<List<BorrowAndReturnVo>> borrowAndReturn() {
        List<BorrowAndReturnVo> borrowAndReturnList = baseMapper.borrowAndReturn();
        return ApiResponse.success(borrowAndReturnList);
    }

    @Override
    public ApiResponse<List<BorrowTopFive>> borrowTopFive() {
        List<BorrowTopFive> borrowTopFiveList = borrowDao.borrowTopFive();
        return ApiResponse.success(borrowTopFiveList);
    }

    @Override
    public ApiResponse<List<PopularBooksVo>> popularBooks() {
        List<PopularBooksVo> ans = borrowDao.popularBooks();
        return ApiResponse.success(ans);
    }

    @Override
    public ApiResponse<List<CategoryAnalyseVo>> categoryAnalyse() {
        List<CategoryAnalyseVo> ans = baseMapper.categoryAnalyse();
        return ApiResponse.success(ans);
    }

    @Override
    public ApiResponse<BookCirculationVo> bookCirculation() {
        List<BookCirculationPojo> historicalData = borrowDao.bookCirculation();
        BookCirculationVo bookCirculationVo = new BookCirculationVo();
        List<String> years = new ArrayList<>();
        String[] name = {"借阅量", "归还量", "预约量"};
        List<Integer> borrowCount = new ArrayList<>();
        List<Integer> returnCount = new ArrayList<>();
        List<Integer> reserveCount = new ArrayList<>();
        List<BookCirculationVo.BookCirculationItemVo> bookCirculationItemVos = new ArrayList<>();

        for (int i = 0; i < historicalData.size(); i++) {
            years.add(historicalData.get(i).getYear());
            borrowCount.add(historicalData.get(i).getBorrowCount());
            returnCount.add(historicalData.get(i).getReturnCount());
            reserveCount.add(historicalData.get(i).getReservationCount());
        }

        List<List<Integer>> value = new ArrayList<>();
        value.add(borrowCount);
        value.add(returnCount);
        value.add(reserveCount);


        for (int i = 0; i < name.length; i++) {
            BookCirculationVo.BookCirculationItemVo bookCirculationItemVo = new BookCirculationVo.BookCirculationItemVo();
            bookCirculationItemVo.setName(name[i]);
            bookCirculationItemVo.setValue(value.get(i));
            bookCirculationItemVos.add(bookCirculationItemVo);
        }
        bookCirculationVo.setYears(years);
        bookCirculationVo.setItems(bookCirculationItemVos);
        return ApiResponse.success(bookCirculationVo);
    }

    @Override
    public ApiResponse<int[]> bookReservation() {
        List<BookReservationPojo> weekData = baseMapper.bookReservation();
        int[] ans = weekData.stream().mapToInt(BookReservationPojo::getReservationCount).toArray();
        return ApiResponse.success(ans);
    }
}
