package com.ldm.library.business.admin.restitution.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.restitution.domain.dto.BookReturnDto;
import com.ldm.library.business.admin.restitution.domain.entity.BookReturn;
import com.ldm.library.business.admin.restitution.domain.vo.BookReturnVo;
import com.ldm.library.business.admin.restitution.service.BookReturnService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RestitutionController
 * @Description 归还管理控制器
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 22:43
 */
@RestController
@RequestMapping("/restitution")
public class RestitutionController {

    @Resource
    private BookReturnService bookReturnService;

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link BookReturn }>>
     * @Description 获取归还记录列表
     * @Author ldm
     * @Date 2024/04/16
     */
    @GetMapping("/list")
    public ApiResponse<PageInfo<BookReturnVo>> list(BookReturnDto reqBody) {
        return bookReturnService.list(reqBody);
    }

}
