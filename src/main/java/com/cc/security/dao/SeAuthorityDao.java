package com.cc.security.dao;

import com.cc.security.entity.SeAuthority;
import com.cc.security.entity.SeAuthorityExample;
import org.springframework.stereotype.Repository;

/**
 * SeAuthorityDao继承基类
 */
@Repository
public interface SeAuthorityDao extends MyBatisBaseDao<SeAuthority, String, SeAuthorityExample> {
}