package com.ldm.library.business.admin.borrow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ldm.library.business.admin.book.domain.vo.BorrowTopFive;
import com.ldm.library.business.admin.borrow.domain.entity.BookBorrow;
import com.ldm.library.business.admin.borrow.domain.vo.BorrowListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BookBorrowDao
 * @Description 图书借阅数据访问对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:12
 */
public interface BookBorrowDao extends BaseMapper<BookBorrow> {
    /**
     * @return int
     * @Description 获取今日借阅图书数量
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayBorrowBooks();

    /**
     * @return int
     * @Description 获取今日逾期图书数量
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayOverdueBooks();

    /**
     * @param title 图书名称
     * @param borrowerName 借阅人名称
     * @return {@link List }<{@link BookBorrow }>
     * @Description TODO
     * @Author ldm
     * @Date 2024/04/16
     */
    Page<BorrowListVo> list(@Param("title") String title, @Param("borrowerName") String borrowerName);

    /**
     * @return {@link List }<{@link BorrowTopFive }>
     * @Description 查询借阅量最高的前5本图书
     * @Author ldm
     * @Date 2024/04/18
     */
    List<BorrowTopFive> borrowTopFive();
}
