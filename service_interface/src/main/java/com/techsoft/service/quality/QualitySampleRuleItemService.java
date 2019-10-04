package com.techsoft.service.quality;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;

public interface QualitySampleRuleItemService extends BaseService<QualitySampleRuleItem> {
	public QualitySampleRuleItem batchInsert(QualitySampleRuleItemVo qualitySampleRuleItemVo, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem) throws BusinessException, SQLException;
	
	public QualitySampleRuleItem batchUpdate(QualitySampleRuleItem qualitySampleRuleItemVoTemp, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem) throws BusinessException, SQLException;
	
}
