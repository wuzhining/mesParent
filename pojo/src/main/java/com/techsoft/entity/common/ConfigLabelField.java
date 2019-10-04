package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigLabelField extends BaseEntity {
	private static final long serialVersionUID = 1664974163388773162L;


	public ConfigLabelField(){	
	}
	
	private Long tenantId;	
	   
	private String labelFieldName;	
	   
	private Long printModeDictId;	
	   
	private String font;	
	   
	private String isBold;	
	   
	private String isValid;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getLabelFieldName() {
		return labelFieldName;
	}

	public void setLabelFieldName(String labelFieldName) {
		this.labelFieldName = labelFieldName;
	}
                		
	public Long getPrintModeDictId() {
		return printModeDictId;
	}

	public void setPrintModeDictId(Long printModeDictId) {
		this.printModeDictId = printModeDictId;
	}
                		
	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}
                		
	public String getIsBold() {
		return isBold;
	}

	public void setIsBold(String isBold) {
		this.isBold = isBold;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
