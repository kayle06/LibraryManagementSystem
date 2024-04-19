package com.ldm.library.business.admin.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.business.admin.book.domain.pojo.BookReservationPojo;
import com.ldm.library.business.admin.book.domain.vo.BookCategoryNameVo;
import com.ldm.library.business.admin.book.domain.vo.BorrowAndReturnVo;
import com.ldm.library.business.admin.book.domain.vo.CategoryAnalyseVo;
import com.ldm.library.business.admin.book.domain.vo.Top5Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BooksDao
 * @Description 图书管理数据访问对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/13
 */
public interface BooksDao extends BaseMapper<Books> {
    /**
     * @return {@link List }<{@link Books }>
     * @Description 查询借阅量最高的前5本图书
     * @Author ldm
     * @Date 2024/04/13
     */
    List<Top5Vo> top5();

    /**
     * @return int
     * @Description 今日进货图书数
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayPurchaseBooks();

    Page<BookCategoryNameVo> list(@Param("title") String title);

    /**
     * @return {@link List }<{@link BorrowAndReturnVo }>
     * @Description 查询借阅和归还数据
     * @Author ldm
     * @Date 2024/04/18
     */
    List<BorrowAndReturnVo> borrowAndReturn();

    /**
     * @return {@link List }<{@link CategoryAnalyseVo }>
     * @Description 分类分析
     * @Author ldm
     * @Date 2024/04/18
     */
    List<CategoryAnalyseVo> categoryAnalyse();

    /**
     * @return {@link int[] }
     * @Description 图书周预约量
     * @Author ldm
     * @Date 2024/04/19
     */
    List<BookReservationPojo> bookReservation();
}