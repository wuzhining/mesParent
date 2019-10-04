package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigTableObject extends BaseEntity {
	private static final long serialVersionUID = 5307873353693280624L;


	public ConfigTableObject(){	
	}
	
	private Long tenantId;	
	   
	private String tableObjectName;	
	   
	private String tableObjectPath;	
	   
	private String tableObjectNameCn;	
	   
	private String isValid;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getTableObjectName() {
		return tableObjectName;
	}

	public void setTableObjectName(String tableObjectName) {
		this.tableObjectName = tableObjectName;
	}
                		
	public String getTableObjectPath() {
		return tableObjectPath;
	}

	public void setTableObjectPath(String tableObjectPath) {
		this.tableObjectPath = tableObjectPath;
	}
                		
	public String getTableObjectNameCn() {
		return tableObjectNameCn;
	}

	public void setTableObjectNameCn(String tableObjectNameCn) {
		this.tableObjectNameCn = tableObjectNameCn;
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
