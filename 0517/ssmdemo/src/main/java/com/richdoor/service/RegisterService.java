package com.richdoor.service;

import java.util.List;

import com.richdoor.entity.RegisterEntity;

public interface RegisterService {
    //新增注册用户
	public boolean addUser(RegisterEntity register	);
	//查询是否有对应用户
	public List<RegisterEntity> queryUserByName(String username);
}
