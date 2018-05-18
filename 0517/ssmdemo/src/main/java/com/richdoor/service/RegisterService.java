package com.richdoor.service;

import java.util.List;

import com.richdoor.entity.RegisterEntity;

public interface RegisterService {
    //新增注册用户
	public boolean addUser(RegisterEntity register	) throws Exception;
	//查询是否有对应用户
	public List<RegisterEntity> queryUserByName(String username) throws Exception;
	//用户登陆校验
	public boolean userLogin(RegisterEntity register);
}
