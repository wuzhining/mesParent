package com.techsoft.entity.quality;

import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.common.QualityInspectType;

public class QualityInspectItemVo extends QualityInspectItem {
	private static final long serialVersionUID = 8175038337750988305L;
	
	private QualityInspectType qualityInspectTypeVo;
	private QualityInspectItem qualityInspectItemVo;

	public QualityInspectItemVo() {	
	}
	
	public QualityInspectItemVo(QualityInspectItem value) {
		value.cloneProperties(this);
	}

	public QualityInspectType getQualityInspectTypeVo() {
		return qualityInspectTypeVo;
	}

	public void setQualityInspectTypeVo(QualityInspectType qualityInspectTypeVo) {
		this.qualityInspectTypeVo = qualityInspectTypeVo;
	}

	public QualityInspectItem getQualityInspectItemVo() {
		return qualityInspectItemVo;
	}

	public void setQualityInspectItemVo(QualityInspectItem qualityInspectItemVo) {
		this.qualityInspectItemVo = qualityInspectItemVo;
	}


	
}
