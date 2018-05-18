package com.richdoor.dao;

import com.richdoor.entity.AuthorityEntity;

public interface AuthorityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthorityEntity record);

    int insertSelective(AuthorityEntity record);

    AuthorityEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthorityEntity record);

    int updateByPrimaryKey(AuthorityEntity record);
}