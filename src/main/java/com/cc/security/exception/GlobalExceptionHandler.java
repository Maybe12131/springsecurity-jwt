package com.cc.security.exception;

import com.cc.security.entity.ResponseDto;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author CaiCang
 * @Date 2020/9/1 15:52
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseDto globalException(ExpiredJwtException ex) {
        return ResponseDto.build(403, "令牌过期，请重新登录." + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseDto global(Exception ex) {
        return ResponseDto.build(400, "异常" + ex.getMessage());
    }



}
