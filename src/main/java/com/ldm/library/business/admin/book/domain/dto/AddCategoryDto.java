package com.ldm.library.business.admin.book.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @ClassName AddCategoryDto
 * @Description 添加图书分类数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 15:24
 */
@Data
public class AddCategoryDto {

    /**
     * 分类名称
     */
    @Length(max = 5, message = "分类名称长度不能超过5个字符")
    private String categoryName;

    /**
     * 分类描述
     */
    private String description;

}
