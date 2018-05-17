package com.richdoor.dao;

import java.util.List;

import com.richdoor.entity.RoleEntity;

public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
    
    List<RoleEntity> selectRoles();
}