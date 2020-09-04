package com.cc.security;

import cn.hutool.core.util.IdUtil;
import com.cc.security.dao.SeAuthorityDao;
import com.cc.security.dao.SeUserDao;
import com.cc.security.entity.SeAuthority;
import com.cc.security.entity.SeUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    SeUserDao userDao;
    @Autowired
    SeAuthorityDao authorityDao;


    @Test
    void contextLoads() {
        SeUser user = new SeUser();
        user.setId(IdUtil.simpleUUID());
        user.setUsername("root");
        user.setPassword("123456789");
        userDao.insert(user);

        SeAuthority authority = new SeAuthority();
        authority.setId(IdUtil.simpleUUID());
        authority.setUserId(user.getId());
        authority.setAuthority("api");
        SeAuthority authority1 = new SeAuthority();
        authority1.setId(IdUtil.simpleUUID());
        authority1.setUserId(user.getId());
        authority1.setAuthority("ROLE_ADMIN");
        SeAuthority authority2 = new SeAuthority();
        authority2.setId(IdUtil.simpleUUID());
        authority2.setUserId(user.getId());
        authority2.setAuthority("my/**");

        authorityDao.insert(authority);
        authorityDao.insert(authority1);
        authorityDao.insert(authority2);


    }

}
