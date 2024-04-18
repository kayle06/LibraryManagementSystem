package com.ldm.library.business.admin.reservation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.reservation.dao.BookReservationMapper;
import com.ldm.library.business.admin.reservation.domain.dto.ReservationListDto;
import com.ldm.library.business.admin.reservation.domain.entity.BookReservation;
import com.ldm.library.business.admin.reservation.domain.vo.BookReservationVo;
import com.ldm.library.business.admin.reservation.service.BookReservationService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReservationServiceImpl extends ServiceImpl<BookReservationMapper, BookReservation> implements BookReservationService{

    @Override
    public ApiResponse<PageInfo<BookReservationVo>> list(ReservationListDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        List<BookReservationVo> list = baseMapper.list(reqBody.getSearchCondition());
        PageInfo<BookReservationVo> pageInfo = new PageInfo<>(list);
        return ApiResponse.success(pageInfo);
    }

    @Override
    public ApiResponse<String> agree(Long id) {
        this.update().set("status", 1).eq("reservation_id", id).update();
        return ApiResponse.success("操作成功");
    }
}
