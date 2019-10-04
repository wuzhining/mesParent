package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class WarehousePalletItem extends BaseEntity {
	private static final long serialVersionUID = 5469899117151739688L;


	public WarehousePalletItem(){	
	}
	
	private Long tenantId;	
	   
	private Long palletId;	
	   
	private Long packboxId;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getPalletId() {
		return palletId;
	}

	public void setPalletId(Long palletId) {
		this.palletId = palletId;
	}
                		
	public Long getPackboxId() {
		return packboxId;
	}

	public void setPackboxId(Long packboxId) {
		this.packboxId = packboxId;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
