package com.ldm.library.business.admin.book.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName SelectBookDto
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/15 21:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SelectBookDto extends PageDto {

    private String title;
}
