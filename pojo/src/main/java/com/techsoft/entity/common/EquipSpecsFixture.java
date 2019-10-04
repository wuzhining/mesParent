package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class EquipSpecsFixture extends BaseEntity {
	private static final long serialVersionUID = -57509020832833737L;


	public EquipSpecsFixture(){	
	}
	
	private Long tenantId;	
	   
	private String fixtureSpecsCode;	
	   
	private String fixtureSpecsName;	
	   
	private Long classesId;	
	   
	private Long fixtureStatusDictId;	
	   
	private Long supplierId;	
	   
	private Integer standarlive;	
	   
	private Double quantity;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getFixtureSpecsCode() {
		return fixtureSpecsCode;
	}

	public void setFixtureSpecsCode(String fixtureSpecsCode) {
		this.fixtureSpecsCode = fixtureSpecsCode;
	}
                		
	public String getFixtureSpecsName() {
		return fixtureSpecsName;
	}

	public void setFixtureSpecsName(String fixtureSpecsName) {
		this.fixtureSpecsName = fixtureSpecsName;
	}
                		
	public Long getClassesId() {
		return classesId;
	}

	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
                		
	public Long getFixtureStatusDictId() {
		return fixtureStatusDictId;
	}

	public void setFixtureStatusDictId(Long fixtureStatusDictId) {
		this.fixtureStatusDictId = fixtureStatusDictId;
	}
                		
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
                		
	public Integer getStandarlive() {
		return standarlive;
	}

	public void setStandarlive(Integer standarlive) {
		this.standarlive = standarlive;
	}
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
