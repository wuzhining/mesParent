package com.techsoft.controller.struct;

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
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructFloorService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.entity.struct.StructWarehouseVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.firm.FirmPostParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructFloorParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;

@Controller
@RequestMapping("/struct/structWarehouse")
public class StructWarehouseController extends BaseController {
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructFloorService clientStructFloorService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取仓库类型集合
			List<ConfigDictionary> warehouseDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.STRUCT_WAREHOUSE_TYPE.getValue());
			modelAndView.addObject("warehouseDicList", warehouseDicList);
			//取物品类型集合
			 List<ConfigDictionary> producDictList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.PRODUCT_TYPE.getValue());
			 modelAndView.addObject("producDictList", producDictList);
			//取工厂集合
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			//取楼层集合
			 StructFloorParamVo floorparamVo = new StructFloorParamVo();
			 List<StructFloor> floorList = clientStructFloorService.selectListByParamVo(floorparamVo,this.getCommonParam(null));
			 modelAndView.addObject("floorList", floorList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWarehouse-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("struct/structWarehouse-edit");
			StructWarehouseVo entity = new StructWarehouseVo();
			if (id != null) {
				entity = clientStructWarehouseService.getVoByID(id, this.getCommonParam(request));
				//取楼层集合
				StructFloor structFloor = clientStructFloorService.getVoByID(entity.getFloorId(),this.getCommonParam(null));
				modelAndView.addObject("structFloor", structFloor);
				//取工厂层集合
				StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(),this.getCommonParam(null));
				modelAndView.addObject("structFactory", structFactory);
			}

			modelAndView.addObject("entity", entity);
			initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			StructWarehouseParamVo structWarehouseParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structWarehouseParamVo==null){
            	structWarehouseParamVo = new StructWarehouseParamVo();
            }
			pageInfo = clientStructWarehouseService.selectPageVoByParamVo(
					structWarehouseParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	/**根据工厂查仓库list creater:Chenzj
	 * @param request
	 * @param structWarehouseParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/linkWarehouseByFactory")
	public List<StructWarehouse> floorLink(HttpServletRequest request, StructWarehouseParamVo structWarehosueParamVo) {
			if (structWarehosueParamVo == null) {
				structWarehosueParamVo = new StructWarehouseParamVo();
			}
			structWarehosueParamVo.setTenantId(getLoginTenantId(request));
			List<StructWarehouse> warehouseList = new ArrayList<StructWarehouse>();
			try {
				warehouseList = clientStructWarehouseService.selectListByParamVo(structWarehosueParamVo, this.getCommonParam(request));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return warehouseList;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			StructWarehouseParamVo structWarehouseParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structWarehouseParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructWarehouseService.saveOrUpdate(structWarehouseParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/structWarehouseOpen")
	public ModelAndView warehouseWinlist(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structWarehouseOpen");
		return modelAndView;
	}
}
