package com.ldm.library.business.admin.borrow.dao;

/**
 * @ClassName BookBorrowDao
 * @Description 图书借阅数据访问对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:12
 */
public interface BookBorrowDao {
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
}
