package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.sys.AdminRoleUserVo;
import com.techsoft.entity.sys.AdminRoleUserParamVo;

public interface ClientAdminRoleUserService extends BaseClientService<AdminRoleUser> {

	public AdminRoleUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleUserVo> selectListVoByParamVo(AdminRoleUserParamVo adminRoleUser, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminRoleUserVo> selectPageVoByParamVo(AdminRoleUserParamVo adminRoleUser, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AdminRoleUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleUserVo> selectListExtendVoByParamVo(AdminRoleUserParamVo adminRoleUser,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AdminRoleUserVo> selectPageExtendVoByParamVo(AdminRoleUserParamVo adminRoleUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminRoleUserParamVo adminRoleUserParamVo, CommonParam commonParam);
}
