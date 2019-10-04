package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProdlineEquipFixture extends BaseEntity {
	private static final long serialVersionUID = -6310709254338476294L;


	public StructProdlineEquipFixture(){	
	}
	
	private Long tenantId;	
	   
	private Long productionlineId;	
	   
	private Long equipSpecsFixtureId;	
	   
	private Long equipFixtureId;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getProductionlineId() {
		return productionlineId;
	}

	public void setProductionlineId(Long productionlineId) {
		this.productionlineId = productionlineId;
	}
                		
	public Long getEquipSpecsFixtureId() {
		return equipSpecsFixtureId;
	}

	public void setEquipSpecsFixtureId(Long equipSpecsFixtureId) {
		this.equipSpecsFixtureId = equipSpecsFixtureId;
	}
                		
	public Long getEquipFixtureId() {
		return equipFixtureId;
	}

	public void setEquipFixtureId(Long equipFixtureId) {
		this.equipFixtureId = equipFixtureId;
	}
}
