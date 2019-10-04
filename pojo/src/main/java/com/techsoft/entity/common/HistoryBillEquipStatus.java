package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class HistoryBillEquipStatus extends BaseEntity {
	private static final long serialVersionUID = 1010386145682271062L;


	public HistoryBillEquipStatus(){	
	}
	
	private Long tenantId;	
	   
	private Long billTypeFixtureDictId;	
	   
	private String billCode;	
	   
	private Long billFixtureId;	
	   
	private Long billStatusFixtureDictId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getBillTypeFixtureDictId() {
		return billTypeFixtureDictId;
	}

	public void setBillTypeFixtureDictId(Long billTypeFixtureDictId) {
		this.billTypeFixtureDictId = billTypeFixtureDictId;
	}
                		
	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
                		
	public Long getBillFixtureId() {
		return billFixtureId;
	}

	public void setBillFixtureId(Long billFixtureId) {
		this.billFixtureId = billFixtureId;
	}
                		
	public Long getBillStatusFixtureDictId() {
		return billStatusFixtureDictId;
	}

	public void setBillStatusFixtureDictId(Long billStatusFixtureDictId) {
		this.billStatusFixtureDictId = billStatusFixtureDictId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
