package com.techsoft.controller.track;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.track.ClientTrackPackboxService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.track.TrackPackboxParamVo;
import com.techsoft.entity.track.TrackPackboxVo;

@Controller
@RequestMapping("/track/trackPackbox")
public class TrackPackboxController extends BaseController {
	@Autowired
	private ClientTrackPackboxService clientTrackPackboxService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//拿到单据类型
			List<ConfigDictionary> billTypeFixtureDict;
			billTypeFixtureDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeFixtureList", billTypeFixtureDict);
			//取状态集合
			List<ConfigDictionary> trackStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.PACKBOX_STATUS_DICT.getValue());
			modelAndView.addObject("trackStatusList", trackStatusList);
			//取物品集合
			ProductMainParamVo productVo= new ProductMainParamVo();
			List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(productVo, this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList);
		} catch (BusinessException | SQLException e) {
			
			e.printStackTrace();
		}
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("track/trackPackbox-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("track/trackPackbox-edit");
		TrackPackboxVo entity = new TrackPackboxVo();
		try {
			if (id != null) {
				entity = clientTrackPackboxService.getVoByID(id, this.getCommonParam(request));
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
			TrackPackboxParamVo trackPackboxParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(trackPackboxParamVo==null){
            	trackPackboxParamVo = new TrackPackboxParamVo();
            }
			pageInfo = clientTrackPackboxService.selectPageVoByParamVo(
					trackPackboxParamVo, this.getCommonParam(request),
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
			TrackPackboxParamVo trackPackboxParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    trackPackboxParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientTrackPackboxService.saveOrUpdate(trackPackboxParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
