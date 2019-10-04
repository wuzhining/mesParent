package com.techsoft.common.enums;
/**
 * 标签复位方式
 * @author app
 *
 */
public enum EnumLabelResetmode {
	NEVER(10369L),//从不
	DAY(10370L),//每天
	WEEK(10371L),//每周
	MONTH(10372L),//每月
	YEAR(10373L);//每年
	  
	private Long value;

	private EnumLabelResetmode(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
