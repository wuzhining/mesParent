package com.techsoft.controller.bill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.bill.ClientBillSaleorderService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillPurchaseVo;
import com.techsoft.entity.bill.BillSaleorderParamVo;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.firm.FirmPartnerParamVo;

@Controller
@RequestMapping("/bill/billSaleorder")
public class BillSaleorderController extends BaseController {
	@Autowired
	private ClientBillSaleorderService clientBillSaleorderService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		FirmPartnerParamVo firmPartnerParamVo = new FirmPartnerParamVo();
		firmPartnerParamVo.setPartnerTypeDictId(10311L);
		try {
			//客户公司
			List<FirmPartner> firmPartner = clientFirmPartnerService.selectListByParamVo(firmPartnerParamVo,this.getCommonParam(null));
			modelAndView.addObject("firmPartner",firmPartner);
			//销售单状态数据字典
			List<ConfigDictionary> saleorderStatusList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("saleorderStatusList",saleorderStatusList);
			//审核状态数据字典
			List<ConfigDictionary> auditStatusDictList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.AUDIT_STATUS.getValue());
			modelAndView.addObject("auditStatusDictList",auditStatusDictList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billSaleorder-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billSaleorder-edit");
		BillSaleorderVo entity = new BillSaleorderVo();
		try {
			if (id != null) {
				entity = clientBillSaleorderService.getVoByID(id, this.getCommonParam(request));
				FirmPartner customer = clientFirmPartnerService.getVoByID(entity.getCustomerId(), this.getCommonParam(request));
				modelAndView.addObject("customer", customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/audit")
	public ModelAndView audit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billSaleorder-audit");
		BillSaleorderVo entity = new BillSaleorderVo();
		try {
			if (id != null) {
				entity = clientBillSaleorderService.getVoByID(id, this.getCommonParam(request));
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
			BillSaleorderParamVo billSaleorderParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billSaleorderParamVo==null){
            	billSaleorderParamVo = new BillSaleorderParamVo();
            }
			pageInfo = clientBillSaleorderService.selectPageVoByParamVo(
					billSaleorderParamVo, this.getCommonParam(request),
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
			BillSaleorderParamVo billSaleorderParamVo,String SP) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billSaleorderParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillSaleorderService.saveOrUpdate(billSaleorderParamVo,
				this.getCommonParam(request),SP);
		return resultMessage;
	}
	
	/**
	 * 
	 *@auther :Yang
	 *@version :2019年8月16日
	 *@param
	 *@return
	 *@description 查看
	 */
	@RequestMapping("/lookOver")
	public ModelAndView lookOver(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billSaleorder-lookover");
		BillSaleorderVo entity = new BillSaleorderVo();
		try {
			if (id != null) {
				entity = clientBillSaleorderService.getVoByID(id, this.getCommonParam(request));
				FirmPartner customer = clientFirmPartnerService.getVoByID(entity.getCustomerId(), this.getCommonParam(request));
				modelAndView.addObject("customer", customer);
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}


}
