package com.ldm.library.business.admin.book.domain.pojo;

import lombok.Data;

/**
 * @ClassName BookReservationPojo
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/19 18:42
 */
@Data
public class BookReservationPojo {

    private String weekday;

    private int reservationCount;
}
