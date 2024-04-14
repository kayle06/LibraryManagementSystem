package com.ldm.library.business.admin.reservation.dao;

/**
 * @ClassName BookReservationDao
 * @Description 图书预约数据访问层
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:31
 */
public interface BookReservationDao {
    /**
     * @return int
     * @Description 获取今日预约的图书数量
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayBookedBooks();
}
