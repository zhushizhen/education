package com.richdoor.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.richdoor.dao.UserDao;
import com.richdoor.entity.UserEntity;
import com.richdoor.enumutils.StatusEnum;
import com.richdoor.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	public boolean addUser(UserEntity userEntity) {
		String id=UUID.randomUUID().toString();
		userEntity.setId(id);
		int number=userDao.insert(userEntity);
		if(number != 0){
			return true;
		}
		return false;
	}

}
