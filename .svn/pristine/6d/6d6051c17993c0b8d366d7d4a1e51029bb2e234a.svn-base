package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualityInspectType;
import com.techsoft.entity.quality.QualityInspectTypeVo;
import com.techsoft.entity.quality.QualityInspectTypeParamVo;

public interface ClientQualityInspectTypeService extends BaseClientService<QualityInspectType> {

	public QualityInspectTypeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualityInspectTypeVo> selectListVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualityInspectTypeVo> selectPageVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public QualityInspectTypeVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualityInspectTypeVo> selectListExtendVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualityInspectTypeVo> selectPageExtendVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualityInspectTypeParamVo qualityInspectTypeParamVo, CommonParam commonParam);
}
