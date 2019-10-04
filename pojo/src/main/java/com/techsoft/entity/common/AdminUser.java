package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class AdminUser extends BaseEntity {
	private static final long serialVersionUID = -6078189558843463332L;


	public AdminUser(){	
	}
	
	private Long tenantId;	
	   
	private String realName;	
	   
	private String status;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
                		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
