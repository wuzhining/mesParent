package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.UserTenant;
import com.techsoft.entity.sys.UserTenantVo;
import com.techsoft.entity.sys.UserTenantParamVo;

public interface ClientUserTenantService extends BaseClientService<UserTenant> {
	
	public UserTenantVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<UserTenantVo>  selectListVoByParamVo(UserTenantParamVo userTenant, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<UserTenantVo>  selectPageVoByParamVo(UserTenantParamVo userTenant, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public UserTenantVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<UserTenantVo>  selectListExtendVoByParamVo(UserTenantParamVo userTenant, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<UserTenantVo>  selectPageExtendVoByParamVo(UserTenantParamVo userTenant, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(UserTenantParamVo userTenantParamVo, CommonParam commonParam);		
}
