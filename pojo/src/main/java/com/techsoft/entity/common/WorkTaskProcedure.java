package com.techsoft.entity.common;

import java.util.Date;

import com.techsoft.common.BaseEntity;

public class WorkTaskProcedure extends BaseEntity {
	private static final long serialVersionUID = 994778509165121749L;


	public WorkTaskProcedure(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long billWorkorderId;	
	   
	private Long workshopId;	
	   
	private Long processId;	
	   
	private Long processNodeId;	
	   
	private String taskCode;	
	   
	private Long taskStatusDictId;	
	   
	private Long productionlineId;	
	   
	private Long bomId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Integer priority;	
	   
	private Integer sortNo;	
	   
	private Long executiveTypeDictId;	
	   
	private Long worktime;	
	   
	private Long buffertimePre;	
	   
	private Long buffertimePost;	
	   
	private Double quantity;	
	   
	private Double quantityInput;	
	   
	private Double quantityOutput;	
	   
	private Double quantityStandard;	
	   
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
                		
	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
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
                		
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
                		
	public Long getTaskStatusDictId() {
		return taskStatusDictId;
	}

	public void setTaskStatusDictId(Long taskStatusDictId) {
		this.taskStatusDictId = taskStatusDictId;
	}
                		
	public Long getProductionlineId() {
		return productionlineId;
	}

	public void setProductionlineId(Long productionlineId) {
		this.productionlineId = productionlineId;
	}
                		
	public Long getBomId() {
		return bomId;
	}

	public void setBomId(Long bomId) {
		this.bomId = bomId;
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
                		
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
                		
	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
                		
	public Long getExecutiveTypeDictId() {
		return executiveTypeDictId;
	}

	public void setExecutiveTypeDictId(Long executiveTypeDictId) {
		this.executiveTypeDictId = executiveTypeDictId;
	}
                		
	public Long getWorktime() {
		return worktime;
	}

	public void setWorktime(Long worktime) {
		this.worktime = worktime;
	}
                		
	public Long getBuffertimePre() {
		return buffertimePre;
	}

	public void setBuffertimePre(Long buffertimePre) {
		this.buffertimePre = buffertimePre;
	}
                		
	public Long getBuffertimePost() {
		return buffertimePost;
	}

	public void setBuffertimePost(Long buffertimePost) {
		this.buffertimePost = buffertimePost;
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
                		
	public Double getQuantityOutput() {
		return quantityOutput;
	}

	public void setQuantityOutput(Double quantityOutput) {
		this.quantityOutput = quantityOutput;
	}
                		
	public Double getQuantityStandard() {
		return quantityStandard;
	}

	public void setQuantityStandard(Double quantityStandard) {
		this.quantityStandard = quantityStandard;
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
