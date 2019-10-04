package com.techsoft.common.enums;

/**
 * 
 * @author tanyekai  
 */ 
public enum EnumProductType {


	
	FINISHED(10321L),//成品
	SEMIFINISHED(10320L),//半成品
	RAWMATERIAL(10319L);//原材料
	  
	private Long value;

	private EnumProductType(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
