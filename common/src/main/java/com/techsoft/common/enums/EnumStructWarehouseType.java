package com.techsoft.common.enums;

/**
 * 
 * @author tanyekai  
 */ 
public enum EnumStructWarehouseType {


	
	OTHER(10318L),//其他
	FULLYAUTOMATIC(10317L);//全自动仓库
	  
	private Long value;

	private EnumStructWarehouseType(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
