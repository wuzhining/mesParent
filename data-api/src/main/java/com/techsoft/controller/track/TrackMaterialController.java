package com.techsoft.controller.track;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.track.ClientTrackMaterialService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.track.TrackMaterialParamVo;
import com.techsoft.entity.track.TrackMaterialVo;

@Controller
@RequestMapping("/track/trackMaterial")
public class TrackMaterialController extends BaseController {
	@Autowired
	private ClientTrackMaterialService clientTrackMaterialService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(new ProductMainParamVo(), this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList); 
			
			List<ProductMaterial> productMateriaList = clientProductMaterialService.selectListByParamVo(new ProductMaterialParamVo(), this.getCommonParam(null));
			modelAndView.addObject("productMateriaList", productMateriaList);
			//单据类型
			List<ConfigDictionary> billTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDicList", billTypeDicList);
			//单据状态
			List<ConfigDictionary> billStatusDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_STATUS.getValue());
			modelAndView.addObject("billStatusDicList", billStatusDicList);
			//仓库
			List<StructWarehouse> structWarehouseList = clientStructWarehouseService.selectListByParamVo(new StructWarehouseParamVo(), this.getCommonParam(null));
			modelAndView.addObject("structWarehouseList", structWarehouseList);
		} catch (SQLException | BusinessException e) {  
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("track/trackMaterial-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("track/trackMaterial-edit");
		TrackMaterialVo entity = new TrackMaterialVo();
		try {
			if (id != null) {
				entity = clientTrackMaterialService.getVoByID(id, this.getCommonParam(request));
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
			TrackMaterialParamVo trackMaterialParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(trackMaterialParamVo==null){
            	trackMaterialParamVo = new TrackMaterialParamVo();
            }
			pageInfo = clientTrackMaterialService.selectPageVoByParamVo(
					trackMaterialParamVo, this.getCommonParam(request),
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
			TrackMaterialParamVo trackMaterialParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    trackMaterialParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientTrackMaterialService.saveOrUpdate(trackMaterialParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
