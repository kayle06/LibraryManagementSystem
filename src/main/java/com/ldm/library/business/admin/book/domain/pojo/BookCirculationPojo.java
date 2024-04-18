package com.ldm.library.business.admin.book.domain.pojo;

import lombok.Data;

/**
 * @ClassName BookCirculationPojo
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/18 23:26
 */
@Data
public class BookCirculationPojo {

    private String year;

    private int borrowCount;

    private int returnCount;

    private int reservationCount;
}
