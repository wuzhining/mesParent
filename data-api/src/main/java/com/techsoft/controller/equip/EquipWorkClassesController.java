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
import com.techsoft.client.service.equip.ClientEquipWorkClassesService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.persistence.ZTreeNode;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.EquipWorkClasses;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.equip.EquipWorkClassesParamVo;
import com.techsoft.entity.equip.EquipWorkClassesVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;

@Controller
@RequestMapping("/equip/equipWorkClasses")
public class EquipWorkClassesController extends BaseController {
	@Autowired
	private ClientEquipWorkClassesService clientEquipWorkClassesService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		/*try {
			EquipWorkClassesParamVo EWparamVo = new EquipWorkClassesParamVo();
			List<EquipWorkClasses> EquipWorkList = clientEquipWorkClassesService.selectListByParamVo(EWparamVo,
					this.getCommonParam(null));
			modelAndView.addObject("EquipWorkList", EquipWorkList);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWorkClasses-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			EquipWorkClassesParamVo EWparamVo = new EquipWorkClassesParamVo();
			EWparamVo.setParent(0);
			List<EquipWorkClasses> EquipWorkList = clientEquipWorkClassesService.selectListByParamVo(EWparamVo,
					this.getCommonParam(null));
			modelAndView.addObject("EquipWorkList", EquipWorkList);
			EquipWorkClassesVo entity = new EquipWorkClassesVo();
			if (id != null) {
				entity = clientEquipWorkClassesService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("equip/equipWorkClasses-edit");
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
			EquipWorkClassesParamVo equipWorkClassesParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(equipWorkClassesParamVo==null){
            	equipWorkClassesParamVo = new EquipWorkClassesParamVo();
            }
			pageInfo = clientEquipWorkClassesService.selectPageVoByParamVo(
					equipWorkClassesParamVo, this.getCommonParam(request),
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
			EquipWorkClassesParamVo equipWorkClassesParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    equipWorkClassesParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientEquipWorkClassesService.saveOrUpdate(equipWorkClassesParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	
	
	@ResponseBody
	@RequestMapping("/loadZtree")
	public List<ZTreeNode> loadZtree(HttpServletRequest request,WarehouseAreaParamVo warehouseAreaParamVo, Integer pageIndex) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();
		try {
            List<EquipWorkClasses> itemList= clientEquipWorkClassesService.selectListByParamVo(new EquipWorkClassesParamVo(), this.getCommonParam(request));
            List<EquipWorkClasses> parentItemList= new ArrayList<EquipWorkClasses>();
			for(EquipWorkClasses item : itemList){
				   if(item.getParentId()==0){
					  parentItemList.add(item);
				   }
				}	
				for(EquipWorkClasses item : parentItemList){
					ZTreeNode nodes = new ZTreeNode();
					  
					  List<ZTreeNode> list_sub = new ArrayList<ZTreeNode>();
					  for(EquipWorkClasses item2 : itemList){
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
	
	@RequestMapping("/listEquipWorkClasses")
	public ModelAndView lineProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureInstruct-classes");
		return modelAndView;
	}

}
