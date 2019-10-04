package com.techsoft.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.product.ClientProductClassesService;
import com.techsoft.client.service.product.ClientProductMainService;
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
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.firm.FirmPartnerParamVo;
import com.techsoft.entity.product.ProductClassesParamVo;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMainVo;

@Controller
@RequestMapping("/product/productMain")
public class ProductMainController extends BaseController {
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductClassesService clientProductClassesService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;

	/*
	 * @Autowired private ConfigDictionaryService configDictionaryService;
	 */
	/**
	 * 页面关联数据初始化
	 * 
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {

		try {
			ProductClassesParamVo ParamVoClasee = new ProductClassesParamVo();
			// 物品分类集合
			List<ProductClasses> classesList = clientProductClassesService.selectListByParamVo(ParamVoClasee,
					this.getCommonParam(null));
			modelAndView.addObject("classesList", classesList);
			// 取供应商公司集合
			FirmPartnerParamVo firmPartnerParamVo = new FirmPartnerParamVo();
			List<FirmPartner> firmPartnerList = clientFirmPartnerService.selectListByParamVo(firmPartnerParamVo,
					this.getCommonParam(null));
			modelAndView.addObject("firmPartnerList", firmPartnerList);
			// 物品类型数据字典
			List<ConfigDictionary> productTypeList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PRODUCT_TYPE.getValue());
			// 物品状态数据字典
			List<ConfigDictionary> productStatusList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PRODUCT_STATUS.getValue());
			// 物品来源数据字典
			List<ConfigDictionary> productSourceList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.PRODUCT_SOURCE.getValue());
			// 检验方式数据字典
			List<ConfigDictionary> qualityVerifyModeList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.QUALITY_INSPECT_MODE.getValue());
			// 半成品类型数据字典
			List<ConfigDictionary> semiProductTypeList = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.SEMI_PRODUCT_TYPE.getValue());

			modelAndView.addObject("productTypeList", productTypeList);
			modelAndView.addObject("productSourceList", productSourceList);
			modelAndView.addObject("productStatusList", productStatusList);
			modelAndView.addObject("semiProductTypeList", semiProductTypeList);
			modelAndView.addObject("qualityVerifyModeList", qualityVerifyModeList);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("product/productMain-list");
		return modelAndView;
	}

	@RequestMapping("/productMainOpen")
	public ModelAndView openWinProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("product/productMainOpen");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id, String audit) {
		ModelAndView modelAndView = new ModelAndView();
		List<Map<String, String>> skuNameList = new ArrayList<>();

		try {
			ProductMainVo entity = new ProductMainVo();
			if (id != null) {
				entity = clientProductMainService.getVoByID(id, this.getCommonParam(request));
			}
			if (id != null) {
				ProductMain productMain = clientProductMainService.selectById(id, this.getCommonParam(null));
				String skuName = "";

				if (productMain != null) {
					skuName = productMain.getSkuName();
				}

				if (skuName != "" && skuName != null) {
					String[] skuNames = skuName.split(",");
					if (skuNames.length > 0) {
						for (String name : skuNames) {
							Map<String, String> map = new HashMap<>();
							map.put("skuName", name);
							skuNameList.add(map);
						}
					}

				}
			}

			if (skuNameList.size() == 0) {
				Map<String, String> map = new HashMap<>();
				map.put("skuName", "");
				skuNameList.add(map);
			}

			modelAndView.addObject("skuNameList", skuNameList);
			modelAndView.addObject("entity", entity);

			if (audit == null) {
				if (entity.getProductStatus() != null) {
					if (entity.getProductStatus().getDictName().equals("新建")) {
						modelAndView.addObject("isEdit", true);
					} else {
						modelAndView.addObject("isEdit", false);
					}

					if (entity.getProductType().getDictName().equals("半成品")) {
						modelAndView.addObject("isOpen", true);
					} else {
						modelAndView.addObject("isOpen", false);
					}
				}
				modelAndView.setViewName("product/productMain-edit");
			} else {
				modelAndView.setViewName("product/productMain-audit");
			}

			initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	/**
	 * 保存物品审核信息
	 * 
	 * @param request
	 * @param productMainParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveAuditStatus")
	public ResultMessage saveAuditStatus(HttpServletRequest request, ProductMainParamVo productMainParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			if (productMainParamVo.getId() != null) {
				ProductMain productMain = clientProductMainService.selectById(productMainParamVo.getId(),
						this.getCommonParam(request));

				if (productMain != null) {
					productMain.setProductStatusDictId(productMainParamVo.getProductStatusDictId());

					clientProductMainService.saveOrUpdate(productMain, this.getCommonParam(request));

					resultMessage.setIsSuccess(true);
				} else {
					resultMessage.setIsSuccess(false);
					resultMessage.addErr("无物品信息");
				}
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
			e.printStackTrace();
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
			e.printStackTrace();
		}

		return resultMessage;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")
	public ReturnPageInfo listJson(HttpServletRequest request, ProductMainParamVo productMainParamVo, Integer pageIndex,
			Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}
		try {
			if (productMainParamVo == null) {
				productMainParamVo = new ProductMainParamVo();
			}
			pageInfo = clientProductMainService.selectPageVoByParamVo(productMainParamVo, this.getCommonParam(request),
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
	public ResultMessage save(HttpServletRequest request, ProductMainParamVo productMainParamVo) {
		ResultMessage resultMessage = new ResultMessage();

		productMainParamVo.setModifyUserId(getLoginUserId(request));
		resultMessage = clientProductMainService.saveOrUpdate(productMainParamVo, this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/shelfOpen")
	public ModelAndView openWinShelf(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("warehouse/warehouseShelfOpen");
		return modelAndView;
	}

	@RequestMapping("/upShelfOpen")
	public ModelAndView openWinUpShelf(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("warehouse/warehouseUpShelfOpen");
		return modelAndView;
	}

	/**
	 * @auther:Wang
	 * @version:2019年7月16日上午8:54:34
	 * @param:
	 * @description 同步高斯贝尔物料信息接口
	 */
	@RequestMapping("/synGospellMat")
	public ResultMessage synGospellMat(HttpServletRequest request) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			resultMessage = clientProductMainService.synGospellMat();
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

}
