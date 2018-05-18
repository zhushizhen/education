package com.richdoor.dao;

import com.richdoor.entity.TeacherEntity;

public interface TeacherDao {
    int deleteByPrimaryKey(String id);

    int insert(TeacherEntity record);

    int insertSelective(TeacherEntity record);

    TeacherEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeacherEntity record);

    int updateByPrimaryKey(TeacherEntity record);
}