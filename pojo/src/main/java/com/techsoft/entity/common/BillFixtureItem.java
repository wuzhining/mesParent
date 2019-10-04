package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class BillFixtureItem extends BaseEntity {
	private static final long serialVersionUID = 3691874828118838321L;


	public BillFixtureItem(){	
	}
	
	private Long tenantId;	
	   
	private Long billFixtureId;	
	   
	private Long equipFixtureId;	
	   
	private Double quantity;	
	   
	private Double numberUsed;	
	   
	private Long dealResultDictId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getBillFixtureId() {
		return billFixtureId;
	}

	public void setBillFixtureId(Long billFixtureId) {
		this.billFixtureId = billFixtureId;
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
                		
	public Double getNumberUsed() {
		return numberUsed;
	}

	public void setNumberUsed(Double numberUsed) {
		this.numberUsed = numberUsed;
	}
                		
	public Long getDealResultDictId() {
		return dealResultDictId;
	}

	public void setDealResultDictId(Long dealResultDictId) {
		this.dealResultDictId = dealResultDictId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
