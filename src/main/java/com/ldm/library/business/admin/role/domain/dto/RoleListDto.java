package com.ldm.library.business.admin.role.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName RoleListDto
 * @Description 角色列表查询参数
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/17 21:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleListDto extends PageDto {

    private String roleName;
}
