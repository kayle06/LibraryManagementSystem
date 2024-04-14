package com.ldm.library.framework.enumerate;

import lombok.Getter;

/**
 * @ClassName ErrorCodeEnum
 * @Description 错误码枚举类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Getter
public enum ResponseEnum {
    USER_NOT_FOUND(1001, "用户不存在"),
    BOOK_NOT_FOUND(1002, "图书不存在"),
    INVALID_REQUEST(1003, "无效的请求"),
    INSUFFICIENT_PERMISSION(1004, "权限不足"),
    INTERNAL_ERROR(1005, "内部错误"),

    // 图书相关
    FAILED_TO_ADD_BOOK(2001, "添加图书失败"),
    SUCCESS_TO_ADD_BOOK(2002, "添加图书成功"),
    FAILED_TO_DELETE_BOOK(2003, "删除图书失败"),
    SUCCESS_TO_DELETE_BOOK(2004, "删除图书成功"),
    FAILED_TO_UPDATE_BOOK(2005, "更新图书失败"),
    SUCCESS_TO_UPDATE_BOOK(2006, "更新图书成功"),


    // ==================== 图书分类相关 ====================
    FAILED_TO_ADD_CATEGORY(3001, "添加图书分类失败"),
    SUCCESS_TO_ADD_CATEGORY(3002, "添加图书分类成功"),
    FAILED_TO_UPDATE_CATEGORY(3003, "更新图书分类失败"),
    SUCCESS_TO_UPDATE_CATEGORY(3004, "更新图书分类成功"),
    FAILED_TO_DELETE_CATEGORY(3005, "删除图书分类失败"),
    SUCCESS_TO_DELETE_CATEGORY(3006, "删除图书分类成功"),

    ;
    private final int code;
    private final String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
