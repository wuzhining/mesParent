package com.techsoft.controller.struct;

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
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.entity.struct.StructFactoryVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.struct.StructFactoryParamVo;

@Controller
@RequestMapping("/struct/structFactory")
public class StructFactoryController extends BaseController {
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;

	/**
	 * 页面关联数据初始化
	 * 
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
		List<ConfigDictionary> dictionaryList = clientConfigDictionaryService
				.selectListByParentId(EnumDictionary.STRUCT_FACTORY_TYPE.getValue());
		modelAndView.addObject("dictionaryList", dictionaryList);
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structFactory-list");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			StructFactoryVo entity = new StructFactoryVo();
			if (id != null) {
				entity = clientStructFactoryService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("struct/structFactory-edit");
			initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")
	public ReturnPageInfo listJson(HttpServletRequest request, StructFactoryParamVo structFactoryParamVo,
			Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
			if (structFactoryParamVo == null) {
				structFactoryParamVo = new StructFactoryParamVo();
			}
			pageInfo = clientStructFactoryService.selectPageVoByParamVo(structFactoryParamVo,
					this.getCommonParam(request), pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request, StructFactoryParamVo structFactoryParamVo) {
		ResultMessage resultMessage = new ResultMessage();

		structFactoryParamVo.setModifyUserId(getLoginUserId(request));
		resultMessage = clientStructFactoryService.saveOrUpdate(structFactoryParamVo, this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/structFactoryOpen")
	public ModelAndView openWinFactory(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structFactoryOpen");
		return modelAndView;
	}
}
