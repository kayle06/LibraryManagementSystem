package com.ldm.library.business.admin.reservation.domain.dto;

import com.ldm.library.framework.domain.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName ReservationListDto
 * @Description 借阅列表数据传输对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/17 22:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationListDto extends PageDto {

    private String searchCondition;
}
