package com.techsoft.client.service.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.UserPassportVo;
import com.techsoft.entity.sys.UserPassportParamVo;

public interface ClientUserPassportService extends BaseClientService<UserPassport> {

	public UserPassportVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<UserPassportVo> selectListVoByParamVo(UserPassportParamVo userPassport, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<UserPassportVo> selectPageVoByParamVo(UserPassportParamVo userPassport, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public UserPassportVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<UserPassportVo> selectListExtendVoByParamVo(UserPassportParamVo userPassport, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<UserPassportVo> selectPageExtendVoByParamVo(UserPassportParamVo userPassport,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(UserPassportParamVo userPassportParamVo, CommonParam commonParam);

	/*
	 * 登录
	 */
	public ResultMessage loginByUserName(CommonParam commonParam, String userName, String password, String loginip);

	/*
	 * 根据用户名取对象
	 */
	public UserPassport getByUserName(String userName);

	/*
	 * 修改密码
	 */
	public ResultMessage modifiyUserPass(UserPassportVo userPassportVo, String oldPassword, String newPassword,
			String password, CommonParam commonParam);
}
