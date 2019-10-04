package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProcedureEquipFixture extends BaseEntity {
	private static final long serialVersionUID = 376786779831907787L;


	public StructProcedureEquipFixture(){	
	}
	
	private Long tenantId;	
	   
	private Long processNodeId;	
	   
	private Long instructId;	
	   
	private Long equipSpecsFixtureId;	
	   
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
                		
	public Long getEquipSpecsFixtureId() {
		return equipSpecsFixtureId;
	}

	public void setEquipSpecsFixtureId(Long equipSpecsFixtureId) {
		this.equipSpecsFixtureId = equipSpecsFixtureId;
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
