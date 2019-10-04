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
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.struct.ClientStructProductionlineService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;

@Controller
@RequestMapping("/bill/billWarehouseSupplier")
public class BillWarehouseSupplierController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientBillPurchaseService clientBillPurchaseService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
		
		//取源单据类型集合
		List<ConfigDictionary> fromBillTypeDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
		modelAndView.addObject("fromBillTypeDictIdList", fromBillTypeDictIdList);
		
		//取供应商集合
		FirmPartnerParamVo firmPartnerParamVo = new FirmPartnerParamVo();
		List<FirmPartner> firmPartner = clientFirmPartnerService.selectListByParamVo(firmPartnerParamVo,this.getCommonParam(null));
		List<FirmPartner> firmPartner3 = new ArrayList<FirmPartner>();
		for (FirmPartner firmPartner2 : firmPartner) {
			if (firmPartner2.getPartnerTypeDictId() == 10313) {//得到供应商
				firmPartner3.add(firmPartner2);
			}
		}
		modelAndView.addObject("firmPartner", firmPartner3);
		
		//取采购单集合
		BillPurchaseParamVo billPurchaseParamVo = new BillPurchaseParamVo();
		List<BillPurchase> billPurchaseList = clientBillPurchaseService.selectListByParamVo(billPurchaseParamVo,this.getCommonParam(null));
		modelAndView.addObject("billPurchaseList", billPurchaseList);
		
		} catch (SQLException e) {  
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouseSupplier-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouseSupplier-edit");
		BillWarehouseVo entity = new BillWarehouseVo();
		try {
			if (id != null) {
				entity = clientBillWarehouseService.getVoByID(id, this.getCommonParam(request));
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
			BillWarehouseParamVo billWarehouseParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billWarehouseParamVo==null){
            	billWarehouseParamVo = new BillWarehouseParamVo();
            }
			pageInfo = clientBillWarehouseService.selectPageVoByParamVo(
					billWarehouseParamVo, this.getCommonParam(request),
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
			BillWarehouseParamVo billWarehouseParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billWarehouseParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillWarehouseService.saveOrUpdate(billWarehouseParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping(value = "/arrivalCheck", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage arrivalCheck(HttpServletRequest request,
			BillWarehouseVo billWarehouseVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billWarehouseVo.setModifyUserId(getLoginUserId(request)); 
	    billWarehouseVo.setBillStatusDictId((long) 10490);
		resultMessage = clientBillWarehouseService.billCheck(billWarehouseVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
