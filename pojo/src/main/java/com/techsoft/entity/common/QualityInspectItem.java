package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class QualityInspectItem extends BaseEntity {
	private static final long serialVersionUID = 1043256059153488547L;


	public QualityInspectItem(){	
	}
	
	private Long tenantId;	
	   
	private String inspectItemName;	
	   
	private Long parentId;	
	   
	private String isModule;	
	   
	private Long inspectTypeId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getInspectItemName() {
		return inspectItemName;
	}

	public void setInspectItemName(String inspectItemName) {
		this.inspectItemName = inspectItemName;
	}
                		
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
                		
	public String getIsModule() {
		return isModule;
	}

	public void setIsModule(String isModule) {
		this.isModule = isModule;
	}
                		
	public Long getInspectTypeId() {
		return inspectTypeId;
	}

	public void setInspectTypeId(Long inspectTypeId) {
		this.inspectTypeId = inspectTypeId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
