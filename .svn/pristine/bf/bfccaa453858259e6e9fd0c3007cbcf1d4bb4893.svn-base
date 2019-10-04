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

import com.techsoft.entity.common.AdminFunction;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.sys.AdminFunctionVo;
import com.techsoft.entity.sys.AdminFunctionParamVo;
import com.techsoft.service.sys.AdminFunctionService;
import com.techsoft.service.sys.AdminMenuService;

@org.springframework.stereotype.Service
public class ClientAdminFunctionServiceImpl extends BaseClientServiceImpl<AdminFunction>
		implements ClientAdminFunctionService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminFunctionService adminFunctionService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminMenuService adminMenuService;

	@Override
	public BaseService<AdminFunction> getBaseService() {
		return adminFunctionService;
	}

	private AdminFunctionVo getVo(AdminFunction adminFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminFunctionVo vo = new AdminFunctionVo(adminFunction);
		if (vo.getMenuId() != null && vo.getMenuId() > 0L) {
			AdminMenu adminMenu = adminMenuService.selectById(vo.getMenuId(), commonParam);
			if (adminMenu != null) {
				vo.setAdminMenu(adminMenu);
			}
		}
		return vo;
	}

	private AdminFunctionVo getExtendVo(AdminFunction adminFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminFunctionVo vo = this.getVo(adminFunction, commonParam);

		return vo;
	}

	private List<AdminFunctionVo> getVoList(List<AdminFunction> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminFunctionVo> voList = new ArrayList<AdminFunctionVo>();
		for (AdminFunction entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminFunctionVo> getExtendVoList(List<AdminFunction> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminFunctionVo> voList = new ArrayList<AdminFunctionVo>();
		for (AdminFunction entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminFunctionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminFunction entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminFunctionVo> selectListVoByParamVo(AdminFunctionParamVo adminFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminFunction == null) {
			adminFunction = new AdminFunctionParamVo();
		}
		adminFunction.setTenantId(commonParam.getTenantId());

		List<AdminFunction> list = (List<AdminFunction>) this.getBaseService().selectListByParamVo(adminFunction,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminFunctionVo> selectPageVoByParamVo(AdminFunctionParamVo adminFunction, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminFunction == null) {
			adminFunction = new AdminFunctionParamVo();
		}
		adminFunction.setTenantId(commonParam.getTenantId());

		PageInfo<AdminFunction> list = (PageInfo<AdminFunction>) this.getBaseService()
				.selectPageByParamVo(adminFunction, commonParam, pageNo, pageSize);
		List<AdminFunctionVo> volist = new ArrayList<AdminFunctionVo>();

		Iterator<AdminFunction> iter = list.getList().iterator();
		AdminFunctionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminFunctionVo> vpage = new Page<AdminFunctionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminFunctionVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminFunction entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminFunctionVo> selectListExtendVoByParamVo(AdminFunctionParamVo adminFunction,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (adminFunction == null) {
			adminFunction = new AdminFunctionParamVo();
		}
		adminFunction.setTenantId(commonParam.getTenantId());

		List<AdminFunction> list = (List<AdminFunction>) this.getBaseService().selectListByParamVo(adminFunction,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminFunctionVo> selectPageExtendVoByParamVo(AdminFunctionParamVo adminFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminFunction == null) {
			adminFunction = new AdminFunctionParamVo();
		}
		adminFunction.setTenantId(commonParam.getTenantId());

		PageInfo<AdminFunction> list = (PageInfo<AdminFunction>) this.getBaseService()
				.selectPageByParamVo(adminFunction, commonParam, pageNo, pageSize);
		List<AdminFunctionVo> volist = new ArrayList<AdminFunctionVo>();

		Iterator<AdminFunction> iter = list.getList().iterator();
		AdminFunctionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminFunctionVo> vpage = new Page<AdminFunctionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminFunctionParamVo adminFunctionParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminFunction adminFunction = null;
		if (adminFunctionParamVo.getFunctionCode() == null) {
			resultMessage.addErr("功能编码不能为空");
			return resultMessage;
		}
		if (adminFunctionParamVo.getFunctionName() == null) {
			resultMessage.addErr("功能名称不能为空");
			return resultMessage;
		}
		if (adminFunctionParamVo.getMenuId() == null) {
			resultMessage.addErr("菜单不能为空");
			return resultMessage;
		}
		try {
			if (adminFunctionParamVo.getId() == null) {// 新增

				adminFunctionParamVo.setTenantId(commonParam.getTenantId());
				adminFunction = adminFunctionService.saveOrUpdate(adminFunctionParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminFunction adminFunctionVoTemp = this.selectById(adminFunctionParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminFunctionVoTemp, adminFunctionParamVo);

				adminFunction = adminFunctionService.saveOrUpdate(adminFunctionVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminFunction);
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
