package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class FirmPartner extends BaseEntity {
	private static final long serialVersionUID = 6316310005962671749L;


	public FirmPartner(){	
	}
	
	private Long tenantId;	
	   
	private Long userId;	
	   
	private String status;	
	   
	private Long partnerTypeDictId;	
	   
	private String companyCode;	
	   
	private String companyName;	
	   
	private String simpleName;	
	   
	private Long countryId;	
	   
	private Long provinceId;	
	   
	private Long cityId;	
	   
	private Long areaId;	
	   
	private String address;	
	   
	private String contactPhone;	
	   
	private String contactName;	
	   
	private String email;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
                		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
                		
	public Long getPartnerTypeDictId() {
		return partnerTypeDictId;
	}

	public void setPartnerTypeDictId(Long partnerTypeDictId) {
		this.partnerTypeDictId = partnerTypeDictId;
	}
                		
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
                		
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
                		
	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
                		
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
                		
	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
                		
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
                		
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
                		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
                		
	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
                		
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
                		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
