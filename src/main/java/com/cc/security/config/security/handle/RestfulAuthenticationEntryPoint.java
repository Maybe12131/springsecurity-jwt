package com.cc.security.config.security.handle;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.cc.security.entity.ResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证信息失效（未认证或者认证信息过期）处理器
 */
@Component
public class RestfulAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException{
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        response.getWriter().println(JSONUtil.toJsonStr(ResponseDto.build(HttpStatus.HTTP_UNAUTHORIZED, "error", "用户未认证")));
        response.getWriter().flush();
    }
}