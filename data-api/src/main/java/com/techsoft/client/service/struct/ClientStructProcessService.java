package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.struct.StructProcessParamVo;

public interface ClientStructProcessService extends BaseClientService<StructProcess> {

	public StructProcessVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessVo> selectListVoByParamVo(StructProcessParamVo structProcess, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<StructProcessVo> selectPageVoByParamVo(StructProcessParamVo structProcess, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public StructProcessVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<StructProcessVo> selectListExtendVoByParamVo(StructProcessParamVo structProcess,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<StructProcessVo> selectPageExtendVoByParamVo(StructProcessParamVo structProcess,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(StructProcessParamVo structProcessParamVo, CommonParam commonParam);
}
