package com.techsoft.entity.warehouse;

import java.util.Date;

import com.techsoft.entity.common.WarehouseStrategyUpshelf;

public class WarehouseStrategyUpshelfParamVo extends WarehouseStrategyUpshelf {
	private static final long serialVersionUID = -8221853983115614159L;


	public WarehouseStrategyUpshelfParamVo (){
	}
	
	public WarehouseStrategyUpshelfParamVo(WarehouseStrategyUpshelf value) {
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
