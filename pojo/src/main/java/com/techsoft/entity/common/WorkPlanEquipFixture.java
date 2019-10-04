package com.techsoft.entity.common;

import java.util.Date;
import com.techsoft.common.BaseEntity;

public class WorkPlanEquipFixture extends BaseEntity {
	private static final long serialVersionUID = 113387280076141304L;


	public WorkPlanEquipFixture(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long billWorkorderId;	
	   
	private Long taskId;	
	   
	private Long processId;	
	   
	private Long processNodeId;	
	   
	private Long instructId;	
	   
	private Long planStatusDictId;	
	   
	private Long workshopId;	
	   
	private Long workshopAreaId;	
	   
	private Long workstationId;	
	   
	private Long equipSpecsFixtureId;	
	   
	private Long equipFixtureId;	
	   
	private Double quantity;	
	   
	private Double quantityInput;	
	   
	private Double quantityConsume;	
	   
	private Date timePlanStart;	
	   
	private Date timePlanEnd;	
	   
	private Date timeActualStart;	
	   
	private Date timeActualEnd;	
	   
	private String isLocked;	
	   
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
                		
	public Long getBillWorkorderId() {
		return billWorkorderId;
	}

	public void setBillWorkorderId(Long billWorkorderId) {
		this.billWorkorderId = billWorkorderId;
	}
                		
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
                		
	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
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
                		
	public Long getPlanStatusDictId() {
		return planStatusDictId;
	}

	public void setPlanStatusDictId(Long planStatusDictId) {
		this.planStatusDictId = planStatusDictId;
	}
                		
	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}
                		
	public Long getWorkshopAreaId() {
		return workshopAreaId;
	}

	public void setWorkshopAreaId(Long workshopAreaId) {
		this.workshopAreaId = workshopAreaId;
	}
                		
	public Long getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Long workstationId) {
		this.workstationId = workstationId;
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
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public Double getQuantityInput() {
		return quantityInput;
	}

	public void setQuantityInput(Double quantityInput) {
		this.quantityInput = quantityInput;
	}
                		
	public Double getQuantityConsume() {
		return quantityConsume;
	}

	public void setQuantityConsume(Double quantityConsume) {
		this.quantityConsume = quantityConsume;
	}
                		
	public Date getTimePlanStart() {
		return timePlanStart;
	}

	public void setTimePlanStart(Date timePlanStart) {
		this.timePlanStart = timePlanStart;
	}
                		
	public Date getTimePlanEnd() {
		return timePlanEnd;
	}

	public void setTimePlanEnd(Date timePlanEnd) {
		this.timePlanEnd = timePlanEnd;
	}
                		
	public Date getTimeActualStart() {
		return timeActualStart;
	}

	public void setTimeActualStart(Date timeActualStart) {
		this.timeActualStart = timeActualStart;
	}
                		
	public Date getTimeActualEnd() {
		return timeActualEnd;
	}

	public void setTimeActualEnd(Date timeActualEnd) {
		this.timeActualEnd = timeActualEnd;
	}
                		
	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
