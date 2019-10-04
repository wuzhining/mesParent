package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class TrackFixture extends BaseEntity {
	private static final long serialVersionUID = -5548367570247569276L;


	public TrackFixture(){	
	}
	
	private Long tenantId;	
	   
	private Long factoryId;	
	   
	private Long fixtureId;	
	   
	private Long billTypeFixtureDictId;	
	   
	private Long billFixtureId;	
	   
	private Long billFixtureItemId;	
	   
	private Long billStatusDictId;	
	   
	private Double quantity;	
	   
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
                		
	public Long getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(Long fixtureId) {
		this.fixtureId = fixtureId;
	}
                		
	public Long getBillTypeFixtureDictId() {
		return billTypeFixtureDictId;
	}

	public void setBillTypeFixtureDictId(Long billTypeFixtureDictId) {
		this.billTypeFixtureDictId = billTypeFixtureDictId;
	}
                		
	public Long getBillFixtureId() {
		return billFixtureId;
	}

	public void setBillFixtureId(Long billFixtureId) {
		this.billFixtureId = billFixtureId;
	}
                		
	public Long getBillFixtureItemId() {
		return billFixtureItemId;
	}

	public void setBillFixtureItemId(Long billFixtureItemId) {
		this.billFixtureItemId = billFixtureItemId;
	}
                		
	public Long getBillStatusDictId() {
		return billStatusDictId;
	}

	public void setBillStatusDictId(Long billStatusDictId) {
		this.billStatusDictId = billStatusDictId;
	}
                		
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
