package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.quality.QualityInspectItemVo;
import com.techsoft.entity.quality.QualityInspectItemParamVo;

public interface ClientQualityInspectItemService extends BaseClientService<QualityInspectItem> {

	public QualityInspectItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualityInspectItemVo> selectListVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualityInspectItemVo> selectPageVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public QualityInspectItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualityInspectItemVo> selectListExtendVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualityInspectItemVo> selectPageExtendVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualityInspectItemParamVo qualityInspectItemParamVo, CommonParam commonParam);
}
