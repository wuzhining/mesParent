package com.techsoft.client.service.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.sys.AdminMenuVo;
import com.techsoft.entity.sys.AdminMenuParamVo;

public interface ClientAdminMenuService extends BaseClientService<AdminMenu> {

	public AdminMenuVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminMenuVo> selectListVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminMenuVo> selectPageVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public AdminMenuVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AdminMenuVo> selectListExtendVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AdminMenuVo> selectPageExtendVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AdminMenuParamVo adminMenuParamVo, CommonParam commonParam);
	
	public ResultMessage adminMenuSystemLists(Long userId, String systemRoletype, String userName,
			CommonParam commonParam)throws BusinessException, SQLException;
}
