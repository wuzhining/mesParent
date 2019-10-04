package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProdlineWorkstation extends BaseEntity {
	private static final long serialVersionUID = 5615945643618488808L;


	public StructProdlineWorkstation(){	
	}
	
	private Long tenantId;	
	   
	private Long productionlineId;	
	   
	private Long workstationId;	
	   
                		
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
                		
	public Long getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Long workstationId) {
		this.workstationId = workstationId;
	}
}
