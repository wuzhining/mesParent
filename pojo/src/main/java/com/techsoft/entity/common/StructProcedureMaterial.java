package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProcedureMaterial extends BaseEntity {
	private static final long serialVersionUID = 2225197658347722043L;


	public StructProcedureMaterial(){	
	}
	
	private Long tenantId;	
	   
	private Long processNodeId;	
	   
	private Long instructId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Double quantity;	
	   
	private Double quantityBase;	
	   
	private Double wastageRatio;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getProcessNodeId() {
		return processNodeId;
	}

	public void setProcessNodeId(Long processNodeId) {
		this.processNodeId = processNodeId;
	}
                		
	public Long getInstructId() {
		return instructId;
	}

	public void setInstructId(Long instructId) {
		this.instructId = instructId;
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
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public Double getQuantityBase() {
		return quantityBase;
	}

	public void setQuantityBase(Double quantityBase) {
		this.quantityBase = quantityBase;
	}
                		
	public Double getWastageRatio() {
		return wastageRatio;
	}

	public void setWastageRatio(Double wastageRatio) {
		this.wastageRatio = wastageRatio;
	}
}
