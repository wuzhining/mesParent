package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructProdlineWorkstation;

public class StructProdlineWorkstationParamVo extends StructProdlineWorkstation {
	private static final long serialVersionUID = -2919563865235075097L;


	public StructProdlineWorkstationParamVo (){
	}
	
	public StructProdlineWorkstationParamVo(StructProdlineWorkstation value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	
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
}
