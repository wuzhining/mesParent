package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ProductClasses extends BaseEntity {
	private static final long serialVersionUID = 1854311164014672668L;


	public ProductClasses(){	
	}
	
	private Long tenantId;	
	   
	private String classesCode;	
	   
	private String classesName;	
	   
	private Long parentId;	
	   
	private String isValid;	
	   
	private Integer sortNo;	
	   
	private String remark;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getClassesCode() {
		return classesCode;
	}

	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}
                		
	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
                		
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
                		
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
