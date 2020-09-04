package com.cc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CaiCang
 * @Date 2020/9/4 16:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("get")
    public String get() {
        return "/test/get";
    }
    @PostMapping("post")
    public String post() {
        return "/test/post";
    }


}
