package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructFloor;

public class StructFloorParamVo extends StructFloor {
	private static final long serialVersionUID = -6467723410963522667L;


	public StructFloorParamVo (){
	}
	
	public StructFloorParamVo(StructFloor value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeFloorCode;
	private String likeFloorName;
	
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

	public String getLikeFloorCode() {
		return likeFloorCode;
	}

	public void setLikeFloorCode(String likeFloorCode) {
		this.likeFloorCode = likeFloorCode;
	}

	public String getLikeFloorName() {
		return likeFloorName;
	}

	public void setLikeFloorName(String likeFloorName) {
		this.likeFloorName = likeFloorName;
	}		
	
}
