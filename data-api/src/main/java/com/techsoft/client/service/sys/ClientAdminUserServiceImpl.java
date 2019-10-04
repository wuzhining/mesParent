package com.techsoft.client.service.sys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.AdminUser;
import com.techsoft.entity.sys.AdminUserParamVo;
import com.techsoft.entity.sys.AdminUserVo;
import com.techsoft.service.sys.AdminUserService;

@org.springframework.stereotype.Service
public class ClientAdminUserServiceImpl extends BaseClientServiceImpl<AdminUser> implements ClientAdminUserService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminUserService adminUserService;

	@Override
	public BaseService<AdminUser> getBaseService() {
		return adminUserService;
	}

	private AdminUserVo getVo(AdminUser adminUser, CommonParam commonParam) throws BusinessException, SQLException {
		AdminUserVo vo = new AdminUserVo(adminUser);

		return vo;
	}

	private AdminUserVo getExtendVo(AdminUser adminUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminUserVo vo = this.getVo(adminUser, commonParam);

		return vo;
	}

	private List<AdminUserVo> getVoList(List<AdminUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminUserVo> voList = new ArrayList<AdminUserVo>();
		for (AdminUser entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminUserVo> getExtendVoList(List<AdminUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminUserVo> voList = new ArrayList<AdminUserVo>();
		for (AdminUser entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminUserVo> selectListVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminUser == null) {
			adminUser = new AdminUserParamVo();
		}
		adminUser.setTenantId(commonParam.getTenantId());

		List<AdminUser> list = (List<AdminUser>) this.getBaseService().selectListByParamVo(adminUser, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminUserVo> selectPageVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (adminUser == null) {
			adminUser = new AdminUserParamVo();
		}
		adminUser.setTenantId(commonParam.getTenantId());

		PageInfo<AdminUser> list = (PageInfo<AdminUser>) this.getBaseService().selectPageByParamVo(adminUser,
				commonParam, pageNo, pageSize);
		List<AdminUserVo> volist = new ArrayList<AdminUserVo>();

		Iterator<AdminUser> iter = list.getList().iterator();
		AdminUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminUserVo> vpage = new Page<AdminUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminUserVo> selectListExtendVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminUser == null) {
			adminUser = new AdminUserParamVo();
		}
		adminUser.setTenantId(commonParam.getTenantId());

		List<AdminUser> list = (List<AdminUser>) this.getBaseService().selectListByParamVo(adminUser, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminUserVo> selectPageExtendVoByParamVo(AdminUserParamVo adminUser, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminUser == null) {
			adminUser = new AdminUserParamVo();
		}
		adminUser.setTenantId(commonParam.getTenantId());

		PageInfo<AdminUser> list = (PageInfo<AdminUser>) this.getBaseService().selectPageByParamVo(adminUser,
				commonParam, pageNo, pageSize);
		List<AdminUserVo> volist = new ArrayList<AdminUserVo>();

		Iterator<AdminUser> iter = list.getList().iterator();
		AdminUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminUserVo> vpage = new Page<AdminUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminUserParamVo adminUserParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminUser adminUser = null;
		try {
			if (adminUserParamVo.getId() == null) {// 新增

				adminUserParamVo.setTenantId(commonParam.getTenantId());
				adminUser = adminUserService.saveOrUpdate(adminUserParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminUser adminUserVoTemp = this.selectById(adminUserParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminUserVoTemp, adminUserParamVo);

				adminUser = adminUserService.saveOrUpdate(adminUserVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminUser);
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
