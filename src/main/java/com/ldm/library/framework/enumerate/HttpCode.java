package com.ldm.library.framework.enumerate;

import lombok.Getter;

/**
 * @ClassName HttpCode
 * @Description HTTP状态码
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Getter
public enum HttpCode{
    // 通用状态码
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "错误的请求"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到资源"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    PARAM_ERROR(40001, "参数错误"),
    ;

    private final int code;
    private final String message;

    HttpCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
