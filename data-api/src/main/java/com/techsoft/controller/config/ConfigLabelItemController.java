package com.techsoft.controller.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigLabelFieldService;
import com.techsoft.client.service.config.ClientConfigLabelItemService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigLabelField;
import com.techsoft.entity.common.ConfigLabelItem;
import com.techsoft.entity.config.ConfigLabelFieldParamVo;
import com.techsoft.entity.config.ConfigLabelItemParamVo;
import com.techsoft.entity.config.ConfigLabelItemVo;

@Controller
@RequestMapping("/config/configLabelItem")
public class ConfigLabelItemController extends BaseController {
	@Autowired
	private ClientConfigLabelItemService clientConfigLabelItemService;
	@Autowired
	private ClientConfigLabelFieldService clientConfigLabelFieldService;
	
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
		modelAndView.setViewName("config/configLabelItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabelItem-edit");
		ConfigLabelItemVo entity = new ConfigLabelItemVo();
		try {
			//获取标签字段
			ConfigLabelFieldParamVo configLabelFieldParamVo = new ConfigLabelFieldParamVo();
			List<ConfigLabelField> configLabelFieldList = clientConfigLabelFieldService.selectListByParamVo(configLabelFieldParamVo, this.getCommonParam(null));
			modelAndView.addObject("configLabelFieldList",configLabelFieldList);
			if (id != null) {
				entity = clientConfigLabelItemService.getVoByID(id, this.getCommonParam(request));
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
			ConfigLabelItemParamVo configLabelItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(configLabelItemParamVo==null){
            	configLabelItemParamVo = new ConfigLabelItemParamVo();
            }
			pageInfo = clientConfigLabelItemService.selectPageVoByParamVo(
					configLabelItemParamVo, this.getCommonParam(request),
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
	public ResultMessage save(HttpServletRequest request,ConfigLabelItemParamVo configLabelItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
			    configLabelItemParamVo.setModifyUserId(getLoginUserId(request)); 
				resultMessage = clientConfigLabelItemService.saveOrUpdate(configLabelItemParamVo,this.getCommonParam(request));
		return resultMessage;
	}
	
	
	
	@RequestMapping(value = "/saveDetail", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage saveDetail(HttpServletRequest request,ConfigLabelItemParamVo configLabelItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
       boolean fal = true;
		try {
			
	        ConfigLabelItemParamVo	tempConfigLabelItemParamVo = new ConfigLabelItemParamVo();
			List<ConfigLabelItemVo> list;
			tempConfigLabelItemParamVo.setLabelId(configLabelItemParamVo.getLabelId());
			 list = clientConfigLabelItemService.selectListVoByParamVo(tempConfigLabelItemParamVo, this.getCommonParam(request));
			
			if (configLabelItemParamVo.getId() == null) {//新增
			     int maxIndex =0;//定义最大值为该数组的第一个数
			     for (int i = 0; i < list.size(); i++) {
			            if(maxIndex < list.get(i).getSortNo()){
			                maxIndex = list.get(i).getSortNo();
			            }
			        }
			     configLabelItemParamVo.setSortNo(maxIndex+1);
		   }else{
			     for (int i = 0; i < list.size(); i++) {
			            if(configLabelItemParamVo.getSortNo() == list.get(i).getSortNo()){
			            	resultMessage.setMessage("排序号不能重复,请重新输入！");
			            	fal=false;
			            	break; 
			            }
			        } 
		   }
			if (fal) {
				configLabelItemParamVo.setModifyUserId(getLoginUserId(request)); 
				resultMessage = clientConfigLabelItemService.saveOrUpdate(configLabelItemParamVo,this.getCommonParam(request));
			}
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientConfigLabelItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	

	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/configLabel-detail");
		List<ConfigLabelField> configLabelFieldList =new ArrayList<ConfigLabelField>();
		try {
			configLabelFieldList = clientConfigLabelFieldService.selectListByParamVo(new ConfigLabelFieldParamVo(), this.getCommonParam(request));
		} catch (Exception e) {                            
			e.printStackTrace();
		}
		modelAndView.addObject("configLabelFieldList",configLabelFieldList);
		initData(modelAndView);
		return modelAndView;
	}

}
