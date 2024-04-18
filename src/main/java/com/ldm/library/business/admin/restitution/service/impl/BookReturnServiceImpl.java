package com.ldm.library.business.admin.restitution.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.restitution.dao.BookReturnMapper;
import com.ldm.library.business.admin.restitution.domain.dto.BookReturnDto;
import com.ldm.library.business.admin.restitution.domain.entity.BookReturn;
import com.ldm.library.business.admin.restitution.domain.vo.BookReturnVo;
import com.ldm.library.business.admin.restitution.service.BookReturnService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.stereotype.Service;
@Service
public class BookReturnServiceImpl extends ServiceImpl<BookReturnMapper, BookReturn> implements BookReturnService{

    @Override
    public ApiResponse<PageInfo<BookReturnVo>> list(BookReturnDto reqBody) {
        PageHelper.startPage(reqBody.getPageNum(), reqBody.getPageSize());
        PageInfo<BookReturnVo> pageInfo = new PageInfo<>(baseMapper.list(reqBody.getReturnName()));
        return ApiResponse.success(pageInfo);
    }
}
