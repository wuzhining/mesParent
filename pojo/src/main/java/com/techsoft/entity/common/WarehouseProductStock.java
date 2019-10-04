package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseProductStock extends BaseEntity {
	private static final long serialVersionUID = -2603871271704896184L;


	public WarehouseProductStock(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Double quantityStock;	
	   
	private Double quantityFrozen;	
	   
	private Double quantityOrder;	
	   
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
                		
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
                		
	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
                		
	public Double getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(Double quantityStock) {
		this.quantityStock = quantityStock;
	}
                		
	public Double getQuantityFrozen() {
		return quantityFrozen;
	}

	public void setQuantityFrozen(Double quantityFrozen) {
		this.quantityFrozen = quantityFrozen;
	}
                		
	public Double getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(Double quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
