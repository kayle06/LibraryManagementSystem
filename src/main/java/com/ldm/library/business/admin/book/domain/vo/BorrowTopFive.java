package com.ldm.library.business.admin.book.domain.vo;

import lombok.Data;

/**
 * @ClassName BorrowTopFive
 * @Description 借阅图书 Top5
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/18 16:12
 */
@Data
public class BorrowTopFive {

    private String title;

    private int borrowCount;
}
