package com.cc.security.service.impl;


import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.cc.security.dao.SeAuthorityDao;
import com.cc.security.dao.SeUserDao;
import com.cc.security.entity.*;
import com.cc.security.service.UserService;
import com.cc.security.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caicang
 * @description 用户信息实现类
 */
@Service
public class UserServiceImpl implements UserService {

    final
    SeUserDao userDao;
    final
    SeAuthorityDao authorityDao;

    public UserServiceImpl(SeUserDao userDao, SeAuthorityDao authorityDao) {
        this.userDao = userDao;
        this.authorityDao = authorityDao;
    }



    /**
     * 用户登录，如果账号密码比对成功，就生成一个token串返回给前端
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public String login(String userName, String password) {
        SeUserExample seUserExample = new SeUserExample();
        seUserExample.createCriteria().andUsernameEqualTo(userName);
        seUserExample.setLimit(1);
        List<SeUser> seUsers = userDao.selectByExample(seUserExample);
        if (ObjectUtil.isNotEmpty(seUsers)) {
            SeUser user = seUsers.get(0);
            if (user.getPassword().equals(password)) {
                SeAuthorityExample seAuthorityExample = new SeAuthorityExample();
                seAuthorityExample.createCriteria().andUserIdEqualTo(user.getId());
                List<SeAuthority> seAuthorities = authorityDao.selectByExample(seAuthorityExample);
                List<String> stringList = seAuthorities.stream().map(SeAuthority::getAuthority).collect(Collectors.toList());
                Console.log(stringList);
                UserEntity userEntity = new UserEntity(userName, password, stringList);
                return JwtUtil.createJwtToken(JSONUtil.toJsonStr(userEntity));
            }
        }
        return "";
    }
}
