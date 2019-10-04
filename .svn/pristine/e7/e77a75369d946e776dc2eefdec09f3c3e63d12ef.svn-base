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
import com.techsoft.client.service.bill.ClientBillEquipItemService;
import com.techsoft.client.service.bill.ClientBillEquipService;
import com.techsoft.client.service.bill.ClientBillFixtureItemService;
import com.techsoft.client.service.bill.ClientBillFixtureService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.equip.ClientEquipFixtureService;
import com.techsoft.client.service.equip.ClientEquipUseApplyItemService;
import com.techsoft.client.service.equip.ClientEquipWorkService;
import com.techsoft.client.service.firm.ClientFirmDepartmentService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillEquipItemParamVo;
import com.techsoft.entity.bill.BillEquipItemVo;
import com.techsoft.entity.bill.BillEquipParamVo;
import com.techsoft.entity.bill.BillEquipVo;
import com.techsoft.entity.bill.BillFixtureItemParamVo;
import com.techsoft.entity.bill.BillFixtureItemVo;
import com.techsoft.entity.bill.BillFixtureParamVo;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.equip.EquipFixtureParamVo;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;

@Controller
@RequestMapping("/equip/equipWorkRepairItem")
public class EquipWorkRepairItemController extends BaseController {
	@Autowired
	private ClientBillEquipItemService clientBillEquipItemService;
	@Autowired
	private ClientBillEquipService clientBillEquipService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientEquipWorkService clientEquipWorkService;
	private boolean addflag=false;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//拿到单据类型
			List<ConfigDictionary> billTypeEquipDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_TYPE_EQUIP.getValue());
			modelAndView.addObject("billTypeEquipDict", billTypeEquipDict);
			
			//拿到单据状态
			List<ConfigDictionary> billStatusEquipDict = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_STATUS_EQUIP.getValue());
			modelAndView.addObject("billStatusEquipDict", billStatusEquipDict);
			
			//取处理结果集合
			List<ConfigDictionary> dealResultList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.BILL_ITEM_DEAL_RESULT.getValue());
			modelAndView.addObject("dealResultList",dealResultList);
			
			//取设备集合
			EquipWorkParamVo equipWorkParamVo = new EquipWorkParamVo();
			List<EquipWork> equipWorkList = clientEquipWorkService.selectListByParamVo(equipWorkParamVo, this.getCommonParam(null));
			modelAndView.addObject("equipWorkList",equipWorkList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWorkRepairItem-list");
		return modelAndView;
	}
	
	@RequestMapping("/listItem")
	public ModelAndView listItem(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWorkScrapItem-list");
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editItem(HttpServletRequest request, Long id,boolean flag,Long billEquipId) {
		ModelAndView modelAndView = new ModelAndView();
		this.addflag=flag;
		try {
			//取设备单据集合
			BillEquipParamVo billEquipParamVo = new BillEquipParamVo();
			List<BillEquip> billEquipList = clientBillEquipService.selectListByParamVo(billEquipParamVo, this.getCommonParam(null));
			modelAndView.addObject("billEquipList", billEquipList);
			
			BillEquipItemVo entity = new BillEquipItemVo();
			if (flag) {
				BillEquipVo billEquipVo = clientBillEquipService.getVoByID(billEquipId, this.getCommonParam(request));
				modelAndView.addObject("entity", billEquipVo);
			}else if(id!=null){
				entity = clientBillEquipItemService.getVoByID(id, this.getCommonParam(request));
				modelAndView.addObject("entity", entity);
			}
			
			modelAndView.setViewName("equip/equipWorkRepairItem-edit");
			initData(modelAndView);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			BillEquipItemParamVo billEquipItemParamVo , Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(billEquipItemParamVo==null){
            	billEquipItemParamVo = new BillEquipItemParamVo();
            }
			pageInfo = clientBillEquipItemService.selectPageVoByParamVo(
					billEquipItemParamVo, this.getCommonParam(request),
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
			BillEquipItemParamVo billEquipItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
		billEquipItemParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillEquipItemService.saveOrUpdate(billEquipItemParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillEquipItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

}
