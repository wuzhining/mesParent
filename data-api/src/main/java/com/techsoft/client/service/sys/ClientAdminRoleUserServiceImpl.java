package com.techsoft.client.service.sys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.AdminRoleUserVo;
import com.techsoft.entity.sys.AdminRoleUserParamVo;
import com.techsoft.service.sys.AdminRoleService;
import com.techsoft.service.sys.AdminRoleUserService;
import com.techsoft.service.sys.UserPassportService;

@org.springframework.stereotype.Service
public class ClientAdminRoleUserServiceImpl extends BaseClientServiceImpl<AdminRoleUser>
		implements ClientAdminRoleUserService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleUserService adminRoleUserService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleService adminRoleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;

	@Override
	public BaseService<AdminRoleUser> getBaseService() {
		return adminRoleUserService;
	}

	private AdminRoleUserVo getVo(AdminRoleUser adminRoleUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleUserVo vo = new AdminRoleUserVo(adminRoleUser);
		if (vo.getRoleId() != null && vo.getRoleId() > 0L) {
			AdminRole adminRole = adminRoleService.selectById(vo.getRoleId(), commonParam);
			if (adminRole != null) {
				vo.setAdminRole(adminRole);
			}
		}
		if (vo.getUserId() != null && vo.getUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassport(userPassport);
			}
		}
		return vo;
	}

	private AdminRoleUserVo getExtendVo(AdminRoleUser adminRoleUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleUserVo vo = this.getVo(adminRoleUser, commonParam);

		return vo;
	}

	private List<AdminRoleUserVo> getVoList(List<AdminRoleUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleUserVo> voList = new ArrayList<AdminRoleUserVo>();
		for (AdminRoleUser entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminRoleUserVo> getExtendVoList(List<AdminRoleUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleUserVo> voList = new ArrayList<AdminRoleUserVo>();
		for (AdminRoleUser entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminRoleUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminRoleUserVo> selectListVoByParamVo(AdminRoleUserParamVo adminRoleUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminRoleUser == null) {
			adminRoleUser = new AdminRoleUserParamVo();
		}
		adminRoleUser.setTenantId(commonParam.getTenantId());

		List<AdminRoleUser> list = (List<AdminRoleUser>) this.getBaseService().selectListByParamVo(adminRoleUser,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleUserVo> selectPageVoByParamVo(AdminRoleUserParamVo adminRoleUser, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleUser == null) {
			adminRoleUser = new AdminRoleUserParamVo();
		}
		adminRoleUser.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleUser> list = (PageInfo<AdminRoleUser>) this.getBaseService()
				.selectPageByParamVo(adminRoleUser, commonParam, pageNo, pageSize);
		List<AdminRoleUserVo> volist = new ArrayList<AdminRoleUserVo>();

		Iterator<AdminRoleUser> iter = list.getList().iterator();
		AdminRoleUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleUserVo> vpage = new Page<AdminRoleUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminRoleUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminRoleUserVo> selectListExtendVoByParamVo(AdminRoleUserParamVo adminRoleUser,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (adminRoleUser == null) {
			adminRoleUser = new AdminRoleUserParamVo();
		}
		adminRoleUser.setTenantId(commonParam.getTenantId());

		List<AdminRoleUser> list = (List<AdminRoleUser>) this.getBaseService().selectListByParamVo(adminRoleUser,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleUserVo> selectPageExtendVoByParamVo(AdminRoleUserParamVo adminRoleUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleUser == null) {
			adminRoleUser = new AdminRoleUserParamVo();
		}
		adminRoleUser.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleUser> list = (PageInfo<AdminRoleUser>) this.getBaseService()
				.selectPageByParamVo(adminRoleUser, commonParam, pageNo, pageSize);
		List<AdminRoleUserVo> volist = new ArrayList<AdminRoleUserVo>();

		Iterator<AdminRoleUser> iter = list.getList().iterator();
		AdminRoleUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleUserVo> vpage = new Page<AdminRoleUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminRoleUserParamVo adminRoleUserParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminRoleUser adminRoleUser = null;
		if (adminRoleUserParamVo.getRoleId() == null) {
			resultMessage.addErr("角色不能为空");
			return resultMessage;
		}
		if (adminRoleUserParamVo.getUserId() == null) {
			resultMessage.addErr("用户名不能为空");
			return resultMessage;
		}
		try {
			if (adminRoleUserParamVo.getId() == null) {// 新增

				adminRoleUserParamVo.setTenantId(commonParam.getTenantId());
				adminRoleUser = adminRoleUserService.saveOrUpdate(adminRoleUserParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminRoleUser adminRoleUserVoTemp = this.selectById(adminRoleUserParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminRoleUserVoTemp, adminRoleUserParamVo);

				adminRoleUser = adminRoleUserService.saveOrUpdate(adminRoleUserVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminRoleUser);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
