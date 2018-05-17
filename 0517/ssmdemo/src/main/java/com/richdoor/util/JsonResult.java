package com.richdoor.util;

import java.io.Serializable;

/**
 * 对返回数据的封装
 * @author Dell
 * @param <T>
 *
 */
public class JsonResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 数据
	 */
	private T data;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * 是否成功
	 */
	private boolean issuccess;
	public Object getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isIssuccess() {
		return issuccess;
	}
	public void setIssuccess(boolean issuccess) {
		this.issuccess = issuccess;
	}
	
	

}
