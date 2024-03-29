package com.techsoft.client.service.sys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumSystemType;
import com.techsoft.common.enums.EnumUserSystemRoletype;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.sys.AdminMenuVo;
import com.techsoft.entity.sys.AdminRoleMenuParamVo;
import com.techsoft.entity.sys.AdminRoleMenuVo;
import com.techsoft.entity.sys.AdminRoleUserParamVo;
import com.techsoft.entity.sys.AdminRoleUserVo;
import com.techsoft.entity.sys.AdminMenuParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.sys.AdminMenuService;
import com.techsoft.service.sys.AdminRoleMenuService;
import com.techsoft.service.sys.AdminRoleUserService;

@org.springframework.stereotype.Service
public class ClientAdminMenuServiceImpl extends BaseClientServiceImpl<AdminMenu> implements ClientAdminMenuService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminMenuService adminMenuService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleMenuService adminRoleMenuService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AdminRoleUserService adminRoleUserService;

	@com.alibaba.dubbo.config.annotation.Reference
	@Override
	public BaseService<AdminMenu> getBaseService() {
		return adminMenuService;
	}

	private AdminMenuVo getVo(AdminMenu adminMenu, CommonParam commonParam) throws BusinessException, SQLException {
		AdminMenuVo vo = new AdminMenuVo(adminMenu);
		if (vo.getParentId() != null && vo.getParentId() > 0L) {
			AdminMenu adminMenu1 = adminMenuService.selectById(vo.getParentId(), commonParam);
			if (adminMenu1 != null) {
				vo.setAdminMenu(adminMenu1);
			}
		}
		if (vo.getSystemTypeDictId() != null && vo.getSystemTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getSystemTypeDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		return vo;
	}

	private AdminMenuVo getExtendVo(AdminMenu adminMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		AdminMenuVo vo = this.getVo(adminMenu, commonParam);

		return vo;
	}

	private List<AdminMenuVo> getVoList(List<AdminMenu> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminMenuVo> voList = new ArrayList<AdminMenuVo>();
		for (AdminMenu entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AdminMenuVo> getExtendVoList(List<AdminMenu> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AdminMenuVo> voList = new ArrayList<AdminMenuVo>();
		for (AdminMenu entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AdminMenuVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminMenu entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AdminMenuVo> selectListVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminMenu == null) {
			adminMenu = new AdminMenuParamVo();
		}
		adminMenu.setTenantId(commonParam.getTenantId());

		List<AdminMenu> list = (List<AdminMenu>) this.getBaseService().selectListByParamVo(adminMenu, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminMenuVo> selectPageVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (adminMenu == null) {
			adminMenu = new AdminMenuParamVo();
		}
		adminMenu.setTenantId(commonParam.getTenantId());

		PageInfo<AdminMenu> list = (PageInfo<AdminMenu>) this.getBaseService().selectPageByParamVo(adminMenu,
				commonParam, pageNo, pageSize);
		List<AdminMenuVo> volist = new ArrayList<AdminMenuVo>();

		Iterator<AdminMenu> iter = list.getList().iterator();
		AdminMenuVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminMenuVo> vpage = new Page<AdminMenuVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AdminMenuVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AdminMenu entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AdminMenuVo> selectListExtendVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (adminMenu == null) {
			adminMenu = new AdminMenuParamVo();
		}
		adminMenu.setTenantId(commonParam.getTenantId());

		List<AdminMenu> list = (List<AdminMenu>) this.getBaseService().selectListByParamVo(adminMenu, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AdminMenuVo> selectPageExtendVoByParamVo(AdminMenuParamVo adminMenu, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (adminMenu == null) {
			adminMenu = new AdminMenuParamVo();
		}
		adminMenu.setTenantId(commonParam.getTenantId());

		PageInfo<AdminMenu> list = (PageInfo<AdminMenu>) this.getBaseService().selectPageByParamVo(adminMenu,
				commonParam, pageNo, pageSize);
		List<AdminMenuVo> volist = new ArrayList<AdminMenuVo>();

		Iterator<AdminMenu> iter = list.getList().iterator();
		AdminMenuVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AdminMenuVo> vpage = new Page<AdminMenuVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AdminMenuParamVo adminMenuParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AdminMenu adminMenu = null;
		try {
			if (adminMenuParamVo.getId() == null) {// 新增

				adminMenuParamVo.setTenantId(commonParam.getTenantId());
				adminMenu = adminMenuService.saveOrUpdate(adminMenuParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AdminMenu adminMenuVoTemp = this.selectById(adminMenuParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(adminMenuVoTemp, adminMenuParamVo);

				adminMenu = adminMenuService.saveOrUpdate(adminMenuVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(adminMenu);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	/**
	 * 根据用户查询后台菜单菜单
	 */

	public ResultMessage adminMenuSystemLists(Long userId, String systemRoletype, String userName,
			CommonParam commonParam) throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		List<Long> menuIds = new ArrayList<>();
		try {
			if (userId != null) {
				AdminRoleUserParamVo adminRoleUserParamVo = new AdminRoleUserParamVo();
				adminRoleUserParamVo.setUserId(userId);
				// 2.根据用户Id查询用户角色的角色id

				List<AdminRoleUser> listVoByParam = adminRoleUserService.selectListByParamVo(adminRoleUserParamVo,
						commonParam);
				if (listVoByParam != null) {
					for (AdminRoleUser adminRoleUser : listVoByParam) {
						AdminRoleMenuParamVo adminRoleMenuParamVo = new AdminRoleMenuParamVo();
						adminRoleMenuParamVo.setRoleId(adminRoleUser.getRoleId());
						// 3.根据角色id查角色菜单的菜单id
						List<AdminRoleMenu> adminRoleMenuList = adminRoleMenuService
								.selectListByParamVo(adminRoleMenuParamVo, commonParam);
						if (adminRoleMenuList != null) {
							for (AdminRoleMenu adminRoleMenu : adminRoleMenuList) {
								menuIds.add(adminRoleMenu.getMenuId());
							}
						}
					}
				}
			}

			if (!EnumUserSystemRoletype.TENANT.getValue().equals(systemRoletype)) {
				List<AdminMenu> adminMenuSystemLists = new ArrayList<>();
				List<AdminMenu> adminMenuPdaLists = new ArrayList<>();
				if (menuIds.size() > 0) {
					List<AdminMenu> selectByIds = adminMenuService.selectByIds(menuIds, commonParam);
					for (AdminMenu adminMenu : selectByIds) {
						if (EnumSystemType.SYSYTEM_TYPE_WEB.getValue().equals(adminMenu.getSystemTypeDictId())
								&& EnumYesOrNo.YES.getValue().equals(adminMenu.getIsValid())) {
							adminMenuSystemLists.add(adminMenu);
						} else {
							adminMenuPdaLists.add(adminMenu);
						}
					}
				}
				if (userName != null && userName != "") {
					if (adminMenuPdaLists.size() <= 0) {
						resultMessage.addErr("系统没查到pda菜单信息");
					} else {
						resultMessage.put(adminMenuPdaLists);
						resultMessage.setIsSuccess(true);
					}

				} else {
					if (adminMenuSystemLists.size() <= 0) {
						resultMessage.addErr("系统没查到后台菜单信息");
					} else {
						resultMessage.put(adminMenuSystemLists);
						resultMessage.setIsSuccess(true);
					}

				}
			} else {
				AdminMenuParamVo adminMenuParamVo = new AdminMenuParamVo();
				adminMenuParamVo.setIsValid(EnumYesOrNo.YES.getValue());
				adminMenuParamVo.setSystemTypeDictId(EnumSystemType.SYSYTEM_TYPE_WEB.getValue()); 
				List<AdminMenu> adminMenuSystemLists = adminMenuService.selectListByParamVo(adminMenuParamVo, commonParam);
				resultMessage.put(adminMenuSystemLists);
				resultMessage.setIsSuccess(true);
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}
}
