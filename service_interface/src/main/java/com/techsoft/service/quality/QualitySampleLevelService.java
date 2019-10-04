package com.techsoft.service.quality;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.entity.quality.QualitySampleLevelVo;

public interface QualitySampleLevelService extends BaseService<QualitySampleLevel> {
	
	public QualitySampleLevel saveBatchInsert(QualitySampleLevelParamVo qualitySampleLevelParamVo, CommonParam commonParam,
			List<QualitySampleLevel> qualitySampleLevelList) throws BusinessException, SQLException;
     //删除整个表数据库
	public void deleteQualitySampleLevel() throws BusinessException, SQLException;
	
	public List<QualitySampleLevelVo> selectSampleLetter() throws BusinessException, SQLException;

}
