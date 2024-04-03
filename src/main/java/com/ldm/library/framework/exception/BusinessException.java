package com.ldm.library.framework.exception;

import com.ldm.library.framework.enumerate.ErrorCodeEnum;
import lombok.Getter;

/**
 * @ClassName BusinessException
 * @Description 业务异常类
 * @Author ldm
 * @Version 1.0
 * @Date 2024/04/03
 */
@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCodeEnum errorCode;

    public BusinessException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
}
