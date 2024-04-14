package com.ldm.library.business.admin.restitution.dao;

/**
 * @ClassName BookReturnDao
 * @Description 图书归还数据访问对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:27
 */
public interface BookReturnDao {
    /**
     * @return int
     * @Description 查询今日归还图书数量
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayReturnBooks();
}
