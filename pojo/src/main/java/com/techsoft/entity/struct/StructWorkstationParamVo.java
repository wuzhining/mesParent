package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructWorkstation;

public class StructWorkstationParamVo extends StructWorkstation {
	private static final long serialVersionUID = 5653282573643880095L;


	public StructWorkstationParamVo (){
	}
	
	public StructWorkstationParamVo(StructWorkstation value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeWorkStationCode;
	private String likeWorkStationName;
	
	
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

	public String getLikeWorkStationCode() {
		return likeWorkStationCode;
	}

	public void setLikeWorkStationCode(String likeWorkStationCode) {
		this.likeWorkStationCode = likeWorkStationCode;
	}

	public String getLikeWorkStationName() {
		return likeWorkStationName;
	}

	public void setLikeWorkStationName(String likeWorkStationName) {
		this.likeWorkStationName = likeWorkStationName;
	}		
	
}
