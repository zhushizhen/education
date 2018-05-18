package com.richdoor.dao;

import com.richdoor.entity.StudentEntity;

public interface StudentDao {
    int deleteByPrimaryKey(String id);

    int insert(StudentEntity record);

    int insertSelective(StudentEntity record);

    StudentEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentEntity record);

    int updateByPrimaryKey(StudentEntity record);
}