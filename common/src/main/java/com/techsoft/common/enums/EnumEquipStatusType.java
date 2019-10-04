package com.techsoft.common.enums;

public enum EnumEquipStatusType {
	AF01(10413L),//正常
	AF02(10535L),//借出
	AF03(10535L),//维修
	AF04(10535L),//挂起校验
	AF05(10535L);//报废 
	
	

	  
	private Long value;

	private EnumEquipStatusType(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
