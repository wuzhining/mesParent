package com.techsoft.common.enums;
/**
 * 
 * 条码状态
 *
 */
public enum EnumBarcodeStatus {
	NEW(10510L),//新建
	INSTORE(10511L),//在架 
	OFFSTORE(10512L),//下架
	OUTSTORE(10513L),//出库
	WORKED(10598L),//已投产
	PRODUCTION(10598L),//产出
	DELIVERED(10599L),//已发货
	DISCARD(10600L);//报废
	private Long value;

	private EnumBarcodeStatus(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
