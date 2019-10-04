package com.techsoft.common.enums;

public enum EnumWorkPlanStatus {
	NOTSTARTED(10577L),//未开始
	DOING(10578L),//进行中
	FINISH(10579L);//结束
 
  
	  
	private Long value;

	private EnumWorkPlanStatus(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
