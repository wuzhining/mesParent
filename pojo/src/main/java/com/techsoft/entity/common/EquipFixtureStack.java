package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class EquipFixtureStack extends BaseEntity {
	private static final long serialVersionUID = -4251336773038469790L;


	public EquipFixtureStack(){	
	}
	
	private Long tenantId;	
	   
	private Long fixtureId;	
	   
	private Long specsFixtureAreaId;	
	   
	private String fixtureStackCode;	
	   
	private String fixtureStackName;	
	   
	private Double numberUsed;	
	   
	private Double numberStandard;	
	   
	private Double numberPrint;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(Long fixtureId) {
		this.fixtureId = fixtureId;
	}
                		
	public Long getSpecsFixtureAreaId() {
		return specsFixtureAreaId;
	}

	public void setSpecsFixtureAreaId(Long specsFixtureAreaId) {
		this.specsFixtureAreaId = specsFixtureAreaId;
	}
                		
	public String getFixtureStackCode() {
		return fixtureStackCode;
	}

	public void setFixtureStackCode(String fixtureStackCode) {
		this.fixtureStackCode = fixtureStackCode;
	}
                		
	public String getFixtureStackName() {
		return fixtureStackName;
	}

	public void setFixtureStackName(String fixtureStackName) {
		this.fixtureStackName = fixtureStackName;
	}
                		
	public Double getNumberUsed() {
		return numberUsed;
	}

	public void setNumberUsed(Double numberUsed) {
		this.numberUsed = numberUsed;
	}
                		
	public Double getNumberStandard() {
		return numberStandard;
	}

	public void setNumberStandard(Double numberStandard) {
		this.numberStandard = numberStandard;
	}
                		
	public Double getNumberPrint() {
		return numberPrint;
	}

	public void setNumberPrint(Double numberPrint) {
		this.numberPrint = numberPrint;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
