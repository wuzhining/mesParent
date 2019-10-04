package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.struct.StructProcessLineVo;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.struct.StructProcessLineParamVo;

public interface ClientStructProcessLineService extends BaseClientService<StructProcessLine> {

	public StructProcessLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessLineVo> selectListVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcessLineVo> selectPageVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructProcessLineVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessLineVo> selectListExtendVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcessLineVo> selectPageExtendVoByParamVo(StructProcessLineParamVo structProcessLine,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructProcessLineParamVo structProcessLineParamVo, CommonParam commonParam);

	public ResultMessage saveBatchListInsert(List<ConfigDictionary> listDictionary, StructProcessVo entity,
			String[] data, List<StructProcessLineVo> processLineList, CommonParam commonParam);

}
