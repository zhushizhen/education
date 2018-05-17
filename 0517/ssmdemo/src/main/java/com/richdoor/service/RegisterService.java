package com.richdoor.service;

import java.util.List;

import com.richdoor.entity.Register;

public interface RegisterService {
    //新增注册用户
	public boolean addUser(Register register	);
	//查询是否有对应用户
	public List<Register> queryUserByName(String username);
}
