package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.entity.sys.AdminAuthOrgUserVo;
import com.techsoft.entity.sys.AdminAuthOrgUserParamVo;

public interface ClientAdminAuthOrgUserService extends BaseClientService<AdminAuthOrgUser> {
	
	public AdminAuthOrgUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<AdminAuthOrgUserVo>  selectListVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<AdminAuthOrgUserVo>  selectPageVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public AdminAuthOrgUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<AdminAuthOrgUserVo>  selectListExtendVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<AdminAuthOrgUserVo>  selectPageExtendVoByParamVo(AdminAuthOrgUserParamVo adminAuthOrgUser, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(AdminAuthOrgUserParamVo adminAuthOrgUserParamVo, CommonParam commonParam);	
	
	/**
	 *  批量增加分配数据权限表
	 */
	public ResultMessage bathinsertAuthOrgsUser(List<AdminAuthOrgUser> adminAuthOrgUser,CommonParam commonParam)throws BusinessException, SQLException;
}
