package com.ldm.library.business.admin.book.domain.vo;

import lombok.Data;

/**
 * @ClassName Top5
 * @Description 图书借阅量前5视图对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 15:49
 */
@Data
public class Top5Vo {


    private String bookName;

    private int borrowCount;

    private int returnCount;

}
