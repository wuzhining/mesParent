package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructWarehouse extends BaseEntity {
	private static final long serialVersionUID = -8841869891194392248L;


	public StructWarehouse(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long floorId;	
	   
	private String warehouseName;	
	   
	private String warehouseCode;	
	   
	private Long warehouseTypeDictId;	
	   
	private Long productTypeDictId;	
	   
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
                		
	public Long getFloorId() {
		return floorId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}
                		
	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
                		
	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
                		
	public Long getWarehouseTypeDictId() {
		return warehouseTypeDictId;
	}

	public void setWarehouseTypeDictId(Long warehouseTypeDictId) {
		this.warehouseTypeDictId = warehouseTypeDictId;
	}
                		
	public Long getProductTypeDictId() {
		return productTypeDictId;
	}

	public void setProductTypeDictId(Long productTypeDictId) {
		this.productTypeDictId = productTypeDictId;
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
