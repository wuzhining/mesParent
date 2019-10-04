package com.techsoft.common.enums;

/**
 * 
 * @author Chenzj  
 */ 
public enum EnumInpectStatus {

	QUALITY_INSPECT_RESULT_PASS(10475L),//合格
	QUALITY_INSPECT_RESULT_FAIL(10476L);//不合格

	  
	private Long value;

	private EnumInpectStatus(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
