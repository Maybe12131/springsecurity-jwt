package com.cc.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CaiCang
 * @Date 2020/9/4 14:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/my")
@Api(tags = "我的接口")
public class MyRestController {

    @GetMapping("/get")
    @ApiOperation("我的接口方法")
    public String get(){
        return "/get";
    }





}
