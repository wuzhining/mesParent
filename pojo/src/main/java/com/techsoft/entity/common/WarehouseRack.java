package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseRack extends BaseEntity {
	private static final long serialVersionUID = -7990983910156321652L;


	public WarehouseRack(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long warehouseId;	
	   
	private Long areaId;	
	   
	private Long productClassesId;	
	   
	private Long productTypeDictId;	
	   
	private String rackCode;	
	   
	private String rackName;	
	   
	private Integer numberLine;	
	   
	private Integer numberColumn;	
	   
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
                		
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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
                		
	public Integer getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(Integer numberLine) {
		this.numberLine = numberLine;
	}
                		
	public Integer getNumberColumn() {
		return numberColumn;
	}

	public void setNumberColumn(Integer numberColumn) {
		this.numberColumn = numberColumn;
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
