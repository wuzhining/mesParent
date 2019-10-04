package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructFactory;

public class StructFactoryParamVo extends StructFactory {
	private static final long serialVersionUID = 690758680194589561L;


	public StructFactoryParamVo (){
	}
	
	public StructFactoryParamVo(StructFactory value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	
	private String likeFactoryId;
	private String likeFactoryName;
	
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

	public String getLikeFactoryId() {
		return likeFactoryId;
	}

	public void setLikeFactoryId(String likeFactoryId) {
		this.likeFactoryId = likeFactoryId;
	}

	public String getLikeFactoryName() {
		return likeFactoryName;
	}

	public void setLikeFactoryName(String likeFactoryName) {
		this.likeFactoryName = likeFactoryName;
	}			
}
