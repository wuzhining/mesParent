package com.techsoft.common.enums;

/**
 * 
 * @author tanyekai  
 */ 
public enum EnumAuditStatus {


	
	UNAUDITED(10585L),//未审核
	AUDITED(10587L),//审核通过
	NONAPPROVAL(10586L);//审核未通过
	  
	private Long value;

	private EnumAuditStatus(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
