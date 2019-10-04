package com.techsoft.client.service.quality;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.QualityInspectDocument;
import com.techsoft.entity.quality.QualityInspectDocumentVo;
import com.techsoft.entity.quality.QualityInspectDocumentParamVo;

public interface ClientQualityInspectDocumentService extends BaseClientService<QualityInspectDocument> {

	public QualityInspectDocumentVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<QualityInspectDocumentVo> selectListVoByParamVo(QualityInspectDocumentParamVo qualityInspectDocument,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<QualityInspectDocumentVo> selectPageVoByParamVo(
			QualityInspectDocumentParamVo qualityInspectDocument, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public QualityInspectDocumentVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<QualityInspectDocumentVo> selectListExtendVoByParamVo(
			QualityInspectDocumentParamVo qualityInspectDocument, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<QualityInspectDocumentVo> selectPageExtendVoByParamVo(
			QualityInspectDocumentParamVo qualityInspectDocument, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(QualityInspectDocumentParamVo qualityInspectDocumentParamVo,
			CommonParam commonParam);
}
