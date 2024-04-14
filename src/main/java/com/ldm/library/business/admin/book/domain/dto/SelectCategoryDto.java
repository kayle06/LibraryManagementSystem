package com.ldm.library.business.admin.book.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName SelectCategoryDto
 * @Description 查询分类数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/14 16:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SelectCategoryDto extends PageDto {

    private String categoryName;
}
