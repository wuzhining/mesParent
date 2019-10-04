package com.techsoft.entity.common;

import java.util.Date;
import com.techsoft.common.BaseEntity;

public class BillWorkorder extends BaseEntity {
	private static final long serialVersionUID = -4038073993540408684L;


	public BillWorkorder(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private String workorderCode;	
	   
	private Long bomId;	
	   
	private Long productId;	
	   
	private Long materialId;	
	   
	private Long workorderStatusDictId;	
	   
	private Long auditStatusDictId;	
	   
	private Long fromBillTypeDictId;	
	   
	private Long fromBillId;	
	   
	private String fromBillCode;	
	   
	private Integer priority;	
	   
	private Double quantity;	
	   
	private Double quantityInput;	
	   
	private Double quantityOutput;	
	   
	private Double quantityStandard;	
	   
	private Double quantityMaximumInput;	
	   
	private Double ratioAllowover;	
	   
	private Date timePlanStart;	
	   
	private Date timePlanEnd;	
	   
	private Date timeActualStart;	
	   
	private Date timeActualEnd;	
	   
	private String isLocked;	
	   
	private Long customerId;	
	   
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
                		
	public String getWorkorderCode() {
		return workorderCode;
	}

	public void setWorkorderCode(String workorderCode) {
		this.workorderCode = workorderCode;
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
                		
	public Long getWorkorderStatusDictId() {
		return workorderStatusDictId;
	}

	public void setWorkorderStatusDictId(Long workorderStatusDictId) {
		this.workorderStatusDictId = workorderStatusDictId;
	}
                		
	public Long getAuditStatusDictId() {
		return auditStatusDictId;
	}

	public void setAuditStatusDictId(Long auditStatusDictId) {
		this.auditStatusDictId = auditStatusDictId;
	}
                		
	public Long getFromBillTypeDictId() {
		return fromBillTypeDictId;
	}

	public void setFromBillTypeDictId(Long fromBillTypeDictId) {
		this.fromBillTypeDictId = fromBillTypeDictId;
	}
                		
	public Long getFromBillId() {
		return fromBillId;
	}

	public void setFromBillId(Long fromBillId) {
		this.fromBillId = fromBillId;
	}
                		
	public String getFromBillCode() {
		return fromBillCode;
	}

	public void setFromBillCode(String fromBillCode) {
		this.fromBillCode = fromBillCode;
	}
                		
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
                		
	public Double getQuantityMaximumInput() {
		return quantityMaximumInput;
	}

	public void setQuantityMaximumInput(Double quantityMaximumInput) {
		this.quantityMaximumInput = quantityMaximumInput;
	}
                		
	public Double getRatioAllowover() {
		return ratioAllowover;
	}

	public void setRatioAllowover(Double ratioAllowover) {
		this.ratioAllowover = ratioAllowover;
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
                		
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
