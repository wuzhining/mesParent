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
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.bill.ClientBillWorkorderService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.utils.JsonUtils;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.bill.BillWorkorderParamVo;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;

@Controller
@RequestMapping("/bill/billWarehouseWorkOrderReturn")
public class BillWarehouseWorkOrderReturnController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientBillWorkorderService clientBillWorkorderService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取单据状态集合
			List<ConfigDictionary> billStatusDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("billStatusDictIdList", billStatusDictIdList);
			
			//源单据类型
			List<ConfigDictionary> fromBillTypeList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("fromBillTypeList", fromBillTypeList);
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
		modelAndView.setViewName("bill/billWarehouseWorkOrderReturn-list");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouseWorkOrderReturn-details");
		return modelAndView;
	}
	
	@RequestMapping("/choicegetWorkOrder")
	public ModelAndView choiceWorkOrder(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouseWorkOrderReturn-choiceWorkOrder");
		return modelAndView;
	}
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:55:41
	*@param request
	*@param billPurchaseItemParamVo
	*@param pageIndex
	*@return
	*@description  加载采购明细信息
	*/
	@ResponseBody
	@RequestMapping("/getWorkOrder/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo getgetWorkOrderJson(HttpServletRequest request,BillWorkorderParamVo billWorkorderParamVo, Integer pageIndex) {
		PageInfo pageInfo = null;
		try {
		if(billWorkorderParamVo==null){
			billWorkorderParamVo = new BillWorkorderParamVo();
        }
			pageInfo = clientBillWorkorderService.selectPageVoByParamVo(
					billWorkorderParamVo, this.getCommonParam(request),
					pageIndex, Constants.SEARCH_PAGE_SIZE);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouse-edit");
		BillWarehouseVo entity = new BillWarehouseVo();
		try {
			if (id != null) {
				entity = clientBillWarehouseService.getVoByID(id,this.getCommonParam(request));
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
	
	@RequestMapping(value = "/batchSave", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage batchSave(HttpServletRequest request,
			BillWarehouseVo billWarehouseVo,BillWorkorder billWorkorder) {
		ResultMessage resultMessage = new ResultMessage();
		
		String item=request.getParameter("array");
		List<BillWorkorder> list = JsonUtils.conversionToList(item, BillWorkorder.class);
		System.err.println(list);
	    
		resultMessage = clientBillWarehouseService.workerReturnSava(list,this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping("/lookOver")
	public ModelAndView lookOver(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouseWorkReturn-lookover");
		BillWarehouseVo entity = new BillWarehouseVo();
		try {
			if (id != null) {
				entity = clientBillWarehouseService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

}
