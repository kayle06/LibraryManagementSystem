package com.ldm.library.framework.result;

import lombok.Data;

/**
 * @ClassName ApiResponse
 * @Description 通用的响应对象
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Data
public class ApiResponse<T> {
    private int code; // 状态码

    private String msg; // 返回消息

    private T data; // 携带的数据

    private ApiResponse() {
    }

    private ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "操作成功", data);
    }

    // 快速创建失败响应的方法
    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, msg, null);
    }

}
