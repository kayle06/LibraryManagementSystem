package com.ldm.library.business.admin.book.domain.dto;

import lombok.Data;

/**
 * @ClassName UpdateCategoryDto
 * @Description 更新图书分类数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 15:58
 */
@Data
public class UpdateCategoryDto {

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类描述
     */
    private String description;

}
