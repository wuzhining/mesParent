package com.techsoft.common.enums;

public enum EnumWorkTaskStatus {
	NOTSTARTED(10580L),//未开始
	DOING(10581L),//进行中
	FINISH(10582L);//结束
 
  
	  
	private Long value;

	private EnumWorkTaskStatus(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
