package com.richdoor.enumutils;
/**
 * 状态
 * @author Dell
 *2018年5月18日
 */
public enum StatusEnum {
	//审核状态
    待审核("待审核"),
    已审核("已审核"),
    ;
    private String value;

	private StatusEnum(String s) {
		this.value = s;
	}

	public String getValue() {

		return this.value;
	}
}
