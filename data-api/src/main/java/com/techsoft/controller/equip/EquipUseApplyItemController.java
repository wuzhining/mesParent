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
import com.techsoft.client.service.bill.ClientBillFixtureItemService;
import com.techsoft.client.service.bill.ClientBillFixtureService;
import com.techsoft.client.service.equip.ClientEquipFixtureService;
import com.techsoft.client.service.equip.ClientEquipUseApplyItemService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillFixtureItemParamVo;
import com.techsoft.entity.bill.BillFixtureItemVo;
import com.techsoft.entity.bill.BillFixtureParamVo;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.equip.EquipFixtureParamVo;
import com.techsoft.entity.firm.FirmDepartmentParamVo;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;

@Controller
@RequestMapping("/equip/equipUseApplyItem")
public class EquipUseApplyItemController extends BaseController {
	@Autowired
	private ClientEquipUseApplyItemService clientBillFixtureItemService;
	@Autowired
	private  ClientEquipFixtureService clientEquipFixtureService;
	@Autowired
	private  ClientBillFixtureService clientBillFixtureService;
	private boolean addflag=false;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工具集合
			EquipFixtureParamVo ParamVoEquipFixture = new EquipFixtureParamVo();
			List<EquipFixture> EquipFixtureList = clientEquipFixtureService.selectListByParamVo(ParamVoEquipFixture,this.getCommonParam(null));
			modelAndView.addObject("EquipFixtureList1", EquipFixtureList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipUseApplyItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id,boolean flag,Long billFixtureId) {
		ModelAndView modelAndView = new ModelAndView();
		this.addflag=flag;
		try {
			//取工具单据集合
			BillFixtureParamVo BillFixtureParamVo = new BillFixtureParamVo();
			List<BillFixture> billFixtureList =clientBillFixtureService.selectListByParamVo(BillFixtureParamVo, this.getCommonParam(null));
			modelAndView.addObject("billFixtureList", billFixtureList);
			//取工具集合
			EquipFixtureParamVo ParamVoEquipFixture = new EquipFixtureParamVo();
			List<EquipFixture> EquipFixtureList = clientEquipFixtureService.selectListByParamVo(ParamVoEquipFixture,this.getCommonParam(null));
			modelAndView.addObject("EquipFixtureList", EquipFixtureList);
			
			BillFixtureItemVo entity = new BillFixtureItemVo();
			if (flag) {
				BillFixtureVo billFixtureVo = clientBillFixtureService.getVoByID(billFixtureId, this.getCommonParam(request));
				modelAndView.addObject("entity", billFixtureVo);
			}else if(id!=null){
				entity = clientBillFixtureItemService.getVoByID(id, this.getCommonParam(request));
				modelAndView.addObject("entity", entity);
			}
			modelAndView.setViewName("equip/equipUseApplyItem-edit");
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
			BillFixtureItemParamVo billFixtureItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(billFixtureItemParamVo==null){
            	billFixtureItemParamVo = new BillFixtureItemParamVo();
            }
			pageInfo = clientBillFixtureItemService.selectPageVoByParamVo(
					billFixtureItemParamVo, this.getCommonParam(request),
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
			BillFixtureItemParamVo billFixtureItemParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    billFixtureItemParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientBillFixtureItemService.saveOrUpdate(billFixtureItemParamVo,
				this.getCommonParam(request),this.addflag);

		return resultMessage;
	}
	
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (id != null) {
				clientBillFixtureItemService.deleteById(id, this.getCommonParam(request));
			    resultMessage.setIsSuccess(true);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
}
