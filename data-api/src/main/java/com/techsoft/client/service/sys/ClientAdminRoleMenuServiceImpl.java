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
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.entity.sys.AdminRoleMenuVo;
import com.techsoft.entity.sys.AdminRoleMenuParamVo;
import com.techsoft.service.sys.AdminMenuService;
import com.techsoft.service.sys.AdminRoleMenuService;
import com.techsoft.service.sys.AdminRoleService;

@org.springframework.stereotype.Service
public class ClientAdminRoleMenuServiceImpl extends BaseClientServiceImpl<AdminRoleMenu>
		implements ClientAdminRoleMenuService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleMenuService adminRoleMenuService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleService adminRoleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminMenuService adminMenuService;

	@Override
	public BaseService<AdminRoleMenu> getBaseService() {
		return adminRoleMenuService;
	}

	private AdminRoleMenuVo getVo(AdminRoleMenu adminRoleMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleMenuVo vo = new AdminRoleMenuVo(adminRoleMenu);
		if (vo.getRoleId() != null && vo.getRoleId() > 0L) {
			AdminRole adminRole = adminRoleService.selectById(vo.getRoleId(), commonParam);
			if (adminRole != null) {
				vo.setAdminRole(adminRole);
			}
		}
		if (vo.getMenuId() != null && vo.getMenuId() > 0L) {
			AdminMenu adminMenu = adminMenuService.selectById(vo.getMenuId(), commonParam);
			if (adminMenu != null) {
				vo.setAdminMenu(adminMenu);
			}
		}
		return vo;
	}

	private AdminRoleMenuVo getExtendVo(AdminRoleMenu adminRoleMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleMenuVo vo = this.getVo(adminRoleMenu, commonParam);

		return vo;
	}

	private List<AdminRoleMenuVo> getVoList(List<AdminRoleMenu> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleMenuVo> voList = new ArrayList<AdminRoleMenuVo>();
		for (AdminRoleMenu entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminRoleMenuVo> getExtendVoList(List<AdminRoleMenu> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleMenuVo> voList = new ArrayList<AdminRoleMenuVo>();
		for (AdminRoleMenu entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminRoleMenuVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleMenu entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminRoleMenuVo> selectListVoByParamVo(AdminRoleMenuParamVo adminRoleMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminRoleMenu == null) {
			adminRoleMenu = new AdminRoleMenuParamVo();
		}
		adminRoleMenu.setTenantId(commonParam.getTenantId());

		List<AdminRoleMenu> list = (List<AdminRoleMenu>) this.getBaseService().selectListByParamVo(adminRoleMenu,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleMenuVo> selectPageVoByParamVo(AdminRoleMenuParamVo adminRoleMenu, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleMenu == null) {
			adminRoleMenu = new AdminRoleMenuParamVo();
		}
		adminRoleMenu.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleMenu> list = (PageInfo<AdminRoleMenu>) this.getBaseService()
				.selectPageByParamVo(adminRoleMenu, commonParam, pageNo, pageSize);
		List<AdminRoleMenuVo> volist = new ArrayList<AdminRoleMenuVo>();

		Iterator<AdminRoleMenu> iter = list.getList().iterator();
		AdminRoleMenuVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleMenuVo> vpage = new Page<AdminRoleMenuVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminRoleMenuVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleMenu entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminRoleMenuVo> selectListExtendVoByParamVo(AdminRoleMenuParamVo adminRoleMenu,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (adminRoleMenu == null) {
			adminRoleMenu = new AdminRoleMenuParamVo();
		}
		adminRoleMenu.setTenantId(commonParam.getTenantId());

		List<AdminRoleMenu> list = (List<AdminRoleMenu>) this.getBaseService().selectListByParamVo(adminRoleMenu,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleMenuVo> selectPageExtendVoByParamVo(AdminRoleMenuParamVo adminRoleMenu,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleMenu == null) {
			adminRoleMenu = new AdminRoleMenuParamVo();
		}
		adminRoleMenu.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleMenu> list = (PageInfo<AdminRoleMenu>) this.getBaseService()
				.selectPageByParamVo(adminRoleMenu, commonParam, pageNo, pageSize);
		List<AdminRoleMenuVo> volist = new ArrayList<AdminRoleMenuVo>();

		Iterator<AdminRoleMenu> iter = list.getList().iterator();
		AdminRoleMenuVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleMenuVo> vpage = new Page<AdminRoleMenuVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminRoleMenuParamVo adminRoleMenuParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminRoleMenu adminRoleMenu = null;
		try {
			if (adminRoleMenuParamVo.getId() == null) {// 新增

				adminRoleMenuParamVo.setTenantId(commonParam.getTenantId());
				adminRoleMenu = adminRoleMenuService.saveOrUpdate(adminRoleMenuParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminRoleMenu adminRoleMenuVoTemp = this.selectById(adminRoleMenuParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminRoleMenuVoTemp, adminRoleMenuParamVo);

				adminRoleMenu = adminRoleMenuService.saveOrUpdate(adminRoleMenuVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminRoleMenu);
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
