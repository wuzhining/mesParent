package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.struct.StructFactoryVo;
import com.techsoft.entity.struct.StructFactoryParamVo;

public interface ClientStructFactoryService extends BaseClientService<StructFactory> {

	public StructFactoryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructFactoryVo> selectListVoByParamVo(StructFactoryParamVo structFactory, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructFactoryVo> selectPageVoByParamVo(StructFactoryParamVo structFactory, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructFactoryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructFactoryVo> selectListExtendVoByParamVo(StructFactoryParamVo structFactory,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructFactoryVo> selectPageExtendVoByParamVo(StructFactoryParamVo structFactory,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructFactoryParamVo structFactoryParamVo, CommonParam commonParam);
}
