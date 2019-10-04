package com.techsoft.common.enums;
/**
 * 
 * 下架策略属性
 *
 */
public enum EnumDownShelfAttribute {
	QUANTITY_STOCK("10549"),//库存数量 
	DATE_INSTORE("10548"),//入库日期
	DATE_MANUFACTURE("10547"),//生产日期
	WAREHOURE_LOCATION("10546");//库位置
	  
	private String value;

	private EnumDownShelfAttribute(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
