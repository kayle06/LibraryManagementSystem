package com.ldm.library.business.admin.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ldm.library.business.admin.user.domain.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description 用户数据访问层
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:40
 */
public interface UserDao extends BaseMapper<Users> {
    /**
     * @return int
     * @Description 获取今日新增用户数
     * @Author ldm
     * @Date 2024/04/13
     */
    int todayNewUsers();

    /**
     * @param studentNo 学号
     * @return {@link List }<{@link Users }>
     * @Description 根据学号查询用户信息
     * @Author ldm
     * @Date 2024/04/17
     */
    Page<Users> list(@Param("studentNo") java.lang.String studentNo);
}
