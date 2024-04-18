package com.ldm.library.business.admin.book.domain.vo;

import lombok.Data;

/**
 * @ClassName PopularBooksVo
 * @Description 热门图书视图对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/18 20:29
 */
@Data
public class PopularBooksVo {

    private String title;

    private int borrowCount;
}
