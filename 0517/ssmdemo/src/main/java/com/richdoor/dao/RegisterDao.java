package com.richdoor.dao;

import java.util.List;

import com.richdoor.entity.RegisterEntity;

public interface RegisterDao {
    int deleteByPrimaryKey(String id);

    int insert(RegisterEntity record);

    int insertSelective(RegisterEntity record);

    RegisterEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RegisterEntity record);

    int updateByPrimaryKey(RegisterEntity record);
    /**
     * 查询是否有对应用户
     * @return
     */
    List<RegisterEntity> selectRegByName(String username);
}