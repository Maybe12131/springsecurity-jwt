package com.cc.security.config.security.handle;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.cc.security.entity.ResponseDto;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问没有授权时的处理器
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        response.getWriter().println(JSONUtil.toJsonStr(ResponseDto.build(HttpStatus.HTTP_FORBIDDEN, "error", "访问越界")));
        response.getWriter().flush();
    }
}