package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigLabelFieldItem extends BaseEntity {
	private static final long serialVersionUID = -5902916902181851403L;


	public ConfigLabelFieldItem(){	
	}
	
	private Long tenantId;	
	   
	private Long labelFieldId;	
	   
	private Long labelFunctionId;	
	   
	private String value;	
	   
	private Integer sortNo;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getLabelFieldId() {
		return labelFieldId;
	}

	public void setLabelFieldId(Long labelFieldId) {
		this.labelFieldId = labelFieldId;
	}
                		
	public Long getLabelFunctionId() {
		return labelFunctionId;
	}

	public void setLabelFunctionId(Long labelFunctionId) {
		this.labelFunctionId = labelFunctionId;
	}
                		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
                		
	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
}
