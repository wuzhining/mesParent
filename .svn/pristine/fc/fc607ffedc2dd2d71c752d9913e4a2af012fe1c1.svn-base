package com.techsoft.controller.history;

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
import com.techsoft.client.service.history.ClientHistoryBillStatusAuditService;
import com.techsoft.entity.history.HistoryBillStatusAuditVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.history.HistoryBillStatusAuditParamVo;

@Controller
@RequestMapping("/history/historyBillStatusAudit")
public class HistoryBillStatusAuditController extends BaseController {
	@Autowired
	private ClientHistoryBillStatusAuditService clientHistoryBillStatusAuditService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//单据类型
			List<ConfigDictionary> billTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDicList", billTypeDicList);
			//审核状态
			List<ConfigDictionary> billAuditStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.AUDIT_STATUS.getValue());
			modelAndView.addObject("billAuditStatusList", billAuditStatusList);
		} catch (BusinessException e) {
			e.printStackTrace();
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
		modelAndView.setViewName("history/historyBillStatusAudit-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("history/historyBillStatusAudit-edit");
		HistoryBillStatusAuditVo entity = new HistoryBillStatusAuditVo();
		try {
			if (id != null) {
				entity = clientHistoryBillStatusAuditService.getVoByID(id, this.getCommonParam(request));
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
			HistoryBillStatusAuditParamVo historyBillStatusAuditParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(historyBillStatusAuditParamVo==null){
            	historyBillStatusAuditParamVo = new HistoryBillStatusAuditParamVo();
            }
			pageInfo = clientHistoryBillStatusAuditService.selectPageVoByParamVo(
					historyBillStatusAuditParamVo, this.getCommonParam(request),
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
			HistoryBillStatusAuditParamVo historyBillStatusAuditParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    historyBillStatusAuditParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientHistoryBillStatusAuditService.saveOrUpdate(historyBillStatusAuditParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
