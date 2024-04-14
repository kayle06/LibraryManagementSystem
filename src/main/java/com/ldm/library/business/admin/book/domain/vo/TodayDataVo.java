package com.ldm.library.business.admin.book.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName TodayData
 * @Description 今日数据视图对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/4/13 17:03
 */
@Data
@Builder
public class TodayDataVo {


    public TodayDataVo() {}

    public TodayDataVo(int purchaseCount, int borrowCount, int returnCount, int reserveCount, int overdueCount, int userCount) {
        this.purchaseCount = purchaseCount;
        this.borrowCount = borrowCount;
        this.returnCount = returnCount;
        this.reserveCount = reserveCount;
        this.overdueCount = overdueCount;
        this.newUserCount = userCount;
    }

    /**
     * 今日进货图书数量
     */
    private int purchaseCount;

    /**
     * 今日借阅图书数量
     */
    private int borrowCount;

    /**
     * 今日归还图书数量
     */
    private int returnCount;

    /**
     * 今日预约图书数量
     */
    private int reserveCount;

    /**
     * 今日超期图书数量
     */
    private int overdueCount;

    /**
     * 今日新增用户数量
     */
    private int newUserCount;

}
