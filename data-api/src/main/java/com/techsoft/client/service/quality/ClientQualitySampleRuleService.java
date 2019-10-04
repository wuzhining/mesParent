package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualitySampleRule;
import com.techsoft.entity.quality.QualitySampleRuleVo;
import com.techsoft.entity.quality.QualitySampleRuleParamVo;

public interface ClientQualitySampleRuleService extends BaseClientService<QualitySampleRule> {

	public QualitySampleRuleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualitySampleRuleVo> selectListVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleRuleVo> selectPageVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public QualitySampleRuleVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualitySampleRuleVo> selectListExtendVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleRuleVo> selectPageExtendVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualitySampleRuleParamVo qualitySampleRuleParamVo, CommonParam commonParam);
}
