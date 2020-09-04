package com.cc.security.dao;

import com.cc.security.entity.SeUser;
import com.cc.security.entity.SeUserExample;
import org.springframework.stereotype.Repository;

/**
 * SeUserDao继承基类
 */
@Repository
public interface SeUserDao extends MyBatisBaseDao<SeUser, String, SeUserExample> {
}