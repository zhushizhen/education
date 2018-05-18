package com.richdoor.dao;

import com.richdoor.entity.WorkEntity;

public interface WorkDao {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkEntity record);

    int insertSelective(WorkEntity record);

    WorkEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkEntity record);

    int updateByPrimaryKey(WorkEntity record);
}