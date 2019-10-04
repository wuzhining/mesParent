package com.techsoft.entity.quality;

import java.util.Date;

import com.techsoft.entity.common.QualityInspectItem;

public class QualityInspectItemParamVo extends QualityInspectItem {
	private static final long serialVersionUID = -3791390176031899221L;
	private Integer notparent;


	public QualityInspectItemParamVo (){
	}
	
	public QualityInspectItemParamVo(QualityInspectItem value) {
		value.cloneProperties(this);
	}	
	private Integer parent;
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

	public Integer getNotparent() {
		return notparent;
	}

	public void setNotparent(Integer notparent) {
		this.notparent = notparent;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	
}
