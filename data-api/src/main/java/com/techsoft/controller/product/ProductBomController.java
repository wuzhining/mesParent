package com.techsoft.controller.product;

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
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductBomService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ProductBomZTree;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;

@Controller
@RequestMapping("/product/productBom")
public class ProductBomController extends BaseController {
	@Autowired
	private ClientProductBomService clientProductBomService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientProductMainService clientProductMainService;

	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());  
		try {
			//取仓库集合
			StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = clientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("warehouseList", warehouseList);
			
			//取物品集合
			ProductMainParamVo productMainParamVo = new ProductMainParamVo();
			List<ProductMain> productMainList =clientProductMainService.selectListByParamVo(productMainParamVo, this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList);
			//取bom集合
			ProductBomParamVo productBomParamVo = new ProductBomParamVo();
			List<ProductBom> productBomMainList =clientProductBomService.selectListByParamVo(productBomParamVo, this.getCommonParam(null));
			modelAndView.addObject("productBomMainList", productBomMainList);
			//查询页面一级bom
			ProductBomParamVo productBomParamList = new ProductBomParamVo();
			productBomParamList.setNumberLevel(1);
			List<ProductBom> productBomList = clientProductBomService.selectListByParamVo(productBomParamList, this.getCommonParam(null));
			modelAndView.addObject("productBomList",productBomList);
			//拿到BOM状态数据字典
			List<ConfigDictionary> bomStatusDictIdList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PRODUCT_BOM_STATUS.getValue());
			modelAndView.addObject("bomStatusDictIdList", bomStatusDictIdList);
		}catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("product/productBom-list");
		return modelAndView;
	}
	
	@RequestMapping("/Treelist")
	public ModelAndView Treelist(HttpServletRequest request,ProductBomParamVo productBomParamVo) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);

		modelAndView.setViewName("product/productBomTree-list");
		return modelAndView;
	}
	
	@RequestMapping("/productBomOpen")
	public ModelAndView openWinProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("product/productBomOpen");
		return modelAndView;
	}
	
	@RequestMapping("/productBomOpenBox")
	public ModelAndView openWinProductBom(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("product/productBomOpenBox");
		return modelAndView;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/productBom-edit");
		ProductBomVo entity = new ProductBomVo();
		try {
			if (id != null) {
				entity = clientProductBomService.getVoByID(id, this.getCommonParam(request));
			}
		}catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
			ProductBomParamVo productBomParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(productBomParamVo==null){
            	productBomParamVo = new ProductBomParamVo();
            }
			pageInfo = clientProductBomService.selectPageVoByParamVo(
					productBomParamVo, this.getCommonParam(request),
					0,0);
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
			ProductBomParamVo productBomParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    productBomParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientProductBomService.saveOrUpdate(productBomParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@ResponseBody
	@RequestMapping("/loadBomtree")
	public List<ProductBomZTree> loadZtree(HttpServletRequest request,ProductBomParamVo productBomParamVo) {
		List<ProductBomZTree> loadZtree = new ArrayList<ProductBomZTree>();
	
		loadZtree = clientProductBomService.loadZtree( productBomParamVo,this.getCommonParam(request));
        
	
		return  loadZtree;
	}
	
	@ResponseBody
	@RequestMapping("/selectListBomTree")
	public List<ProductBomVo> selectListBomTree(HttpServletRequest request,ProductBomParamVo productBomParamVo) {
		List<ProductBomVo> loadZtree = new ArrayList<ProductBomVo>();
	    Long id = productBomParamVo.getId();
		loadZtree = clientProductBomService.selectListBomTree(id, this.getCommonParam(request));
		return  loadZtree;
	}
	
	/**
	*@auther:Wang
	*@version:2019年7月25日上午9:34:04
	*@param:
	*@description 同步高斯贝尔物料bom接口
	*/
	@RequestMapping("/synGospellBom")
	public ResultMessage synGospellMat(HttpServletRequest request){
		ResultMessage resultMessage = new ResultMessage();
		try {
			resultMessage = clientProductBomService.synGospellBom();
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
