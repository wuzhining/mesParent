package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class BillInspect extends BaseEntity {
	private static final long serialVersionUID = -6535064573309137635L;


	public BillInspect(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private String inspectCode;	
	   
	private Long supplierId;	
	   
	private Long fromBillTypeDictId;	
	   
	private Long fromBillId;	
	   
	private String fromBillCode;	
	   
	private Long materialId;	
	   
	private Long auditStatusDictId;	
	   
	private Long inspectModeDictId;	
	   
	private Long inspectStatusDictId;	
	   
	private Long inspectResultDictId;	
	   
	private Long dealResultDictId;	
	   
	private Double quantity;	
	   
	private Double quantitySample;	
	   
	private Double quantitySampleFail;	
	   
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
                		
	public String getInspectCode() {
		return inspectCode;
	}

	public void setInspectCode(String inspectCode) {
		this.inspectCode = inspectCode;
	}
                		
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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
                		
	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
                		
	public Long getAuditStatusDictId() {
		return auditStatusDictId;
	}

	public void setAuditStatusDictId(Long auditStatusDictId) {
		this.auditStatusDictId = auditStatusDictId;
	}
                		
	public Long getInspectModeDictId() {
		return inspectModeDictId;
	}

	public void setInspectModeDictId(Long inspectModeDictId) {
		this.inspectModeDictId = inspectModeDictId;
	}
                		
	public Long getInspectStatusDictId() {
		return inspectStatusDictId;
	}

	public void setInspectStatusDictId(Long inspectStatusDictId) {
		this.inspectStatusDictId = inspectStatusDictId;
	}
                		
	public Long getInspectResultDictId() {
		return inspectResultDictId;
	}

	public void setInspectResultDictId(Long inspectResultDictId) {
		this.inspectResultDictId = inspectResultDictId;
	}
                		
	public Long getDealResultDictId() {
		return dealResultDictId;
	}

	public void setDealResultDictId(Long dealResultDictId) {
		this.dealResultDictId = dealResultDictId;
	}
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public Double getQuantitySample() {
		return quantitySample;
	}

	public void setQuantitySample(Double quantitySample) {
		this.quantitySample = quantitySample;
	}
                		
	public Double getQuantitySampleFail() {
		return quantitySampleFail;
	}

	public void setQuantitySampleFail(Double quantitySampleFail) {
		this.quantitySampleFail = quantitySampleFail;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
