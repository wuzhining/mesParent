package com.techsoft.controller.track;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;

@Controller
@RequestMapping("/track/trackBarcode")
public class TrackBarcodeController extends BaseController {
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;

	
	 
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//物品
			List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(new ProductMainParamVo(), this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList); 
			//物料
			List<ProductMaterial> productMateriaList = clientProductMaterialService.selectListByParamVo(new ProductMaterialParamVo(), this.getCommonParam(null));
			modelAndView.addObject("productMateriaList", productMateriaList);
			//条码规则类型
			/*List<ConfigDictionary> BarcodeRuleList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RULE.getValue());
			modelAndView.addObject("BarcodeRuleList", BarcodeRuleList);*/
			//条码状态
			List<ConfigDictionary> barcodeStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BARCODE_STATUS.getValue());
			modelAndView.addObject("barcodeStatusList", barcodeStatusList);
			//单据类型
			List<ConfigDictionary> billTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDicList", billTypeDicList);
			//单据状态
			List<ConfigDictionary> billStatusDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("billStatusDicList", billStatusDicList);
			//合作伙伴
			List<FirmPartner> firmPartnerList = clientFirmPartnerService.selectListByParamVo(new FirmPartnerParamVo(), this.getCommonParam(null));
			modelAndView.addObject("firmPartnerList", firmPartnerList);
			//仓库
			List<StructWarehouse> structWarehouseList = clientStructWarehouseService.selectListByParamVo(new StructWarehouseParamVo(), this.getCommonParam(null));
			modelAndView.addObject("structWarehouseList", structWarehouseList);
		}catch (BusinessException e) {
			e.printStackTrace();	
		} catch (SQLException e) {  
			e.printStackTrace();
		} 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("track/trackBarcode-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("track/trackBarcode-edit");
		TrackBarcodeVo entity = new TrackBarcodeVo();
		try {
			if (id != null) {
				entity = clientTrackBarcodeService.getVoByID(id, this.getCommonParam(request));
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
			TrackBarcodeParamVo trackBarcodeParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(trackBarcodeParamVo==null){
            	trackBarcodeParamVo = new TrackBarcodeParamVo();
            }
			pageInfo = clientTrackBarcodeService.selectPageVoByParamVo(
					trackBarcodeParamVo, this.getCommonParam(request),
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
			TrackBarcodeParamVo trackBarcodeParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    trackBarcodeParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientTrackBarcodeService.saveOrUpdate(trackBarcodeParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	@RequestMapping(value = "/insertPrintBarcode", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage insertBeachTrackBarcode(HttpServletRequest request,
			@RequestBody TrackBarcode[] TrackBarcodes) {
		ResultMessage resultMessage = new ResultMessage();
		List<TrackBarcode> trackBarcodeVoList= new ArrayList<>();
		//批量条码打印记录保存
		for (TrackBarcode trackBarcode : TrackBarcodes) {
			trackBarcode.setCreateUserId(getLoginUserId(request));
			trackBarcode.setModifyUserId(getLoginUserId(request));
			trackBarcodeVoList.add(trackBarcode);
		}
		try {
			 resultMessage = clientTrackBarcodeService.InsertbatchTrackBarcode(trackBarcodeVoList,
					this.getCommonParam(request));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	/**根据到货id 查条码 list
	 * @param request
	 * @param structWarehouseParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listBarcode")
	public List<TrackBarcode> listBarcode(HttpServletRequest request, TrackBarcodeParamVo trackBarcodeParamVo) {
			if (trackBarcodeParamVo == null) {
				trackBarcodeParamVo = new TrackBarcodeParamVo();
			}
			trackBarcodeParamVo.setTenantId(getLoginTenantId(request));
			List<TrackBarcode> list = new ArrayList<TrackBarcode>();
			try {
				list = clientTrackBarcodeService.selectListByParamVo(trackBarcodeParamVo, this.getCommonParam(request));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	
}
