package com.techsoft.entity.product;

import java.util.Date;

import com.techsoft.entity.common.ProductMaterial;

public class ProductMaterialParamVo extends ProductMaterial {
	private static final long serialVersionUID = 6026748496007676076L;


	public ProductMaterialParamVo (){
	}
	
	public ProductMaterialParamVo(ProductMaterial value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeMaterialCode;
	private String likeMaterialName;
	
	
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date value) {
		this.createTimeBegin = value;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date value) {
		this.createTimeEnd = value;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date value) {
		this.modifyTimeBegin = value;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date value) {
		this.modifyTimeEnd = value;
	}

	public String getLikeMaterialCode() {
		return likeMaterialCode;
	}

	public void setLikeMaterialCode(String likeMaterialCode) {
		this.likeMaterialCode = likeMaterialCode;
	}

	public String getLikeMaterialName() {
		return likeMaterialName;
	}

	public void setLikeMaterialName(String likeMaterialName) {
		this.likeMaterialName = likeMaterialName;
	}			
}
