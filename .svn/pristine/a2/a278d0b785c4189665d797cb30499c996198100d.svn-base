package com.techsoft.dao.sys;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.utils.StringUtil;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.UserPassportParamVo;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.mapper.sys.UserPassportMapper;

@Repository
public class UserPassportDaoImpl extends BaseDaoImpl<UserPassport> implements UserPassportDao {
	@Resource
	protected UserPassportMapper userPassportMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<UserPassport> getEntityClass() {
		return UserPassport.class;
	}

	@Override
	public BaseMapper<UserPassport> getBaseMapper() {
		return this.userPassportMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "user_passport";
	}

	@Override
	public void insertSaveCheck(UserPassport value) throws BusinessException, SQLException {
		/*if(value.getUserName() == null || value.getUserName().equals(0L)){
			throw new BusinessException("用户名不能为空");
		}
		if(!StringUtil.verifyLoginName(value.getUserName())){
			throw new BusinessException("用户名格式不正确!6至11位字母和数字组成");
		}*/
		if(value.getPassword() == null || value.getPassword().equals(0L)){
			throw new BusinessException("密码不能为空");
		}
		if(value.getPassword().length() < 6){
			throw new BusinessException("密码长度不能小于6位数");
		}
	}
	@Override
	public void updateSaveCheck(UserPassport value) throws BusinessException, SQLException {
		/*if(value.getUserName() == null || value.getUserName().equals(0L)){
			throw new BusinessException("用户名不能为空");
		}
		if(!StringUtil.verifyLoginName(value.getUserName())){
			throw new BusinessException("用户名格式不正确!6至11位字母和数字组成3");
		}*/
		if(value.getPassword() == null || value.getPassword().equals(0L)){
			throw new BusinessException("密码不能为空");
		}
		if(value.getPassword().length() < 6){
			throw new BusinessException("密码长度不能小于6位数");
		}
	}

	@Override
	public void deleteSaveCheck(UserPassport value) throws BusinessException, SQLException {

	}

	public UserPassport getByUserName(String userName) throws SQLException {
		if (StringUtils.isBlank(userName)) {
			return null;
		}
		UserPassportParamVo userPassport = new UserPassportParamVo();
		userPassport.setUserName(userName);
		List<UserPassport> list = (List<UserPassport>) selectListByParamVo(userPassport);
		if ((list != null) && (!list.isEmpty())) {
			return list.get(0);
		}
		return null;
	}

}
