package com.techsoft.entity.quality;

import com.techsoft.entity.common.QualitySampleRuleItem;

public class QualitySampleRuleItemVo extends QualitySampleRuleItem {
	private static final long serialVersionUID = 298503969095226691L;

	public QualitySampleRuleItemVo() {	
	}
	
	public QualitySampleRuleItemVo(QualitySampleRuleItem value) {
		value.cloneProperties(this);
	}		
}
