package com.ldm.library.business.admin.user.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName UserListDto
 * @Description TODO
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/17 17:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserListDto extends PageDto {

    private String studentNo;
}
