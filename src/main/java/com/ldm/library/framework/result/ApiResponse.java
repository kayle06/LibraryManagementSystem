package com.ldm.library.framework.result;

import lombok.Data;

import java.util.UUID;

/**
 * @ClassName ApiResponse
 * @Description 通用的响应对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Data
public class ApiResponse<T> {
    private int code;

    private String msg;

    private T data;

    private String traceId = generateTraceId();

    private ApiResponse() {
    }

    private ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(200, "操作成功", null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "操作成功", data);
    }

    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, msg, null);
    }

    private String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}