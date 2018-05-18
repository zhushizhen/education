package com.richdoor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.richdoor.entity.RegisterEntity;
import com.richdoor.entity.RoleEntity;
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
		List<RegisterEntity> registerlist=new ArrayList<RegisterEntity>();
		try {
			registerlist = registerService.queryUserByName(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registerlist.size() !=0){
			jsonResult.setMessage("该用户名已存在！");
		}
		return jsonResult;
	}
	/**
	 * 注册用户
	 */
	@RequestMapping("/addUser")
	public @ResponseBody JsonResult<String> addUser( String register){
		JsonResult<String> jsonResult=new JsonResult<String>();
	
		RegisterEntity registerEntity = JSONArray.toJavaObject((JSONObject) JSONArray.parse(register), RegisterEntity.class);
		Integer roleid=registerEntity.getRoleid();
		boolean flag=true;
		try {
			flag = registerService.addUser(registerEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(roleid == 1 || roleid == 2){
			jsonResult.setMessage("您的信息需要审核过后才能登陆，请联系管理员审核");
		}
		if(flag == false){
			jsonResult.setMessage("注册失败");
		}
		jsonResult.setIssuccess(flag);
		jsonResult.setData(null);;
		return jsonResult;
	}
}
