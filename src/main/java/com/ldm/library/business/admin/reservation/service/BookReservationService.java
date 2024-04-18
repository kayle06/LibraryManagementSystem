package com.ldm.library.business.admin.reservation.service;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.reservation.domain.dto.ReservationListDto;
import com.ldm.library.business.admin.reservation.domain.entity.BookReservation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldm.library.business.admin.reservation.domain.vo.BookReservationVo;
import com.ldm.library.framework.result.ApiResponse;

public interface BookReservationService extends IService<BookReservation>{


    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link BookReservation }>>
     * @Description 分页查询预约记录
     * @Author ldm
     * @Date 2024/04/17
     */
    ApiResponse<PageInfo<BookReservationVo>> list(ReservationListDto reqBody);

    /**
     * @param id 预约记录id
     * @return {@link ApiResponse }<{@link String }>
     * @Description 同意预约
     * @Author ldm
     * @Date 2024/04/18
     */
    ApiResponse<String> agree(Long id);
}
