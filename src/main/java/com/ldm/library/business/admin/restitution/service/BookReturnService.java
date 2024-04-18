package com.ldm.library.business.admin.restitution.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.restitution.domain.dto.BookReturnDto;
import com.ldm.library.business.admin.restitution.domain.entity.BookReturn;
import com.ldm.library.business.admin.restitution.domain.vo.BookReturnVo;
import com.ldm.library.framework.result.ApiResponse;

public interface BookReturnService extends IService<BookReturn>{


    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link BookReturn }>>
     * @Description 分页查询图书归还记录
     * @Author ldm
     * @Date 2024/04/16
     */
    ApiResponse<PageInfo<BookReturnVo>> list(BookReturnDto reqBody);
}
