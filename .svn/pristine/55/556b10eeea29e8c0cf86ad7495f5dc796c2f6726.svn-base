package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.entity.sys.AdminRoleMenuVo;
import com.techsoft.entity.sys.AdminRoleMenuParamVo;

public interface ClientAdminRoleMenuService extends BaseClientService<AdminRoleMenu> {

	public AdminRoleMenuVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleMenuVo> selectListVoByParamVo(AdminRoleMenuParamVo adminRoleMenu, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminRoleMenuVo> selectPageVoByParamVo(AdminRoleMenuParamVo adminRoleMenu, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AdminRoleMenuVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminRoleMenuVo> selectListExtendVoByParamVo(AdminRoleMenuParamVo adminRoleMenu,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AdminRoleMenuVo> selectPageExtendVoByParamVo(AdminRoleMenuParamVo adminRoleMenu,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminRoleMenuParamVo adminRoleMenuParamVo, CommonParam commonParam);
}
