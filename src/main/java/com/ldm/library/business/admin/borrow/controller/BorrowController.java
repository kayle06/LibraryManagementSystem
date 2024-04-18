package com.ldm.library.business.admin.borrow.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.borrow.domain.dto.BorrowListDto;
import com.ldm.library.business.admin.borrow.domain.entity.BookBorrow;
import com.ldm.library.business.admin.borrow.domain.vo.BorrowListVo;
import com.ldm.library.business.admin.borrow.service.BorrowService;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BorrowController
 * @Description 借阅管理控制器
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/16 11:02
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {


    @Resource
    private BorrowService borrowService;


    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link List }<{@link BookBorrow }>>
     * @Description 借阅列表
     * @Author ldm
     * @Date 2024/04/16
     */
    @GetMapping("/list")
    public ApiResponse<PageInfo<BorrowListVo>> list(BorrowListDto reqBody) {
        return borrowService.list(reqBody);
    }

    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody BookBorrow bookBorrow) {
        return borrowService.add(bookBorrow);
    }

    /**
     * @param id 借阅 id
     * @return {@link ApiResponse }<{@link String }>
     * @Description 归还图书
     * @Author ldm
     * @Date 2024/04/16
     */
    @PutMapping("/return/{id}")
    public ApiResponse<String> returnBook(@PathVariable Integer id) {
        return borrowService.returnBook(id);
    }

    /**
     * @param bookBorrow 借阅信息
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新借阅信息
     * @Author ldm
     * @Date 2024/04/16
     */
    @PutMapping("/update")
    public ApiResponse<String> update(@RequestBody BookBorrow bookBorrow) {
        return borrowService.update(bookBorrow);
    }
}
