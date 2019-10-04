package com.techsoft.controller.equip;

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
import com.techsoft.client.service.equip.ClientEquipClassesWorkService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.persistence.ZTreeNode;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.entity.equip.EquipClassesWorkParamVo;
import com.techsoft.entity.equip.EquipClassesWorkVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;

@Controller
@RequestMapping("/equip/equipClassesWork")
public class EquipClassesWorkController extends BaseController {
	@Autowired
	private ClientEquipClassesWorkService clientEquipClassesWorkService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipClassesWork-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("equip/equipClassesWork-edit");
		EquipClassesWorkVo entity = new EquipClassesWorkVo();
		try {
			EquipClassesWorkParamVo EWparamVo = new EquipClassesWorkParamVo();
			EWparamVo.setParent(0);
			List<EquipClassesWork> EquipWorkList = clientEquipClassesWorkService.selectListByParamVo(EWparamVo,this.getCommonParam(null));
			modelAndView.addObject("EquipWorkList", EquipWorkList);
			if (id != null) {
				entity = clientEquipClassesWorkService.getVoByID(id, this.getCommonParam(request));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			EquipClassesWorkParamVo equipClassesWorkParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(equipClassesWorkParamVo==null){
            	equipClassesWorkParamVo = new EquipClassesWorkParamVo();
            }
			pageInfo = clientEquipClassesWorkService.selectPageVoByParamVo(
					equipClassesWorkParamVo, this.getCommonParam(request),
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
			EquipClassesWorkParamVo equipClassesWorkParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    equipClassesWorkParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientEquipClassesWorkService.saveOrUpdate(equipClassesWorkParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/loadZtree")
	public List<ZTreeNode> loadZtree(HttpServletRequest request,WarehouseAreaParamVo warehouseAreaParamVo, Integer pageIndex) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();
		try {
            List<EquipClassesWork> itemList= clientEquipClassesWorkService.selectListByParamVo(new EquipClassesWorkParamVo(), this.getCommonParam(request));
            List<EquipClassesWork> parentItemList= new ArrayList<EquipClassesWork>();
			for(EquipClassesWork item : itemList){
				   if(item.getParentId()==0){
					  parentItemList.add(item);
				   }
				}	
				for(EquipClassesWork item : parentItemList){
					ZTreeNode nodes = new ZTreeNode();
					  
					  List<ZTreeNode> list_sub = new ArrayList<ZTreeNode>();
					  for(EquipClassesWork item2 : itemList){
						   if(item2.getParentId().equals(item.getId())){
							  ZTreeNode nodes2 = new ZTreeNode();
							  nodes2.setId(item2.getId());
							  nodes2.setParentId(item2.getParentId());
							  nodes2.setName(item2.getClassesName());
							  nodes2.setOpen(false);
							  list_sub.add(nodes2);

						   } 
						 
					 }
					  nodes.setChildren(list_sub);
					  nodes.setId(item.getId());
					  nodes.setParentId(item.getParentId());
					  nodes.setName(item.getClassesName());
					  nodes.setOpen(false);
					  nodeList.add(nodes);
	  
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  nodeList;
	}
	
	
	@RequestMapping("/listEquipClassesWork")
	public ModelAndView lineProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureInstruct-classes");
		return modelAndView;
	}


}
