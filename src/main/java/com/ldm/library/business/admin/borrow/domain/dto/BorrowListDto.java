package com.ldm.library.business.admin.borrow.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BorrowListDto
 * @Description 借阅图书数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 11:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BorrowListDto extends PageDto {

    private String title;

    private String borrowerName;
}
