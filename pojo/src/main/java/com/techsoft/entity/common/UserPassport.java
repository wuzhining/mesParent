package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class UserPassport extends BaseEntity {
	private static final long serialVersionUID = -2747904793920748194L;


	public UserPassport(){	
	}
	
	private String userName;	
	   
	private String email;	
	   
	private String password;	
	   
	private String mobileNumber;	
	   
	private String realName;	
	   
	private String aliasName;	
	   
	private String systemRoletype;	
	   
	private String status;	
	   
	private Long tenantId;	
	   
	private Integer provinceId;	
	   
	private Integer cityId;	
	   
	private Integer areaId;	
	   
                		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
                		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
                		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
                		
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
                		
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
                		
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
                		
	public String getSystemRoletype() {
		return systemRoletype;
	}

	public void setSystemRoletype(String systemRoletype) {
		this.systemRoletype = systemRoletype;
	}
                		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
                		
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
                		
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
