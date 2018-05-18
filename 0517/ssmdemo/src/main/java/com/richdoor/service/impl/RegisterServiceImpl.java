package com.richdoor.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.richdoor.dao.RegisterDao;
import com.richdoor.entity.RegisterEntity;
import com.richdoor.entity.UserEntity;
import com.richdoor.enumutils.StatusEnum;
import com.richdoor.service.RegisterService;
import com.richdoor.service.UserService;
@Service("registerService") 
public class RegisterServiceImpl implements RegisterService {
	
	@Resource
	private RegisterDao registerDao;
	
	@Resource
	private UserService userService;
  
	public boolean addUser(RegisterEntity register) throws Exception{
		String id=UUID.randomUUID().toString();
		register.setId(id);
		String password=register.getPassword();
		password=getMD5(password);
		register.setPassword(password);
		
		int number=registerDao.insert(register);
		
		int roleid=register.getRoleid();
		if(roleid == 1 || roleid ==2){
			UserEntity userEntity=new UserEntity();
			userEntity.setRegid(id);
			userEntity.setStatus(StatusEnum.待审核.getValue());
			userService.addUser(userEntity);
		}
		if(number != 0){
			return true;
		}
		return false;
	}
	
	public List<RegisterEntity> queryUserByName(String username) {
		List<RegisterEntity> regList=registerDao.selectRegByName(username);
		return regList;
	}
	
   //对密码进行md5加密
	public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }

    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }

	public boolean userLogin(RegisterEntity register) {
		register.setPassword(getMD5(register.getPassword()));
		 register=registerDao.loginUser(register);
		 boolean flag=false;
		 if(register!=null){
			 flag=true;
		 }
		return flag;
	}



	
}
