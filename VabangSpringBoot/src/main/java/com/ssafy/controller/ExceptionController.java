package com.ssafy.controller;

import com.ssafy.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@CrossOrigin("*")
public class ExceptionController {

    @ExceptionHandler({
        UnAuthorizedException.class
    })
    public ResponseEntity<Map<String, Object>> jwtExceptionHandle(final UnAuthorizedException e) {
        log.error("token exception");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", "fail");
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(resultMap, status);
    }
}
