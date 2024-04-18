package com.ldm.library.business.admin.borrow.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BorrowListVo {
    /**
    * 借阅记录ID
    */
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date borrowDate;

    /**
    * 应还日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dueDate;

    /**
    * 实际还书日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    private String title;

    private String userName;
}