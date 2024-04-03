package com.ldm.library.framework.enumerate;

import lombok.Getter;

/**
 * @ClassName LibraryEnum
 * @Description 图书馆枚举类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Getter
public enum LibraryEnum {
    // 用户角色
    ROLE_MEMBER(0, "普通用户"),
    ROLE_ADMIN(1, "管理员"),

    // 用户状态
    USER_STATUS_INACTIVE(0, "未激活"),
    USER_STATUS_ACTIVE(1, "已激活"),

    // 图书状态
    BOOK_STATUS_MAINTENANCE(0, "维护中"),
    BOOK_STATUS_AVAILABLE(1, "可借"),
    BOOK_STATUS_BORROWED(2, "已借出"),
    BOOK_STATUS_RESERVED(3, "已预订"),

    // 借阅记录状态
    BORROW_STATUS_BORROWED(0, "借阅中"),
    BORROW_STATUS_RETURNED(1, "已归还"),
    BORROW_STATUS_OVERDUE(2, "逾期"),

    // 通知目标角色
    NOTIFICATION_TARGET_ALL(0, "所有用户"),
    NOTIFICATION_TARGET_MEMBER(1, "普通用户"),
    NOTIFICATION_TARGET_ADMIN(2, "管理员");

    private final int code;
    private final String description;

    LibraryEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
