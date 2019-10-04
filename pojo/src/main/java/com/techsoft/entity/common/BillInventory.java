package com.techsoft.entity.common;

import java.util.Date;

import com.techsoft.common.BaseEntity;

public class BillInventory extends BaseEntity {
	private static final long serialVersionUID = 3525582903268440614L;


	public BillInventory(){	
	}
	
	private Long tenantId;	
	   
	private Long warehouseId;	
	   
	private String billCode;	
	   
	private Long billStatusDictId;	
	   
	private Long auditStatusDictId;	
	   
	private Long settleStatusDictId;	
	   
	private Long inventoryModeDictId;	
	   
	private Date timeStart;	
	   
	private Date timeEnd;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
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
                		
	public Long getSettleStatusDictId() {
		return settleStatusDictId;
	}

	public void setSettleStatusDictId(Long settleStatusDictId) {
		this.settleStatusDictId = settleStatusDictId;
	}
                		
	public Long getInventoryModeDictId() {
		return inventoryModeDictId;
	}

	public void setInventoryModeDictId(Long inventoryModeDictId) {
		this.inventoryModeDictId = inventoryModeDictId;
	}
                		
	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
                		
	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
