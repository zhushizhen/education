package com.richdoor.dao;

import com.richdoor.entity.RoleauthEntity;

public interface RoleauthDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleauthEntity record);

    int insertSelective(RoleauthEntity record);

    RoleauthEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleauthEntity record);

    int updateByPrimaryKey(RoleauthEntity record);
}