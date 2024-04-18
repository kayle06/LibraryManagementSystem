package com.ldm.library.business.admin.book.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName BookCirculationVo
 * @Description 图书流通视图对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/18 23:19
 */
@Data
public class BookCirculationVo {

    private List<String> years;

    private List<BookCirculationItemVo> items;

    @Data
    public static class BookCirculationItemVo {

        private String name;

        private List<Integer> value;
    }
}
