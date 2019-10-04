package com.techsoft.entity.equip;

import java.util.Date;

import com.techsoft.entity.common.EquipSpecsFixtureArea;

public class EquipSpecsFixtureAreaParamVo extends EquipSpecsFixtureArea {
	private static final long serialVersionUID = 4505225111555021133L;


	public EquipSpecsFixtureAreaParamVo (){
	}
	
	public EquipSpecsFixtureAreaParamVo(EquipSpecsFixtureArea value) {
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
