package com.techsoft.controller.pda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techsoft.client.service.sys.ClientAdminMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleUserService;
import com.techsoft.client.service.sys.ClientUserPassportService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumSystemType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.AdminMenuParamVo;
import com.techsoft.entity.sys.AdminMenuVo;
import com.techsoft.entity.sys.AdminRoleMenuParamVo;
import com.techsoft.entity.sys.AdminRoleMenuVo;
import com.techsoft.entity.sys.AdminRoleUserParamVo;
import com.techsoft.entity.sys.AdminRoleUserVo;
import com.techsoft.entity.sys.UserPassportAuthorityVo;
import com.techsoft.entity.sys.UserPassportVo;

/**
 * @auther:Chen
 * @version:2019年4月30日上午10:33:10
 * @param:
 * @description pda菜单目录请求controller层
 */
@Controller
@RequestMapping("/pda/pdaMenu")
public class PdaMenuController extends BaseController {
	@Autowired
	private ClientAdminMenuService clientAdminMenuService;
	@Autowired
	private ClientUserPassportService clientUserPassportService;
	@Autowired
	private ClientAdminRoleUserService clientAdminRoleUserService;
	@Autowired
	private ClientAdminRoleMenuService clientAdminRoleMenuService;

	/**
	 * @auther:Zhugh
	 * @version:2019年5月28日
	 * @description:查询pda菜单信息返回json数据格式返回给pda
	 */
	@ResponseBody
	@RequestMapping(value = "/menuList", method = RequestMethod.POST)
	public ResultMessage menuList(HttpServletRequest request, Long pdaId,String factoryId) throws BusinessException {
		ResultMessage resultMessage = new ResultMessage();
		Long userId = getLoginUserId(request);// 1.拿当前登录id
		if (userId == null) {
			return null;
		}
		// UserPassport userPassport=new UserPassport();
		List<Long> menuIds = new ArrayList<>();
		List<AdminMenu> adminMenuList = new ArrayList<>();
		try {
			// userPassport=clientUserPassportService.selectById(userId,
			// this.getCommonParam(request));
			List<AdminRoleMenu> adminRoleMenuVoList = null;
			// if(userPassport!=null){
			AdminRoleUserParamVo adminRoleUserParamVo = new AdminRoleUserParamVo();
			adminRoleUserParamVo.setUserId(userId);
			List<AdminRoleUser> listVoByParamVo = clientAdminRoleUserService.selectListByParamVo(adminRoleUserParamVo,
					this.getCommonParam(request));
			if (listVoByParamVo != null) {
				for (AdminRoleUser adminRoleUserVo : listVoByParamVo) {
					AdminRoleMenuParamVo adminRoleMenuParamVo = new AdminRoleMenuParamVo();
					adminRoleMenuParamVo.setRoleId(adminRoleUserVo.getRoleId());
					adminRoleMenuVoList = clientAdminRoleMenuService.selectListByParamVo(adminRoleMenuParamVo,
							this.getCommonParam(request));
				}
			}
			// }

			AdminMenuParamVo adminMenuParamVo = new AdminMenuParamVo();
			adminMenuParamVo.setSystemTypeDictId(EnumSystemType.SYSTEM_TYPE_PDA.getValue());
			List<AdminMenu> selectListVoByParamVo = clientAdminMenuService.selectListByParamVo(adminMenuParamVo,
					this.getCommonParam(request));
			if (adminRoleMenuVoList != null) {
				for (AdminMenu adminMenu : selectListVoByParamVo) {

					for (AdminRoleMenu adminRoleMenuVo : adminRoleMenuVoList) {
						// menuIds.add(adminRoleMenuVo.getMenuId());
						// AdminMenuParamVo adminMenuParamVo=new
						// AdminMenuParamVo();
						// adminMenuParamVo.setId(adminRoleMenuVo.getMenuId());
						// adminMenuParamVo.setSystemTypeDictId(EnumDictSystemType.SYSTEM_TYPE_PDA.getValue());
						// List<AdminMenu> selectListVoByParamVo =
						// clientAdminMenuService.selectListByParamVo(adminMenuParamVo,
						// this.getCommonParam(request));
						if (adminMenu.getId().equals(adminRoleMenuVo.getMenuId())) {
							adminMenuList.add(adminMenu);
						}
					}
				}

			}
			// for (Long menuId : menuIds) {
			// AdminMenuParamVo adminMenuParamVo=new AdminMenuParamVo();
			// adminMenuParamVo.setId(menuId);
			// adminMenuParamVo.setSystemTypeDictId(EnumDictSystemType.SYSTEM_TYPE_PDA.getValue());
			// List<AdminMenuVo> selectListVoByParamVo =
			// clientAdminMenuService.selectListVoByParamVo(adminMenuParamVo,
			// this.getCommonParam(request));
			// for (AdminMenuVo adminMenuVo : selectListVoByParamVo) {
			// adminMenuList.add(adminMenuVo);
			// }
			// }

			// List<AdminMenuVo> returnList =clientAdminMenuService.get
			if (adminMenuList.size() <= 0) {
				resultMessage.addErr("系统没查到pda菜单信息");
			} else {
				resultMessage.put(adminMenuList);
				resultMessage.setIsSuccess(true);
			}
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}
		return resultMessage;
	}

	/**
	 * @auther:Zhugh
	 * @version:2019年6月6日
	 * @description:查询后台菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public ResultMessage menu(HttpServletRequest request, String userName,String factoryId) {
		ResultMessage resultMessage = new ResultMessage();
		try {

			Long userId = getLoginUserId(request);// 1.拿当前登录id
			if (userId == null) {
				return null;
			}
			UserPassportAuthorityVo userPassportAuthorityVo = getLoginUserPassport(request);
			resultMessage = clientAdminMenuService.adminMenuSystemLists(userId,
					userPassportAuthorityVo.getSystemRoletype(), userName, this.getCommonParam(request));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * @auther:Zhugh
	 * @version:2019年8月21日
	 * @description:pda修改密码返回json数据格式返回给pda
	 */
	@ResponseBody
	@RequestMapping(value = "/usersave", method = RequestMethod.POST)
	public ResultMessage usersave(HttpServletRequest request, UserPassportVo userPassportVo, String oldPassword,
			String newPassword,String password,String factoryId) {
		//System.out.println(newPassword.length());
		ResultMessage resultMessage = new ResultMessage();
		userPassportVo.setCreateUserId(getLoginUserId(request));
		resultMessage = clientUserPassportService.modifiyUserPass(userPassportVo, oldPassword.trim(),
				newPassword.trim(), password.trim(), this.getCommonParam(request));
		return resultMessage;
	}

}