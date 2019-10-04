package com.techsoft.entity.quality;

import java.util.Date;

import com.techsoft.entity.common.QualityInspectType;

public class QualityInspectTypeParamVo extends QualityInspectType {
	private static final long serialVersionUID = 1561050323978648415L;


	public QualityInspectTypeParamVo (){
	}
	
	public QualityInspectTypeParamVo(QualityInspectType value) {
		value.cloneProperties(this);
	}
	private String inspectTypeCodeLike;
	private String inspectTypeNameLike;
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

	public String getInspectTypeNameLike() {
		return inspectTypeNameLike;
	}

	public void setInspectTypeNameLike(String inspectTypeNameLike) {
		this.inspectTypeNameLike = inspectTypeNameLike;
	}

	public String getInspectTypeCodeLike() {
		return inspectTypeCodeLike;
	}

	public void setInspectTypeCodeLike(String inspectTypeCodeLike) {
		this.inspectTypeCodeLike = inspectTypeCodeLike;
	}
	
	
}
