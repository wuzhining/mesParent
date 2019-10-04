package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigParameter extends BaseEntity {
	private static final long serialVersionUID = 3082129318749498678L;


	public ConfigParameter(){	
	}
	
	private Long tenantId;	
	   
	private String paramType;	
	   
	private String paramCode;	
	   
	private String paramName;	
	   
	private String paramValue;	
	   
	private String isValid;	
	   
	private String isOpen;	
	   
	private String isSystemset;	
	   
	private Integer sortNo;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
                		
	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
                		
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
                		
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
                		
	public String getIsSystemset() {
		return isSystemset;
	}

	public void setIsSystemset(String isSystemset) {
		this.isSystemset = isSystemset;
	}
                		
	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
