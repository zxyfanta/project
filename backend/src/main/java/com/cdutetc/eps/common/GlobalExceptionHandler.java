package com.cdutetc.eps.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 异常的分类
    // 未能识别的异常
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleGeneralException(Exception e){
        return ApiResponse.error(e.getMessage());
    }
    // 自定义的异常
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e){
        return new ResponseEntity<>(ApiResponse.error(e.getMessage(),e.getCode()),HttpStatus.valueOf(e.getCode()));
    }

    //常见异常
}
