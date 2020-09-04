package com.cc.security.controller;

import cn.hutool.core.util.ObjectUtil;
import com.cc.security.entity.ResponseDto;
import com.cc.security.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CaiCang
 * @Date 2020/9/1 15:26
 * @Version 1.0
 */
@Api(tags = "登录接口")
@RestController
public class LoginController {

    final
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("登录方法")
    @GetMapping("/login")
    public ResponseDto login(@ApiParam(value = "用户名",required = true) @RequestParam String userName, @ApiParam("密码") @RequestParam String password) {
        String login = userService.login(userName, password);
        if (ObjectUtil.isNotEmpty(login)) {
            return ResponseDto.build(0, "seccess", login);
        }
        return ResponseDto.build(400, "error");
    }

    @PostMapping("/api")
    public ResponseDto api() {
        return ResponseDto.build(400, "success", SecurityContextHolder.getContext().getAuthentication());
    }


}
