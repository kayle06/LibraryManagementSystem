package com.ldm.library.business.admin.book.domain.vo;

import lombok.Data;

/**
 * @ClassName BorrowAndReturnVo
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/18 14:07
 */
@Data
public class BorrowAndReturnVo {

    private String day;

    private int borrowCount;

    private int returnCount;
}
