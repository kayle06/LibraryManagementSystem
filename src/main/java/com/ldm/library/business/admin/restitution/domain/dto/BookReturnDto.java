package com.ldm.library.business.admin.restitution.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BookReturnDto
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 23:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookReturnDto extends PageDto {

    private String returnName;
}
