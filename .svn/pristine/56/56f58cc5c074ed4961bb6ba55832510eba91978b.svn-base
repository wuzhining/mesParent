package com.techsoft.dao.sys;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.mapper.sys.AdminAuthOrgUserMapper;

@Repository
public class AdminAuthOrgUserDaoImpl extends BaseDaoImpl<AdminAuthOrgUser> implements AdminAuthOrgUserDao {
	@Resource
	protected AdminAuthOrgUserMapper adminAuthOrgUserMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AdminAuthOrgUser> getEntityClass() {
		return AdminAuthOrgUser.class;
	}	
	
	@Override
	public BaseMapper<AdminAuthOrgUser> getBaseMapper() {
		return this.adminAuthOrgUserMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ADMIN_AUTH_ORG_USER";
	}
	
	@Override
	public void insertSaveCheck(AdminAuthOrgUser value) throws BusinessException, SQLException {
		if (value.getFactoryId() == null || value.getFactoryId().equals(0L)) {
			throw new BusinessException("工厂id不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(AdminAuthOrgUser value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(AdminAuthOrgUser value) throws BusinessException, SQLException {
	
	}
	/**
	 *  批量增加分配数据权限表
	 */
	@Override
	public int insertAuthOrgsUser(List<AdminAuthOrgUser> lists, CommonParam commonParam)
			throws BusinessException, SQLException {
		//List<AdminAuthOrgUser> adminAuthOrgUserLists = new ArrayList<AdminAuthOrgUser>();
		int result=0;
		for(AdminAuthOrgUser adminAuthOrgUser : lists){
			adminAuthOrgUser.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			adminAuthOrgUser.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			adminAuthOrgUser.setTenantId(commonParam.getTenantId());
			 result = adminAuthOrgUserMapper.insertEntity(adminAuthOrgUser);
			//adminAuthOrgUserLists.add(adminAuthOrgUser);
			
			if (result != lists.size()) {
				throw new BusinessException("批量增加的分配数据权限表数据与传入的分配数据权限表数量不一致， 请检查!");
			}
		}
	
		//int result = adminAuthOrgUserMapper.insertAuthOrgsUser(adminAuthOrgUserLists);
		return result;
	}
			
}
