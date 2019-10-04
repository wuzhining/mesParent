package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseArea extends BaseEntity {
	private static final long serialVersionUID = -3499580999544462548L;


	public WarehouseArea(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long warehouseId;	
	   
	private String areaCode;	
	   
	private String areaName;	
	   
	private Long parentId;	
	   
	private String isValid;	
	   
	private Integer baseCoordinateX;	
	   
	private Integer baseCoordinateY;	
	   
	private Integer baseCoordinateZ;	
	   
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
                		
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
                		
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
                		
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
                		
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public Integer getBaseCoordinateX() {
		return baseCoordinateX;
	}

	public void setBaseCoordinateX(Integer baseCoordinateX) {
		this.baseCoordinateX = baseCoordinateX;
	}
                		
	public Integer getBaseCoordinateY() {
		return baseCoordinateY;
	}

	public void setBaseCoordinateY(Integer baseCoordinateY) {
		this.baseCoordinateY = baseCoordinateY;
	}
                		
	public Integer getBaseCoordinateZ() {
		return baseCoordinateZ;
	}

	public void setBaseCoordinateZ(Integer baseCoordinateZ) {
		this.baseCoordinateZ = baseCoordinateZ;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
