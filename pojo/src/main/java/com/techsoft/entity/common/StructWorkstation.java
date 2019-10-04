package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructWorkstation extends BaseEntity {
	private static final long serialVersionUID = 6228992667163384964L;


	public StructWorkstation(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long workshopId;	
	   
	private Long workshopAreaId;	
	   
	private Long executiveTypeDictId;	
	   
	private String workstationName;	
	   
	private String workstationCode;	
	   
	private Integer coordinateX;	
	   
	private Integer coordinateY;	
	   
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
                		
	public Long getWorkshopAreaId() {
		return workshopAreaId;
	}

	public void setWorkshopAreaId(Long workshopAreaId) {
		this.workshopAreaId = workshopAreaId;
	}
                		
	public Long getExecutiveTypeDictId() {
		return executiveTypeDictId;
	}

	public void setExecutiveTypeDictId(Long executiveTypeDictId) {
		this.executiveTypeDictId = executiveTypeDictId;
	}
                		
	public String getWorkstationName() {
		return workstationName;
	}

	public void setWorkstationName(String workstationName) {
		this.workstationName = workstationName;
	}
                		
	public String getWorkstationCode() {
		return workstationCode;
	}

	public void setWorkstationCode(String workstationCode) {
		this.workstationCode = workstationCode;
	}
                		
	public Integer getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Integer coordinateX) {
		this.coordinateX = coordinateX;
	}
                		
	public Integer getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Integer coordinateY) {
		this.coordinateY = coordinateY;
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
