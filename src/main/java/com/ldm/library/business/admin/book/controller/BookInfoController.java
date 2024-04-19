package com.ldm.library.business.admin.book.controller;

import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.book.domain.dto.SelectBookDto;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.business.admin.book.domain.vo.*;
import com.ldm.library.business.admin.book.service.BookInfoService;
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
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link PageInfo }<{@link BookCategoryNameVo }>>
     * @Description 查询图书信息。根据条件查询
     * @Author ldm
     * @Date 2024/04/15
     */
    @GetMapping("/list")
    public ApiResponse<PageInfo<BookCategoryNameVo>> select(SelectBookDto reqBody) {
        return bookInfoService.select(reqBody);
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link Books }>>
     * @Description 查询所有图书信息
     * @Author ldm
     * @Date 2024/04/16
     */
    @GetMapping("/listAll")
    public ApiResponse<List<Books>> selectAll() {
        return bookInfoService.selectAll();
    }

    /**
     * @param id 图书ID
     * @return {@link ApiResponse }<{@link Books }>
     * @Description 查询图书信息。根据ID查询
     * @Author ldm
     * @Date 2024/04/15
     */
    @GetMapping("/detail/{id}")
    public ApiResponse<Books> selectById(@PathVariable Long id) {
        return bookInfoService.selectById(id);
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

    /**
     * @return {@link ApiResponse }<{@link TodayDataVo }>
     * @Description 查询图书今日新增、总量、总销量信息
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/todayData")
    public ApiResponse<TodayDataVo> todayData() {
        return bookInfoService.todayData();
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link BorrowAndReturnVo }>>
     * @Description 查询本周借阅及归还数据
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/borrowAndReturn")
    public ApiResponse<List<BorrowAndReturnVo>> borrowAndReturn() {
        return bookInfoService.borrowAndReturn();
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link BorrowTopFive }>>
     * @Description 查询借阅量最高的前5本图书
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/borrowTopFive")
    public ApiResponse<List<BorrowTopFive>> borrowTopFive() {
        return bookInfoService.borrowTopFive();
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link PopularBooksVo }>>
     * @Description 热门图书分析
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/popularBooks")
    public ApiResponse<List<PopularBooksVo>> popularBooks() {
        return bookInfoService.popularBooks();
    }

    /**
     * @return {@link ApiResponse }<{@link List }<{@link CategoryAnalyseVo }>>
     * @Description 图书分类分析
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/categoryAnalyse")
    public ApiResponse<List<CategoryAnalyseVo>> categoryAnalyse() {
        return bookInfoService.categoryAnalyse();
    }

    /**
     * @return {@link ApiResponse }<{@link BookCirculationVo }>
     * @Description 图书流通分析
     * @Author ldm
     * @Date 2024/04/18
     */
    @GetMapping("/bookCirculation")
    public ApiResponse<BookCirculationVo> bookCirculation() {
        return bookInfoService.bookCirculation();
    }

    @GetMapping("/bookReservation")
    public ApiResponse<int[]> bookReservation() {
        return bookInfoService.bookReservation();
    }
}
