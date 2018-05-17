package com.richdoor.dao;

import java.util.List;

import com.richdoor.entity.Register;

public interface RegisterDao {
    int deleteByPrimaryKey(String id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
    /**
     * 查询是否有对应用户
     * @return
     */
    List<Register> selectRegByName(String username);
}