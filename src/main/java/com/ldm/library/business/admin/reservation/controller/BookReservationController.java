package com.ldm.library.business.admin.reservation.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.reservation.domain.dto.ReservationListDto;
import com.ldm.library.business.admin.reservation.domain.entity.BookReservation;
import com.ldm.library.business.admin.reservation.domain.vo.BookReservationVo;
import com.ldm.library.business.admin.reservation.service.BookReservationService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/reservation")
public class BookReservationController {

    @Resource
    private BookReservationService bookReservationService;

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link BookReservation }>>
     * @Description 分页查询预约记录
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("list")
    public ApiResponse<PageInfo<BookReservationVo>> list(ReservationListDto reqBody) {
        return bookReservationService.list(reqBody);
    }

    @PutMapping("/agree/{id}")
    public ApiResponse<String> agree(@PathVariable Long id) {
        return bookReservationService.agree(id);
    }

}
