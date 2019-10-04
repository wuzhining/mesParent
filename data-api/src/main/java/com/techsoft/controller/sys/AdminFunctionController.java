package com.techsoft.controller.sys;

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
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.sys.ClientAdminFunctionService;
import com.techsoft.client.service.sys.ClientAdminMenuService;
import com.techsoft.entity.sys.AdminFunctionVo;
import com.techsoft.entity.sys.AdminMenuParamVo;
import com.techsoft.entity.common.AdminMenu;
import com.techsoft.entity.sys.AdminFunctionParamVo;

@Controller
@RequestMapping("/sys/adminFunction")
public class AdminFunctionController extends BaseController {
	@Autowired
	private ClientAdminFunctionService clientAdminFunctionService;
	@Autowired
	private ClientAdminMenuService clientAdminMenuService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			//取菜单集合
			AdminMenuParamVo  ParamVo = new AdminMenuParamVo();
			List<AdminMenu> menuList = clientAdminMenuService.selectListByParamVo(ParamVo, this.getCommonParam(null));
			modelAndView.addObject("menuList", menuList); 
		}catch(SQLException e){
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("sys/adminFunction-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取菜单集合
			AdminMenuParamVo  ParamVo = new AdminMenuParamVo();
			List<AdminMenu> adminMenu = clientAdminMenuService.selectListByParamVo(ParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminMenu", adminMenu); 
			AdminFunctionVo entity = new AdminFunctionVo();
			AdminMenu adminMenu2 = new AdminMenu();
			if (id != null) {
				entity = clientAdminFunctionService.getVoByID(id, this.getCommonParam(request));
				if(entity.getMenuId() != null && entity.getMenuId()> 0L){
					adminMenu2 = clientAdminMenuService.getVoByID(entity.getMenuId(), this.getCommonParam(request));
				}
			}
			modelAndView.addObject("entity", entity);
			modelAndView.addObject("adminMenu2", adminMenu2);
			modelAndView.setViewName("sys/adminFunction-edit");
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
			AdminFunctionParamVo adminFunctionParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(adminFunctionParamVo==null){
            	adminFunctionParamVo = new AdminFunctionParamVo();
            }
			pageInfo = clientAdminFunctionService.selectPageVoByParamVo(
					adminFunctionParamVo, this.getCommonParam(request),
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
			AdminFunctionParamVo adminFunctionParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    adminFunctionParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAdminFunctionService.saveOrUpdate(adminFunctionParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
