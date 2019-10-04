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
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.client.service.sys.ClientAdminAuthOrgUserService;
import com.techsoft.client.service.sys.ClientUserPassportService;
import com.techsoft.entity.sys.AdminAuthOrgUserVo;
import com.techsoft.entity.sys.UserPassportParamVo;
import com.techsoft.entity.common.AdminAuthOrgUser;
import com.techsoft.entity.common.ConfigArea;
import com.techsoft.entity.common.ConfigCountry;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.config.ConfigAreaParamVo;
import com.techsoft.entity.config.ConfigCountryParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;
import com.techsoft.entity.sys.AdminAuthOrgUserParamVo;

@Controller
@RequestMapping("/sys/adminAuthOrgUser")
public class AdminAuthOrgUserController extends BaseController {
	@Autowired
	private ClientAdminAuthOrgUserService clientAdminAuthOrgUserService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientUserPassportService clientUserPassportService;
	@Autowired
	private ClientStructWorkshopService clientStructWorkshopService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
			//取工厂集合
			StructFactoryParamVo factoryVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(factoryVo, null);
			modelAndView.addObject("factoryList", factoryList);
			//取用户集合
			UserPassportParamVo userVo = new UserPassportParamVo();
			List<UserPassport> userList = clientUserPassportService.selectListByParamVo(userVo, null);
			modelAndView.addObject("userList", userList);
			//取仓库集合
			StructWarehouseParamVo warehouseVo = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = clientStructWarehouseService.selectListByParamVo(warehouseVo, null);
			modelAndView.addObject("warehouseList", warehouseList);
			//取车间集合
			StructWorkshopParamVo workshopVo = new StructWorkshopParamVo();
			List<StructWorkshop> workshopList = clientStructWorkshopService.selectListByParamVo(workshopVo, null);
			modelAndView.addObject("workshopList", workshopList);
		      
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
	    modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("sys/adminAuthOrgUser-list");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id,String forward) {
		ModelAndView modelAndView = new ModelAndView();
		if("2".equals(forward)){
			modelAndView.setViewName("sys/adminAuthOrgUser-edits");
		}else{
			modelAndView.setViewName("sys/adminAuthOrgUser-edit");
		}
		AdminAuthOrgUserVo entity = new AdminAuthOrgUserVo();
		try {
			if (id != null) {
				entity = clientAdminAuthOrgUserService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * 根据工厂查询仓库
	 * @param request 包含有factory_id
	 * @param StructWarehouseParamVo 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkByFactory")	
	public List<StructWarehouse> linkByCountry(HttpServletRequest request, StructWarehouseParamVo structWarehouseParamVo) {
			if (structWarehouseParamVo == null) {
				structWarehouseParamVo = new StructWarehouseParamVo();
			}
			
			structWarehouseParamVo.setTenantId(getLoginTenantId(request));
			List<StructWarehouse> StructWarehouseList=null;
			try {
				 StructWarehouseList=clientStructWarehouseService.selectListByParamVo(structWarehouseParamVo,this.getCommonParam(request));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return StructWarehouseList;
	}

	/**
	 * 根据工厂查询车间
	 * @param request 包含有factory_id
	 * @param StructWorkshopParamVo 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkByWarehouse")	
	public List<StructWorkshop> linkByWarehpuse(HttpServletRequest request, StructWorkshopParamVo structWorkshopParamVo) {
			if (structWorkshopParamVo == null) {
				structWorkshopParamVo = new StructWorkshopParamVo();
			}
			
			structWorkshopParamVo.setTenantId(getLoginTenantId(request));
			List<StructWorkshop> StructWorkshopList=null;
			try {
				StructWorkshopList=clientStructWorkshopService.selectListByParamVo(structWorkshopParamVo,this.getCommonParam(request));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return StructWorkshopList;
	}

	
	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			AdminAuthOrgUserParamVo adminAuthOrgUserParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(adminAuthOrgUserParamVo==null){
            	adminAuthOrgUserParamVo = new AdminAuthOrgUserParamVo();
            }
			pageInfo = clientAdminAuthOrgUserService.selectPageVoByParamVo(
					adminAuthOrgUserParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	
	@RequestMapping(value = "/saves", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage saves(HttpServletRequest request,
			AdminAuthOrgUserParamVo adminAuthOrgUserParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
		adminAuthOrgUserParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAdminAuthOrgUserService.saveOrUpdate(adminAuthOrgUserParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			AdminAuthOrgUserParamVo adminAuthOrgUserParamVo,String str,String warehouse,String workshop) throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		List<Long> loginId = new ArrayList<>();
		String[] split = str.split(",");
		for(String string : split){
			loginId.add(Long.parseLong(string));
		}
		
		List<Long> WarehouseId = new ArrayList<>();
		if(warehouse != null){
		String[] split1 = warehouse.split(",");
		for(String string : split1){
			WarehouseId.add(Long.parseLong(string));
		}
		}
		
		List<Long> WorkshopId = new ArrayList<>();
		if(workshop != null){
		String[] split2 = workshop.split(",");
		for(String string : split2){
			WorkshopId.add(Long.parseLong(string));
		}
		}
		//得到用户id
		Long userId =adminAuthOrgUserParamVo.getUserId();
	    adminAuthOrgUserParamVo.setModifyUserId(getLoginUserId(request)); 
	    List<StructFactory> sf = new ArrayList<StructFactory>();
	    List<StructWarehouse> sw = new ArrayList<StructWarehouse>();
	    List<StructWorkshop> sk = new ArrayList<StructWorkshop>();
	    //查询工厂
	    if(loginId.size() >0){
	    sf =  clientStructFactoryService.selectByIds(loginId, this.getCommonParam(request));
	    }
	    if(WarehouseId.size() >0){
	    //查询仓库
	    sw = clientStructWarehouseService.selectByIds(WarehouseId, this.getCommonParam(request));
	    }
	    //查询车间
	    if(WorkshopId .size()>0){
	    sk = clientStructWorkshopService.selectByIds(WorkshopId, this.getCommonParam(request));
	    }
	    List<AdminAuthOrgUser> adminList = new ArrayList<AdminAuthOrgUser>();
	    //当工厂下没有仓库和车间
	    int checkIf = 0;
	    if(sf.size()>0){
	    	for (StructFactory structFactory : sf) {
	    		AdminAuthOrgUserParamVo factoryParam3=new AdminAuthOrgUserParamVo();
	    		if(sw.size()>0){//仓库
	    			for (StructWarehouse structWarehouse : sw) {
	    				checkIf = 0;
	    				AdminAuthOrgUserParamVo factoryParam2=new AdminAuthOrgUserParamVo();
	    				if(sk.size()>0){//车间
	    					for (StructWorkshop structWorkshop : sk) {
	    		    			//当工厂与仓库与车间的工厂id相同的时候
	    						AdminAuthOrgUserParamVo factoryParam=new AdminAuthOrgUserParamVo();
	    						if(structFactory.getId().equals(structWarehouse.getFactoryId()) && structFactory.getId().equals(structWorkshop.getFactoryId())){
	    							factoryParam.setFactoryId(structFactory.getId());
	    		    				factoryParam.setWarehouseId(structWarehouse.getId());
	    		    				factoryParam.setWorkshopId(structWorkshop.getId());
	    		    				checkIf++;
	    						}
	    						if(!factoryParam.toString().equals("{}")){
		    		    			factoryParam.setUserId(userId);
		    		    			adminList.add(factoryParam);
	    						}
	    		    		}
	    					
	    				}else{//车间为空
	    					if(structFactory.getId().equals(structWarehouse.getFactoryId())){
	    						factoryParam2.setFactoryId(structFactory.getId());
	    						factoryParam2.setWarehouseId(structWarehouse.getId());
	    						checkIf++;
	    					}
	    					if(!factoryParam2.toString().equals("{}")){
	    						factoryParam2.setUserId(userId);
				    			adminList.add(factoryParam2);
    						}
	    				}
	    			}
	    			if(sk.size()==0 && checkIf==0){
	    				int num = 0;
	    				for(int i = 0;i < adminList.size();i++){
	    					if(adminList.get(i).getFactoryId().equals(structFactory.getId())){
	    						num++;
	    					}
	    				}
	    				if(num==0){
	    					factoryParam3.setUserId(userId);
		    				 factoryParam3.setFactoryId(structFactory.getId());
		    				 adminList.add(factoryParam3);
	    				}
	    			}
	    		}else{//仓库为空，车间不为空
	    			if(sk.size()>0){
	    				for(StructWorkshop structWorkshop : sk){
	    					checkIf = 0;
	    					AdminAuthOrgUserParamVo factoryParam4=new AdminAuthOrgUserParamVo();
	    					if(structFactory.getId().equals(structWorkshop.getFactoryId())){
				    			factoryParam4.setFactoryId(structFactory.getId());
				    			factoryParam4.setWorkshopId(structWorkshop.getId());
				    			checkIf++;
	    					}
	    					if(!factoryParam4.toString().equals("{}")){
	    						factoryParam4.setUserId(userId);
				    			adminList.add(factoryParam4);
    						}
	    				}
	    				if(sw.size()==0 && checkIf==0){
	    					int num = 0;
		    				for(int i = 0;i < adminList.size();i++){
		    					if(adminList.get(i).getFactoryId().equals(structFactory.getId())){
		    						num++;
		    					}
		    				}
		    				if(num==0){
		    					factoryParam3.setUserId(userId);
			    				 factoryParam3.setFactoryId(structFactory.getId());
			    				 adminList.add(factoryParam3);
		    				}
	    				}
	    			}else{//仓库为空,车间为空
	    				factoryParam3.setUserId(userId);
	    				factoryParam3.setFactoryId(structFactory.getId());
	    				adminList.add(factoryParam3);
	    			}
	    		}
	    		if(sw.size()>0 && sk.size()>0){
	    			if(checkIf <= 0){
	    				int num = 0;
	    				for(int i = 0;i<adminList.size();i++){
	    					if(adminList.get(i).getFactoryId().equals(structFactory.getId())){
	    						num++;
	    					}
	    				}
	    				if(num==0){
	    					AdminAuthOrgUserParamVo factoryParam=new AdminAuthOrgUserParamVo();
	    					factoryParam.setUserId(userId);
	    					factoryParam.setFactoryId(structFactory.getId());
	    					adminList.add(factoryParam);
	    				}
	    			}
	    		}
	    }
	    	
	}else{
		resultMessage.addErr("工厂不能为空");
		return resultMessage;
	}
	    resultMessage = clientAdminAuthOrgUserService.bathinsertAuthOrgsUser(adminList, this.getCommonParam(request));
		return resultMessage;
}

	
	//查询工厂
	@RequestMapping(value = "/factory", method = RequestMethod.POST)
	@ResponseBody
	public List<StructFactory> queryFactory(HttpServletRequest request,
			StructFactoryParamVo factoryVo) {
		List<StructFactory> list=new ArrayList<>();
		if(factoryVo == null){
			factoryVo = new StructFactoryParamVo();
		}
		 
		try {
			 list = clientStructFactoryService.selectListByParamVo(factoryVo, null);
		} catch (SQLException e) {
			
		}
		return list;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id){
		ResultMessage resultMessage = new ResultMessage();
		try {
		if(id != null){
				clientAdminAuthOrgUserService.deleteById(id, this.getCommonParam(request));
				resultMessage.setIsSuccess(true);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
