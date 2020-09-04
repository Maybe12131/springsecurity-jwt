package com.cc.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author CaiCang
 * @Date 2020/9/1 14:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class UserEntity {
    private  String userName;
    private String password;
    private List<String> authorities;
}
