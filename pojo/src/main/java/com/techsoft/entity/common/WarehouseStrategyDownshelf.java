package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseStrategyDownshelf extends BaseEntity {
	private static final long serialVersionUID = -663288729975900343L;


	public WarehouseStrategyDownshelf(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long warehouseId;	
	   
	private String strategyCode;	
	   
	private String strategyName;	
	   
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
                		
	public String getStrategyCode() {
		return strategyCode;
	}

	public void setStrategyCode(String strategyCode) {
		this.strategyCode = strategyCode;
	}
                		
	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
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
