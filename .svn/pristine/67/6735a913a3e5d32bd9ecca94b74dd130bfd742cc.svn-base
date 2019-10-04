package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualityInspectModuleRelation;
import com.techsoft.entity.quality.QualityInspectModuleRelationVo;
import com.techsoft.entity.quality.QualityInspectModuleRelationParamVo;

public interface ClientQualityInspectModuleRelationService extends BaseClientService<QualityInspectModuleRelation> {

	public QualityInspectModuleRelationVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualityInspectModuleRelationVo> selectListVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<QualityInspectModuleRelationVo> selectPageVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public QualityInspectModuleRelationVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualityInspectModuleRelationVo> selectListExtendVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<QualityInspectModuleRelationVo> selectPageExtendVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualityInspectModuleRelationParamVo qualityInspectModuleRelationParamVo,
			CommonParam commonParam);
}
