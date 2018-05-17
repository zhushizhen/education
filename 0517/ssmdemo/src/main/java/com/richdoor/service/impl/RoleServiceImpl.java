package com.richdoor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.richdoor.dao.RoleDao;
import com.richdoor.entity.Role;
import com.richdoor.service.RoleService;

@Service("roleService") 
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	public List<Role> getRoleList() {
		List<Role> roleList=roleDao.selectRoles();
		return roleList;
	}

}
