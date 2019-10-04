package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigCodeRuleItem extends BaseEntity {
	private static final long serialVersionUID = -7797254878537016849L;


	public ConfigCodeRuleItem(){	
	}
	
	private Long tenantId;	
	   
	private Long codeRuleId;	
	   
	private Long labelFunctionId;	
	   
	private String value;	
	   
	private Integer sortNo;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getCodeRuleId() {
		return codeRuleId;
	}

	public void setCodeRuleId(Long codeRuleId) {
		this.codeRuleId = codeRuleId;
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
