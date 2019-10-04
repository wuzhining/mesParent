package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class BillWarehouse extends BaseEntity {
	private static final long serialVersionUID = -9214103121186570440L;


	public BillWarehouse(){	
	}
	
	private Long tenantId;	

	private Long factoryId;	
	   
	private String typeStock;	
	   
	private Long billTypeDictId;	
	   
	private String billCode;	
	   
	private Long billStatusDictId;	
	   
	private Long auditStatusDictId;	
	   
	private Long fromBillTypeDictId;	
	   
	private Long fromBillId;	
	   
	private String fromBillCode;	
	   
	private Long fromWarehouseId;	
	   
	private Long toWarehouseId;	
	   
	private Long fromProductionlineId;	
	   
	private Long toProductionlineId;	
	   
	private Long departmentId;	
	   
	private Long partnerId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getTypeStock() {
		return typeStock;
	}

	public void setTypeStock(String typeStock) {
		this.typeStock = typeStock;
	}
                		
	public Long getBillTypeDictId() {
		return billTypeDictId;
	}

	public void setBillTypeDictId(Long billTypeDictId) {
		this.billTypeDictId = billTypeDictId;
	}
                		
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
                		
	public Long getBillStatusDictId() {
		return billStatusDictId;
	}

	public void setBillStatusDictId(Long billStatusDictId) {
		this.billStatusDictId = billStatusDictId;
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
                		
	public Long getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(Long fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}
                		
	public Long getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(Long toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}
                		
	public Long getFromProductionlineId() {
		return fromProductionlineId;
	}

	public void setFromProductionlineId(Long fromProductionlineId) {
		this.fromProductionlineId = fromProductionlineId;
	}
                		
	public Long getToProductionlineId() {
		return toProductionlineId;
	}

	public void setToProductionlineId(Long toProductionlineId) {
		this.toProductionlineId = toProductionlineId;
	}
                		
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
                		
	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}
}
