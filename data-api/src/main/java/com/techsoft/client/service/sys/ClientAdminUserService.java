package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminUser;
import com.techsoft.entity.sys.AdminUserVo;
import com.techsoft.entity.sys.AdminUserParamVo;

public interface ClientAdminUserService extends BaseClientService<AdminUser> {

	public AdminUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminUserVo> selectListVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminUserVo> selectPageVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public AdminUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminUserVo> selectListExtendVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminUserVo> selectPageExtendVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminUserParamVo adminUserParamVo, CommonParam commonParam);
}
