package com.techsoft.dao.quality;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.entity.quality.QualitySampleLevelVo;

public interface QualitySampleLevelDao extends BaseDao<QualitySampleLevel> {
	
	public void insertBatch(QualitySampleLevelParamVo qualitySampleLevel, List<QualitySampleLevel> qualitySampleLevelList,
			CommonParam commonParam) throws BusinessException, SQLException;

    //删除整个表数据库
	public void deleteQualitySampleLevel() throws BusinessException, SQLException;
		
	public List<QualitySampleLevelVo> selectSampleLetter() throws BusinessException, SQLException;

}
