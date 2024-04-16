package com.ldm.library.business.admin.book.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 图书分类信息表
 */
@Data
public class BookCategories {

    /**
    * 分类ID
    */
    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    /**
    * 分类名称
    */
    private String categoryName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
    * 分类描述
    */
    private String description;
}