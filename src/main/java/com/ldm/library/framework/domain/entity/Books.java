package com.ldm.library.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 图书信息表
 */
@Data
public class Books {
    /**
    * 图书ID
    */
    @TableId
    private Integer bookId;

    /**
    * 书名
    */
    private String title;

    /**
    * 作者
    */
    private String author;

    /**
    * ISBN号
    */
    private String isbn;

    /**
    * 出版社
    */
    private String publisher;

    /**
    * 出版年份
    */
    private String publicationYear;

    /**
    * 分类ID
    */
    private Integer categoryId;

    /**
    * 状态（0: 维护中, 1: 可借, 2: 已借出）
    */
    private Integer status;

    /**
     * 标志（0: 未删除, 1: 已删除）
     */
    private Integer flag;

    /**
    * 书架位置
    */
    private String shelfLocation;
}