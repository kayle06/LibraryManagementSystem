package com.ldm.library.business.admin.book.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 图书信息表
 */
@Data
public class Books {
    /**
     * 图书ID
     */
    @TableId(type = IdType.AUTO)
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
     * 出版社
     */
    private String publisher;

    /**
     * 库存
     */
    private Integer stock;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}