package com.techsoft.common.enums;

public enum EnumProcedureInstructType {
	IN(10556L),//输入
	OUT(10557L),//输出
	DOWORK(10558L),//加工
	LABELING(10601L),//贴标
	INSPECT(10602L);//检测
	private Long value;

	private EnumProcedureInstructType(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
