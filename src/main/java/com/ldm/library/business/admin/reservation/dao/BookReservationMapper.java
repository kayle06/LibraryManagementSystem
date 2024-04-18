package com.ldm.library.business.admin.reservation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldm.library.business.admin.reservation.domain.entity.BookReservation;
import com.ldm.library.business.admin.reservation.domain.vo.BookReservationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookReservationMapper extends BaseMapper<BookReservation> {

    /**
     * @param searchCondition 条件
     * @return {@link List }<{@link BookReservation }>
     * @Description 根据条件查询预约记录
     * @Author ldm
     * @Date 2024/04/17
     */
    List<BookReservationVo> list(@Param("searchCondition") String searchCondition);
}