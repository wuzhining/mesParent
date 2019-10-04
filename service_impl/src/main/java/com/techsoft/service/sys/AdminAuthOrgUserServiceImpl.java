package com.techsoft.service.sys;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.entity.sys.AdminAuthOrgUserParamVo;
import com.techsoft.dao.sys.AdminAuthOrgUserDao;

@Service
public class AdminAuthOrgUserServiceImpl extends BaseServiceImpl<AdminAuthOrgUser> implements AdminAuthOrgUserService {
	@Autowired
	private AdminAuthOrgUserDao adminAuthOrgUserDao;
	
	@Override
	public BaseDao<AdminAuthOrgUser> getBaseDao() {
		return adminAuthOrgUserDao;
	}	
	
	@Override
	public Class<AdminAuthOrgUser> getEntityClass() {
		return AdminAuthOrgUser.class;
	}
	
	@Override
	protected AdminAuthOrgUser insertEntity(AdminAuthOrgUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected AdminAuthOrgUser updatePartEntity(AdminAuthOrgUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected AdminAuthOrgUser updateEntity(AdminAuthOrgUser entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
	
	public int insertAuthOrgsUser(AdminAuthOrgUserParamVo adminAuthOrgUserParamVo, CommonParam commonParam)throws BusinessException, SQLException{
		List<AdminAuthOrgUser> adminAuthOrgUserList = adminAuthOrgUserParamVo.getAdminAuthOrgUserList();
		int result = 0;
		for (AdminAuthOrgUser adminAuthOrgUser : adminAuthOrgUserList) {
			adminAuthOrgUser.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			adminAuthOrgUser.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			adminAuthOrgUser.setTenantId(commonParam.getTenantId());
			AdminAuthOrgUser adminAuthOrgUser2=super.insertEntity(adminAuthOrgUser,commonParam);
			if(adminAuthOrgUser2!=null){
				result++;
			}
		}
	//	adminAuthOrgUserDao.insertAuthOrgsUser(adminAuthOrgUserList,commonParam);
		return result;
	}
}
