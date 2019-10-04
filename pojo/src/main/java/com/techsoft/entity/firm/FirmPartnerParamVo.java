package com.techsoft.entity.firm;

import java.util.Date;

import com.techsoft.entity.common.FirmPartner;

public class FirmPartnerParamVo extends FirmPartner {
	private static final long serialVersionUID = -9113172116794072952L;


	public FirmPartnerParamVo (){
	}
	
	public FirmPartnerParamVo(FirmPartner value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String companyNameLike;
	
	
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

	public String getCompanyNameLike() {
		return companyNameLike;
	}

	public void setCompanyNameLike(String companyNameLike) {
		this.companyNameLike = companyNameLike;
	}
	
}
