package com.ssafy.interceptor;

import com.ssafy.exception.UnAuthorizedException;
import com.ssafy.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    private static final String HEADER_AUTH = "access-token";

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final String token = request.getHeader(HEADER_AUTH);

        logger.info("JwtInterceptor");
        if (token != null && jwtService.checkToken(token)) {
            logger.info("토큰 사용 가능 : {}", token);
            return true;
        } else {
            logger.info("토큰 사용 불가능 : {}", token);
            throw new UnAuthorizedException();
        }
    }

}
