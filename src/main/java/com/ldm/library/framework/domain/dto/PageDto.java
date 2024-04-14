package com.ldm.library.framework.domain.dto;

import lombok.Data;

/**
 * @ClassName Page
 * @Description 分页数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 14:07
 */
@Data
public class PageDto {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页显示条数
     */
    private int pageSize;
}
