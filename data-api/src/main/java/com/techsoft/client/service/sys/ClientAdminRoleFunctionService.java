package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminRoleFunction;
import com.techsoft.entity.sys.AdminRoleFunctionVo;
import com.techsoft.entity.sys.AdminRoleFunctionParamVo;

public interface ClientAdminRoleFunctionService extends BaseClientService<AdminRoleFunction> {

	public AdminRoleFunctionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleFunctionVo> selectListVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AdminRoleFunctionVo> selectPageVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public AdminRoleFunctionVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleFunctionVo> selectListExtendVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AdminRoleFunctionVo> selectPageExtendVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminRoleFunctionParamVo adminRoleFunctionParamVo, CommonParam commonParam);
}
