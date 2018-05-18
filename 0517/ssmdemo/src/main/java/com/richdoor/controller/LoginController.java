package com.richdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.richdoor.entity.RegisterEntity;
import com.richdoor.service.RegisterService;
import com.richdoor.util.JsonResult;
/**
 * 登陆控制
 * @author zhusz
 *2018年5月18日
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/userLogin")
	public @ResponseBody  JsonResult<String> loginInfo(String loginUser){
		JsonResult<String> jsonResult=new JsonResult<String>();
		RegisterEntity registerEntity=JSONArray.toJavaObject((JSONObject) JSONArray.parse(loginUser), RegisterEntity.class);
		
		try {
			boolean flag=registerService.userLogin(registerEntity);
		    if(flag){
		    	jsonResult.setIssuccess(true);
		    	jsonResult.setMessage("登陆成功");
		    }else{
		    	jsonResult.setIssuccess(false);
		    	jsonResult.setMessage("用户名/密码不正确，请确认后再登陆");
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult;
	}
}
