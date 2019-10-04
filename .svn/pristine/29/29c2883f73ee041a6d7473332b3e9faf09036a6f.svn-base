package com.techsoft.controller.equip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.bill.ClientBillEquipService;
import com.techsoft.client.service.bill.ClientBillFixtureService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.equip.ClientEquipWorkService;
import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.client.service.struct.ClientStructWorkstationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillEquipParamVo;
import com.techsoft.entity.bill.BillEquipVo;
import com.techsoft.entity.bill.BillFixtureParamVo;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;
import com.techsoft.entity.struct.StructWorkstationParamVo;

@Controller
@RequestMapping("/equip/equipWorkRepair")
public class EquipWorkRepairController extends BaseController {
	@Autowired
	private ClientBillEquipService clientBillEquipService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientFirmDepartmentService clientFirmDepartmentService;
	@Autowired
	private ClientStructWorkshopService clientStructWorkshopService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取部门集合
			FirmDepartmentParamVo ParamVowarehosue = new FirmDepartmentParamVo();
			List<FirmDepartment> DepartmentList = clientFirmDepartmentService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("DepartmentList", DepartmentList);
			
			//取车间集合
			StructWorkshopParamVo structWorkshopParamVo = new StructWorkshopParamVo();
			List<StructWorkshop> structWorkshopList = clientStructWorkshopService.selectListByParamVo(structWorkshopParamVo,this.getCommonParam(null));
			modelAndView.addObject("structWorkshopList", structWorkshopList);
			
			//拿到单据类型
			List<ConfigDictionary> billTypeEquipDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE_EQUIP.getValue());
			modelAndView.addObject("billTypeEquipDict", billTypeEquipDict);
			
			//拿到单据状态
			List<ConfigDictionary> billStatusEquipDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_STATUS_EQUIP.getValue());
			modelAndView.addObject("billStatusEquipDict", billStatusEquipDict);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWorkRepair-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//拿到维修单据类型
			ConfigDictionary billTypeFixtureDict = clientConfigDictionaryService
					.selectById(10424L, this.getCommonParam(null));
			
			modelAndView.addObject("billTypeFixtureDict", billTypeFixtureDict);
			
			//拿到维修单据状态
			ConfigDictionary billStatusFixtureDict = clientConfigDictionaryService
					.selectById(10437L, this.getCommonParam(null));
			modelAndView.addObject("billStatusFixtureDict", billStatusFixtureDict);
			
			BillEquipVo entity = new BillEquipVo();
			if (id != null) {
				entity = clientBillEquipService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("equip/equipProductUseApply-edit");
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
			BillEquipParamVo billEquipParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billEquipParamVo==null){
            	billEquipParamVo = new BillEquipParamVo();
            }
			pageInfo = clientBillEquipService.selectPageVoByParamVo(
					billEquipParamVo, this.getCommonParam(request),
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
			BillEquipParamVo billEquipParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
		billEquipParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillEquipService.saveOrUpdate(billEquipParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

}
