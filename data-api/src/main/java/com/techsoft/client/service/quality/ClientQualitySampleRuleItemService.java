package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;
import com.techsoft.entity.quality.QualitySampleRuleItemParamVo;

public interface ClientQualitySampleRuleItemService extends BaseClientService<QualitySampleRuleItem> {

	public QualitySampleRuleItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualitySampleRuleItemVo> selectListVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleRuleItemVo> selectPageVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public QualitySampleRuleItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualitySampleRuleItemVo> selectListExtendVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualitySampleRuleItemVo> selectPageExtendVoByParamVo(
			QualitySampleRuleItemParamVo qualitySampleRuleItem, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualitySampleRuleItemParamVo qualitySampleRuleItemVo, CommonParam commonParam);

	public ResultMessage batchInsertList(QualitySampleRuleItemVo qualitySampleRuleItemParamVo, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem);

}
