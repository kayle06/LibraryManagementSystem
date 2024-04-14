package com.ldm.library.business.admin.book.controller;

import com.ldm.library.business.admin.book.domain.vo.TodayDataVo;
import com.ldm.library.business.admin.book.domain.vo.Top5Vo;
import com.ldm.library.business.admin.book.service.BookInfoService;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.framework.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BookInfoController
 * @Description 图书信息控制器
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:29
 */
@RestController
@RequestMapping("/book")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 添加图书
     * @Author ldm
     * @Date 2024/04/03
     */
    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody Books reqBody) {
        return bookInfoService.add(reqBody);
    }

    /**
     * @param id 需要被删除的图书ID
     * @return {@link ApiResponse }<{@link String }>
     * @Description 删除图书
     * @Author ldm
     * @Date 2024/04/04
     */
    @DeleteMapping("/del/{id}")
    public ApiResponse<String> del(@PathVariable Long id) {
        return bookInfoService.del(id);
    }

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新图书信息
     * @Author ldm
     * @Date 2024/04/11
     */
    @PutMapping("/update")
    public ApiResponse<String> update(@RequestBody Books reqBody) {
        return bookInfoService.update(reqBody);
    }

    /**
     * @param id 需要查询的图书ID
     * @return {@link ApiResponse }<{@link List }<{@link Books }>>
     * @Description 查询图书信息。不传即为查询所有图书信息
     * @Author ldm
     * @Date 2024/04/11
     */
    @GetMapping("/select")
    public ApiResponse<List<Books>> select(@RequestBody List<Integer> id) {
        return bookInfoService.select(id);
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link Top5Vo }>>
     * @Description 查询图书销量前5的图书信息
     * @Author ldm
     * @Date 2024/04/13
     */
    @GetMapping("/top5")
    public ApiResponse<List<Top5Vo>> top5() {
        return bookInfoService.top5();
    }

    @GetMapping("/todayData")
    public ApiResponse<TodayDataVo> todayData() {
        return bookInfoService.todayData();
    }
}
