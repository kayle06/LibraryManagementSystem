package com.ldm.library.business.admin.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.ldm.library.business.admin.book.domain.dto.SelectBookDto;
import com.ldm.library.business.admin.book.domain.entity.Books;
import com.ldm.library.business.admin.book.domain.vo.BookCategoryNameVo;
import com.ldm.library.business.admin.book.domain.vo.TodayDataVo;
import com.ldm.library.business.admin.book.domain.vo.Top5Vo;
import com.ldm.library.framework.result.ApiResponse;

import java.util.List;

/**
 * @ClassName BookInfoService
 * @Description 图书信息服务
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/3 22:36
 */
public interface BookInfoService extends IService<Books> {
    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 添加图书信息
     * @Author ldm
     * @Date 2024/04/03
     */
    ApiResponse<String> add(Books reqBody);

    /**
     * @param id 图书主键
     * @return {@link ApiResponse }<{@link String }>
     * @Description 逻辑删除图书
     * @Author ldm
     * @Date 2024/04/03
     */
    ApiResponse<String> del(Long id);

    /**
     * @param reqBody 入参
     * @return {@link ApiResponse }<{@link String }>
     * @Description 更新图书信息
     * @Author ldm
     * @Date 2024/04/11
     */
    ApiResponse<String> update(Books reqBody);

    /**
     * @param title@return {@link ApiResponse }<{@link String }>
     * @param reqBody
     * @Description 查询图书信息，不传为查询全部
     * @Author ldm
     * @Date 2024/04/11
     */
    ApiResponse<PageInfo<BookCategoryNameVo>> select(SelectBookDto reqBody);

    /**
     * @return {@link ApiResponse }<{@link List }<{@link Books }>>
     * @Description 查询前5本图书
     * @Author ldm
     * @Date 2024/04/11
     */
    ApiResponse<List<Top5Vo>> top5();

    /**
     * @return {@link ApiResponse }
     * @Description 统计今日数据
     * @Author ldm
     * @Date 2024/04/13
     */
    ApiResponse<TodayDataVo> todayData();

    /**
     * @param id 图书主键
     * @return {@link ApiResponse }<{@link Books }>
     * @Description 查询图书信息
     * @Author ldm
     * @Date 2024/04/15
     */
    ApiResponse<Books> selectById(Long id);

}
