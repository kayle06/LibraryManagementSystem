package com.ldm.library.framework.domain.vo;

import lombok.Data;

/**
 * @ClassName PageVo
 * @Description 分页视图对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 14:17
 */
@Data
public class PageVo {

    private int pageNum;

    private int pageSize;

    private int totalCount;

    private int totalPage;
}
