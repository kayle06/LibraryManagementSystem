package com.ldm.library.business.admin.user.dao;

/**
 * @ClassName UserDao
 * @Description 用户数据访问层
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:40
 */
public interface UserDao {
    /**
     * @return int
     * @Description 获取今日新增用户数
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayNewUsers();
}
