package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class StructProcedureWorkstation extends BaseEntity {
	private static final long serialVersionUID = 1067526389498528348L;


	public StructProcedureWorkstation(){	
	}
	
	private Long tenantId;	
	   
	private Long processNodeId;	
	   
	private Long workstationId;	
	   
                		
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
                		
	public Long getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Long workstationId) {
		this.workstationId = workstationId;
	}
}
