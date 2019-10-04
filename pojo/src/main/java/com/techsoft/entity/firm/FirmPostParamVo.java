package com.techsoft.entity.firm;

import java.util.Date;

import com.techsoft.entity.common.FirmPost;

public class FirmPostParamVo extends FirmPost {
	private static final long serialVersionUID = 1271233313001098338L;


	public FirmPostParamVo (){
	}
	
	public FirmPostParamVo(FirmPost value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private Integer parent;
	private String postNameLike;
	private String postCodeLike;
	
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

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getPostNameLike() {
		return postNameLike;
	}

	public void setPostNameLike(String postNameLike) {
		this.postNameLike = postNameLike;
	}

	public String getPostCodeLike() {
		return postCodeLike;
	}

	public void setPostCodeLike(String postCodeLike) {
		this.postCodeLike = postCodeLike;
	}	
	
}
