package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehouseStrategyDownshelfItem extends BaseEntity {
	private static final long serialVersionUID = -3810380983935246135L;


	public WarehouseStrategyDownshelfItem(){	
	}
	
	private Long strategyUpshelfId;	
	   
	private Long tenantId;	
	   
	private String isValid;	
	   
	private Integer sortNo;	
	   
	private Long modeMatchingDictId;	
	   
	private Long attributeDictId;	
	   
	private Long adcdesOrderDictId;	
	   
	private String value;	
	   
	private Long rackId;	
	   
	private Long locationId;	
	   
	private Long areaId;	
	   
	private String remark;	
	   
                		
	public Long getStrategyUpshelfId() {
		return strategyUpshelfId;
	}

	public void setStrategyUpshelfId(Long strategyUpshelfId) {
		this.strategyUpshelfId = strategyUpshelfId;
	}
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
                		
	public Long getModeMatchingDictId() {
		return modeMatchingDictId;
	}

	public void setModeMatchingDictId(Long modeMatchingDictId) {
		this.modeMatchingDictId = modeMatchingDictId;
	}
                		
	public Long getAttributeDictId() {
		return attributeDictId;
	}

	public void setAttributeDictId(Long attributeDictId) {
		this.attributeDictId = attributeDictId;
	}
                		
	public Long getAdcdesOrderDictId() {
		return adcdesOrderDictId;
	}

	public void setAdcdesOrderDictId(Long adcdesOrderDictId) {
		this.adcdesOrderDictId = adcdesOrderDictId;
	}
                		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
                		
	public Long getRackId() {
		return rackId;
	}

	public void setRackId(Long rackId) {
		this.rackId = rackId;
	}
                		
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
                		
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
