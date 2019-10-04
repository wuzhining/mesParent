package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class EquipWorkStack extends BaseEntity {
	private static final long serialVersionUID = -2988111756713816806L;


	public EquipWorkStack(){	
	}
	
	private Long tenantId;	
	   
	private Long equipWorkId;	
	   
	private String equipStackArea;	
	   
	private String equipStackCode;	
	   
	private String equipStackName;	
	   
	private Long equipFixtureId;	
	   
	private Long equipFixtureStackId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getEquipWorkId() {
		return equipWorkId;
	}

	public void setEquipWorkId(Long equipWorkId) {
		this.equipWorkId = equipWorkId;
	}
                		
	public String getEquipStackArea() {
		return equipStackArea;
	}

	public void setEquipStackArea(String equipStackArea) {
		this.equipStackArea = equipStackArea;
	}
                		
	public String getEquipStackCode() {
		return equipStackCode;
	}

	public void setEquipStackCode(String equipStackCode) {
		this.equipStackCode = equipStackCode;
	}
                		
	public String getEquipStackName() {
		return equipStackName;
	}

	public void setEquipStackName(String equipStackName) {
		this.equipStackName = equipStackName;
	}
                		
	public Long getEquipFixtureId() {
		return equipFixtureId;
	}

	public void setEquipFixtureId(Long equipFixtureId) {
		this.equipFixtureId = equipFixtureId;
	}
                		
	public Long getEquipFixtureStackId() {
		return equipFixtureStackId;
	}

	public void setEquipFixtureStackId(Long equipFixtureStackId) {
		this.equipFixtureStackId = equipFixtureStackId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
