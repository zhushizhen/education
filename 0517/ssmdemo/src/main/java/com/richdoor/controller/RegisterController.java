package com.richdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richdoor.entity.Register;
import com.richdoor.entity.Role;
import com.richdoor.service.RegisterService;
import com.richdoor.util.JsonResult;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	/**
	 * 查询是否有对应用户
	 */
	@RequestMapping("/isRepeatName")
	public @ResponseBody JsonResult<String> queryByName(String username){
		JsonResult<String> jsonResult=new JsonResult<String>();
		List<Register> registerlist=registerService.queryUserByName(username);
		if(registerlist.size() !=0){
			jsonResult.setMessage("该用户名已存在！");
		}
		
		return jsonResult;
	}
}
