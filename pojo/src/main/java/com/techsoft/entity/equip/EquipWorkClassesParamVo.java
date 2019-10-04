package com.techsoft.entity.equip;

import java.util.Date;

import com.techsoft.entity.common.EquipWorkClasses;

public class EquipWorkClassesParamVo extends EquipWorkClasses {
	private static final long serialVersionUID = -8261969338202598477L;


	public EquipWorkClassesParamVo (){
	}
	
	public EquipWorkClassesParamVo(EquipWorkClasses value) {
		value.cloneProperties(this);
	}
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private Integer  parent ;
	private String  classesCodeLike;
	private String classesNameLike;
	
	
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

	public String getClassesCodeLike() {
		return classesCodeLike;
	}

	public void setClassesCodeLike(String classesCodeLike) {
		this.classesCodeLike = classesCodeLike;
	}

	public String getClassesNameLike() {
		return classesNameLike;
	}

	public void setClassesNameLike(String classesNameLike) {
		this.classesNameLike = classesNameLike;
	}


	
}
