package com.ldm.library.business.admin.restitution.domain.vo;

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
 * 图书归还记录表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_return")
public class BookReturnVo {
    /**
     * 图书归还 id
     */
    @TableId(value = "return_id", type = IdType.AUTO)
    private Integer returnId;

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
     * 归还时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String userName;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dueDate;
}