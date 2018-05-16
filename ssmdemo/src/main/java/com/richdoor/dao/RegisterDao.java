package com.richdoor.dao;

import com.richdoor.entity.Register;

public interface RegisterDao {
    int deleteByPrimaryKey(String id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}