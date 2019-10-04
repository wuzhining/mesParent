package com.techsoft.common.enums;
/**
 * 
 * @author app
 *
 */
public enum EnumLabelFunctionType {
	SERIALNUMBER(10501L),//序列号
	FIXVALUE(10502L),//固定值
	DATE(10503L),//日期
	DATATABLEFIELD(10504L);//数据表字段
	  
	private Long value;

	private EnumLabelFunctionType(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
