package com.ldm.library.business.admin.borrow.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 借阅记录表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrow {
    /**
    * 借阅记录ID
    */
    @TableId(type = IdType.AUTO)
    private Integer borrowId;

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 图书ID
    */
    private Integer bookId;

    /**
    * 借出日期
    */
    private Date borrowDate;

    /**
    * 应还日期
    */
    private Date dueDate;

    /**
    * 实际还书日期
    */
    private Date returnDate;

    /**
    * 状态（0: 借阅中, 1: 已还书, 2: 逾期）
    */
    private Integer status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;
}