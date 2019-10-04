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
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleFunction;
import com.techsoft.entity.sys.AdminRoleFunctionVo;
import com.techsoft.entity.sys.AdminRoleFunctionParamVo;
import com.techsoft.service.sys.AdminFunctionService;
import com.techsoft.service.sys.AdminRoleFunctionService;
import com.techsoft.service.sys.AdminRoleService;

@org.springframework.stereotype.Service
public class ClientAdminRoleFunctionServiceImpl extends BaseClientServiceImpl<AdminRoleFunction>
		implements ClientAdminRoleFunctionService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleFunctionService adminRoleFunctionService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleService adminRoleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminFunctionService adminFunctionService;

	@Override
	public BaseService<AdminRoleFunction> getBaseService() {
		return adminRoleFunctionService;
	}

	private AdminRoleFunctionVo getVo(AdminRoleFunction adminRoleFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleFunctionVo vo = new AdminRoleFunctionVo(adminRoleFunction);
		if (vo.getRoleId() != null && vo.getRoleId() > 0L) {
			AdminRole adminRole = adminRoleService.selectById(vo.getRoleId(), commonParam);
			if (adminRole != null) {
				vo.setAdminRole(adminRole);
			}
		}
		if (vo.getFunctionId() != null && vo.getFunctionId() > 0L) {
			AdminFunction adminFunction = adminFunctionService.selectById(vo.getFunctionId(), commonParam);
			if (adminFunction != null) {
				vo.setAdminFunction(adminFunction);
			}
		}

		return vo;
	}

	private AdminRoleFunctionVo getExtendVo(AdminRoleFunction adminRoleFunction, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleFunctionVo vo = this.getVo(adminRoleFunction, commonParam);

		return vo;
	}

	private List<AdminRoleFunctionVo> getVoList(List<AdminRoleFunction> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleFunctionVo> voList = new ArrayList<AdminRoleFunctionVo>();
		for (AdminRoleFunction entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminRoleFunctionVo> getExtendVoList(List<AdminRoleFunction> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminRoleFunctionVo> voList = new ArrayList<AdminRoleFunctionVo>();
		for (AdminRoleFunction entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminRoleFunctionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminRoleFunction entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminRoleFunctionVo> selectListVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (adminRoleFunction == null) {
			adminRoleFunction = new AdminRoleFunctionParamVo();
		}
		adminRoleFunction.setTenantId(commonParam.getTenantId());

		List<AdminRoleFunction> list = (List<AdminRoleFunction>) this.getBaseService()
				.selectListByParamVo(adminRoleFunction, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleFunctionVo> selectPageVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleFunction == null) {
			adminRoleFunction = new AdminRoleFunctionParamVo();
		}
		adminRoleFunction.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleFunction> list = (PageInfo<AdminRoleFunction>) this.getBaseService()
				.selectPageByParamVo(adminRoleFunction, commonParam, pageNo, pageSize);
		List<AdminRoleFunctionVo> volist = new ArrayList<AdminRoleFunctionVo>();

		Iterator<AdminRoleFunction> iter = list.getList().iterator();
		AdminRoleFunctionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleFunctionVo> vpage = new Page<AdminRoleFunctionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminRoleFunctionVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminRoleFunction entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminRoleFunctionVo> selectListExtendVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (adminRoleFunction == null) {
			adminRoleFunction = new AdminRoleFunctionParamVo();
		}
		adminRoleFunction.setTenantId(commonParam.getTenantId());

		List<AdminRoleFunction> list = (List<AdminRoleFunction>) this.getBaseService()
				.selectListByParamVo(adminRoleFunction, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminRoleFunctionVo> selectPageExtendVoByParamVo(AdminRoleFunctionParamVo adminRoleFunction,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminRoleFunction == null) {
			adminRoleFunction = new AdminRoleFunctionParamVo();
		}
		adminRoleFunction.setTenantId(commonParam.getTenantId());

		PageInfo<AdminRoleFunction> list = (PageInfo<AdminRoleFunction>) this.getBaseService()
				.selectPageByParamVo(adminRoleFunction, commonParam, pageNo, pageSize);
		List<AdminRoleFunctionVo> volist = new ArrayList<AdminRoleFunctionVo>();

		Iterator<AdminRoleFunction> iter = list.getList().iterator();
		AdminRoleFunctionVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminRoleFunctionVo> vpage = new Page<AdminRoleFunctionVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminRoleFunctionParamVo adminRoleFunctionParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminRoleFunction adminRoleFunction = null;
		try {
			if (adminRoleFunctionParamVo.getId() == null) {// 新增

				adminRoleFunctionParamVo.setTenantId(commonParam.getTenantId());
				adminRoleFunction = adminRoleFunctionService.saveOrUpdate(adminRoleFunctionParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminRoleFunction adminRoleFunctionVoTemp = this.selectById(adminRoleFunctionParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(adminRoleFunctionVoTemp, adminRoleFunctionParamVo);

				adminRoleFunction = adminRoleFunctionService.saveOrUpdate(adminRoleFunctionVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminRoleFunction);
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
