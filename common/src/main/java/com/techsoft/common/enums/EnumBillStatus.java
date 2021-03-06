package com.techsoft.common.enums;
/**
 * 
 * 单据状态
 *
 */
public enum EnumBillStatus {
	NEW(10488L),//新建
	DOING(10489L),//处理中
	FINISHED(10490L);//完结
	  
	private Long value;

	private EnumBillStatus(Long value) {
		this.value = value;  
	}

	public Long getValue() {
		return value;
	}
}
