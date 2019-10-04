package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructWarehouseLocation extends BaseEntity {
	private static final long serialVersionUID = 7613072681789622406L;


	public StructWarehouseLocation(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long warehouseId;	
	   
	private String locationName;	
	   
	private String locationCode;	
	   
	private Long productClassesId;	
	   
	private Long productTypeDictId;	
	   
	private String rackCode;	
	   
	private String rackName;	
	   
	private Integer numberColumn;	
	   
	private Integer numberLine;	
	   
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
                		
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
                		
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
                		
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
                		
	public Long getProductClassesId() {
		return productClassesId;
	}

	public void setProductClassesId(Long productClassesId) {
		this.productClassesId = productClassesId;
	}
                		
	public Long getProductTypeDictId() {
		return productTypeDictId;
	}

	public void setProductTypeDictId(Long productTypeDictId) {
		this.productTypeDictId = productTypeDictId;
	}
                		
	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}
                		
	public String getRackName() {
		return rackName;
	}

	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
                		
	public Integer getNumberColumn() {
		return numberColumn;
	}

	public void setNumberColumn(Integer numberColumn) {
		this.numberColumn = numberColumn;
	}
                		
	public Integer getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(Integer numberLine) {
		this.numberLine = numberLine;
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
