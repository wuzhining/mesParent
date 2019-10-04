package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminFunction;
import com.techsoft.entity.sys.AdminFunctionVo;
import com.techsoft.entity.sys.AdminFunctionParamVo;

public interface ClientAdminFunctionService extends BaseClientService<AdminFunction> {

	public AdminFunctionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminFunctionVo> selectListVoByParamVo(AdminFunctionParamVo adminFunction, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminFunctionVo> selectPageVoByParamVo(AdminFunctionParamVo adminFunction, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AdminFunctionVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminFunctionVo> selectListExtendVoByParamVo(AdminFunctionParamVo adminFunction,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AdminFunctionVo> selectPageExtendVoByParamVo(AdminFunctionParamVo adminFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminFunctionParamVo adminFunctionParamVo, CommonParam commonParam);
}
