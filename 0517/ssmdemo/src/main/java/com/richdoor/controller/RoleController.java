package com.richdoor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richdoor.entity.Role;
import com.richdoor.service.RoleService;
import com.richdoor.util.JsonResult;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
    
	@RequestMapping("/roleList")
	public @ResponseBody JsonResult<List<Role>> getRoleList(){
		JsonResult<List<Role>> jsonResult=new JsonResult<List<Role>>();
		List<Role> roleList=roleService.getRoleList();
		if(roleList !=null){
			
			jsonResult.setData(roleList);
			jsonResult.setIssuccess(true);
			jsonResult.setMessage("数据返回成功");
		}else{
			jsonResult.setData(null);
			jsonResult.setIssuccess(false);
			jsonResult.setMessage("数据返回失败");
		}
		
		
		return jsonResult;
	} 
}
