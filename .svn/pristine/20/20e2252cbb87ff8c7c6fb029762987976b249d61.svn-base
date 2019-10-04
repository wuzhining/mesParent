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
import com.techsoft.client.service.equip.ClientEquipFixtureService;
import com.techsoft.client.service.track.ClientTrackFixtureService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.equip.EquipFixtureParamVo;
import com.techsoft.entity.track.TrackFixtureParamVo;
import com.techsoft.entity.track.TrackFixtureVo;

@Controller
@RequestMapping("/track/trackFixture")
public class TrackFixtureController extends BaseController {
	@Autowired
	private ClientTrackFixtureService clientTrackFixtureService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientEquipFixtureService clientEquipFixtureService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//拿到单据类型
			List<ConfigDictionary> billTypeFixtureDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE_FIXTURE.getValue());
			modelAndView.addObject("billTypeFixtureList", billTypeFixtureDict);
			//取状态集合
			List<ConfigDictionary> trackStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.FIXTURE_STATUS.getValue());
			modelAndView.addObject("trackStatusList", trackStatusList);
			//工具名称
			EquipFixtureParamVo EquipVo=new EquipFixtureParamVo();
			List<EquipFixture> equipFixtureList = clientEquipFixtureService.selectListByParamVo(EquipVo, this.getCommonParam(null));
			modelAndView.addObject("equipFixtureList", equipFixtureList);
		} catch (BusinessException | SQLException e) {
			
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("track/trackFixture-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//拿到单据类型
			List<ConfigDictionary> billTypeFixtureDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE_FIXTURE.getValue());
			modelAndView.addObject("billTypeFixtureList", billTypeFixtureDict);
			//取状态集合
			List<ConfigDictionary> trackStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.FIXTURE_STATUS.getValue());
			modelAndView.addObject("trackStatusList", trackStatusList);
			TrackFixtureVo entity = new TrackFixtureVo();
			if (id != null) {
				entity = clientTrackFixtureService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("track/trackFixture-edit");
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
			TrackFixtureParamVo trackFixtureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(trackFixtureParamVo==null){
            	trackFixtureParamVo = new TrackFixtureParamVo();
            }
			pageInfo = clientTrackFixtureService.selectPageVoByParamVo(
					trackFixtureParamVo, this.getCommonParam(request),
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
			TrackFixtureParamVo trackFixtureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    trackFixtureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientTrackFixtureService.saveOrUpdate(trackFixtureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
