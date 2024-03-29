package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructProductionline;

public class StructProductionlineParamVo extends StructProductionline {
	private static final long serialVersionUID = 4169915073868037162L;


	public StructProductionlineParamVo (){
	}
	
	public StructProductionlineParamVo(StructProductionline value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	

	private Long productBomId; //产品BOM id
	
	
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
 
	public Long getProductBomId() {
		return productBomId;
	}

	public void setProductBomId(Long productBomId) {
		this.productBomId = productBomId;
	}
 		
}
