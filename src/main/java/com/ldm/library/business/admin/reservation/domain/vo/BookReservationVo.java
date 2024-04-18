package com.ldm.library.business.admin.reservation.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 图书预约记录表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_reservation")
public class BookReservationVo {
    /**
     * 图书预约主键
     */
    @TableId(value = "reservation_id", type = IdType.AUTO)
    private Integer reservationId;

    /**
     * 用户 id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 图书 id
     */
    @TableField(value = "book_id")
    private Integer bookId;

    /**
     * 状态 0-未批准，1-已批准
     */
    @TableField(value = "status")
    private int status;

    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime;

    private String userName;

    private String title;
}