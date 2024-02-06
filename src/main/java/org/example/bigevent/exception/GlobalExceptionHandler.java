package org.example.bigevent.exception;

import org.example.bigevent.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e) {
        var len = StringUtils.hasLength(e.getMessage());
        return Result.error(len ? e.getMessage() : "操作失败");
    }
}
