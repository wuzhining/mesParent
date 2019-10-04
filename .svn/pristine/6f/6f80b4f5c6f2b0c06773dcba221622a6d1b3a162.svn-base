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
import com.techsoft.client.service.bill.ClientBillFixtureService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.struct.ClientStructWorkstationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillFixtureParamVo;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.struct.StructWorkstationParamVo;

@Controller
@RequestMapping("/equip/equipUseApply")
public class EquipUseApplyController extends BaseController {
	@Autowired
	private ClientBillFixtureService clientBillFixtureService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientFirmDepartmentService clientFirmDepartmentService;
	@Autowired
	private ClientStructWorkstationService clientStructWorkstationService;
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
			
			//拿到单据类型
			List<ConfigDictionary> billTypeFixtureDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE_FIXTURE.getValue());
			modelAndView.addObject("billTypeFixtureDict1", billTypeFixtureDict);
			
			//拿到单据状态
			List<ConfigDictionary> billStatusFixtureDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_STATUS_FIXTURE.getValue());
			modelAndView.addObject("billStatusFixtureDict1", billStatusFixtureDict);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipUseApply-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取部门集合
			FirmDepartmentParamVo ParamVowarehosue = new FirmDepartmentParamVo();
			List<FirmDepartment> DepartmentList = clientFirmDepartmentService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("DepartmentList", DepartmentList);
			
			//取工站集合
			StructWorkstationParamVo ParamVoWorkstation = new StructWorkstationParamVo();
			List<StructWorkstation> WorkstationList = clientStructWorkstationService.selectListByParamVo(ParamVoWorkstation,this.getCommonParam(null));
			modelAndView.addObject("WorkstationList", WorkstationList);
			
			//拿到单据类型
			ConfigDictionary billTypeFixtureDict = clientConfigDictionaryService
					.selectById(10423L, this.getCommonParam(null));
			modelAndView.addObject("billTypeFixtureDict", billTypeFixtureDict);
			
			//拿到单据状态
			ConfigDictionary billStatusFixtureDict = clientConfigDictionaryService
					.selectById(10431L, this.getCommonParam(null));
			modelAndView.addObject("billStatusFixtureDict", billStatusFixtureDict);
			
			BillFixtureVo entity = new BillFixtureVo();
			if (id != null) {
				entity = clientBillFixtureService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("equip/equipUseApply-edit");
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
			BillFixtureParamVo billFixtureParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(billFixtureParamVo==null){
            	billFixtureParamVo = new BillFixtureParamVo();
            }
			pageInfo = clientBillFixtureService.selectPageVoByParamVo(
					billFixtureParamVo, this.getCommonParam(request),
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
			BillFixtureParamVo billFixtureParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billFixtureParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillFixtureService.saveOrUpdate(billFixtureParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

}
