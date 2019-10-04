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
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.bill.ClientBillPurchaseService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.entity.bill.BillPurchaseVo;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;

@Controller
@RequestMapping("/bill/billPurchase")
public class BillPurchaseController extends BaseController {
	@Autowired
	private ClientBillPurchaseService clientBillPurchaseService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取供应商集合
			FirmPartnerParamVo firmPartnerParamVo = new FirmPartnerParamVo();
			firmPartnerParamVo.setPartnerTypeDictId(10313L);
			List<FirmPartner> firmPartnerList = clientFirmPartnerService.selectListByParamVo(firmPartnerParamVo,this.getCommonParam(null));
			modelAndView.addObject("firmPartnerList", firmPartnerList);
			//单据状态数据字典
			List<ConfigDictionary> billPurchaseStatusList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("billPurchaseStatusList",billPurchaseStatusList);
			//审核状态数据字典
			List<ConfigDictionary> auditStatusDictList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.AUDIT_STATUS.getValue());
			modelAndView.addObject("auditStatusDictList",auditStatusDictList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/audit")
	public ModelAndView audit(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billPurchase-audit");
		return modelAndView;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billPurchase-list");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billPurchase-edit");
		BillPurchaseVo entity = new BillPurchaseVo();
		try {
			if (id != null) {
				entity = clientBillPurchaseService.getVoByID(id, this.getCommonParam(request));
				FirmPartner firmPartner = clientFirmPartnerService.getVoByID(entity.getSupplierId(), this.getCommonParam(request));
				modelAndView.addObject("firmPartner", firmPartner);
			}
			modelAndView.addObject("entity", entity);
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
			BillPurchaseParamVo billPurchaseParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billPurchaseParamVo==null){
            	billPurchaseParamVo = new BillPurchaseParamVo();
            }
			pageInfo = clientBillPurchaseService.selectPageVoByParamVo(
					billPurchaseParamVo, this.getCommonParam(request),
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
			BillPurchaseParamVo billPurchaseParamVo,String SP) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billPurchaseParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillPurchaseService.saveOrUpdate(billPurchaseParamVo,
				this.getCommonParam(request),SP);
		return resultMessage;
	}

	
	@RequestMapping("/lookOver")
	public ModelAndView lookOver(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billPurchase-lookover");
		BillPurchaseVo entity = new BillPurchaseVo();
		try {
			if (id != null) {
				entity = clientBillPurchaseService.getVoByID(id, this.getCommonParam(request));
				FirmPartner firmPartner = clientFirmPartnerService.getVoByID(entity.getSupplierId(), this.getCommonParam(request));
				modelAndView.addObject("firmPartner", firmPartner);
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}


}
