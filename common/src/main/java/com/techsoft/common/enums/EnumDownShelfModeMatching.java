package com.techsoft.common.enums;
/**
 * 
 * 下架匹配方式
 *
 */
public enum EnumDownShelfModeMatching {
	FIRST(10555L),//优先匹配
	FUZZY(10554L),//模糊匹配
	EXACT(10553L);//精确匹配
	  
	private Long value;

	private EnumDownShelfModeMatching(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
