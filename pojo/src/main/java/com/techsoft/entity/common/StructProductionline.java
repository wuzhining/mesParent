package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProductionline extends BaseEntity {
	private static final long serialVersionUID = -1145161777362105733L;


	public StructProductionline(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long workshopId;	
	   
	private String productionlineName;	
	   
	private String productionlineCode;	
	   
	private String isValid;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}
                		
	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}
                		
	public String getProductionlineName() {
		return productionlineName;
	}

	public void setProductionlineName(String productionlineName) {
		this.productionlineName = productionlineName;
	}
                		
	public String getProductionlineCode() {
		return productionlineCode;
	}

	public void setProductionlineCode(String productionlineCode) {
		this.productionlineCode = productionlineCode;
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
