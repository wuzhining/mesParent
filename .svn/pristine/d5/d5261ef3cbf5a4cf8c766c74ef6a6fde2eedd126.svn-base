package com.techsoft.controller.firm;

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
import com.techsoft.client.service.firm.ClientFirmPostService;
import com.techsoft.entity.firm.FirmPostVo;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.firm.FirmPostParamVo;

@Controller
@RequestMapping("/firm/firmPost")
public class FirmPostController extends BaseController {
	@Autowired
	private ClientFirmPostService clientFirmPostService;
	
	@Autowired
	private ClientFirmDepartmentService clientFirmDepartmentService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			FirmDepartmentParamVo firmDepartmentParamVo = new FirmDepartmentParamVo();
			List<FirmDepartment> firmDepartment = clientFirmDepartmentService.selectListByParamVo(firmDepartmentParamVo, this.getCommonParam(null));
			modelAndView.addObject("firmDepartment",firmDepartment);
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
		modelAndView.setViewName("firm/firmPost-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取上级岗位集合
			FirmPostParamVo FPPVo = new FirmPostParamVo();
			FPPVo.setParent(0);
			List<FirmPost> firmPost = clientFirmPostService.selectListByParamVo(FPPVo, this.getCommonParam(null));
			modelAndView.addObject("firmPost", firmPost);
			FirmPostVo entity = new FirmPostVo();
			if (id != null) {
				entity = clientFirmPostService.getVoByID(id, this.getCommonParam(request));
				FirmDepartment department = clientFirmDepartmentService.getVoByID(entity.getDepartmenId(), this.getCommonParam(null));
				modelAndView.addObject("department", department);
			}
			
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("firm/firmPost-edit");
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
			FirmPostParamVo firmPostParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(firmPostParamVo==null){
            	firmPostParamVo = new FirmPostParamVo();
            }
			pageInfo = clientFirmPostService.selectPageVoByParamVo(
					firmPostParamVo, this.getCommonParam(request),
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
			FirmPostParamVo firmPostParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    firmPostParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientFirmPostService.saveOrUpdate(firmPostParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping("/firmPostOpen")
	public ModelAndView firmPostOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("firm/firmPost-Open");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/loadZtree")
	public List<ZTreeNode> loadZtree(HttpServletRequest request) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();
		try {
            List<FirmPost> itemList= clientFirmPostService.selectListByParamVo(new FirmPostParamVo(), this.getCommonParam(request));
            List<FirmPost> parentItemList= new ArrayList<FirmPost>();
			for(FirmPost item : itemList){
				   if(item.getParentId()==0){
					  parentItemList.add(item);
				   }
				}	
				for(FirmPost item : parentItemList){
					ZTreeNode nodes = new ZTreeNode();
					  
					  List<ZTreeNode> list_sub = new ArrayList<ZTreeNode>();
					  for(FirmPost item2 : itemList){
						   if(item2.getParentId().equals(item.getId())){
							  ZTreeNode nodes2 = new ZTreeNode();
							  nodes2.setId(item2.getId());
							  nodes2.setParentId(item2.getParentId());
							  nodes2.setName(item2.getPostName());
							  nodes2.setOpen(false);
							  list_sub.add(nodes2);

						   } 
						 
					 }
					  nodes.setChildren(list_sub);
					  nodes.setId(item.getId());
					  nodes.setParentId(item.getParentId());
					  nodes.setName(item.getPostName());
					  nodes.setOpen(false);
					  nodeList.add(nodes);
	  
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  nodeList;
	}

}
