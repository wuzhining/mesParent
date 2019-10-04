package com.techsoft.entity.equip;

import java.util.Date;

import com.techsoft.entity.common.EquipWork;

public class EquipWorkParamVo extends EquipWork {
	private static final long serialVersionUID = 3389855082933341288L;


	public EquipWorkParamVo (){
	}
	
	public EquipWorkParamVo(EquipWork value) {
		value.cloneProperties(this);
	}	
	
	private Date createTimeBegin;
	private Date createTimeEnd;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	private String equipCodeLike;
	private String equipLabelLike;
	private String equipNameLike;
	private String equipPatternLike;
	
	
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

	public String getEquipCodeLike() {
		return equipCodeLike;
	}

	public void setEquipCodeLike(String equipCodeLike) {
		this.equipCodeLike = equipCodeLike;
	}

	public String getEquipLabelLike() {
		return equipLabelLike;
	}

	public void setEquipLabelLike(String equipLabelLike) {
		this.equipLabelLike = equipLabelLike;
	}

	public String getEquipNameLike() {
		return equipNameLike;
	}

	public void setEquipNameLike(String equipNameLike) {
		this.equipNameLike = equipNameLike;
	}

	public String getEquipPatternLike() {
		return equipPatternLike;
	}

	public void setEquipPatternLike(String equipPatternLike) {
		this.equipPatternLike = equipPatternLike;
	}
	
	
}
