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
import com.techsoft.entity.sys.AdminRoleVo;
import com.techsoft.entity.sys.AdminRoleParamVo;
import com.techsoft.service.sys.AdminRoleService;

@org.springframework.stereotype.Service
public class ClientAdminRoleServiceImpl extends BaseClientServiceImpl<AdminRole> implements ClientAdminRoleService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleService adminRoleService;

	@Override
	public BaseService<AdminRole> getBaseService() {
		return adminRoleService;
	}

	private AdminRoleVo getVo(AdminRole adminRole, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleVo vo = new AdminRoleVo(adminRole);

		return vo;
	}

	private AdminRoleVo getExtendVo(AdminRole adminRole, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleVo vo = this.getVo(adminRole, commonParam);

		return vo;
	}

	private List<AdminRoleVo> getVoList(List<AdminRole> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleVo> voList = new ArrayList<AdminRoleVo>();
		for (AdminRole entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminRoleVo> getExtendVoList(List<AdminRole> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleVo> voList = new ArrayList<AdminRoleVo>();
		for (AdminRole entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminRoleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRole entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminRoleVo> selectListVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminRole == null) {
			adminRole = new AdminRoleParamVo();
		}
		adminRole.setTenantId(commonParam.getTenantId());

		List<AdminRole> list = (List<AdminRole>) this.getBaseService().selectListByParamVo(adminRole, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleVo> selectPageVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (adminRole == null) {
			adminRole = new AdminRoleParamVo();
		}
		adminRole.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRole> list = (PageInfo<AdminRole>) this.getBaseService().selectPageByParamVo(adminRole,
				commonParam, pageNo, pageSize);
		List<AdminRoleVo> volist = new ArrayList<AdminRoleVo>();

		Iterator<AdminRole> iter = list.getList().iterator();
		AdminRoleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleVo> vpage = new Page<AdminRoleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminRoleVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRole entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminRoleVo> selectListExtendVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminRole == null) {
			adminRole = new AdminRoleParamVo();
		}
		adminRole.setTenantId(commonParam.getTenantId());

		List<AdminRole> list = (List<AdminRole>) this.getBaseService().selectListByParamVo(adminRole, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleVo> selectPageExtendVoByParamVo(AdminRoleParamVo adminRole, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRole == null) {
			adminRole = new AdminRoleParamVo();
		}
		adminRole.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRole> list = (PageInfo<AdminRole>) this.getBaseService().selectPageByParamVo(adminRole,
				commonParam, pageNo, pageSize);
		List<AdminRoleVo> volist = new ArrayList<AdminRoleVo>();

		Iterator<AdminRole> iter = list.getList().iterator();
		AdminRoleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleVo> vpage = new Page<AdminRoleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminRoleParamVo adminRoleParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminRole adminRole = null;
		try {
			if (adminRoleParamVo.getId() == null) {// 新增

				adminRoleParamVo.setTenantId(commonParam.getTenantId());
				adminRole = adminRoleService.saveOrUpdate(adminRoleParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminRole adminRoleVoTemp = this.selectById(adminRoleParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminRoleVoTemp, adminRoleParamVo);

				adminRole = adminRoleService.saveOrUpdate(adminRoleVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminRole);
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
