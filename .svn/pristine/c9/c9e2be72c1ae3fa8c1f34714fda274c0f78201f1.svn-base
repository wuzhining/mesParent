package com.techsoft.controller.sys;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.sys.ClientAdminMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleMenuService;
import com.techsoft.client.service.sys.ClientAdminRoleService;
import com.techsoft.entity.sys.AdminRoleMenuVo;
import com.techsoft.entity.sys.AdminRoleParamVo;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleFunction;
import com.techsoft.entity.common.AdminRoleMenu;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.sys.AdminMenuParamVo;
import com.techsoft.entity.sys.AdminRoleFunctionParamVo;
import com.techsoft.entity.sys.AdminRoleMenuParamVo;

@Controller
@RequestMapping("/sys/adminRoleMenu")
public class AdminRoleMenuController extends BaseController {
	@Autowired
	private ClientAdminRoleMenuService clientAdminRoleMenuService;
	@Autowired
	private ClientAdminRoleService clientAdminRoleService;
	@Autowired
	private ClientAdminMenuService clientAdminMenuService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			//获取角色
			AdminRoleParamVo adminRoleParamVo = new AdminRoleParamVo();
			List<AdminRole> adminRoleList = clientAdminRoleService.selectListByParamVo(adminRoleParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminRoleList1", adminRoleList);
			//获取菜单
			AdminMenuParamVo  adminMenuParamVo = new AdminMenuParamVo();
			List<AdminMenu> adminMenuList = clientAdminMenuService.selectListByParamVo(adminMenuParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminMenuList1",adminMenuList);
			//获取系统类型id
			List<ConfigDictionary> dictionaryList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.SYSTEM_TYPE.getValue());
			modelAndView.addObject("dictionaryList",dictionaryList);
		}catch(Exception e){
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("sys/adminRoleMenu-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//获取角色
			AdminRoleParamVo adminRoleParamVo = new AdminRoleParamVo();
			List<AdminRole> adminRoleList = clientAdminRoleService.selectListByParamVo(adminRoleParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminRoleList", adminRoleList);
			//获取菜单
			AdminMenuParamVo  adminMenuParamVo = new AdminMenuParamVo();
			List<AdminMenu> adminMenuList = clientAdminMenuService.selectListByParamVo(adminMenuParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminMenuList",adminMenuList);
			AdminRoleMenuVo entity = new AdminRoleMenuVo();
			if (id != null) {
				entity = clientAdminRoleMenuService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("sys/adminRoleMenu-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			AdminRoleMenuParamVo adminRoleMenuParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(adminRoleMenuParamVo==null){
            	adminRoleMenuParamVo = new AdminRoleMenuParamVo();
            }
			pageInfo = clientAdminRoleMenuService.selectPageVoByParamVo(
					adminRoleMenuParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			AdminRoleMenuParamVo adminRoleMenuParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    adminRoleMenuParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAdminRoleMenuService.saveOrUpdate(adminRoleMenuParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/details")
   public ModelAndView details(HttpServletRequest request){
	   ModelAndView modelAndView = new ModelAndView();
	   modelAndView.setViewName("sys/adminMenu-details");
	   List<AdminRoleMenu> entityList = new ArrayList<AdminRoleMenu>();
	   try{
		   entityList = clientAdminRoleMenuService.selectListByParamVo(new AdminRoleMenuParamVo(), this.getCommonParam(null));
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   modelAndView.addObject(entityList);
	   initData(modelAndView);
	   return modelAndView;
   }
	

	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try{
			if(id != null){
				clientAdminRoleMenuService.deleteById(id, this.getCommonParam(request));
				resultMessage.setIsSuccess(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultMessage;
	}

	
	@RequestMapping("/choiceFunct")
	public ModelAndView choiceFunct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sys/adminMenu-choiceFunct");
		  List<AdminRoleMenu> entityList = new ArrayList<AdminRoleMenu>();
		try{
			entityList	= clientAdminRoleMenuService.selectListByParamVo(new AdminRoleMenuParamVo(), this.getCommonParam(request));
		}catch(Exception e){
			e.printStackTrace();
		}
		modelAndView.addObject(entityList);
		initData(modelAndView);
		return modelAndView;
	}

}
