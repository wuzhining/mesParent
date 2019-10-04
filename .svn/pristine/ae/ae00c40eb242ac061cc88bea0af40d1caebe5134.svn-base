package com.techsoft.controller.bill;

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
import com.techsoft.common.persistence.ZTreeNode;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.entity.firm.FirmDepartmentVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.firm.FirmDepartmentParamVo;

@Controller
@RequestMapping("/bill/processingTechnic")
public class ProcessingTechnicController extends BaseController {
	@Autowired
	private ClientFirmDepartmentService clientFirmDepartmentService;
	
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList); 
		} catch (SQLException e) {
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
		modelAndView.setViewName("bill/processingTechnic-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取上级部门集合
			FirmDepartmentParamVo depaParamVo = new FirmDepartmentParamVo();
			depaParamVo.setParent(0);
			List<FirmDepartment> department = clientFirmDepartmentService.selectListByParamVo(depaParamVo, this.getCommonParam(null));
			modelAndView.addObject("department", department);
			
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			FirmDepartmentVo entity = new FirmDepartmentVo();
			if (id != null) {
				entity = clientFirmDepartmentService.getVoByID(id, this.getCommonParam(request));
			}
		
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("firm/firmDepartment-edit");
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
			FirmDepartmentParamVo firmDepartmentParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(firmDepartmentParamVo==null){
            	firmDepartmentParamVo = new FirmDepartmentParamVo();
            }
			pageInfo = clientFirmDepartmentService.selectPageVoByParamVo(
					firmDepartmentParamVo, this.getCommonParam(request),
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
			FirmDepartmentParamVo firmDepartmentParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    firmDepartmentParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientFirmDepartmentService.saveOrUpdate(firmDepartmentParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@ResponseBody
	@RequestMapping("/loadZtree")
	public List<ZTreeNode> loadZtree(HttpServletRequest request,WarehouseAreaParamVo warehouseAreaParamVo, Integer pageIndex) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();
		try {
            List<FirmDepartment> itemList= clientFirmDepartmentService.selectListByParamVo(new FirmDepartmentParamVo(), this.getCommonParam(request));
            List<FirmDepartment> parentItemList= new ArrayList<FirmDepartment>();
			for(FirmDepartment item : itemList){
				   if(item.getParentId()==0){
					  parentItemList.add(item);
				   }
				}	
				for(FirmDepartment item : parentItemList){
					ZTreeNode nodes = new ZTreeNode();
					  
					  List<ZTreeNode> list_sub = new ArrayList<ZTreeNode>();
					  for(FirmDepartment item2 : itemList){
						   if(item2.getParentId().equals(item.getId())){
							  ZTreeNode nodes2 = new ZTreeNode();
							  nodes2.setId(item2.getId());
							  nodes2.setParentId(item2.getParentId());
							  nodes2.setName(item2.getDepartmentName());
							  nodes2.setOpen(false);
							  list_sub.add(nodes2);

						   } 
						 
					 }
					  nodes.setChildren(list_sub);
					  nodes.setId(item.getId());
					  nodes.setParentId(item.getParentId());
					  nodes.setName(item.getDepartmentName());
					  nodes.setOpen(false);
					  nodeList.add(nodes);
	  
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  nodeList;
	}

}
