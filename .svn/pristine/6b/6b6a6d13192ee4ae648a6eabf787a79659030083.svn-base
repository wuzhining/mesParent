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

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.utils.JsonUtils;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.bill.ClientBillDeliveryService;
import com.techsoft.client.service.bill.ClientBillWarehouseService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.struct.ClientStructProductionlineService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.bill.BillDeliveryParamVo;
import com.techsoft.entity.bill.BillPurchaseVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;

@Controller
@RequestMapping("/bill/billWarehouse")
public class BillWarehouseController extends BaseController {
	@Autowired
	private ClientBillWarehouseService clientBillWarehouseService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientStructProductionlineService clientStructProductionlineService;
	@Autowired
	private ClientFirmDepartmentService clientFirmDepartmentServiceService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientBillDeliveryService clientBillDeliveryService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try{
		//取单据类型集合
		List<ConfigDictionary> billTypeDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
		modelAndView.addObject("billTypeDictIdList", billTypeDictIdList);
		
		//取单据状态集合
		List<ConfigDictionary> billStatusDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
		modelAndView.addObject("billStatusDictIdList", billStatusDictIdList);
		
		//取源单据类型集合
		List<ConfigDictionary> fromBillTypeDictIdList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
		modelAndView.addObject("fromBillTypeDictIdList", fromBillTypeDictIdList);
		
		//取源仓库集合
		StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
		List<StructWarehouse> fromWarehouseIdList = clientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
		modelAndView.addObject("fromWarehouseIdList", fromWarehouseIdList);
		
		//取目标仓库集合
		StructWarehouseParamVo ParamVoTowarehosue = new StructWarehouseParamVo();
		List<StructWarehouse> toWarehouseIdList = clientStructWarehouseService.selectListByParamVo(ParamVoTowarehosue,this.getCommonParam(null));
		modelAndView.addObject("toWarehouseIdList", toWarehouseIdList);
		
		//取源产线集合
		StructProductionlineParamVo ParamVoStructProductionline = new StructProductionlineParamVo();
		List<StructProductionline> fromProductionlineIdList = clientStructProductionlineService.selectListByParamVo(ParamVoStructProductionline,this.getCommonParam(null));
		modelAndView.addObject("fromProductionlineIdList", fromProductionlineIdList);
		
		//取目标产线集合
		StructProductionlineParamVo ParamVoToStructProductionline = new StructProductionlineParamVo();
		List<StructProductionline> toProductionlineIdList = clientStructProductionlineService.selectListByParamVo(ParamVoToStructProductionline,this.getCommonParam(null));
		modelAndView.addObject("toProductionlineIdList", toProductionlineIdList);
		
		//取部门集合
		FirmDepartmentParamVo ParamVoFirmDepartmentParamVo = new FirmDepartmentParamVo();
		List<FirmDepartment> departmentIdList = clientFirmDepartmentServiceService.selectListByParamVo(ParamVoFirmDepartmentParamVo,this.getCommonParam(null));
		modelAndView.addObject("departmentIdList", departmentIdList);
				
		//取合作伙伴集合
		FirmPartnerParamVo ParamVoFirmPartner = new FirmPartnerParamVo();
		List<FirmPartner> partnerIdList = clientFirmPartnerService.selectListByParamVo(ParamVoFirmPartner,this.getCommonParam(null));
		modelAndView.addObject("partnerIdList", partnerIdList);
		
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
		modelAndView.setViewName("bill/billWarehouse-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouse-edit");
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
	    billWarehouseParamVo.setBillTypeDictId(EnumBillType.BILL_TYPE_WAREHOUSE_ARRIVAL.getValue());
		resultMessage = clientBillWarehouseService.saveOrUpdate(billWarehouseParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:38:22
	*@param request
	*@param billWarehouseVo 单据对象
	*@return resultMessage  结果集
	*@description  来料单审核生成质检单
	*/
	@RequestMapping("/sync")
	public ModelAndView choiceWorkOrder(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouseSyncSupDelivery-choiceSupDelivery");
		return modelAndView;
	}
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:46:47
	*@param request
	*@param billWarehouseParamVo
	*@param pageIndex
	*@return
	*@description   加载退货单数据
	*/
	@ResponseBody
	@RequestMapping("/getDeliveryBill/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo getWorkOrderBomJson(HttpServletRequest request,BillDeliveryParamVo billDeliveryParamVo, Integer pageIndex) {
		PageInfo pageInfo = null;
		try {
		if(billDeliveryParamVo==null){
			billDeliveryParamVo = new BillDeliveryParamVo();
        }
		billDeliveryParamVo.setBillStatusDictId(EnumBillStatus.DOING.getValue());
			pageInfo = clientBillDeliveryService.selectPageVoByParamVo(
					billDeliveryParamVo, this.getCommonParam(request),
					pageIndex, Constants.SEARCH_PAGE_SIZE);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}
	
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:38:22
	*@param request
	*@param billWarehouseVo 单据对象
	*@return resultMessage  结果集
	*@description  来料单审核生成质检单
	*/
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
	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:38:22
	*@param request
	*@param billWarehouseVo 单据对象
	*@return resultMessage  结果集
	*@description  来料单审核生成质检单
	*/
	@RequestMapping(value = "/Check", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage Check(HttpServletRequest request,
			BillWarehouseVo billWarehouseVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billWarehouseVo.setModifyUserId(getLoginUserId(request)); 
	    billWarehouseVo.setBillStatusDictId(EnumBillStatus.DOING.getValue());
		resultMessage = clientBillWarehouseService.printCheck(billWarehouseVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping(value = "/deliverySave", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage deliverySave(HttpServletRequest request,
			BillDelivery billDelivery) {
		ResultMessage resultMessage = new ResultMessage();
		String item=request.getParameter("array");
		String factoryId=request.getParameter("factoryId");
		if (item == null) {
			resultMessage.setMessage("请选择一行数据");
			return resultMessage;
		}
		if (factoryId == null) {
			resultMessage.setMessage("请选择工厂");
			return resultMessage;
		}
		List<BillDelivery> list = JsonUtils.conversionToList(item, BillDelivery.class);
		System.err.println(list);
	    
		resultMessage = clientBillWarehouseService.deliverySave(list,Long.parseLong(factoryId),this.getCommonParam(request));
		return resultMessage;
	}
	

	@RequestMapping("/audit")
	public ModelAndView audit(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("bill/billWarehouse-audit");
		return modelAndView;
	}
	
	@RequestMapping("/lookOver")
	public ModelAndView lookOver(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bill/billWarehouse-lookover");
		BillWarehouseVo entity = new BillWarehouseVo();
		try {
			if (id != null) {
				entity = clientBillWarehouseService.getVoByID(id, this.getCommonParam(request));
				//FirmPartner firmPartner = clientFirmPartnerService.getVoByID(entity.getDepartmentId(), this.getCommonParam(request));
				//modelAndView.addObject("firmPartner", firmPartner);
			}
			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
