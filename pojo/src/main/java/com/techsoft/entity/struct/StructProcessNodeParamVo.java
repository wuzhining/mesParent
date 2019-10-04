package com.techsoft.entity.struct;

import java.util.Date;

import com.techsoft.entity.common.StructProcessNode;

public class StructProcessNodeParamVo extends StructProcessNode {
	private static final long serialVersionUID = -2309629294508096084L;


	public StructProcessNodeParamVo (){
	}
	
	public StructProcessNodeParamVo(StructProcessNode value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;	
	private String nodeNames;
	
	
	public String getNodeNames() {
		return nodeNames;
	}

	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}

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
