package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.sys.AdminRoleVo;
import com.techsoft.entity.sys.AdminRoleParamVo;

public interface ClientAdminRoleService extends BaseClientService<AdminRole> {

	public AdminRoleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleVo> selectListVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminRoleVo> selectPageVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public AdminRoleVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleVo> selectListExtendVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminRoleVo> selectPageExtendVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminRoleParamVo adminRoleParamVo, CommonParam commonParam);
}
