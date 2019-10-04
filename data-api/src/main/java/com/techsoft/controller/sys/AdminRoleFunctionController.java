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
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.sys.ClientAdminFunctionService;
import com.techsoft.client.service.sys.ClientAdminRoleFunctionService;
import com.techsoft.client.service.sys.ClientAdminRoleService;
import com.techsoft.entity.sys.AdminRoleFunctionVo;
import com.techsoft.entity.sys.AdminRoleParamVo;
import com.techsoft.entity.sys.AdminRoleUserParamVo;
import com.techsoft.entity.common.AdminFunction;
import com.techsoft.entity.common.AdminRole;
import com.techsoft.entity.common.AdminRoleFunction;
import com.techsoft.entity.common.AdminRoleUser;
import com.techsoft.entity.sys.AdminFunctionParamVo;
import com.techsoft.entity.sys.AdminRoleFunctionParamVo;

@Controller
@RequestMapping("/sys/adminRoleFunction")
public class AdminRoleFunctionController extends BaseController {
	@Autowired
	private ClientAdminRoleFunctionService clientAdminRoleFunctionService;
	@Autowired
	private ClientAdminRoleService clientAdminRoleService;
	@Autowired
	private ClientAdminFunctionService clientAdminFunctionService;
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
			//获取功能
			AdminFunctionParamVo adminFunctionParamVo = new AdminFunctionParamVo();
			List<AdminFunction> adminFunctionList = clientAdminFunctionService.selectListByParamVo(adminFunctionParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminFunctionList1",adminFunctionList);
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("sys/adminRoleFunction-list");
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
			//获取功能
			AdminFunctionParamVo adminFunctionParamVo = new AdminFunctionParamVo();
			List<AdminFunction> adminFunctionList = clientAdminFunctionService.selectListByParamVo(adminFunctionParamVo, this.getCommonParam(null));
			modelAndView.addObject("adminFunctionList",adminFunctionList);
			AdminRoleFunctionVo entity = new AdminRoleFunctionVo();
			if (id != null) {
				entity = clientAdminRoleFunctionService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("sys/adminRoleFunction-edit");
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
			AdminRoleFunctionParamVo adminRoleFunctionParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(adminRoleFunctionParamVo==null){
            	adminRoleFunctionParamVo = new AdminRoleFunctionParamVo();
            }
			pageInfo = clientAdminRoleFunctionService.selectPageVoByParamVo(
					adminRoleFunctionParamVo, this.getCommonParam(request),
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
			AdminRoleFunctionParamVo adminRoleFunctionParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    adminRoleFunctionParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAdminRoleFunctionService.saveOrUpdate(adminRoleFunctionParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sys/adminRole-details");
		List<AdminRoleFunction> entityList = new ArrayList<AdminRoleFunction>();
		try{
			entityList = clientAdminRoleFunctionService.selectListByParamVo(new AdminRoleFunctionParamVo(), this.getCommonParam(null));
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
				clientAdminRoleFunctionService.deleteById(id, this.getCommonParam(request));
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
		modelAndView.setViewName("sys/adminRole-choiceFunct");
		List<AdminRoleFunction> entityList = new ArrayList<AdminRoleFunction>();
		try{
			entityList	= clientAdminRoleFunctionService.selectListByParamVo(new AdminRoleFunctionParamVo(), this.getCommonParam(request));
		}catch(Exception e){
			e.printStackTrace();
		}
		modelAndView.addObject(entityList);
		initData(modelAndView);
		return modelAndView;
	}

}
