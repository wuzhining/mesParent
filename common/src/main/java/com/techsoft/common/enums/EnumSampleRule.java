package com.techsoft.common.enums;

/**
 * 
 * @author Chenzj  
 */ 
public enum EnumSampleRule {

	TIGHTEN(10388L),//检验加严
	COMMON(10387L),//检验正常
	LOOSEN(10389L);//检验放松
	  
	private Long value;

	private EnumSampleRule(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
