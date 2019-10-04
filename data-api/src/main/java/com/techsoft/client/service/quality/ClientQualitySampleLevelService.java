package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelVo;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;

public interface ClientQualitySampleLevelService extends BaseClientService<QualitySampleLevel> {

	public QualitySampleLevelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualitySampleLevelVo> selectListVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleLevelVo> selectPageVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public QualitySampleLevelVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualitySampleLevelVo> selectListExtendVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleLevelVo> selectPageExtendVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualitySampleLevelParamVo qualitySampleLevelParamVo, CommonParam commonParam);

	public ResultMessage saveBatchSampleLevel(QualitySampleLevelParamVo qualitySampleLevelParamVo, CommonParam commonParam,
			List<QualitySampleLevel> itemList);

	public List<QualitySampleLevelVo> selectSampleLetter() throws BusinessException, SQLException;
	
	
	
}
