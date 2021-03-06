package com.techsoft.controller.barcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.bill.ClientBillWarehouseItemService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.config.ClientConfigLabelService;
import com.techsoft.client.service.firm.ClientFirmPartnerService;
import com.techsoft.client.service.product.ClientProductLabelService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.product.ClientProductPackboxService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.warehouse.ClientWarehousePalletService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductLabel;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.ProductPackbox;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.product.ProductLabelParamVo;
import com.techsoft.entity.product.ProductMainParamVo;

@Controller
@RequestMapping("/barcode/barcodeMain")
public class BarcodeMainController extends BaseController {
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	@Autowired
	private ClientBillWarehouseItemService clientBillWarehouseItemService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientProductMainService clientProductMainService;
	@Autowired
	private ClientProductMaterialService clientProductMaterialService;
	@Autowired
	private ClientProductLabelService clientProductLabelService;
	@Autowired
	private ClientFirmPartnerService clientFirmPartnerService;
	@Autowired
	private ClientProductPackboxService clientProductPackboxService;
	@Autowired
	private ClientWarehousePalletService clientWarehousePalletService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientStructWarehouseService clientStructWarehouseService;
	@Autowired
	private ClientConfigLabelService clientconfigLabelService;
	/**
	 * 页面关联数据初始化
	 * 
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
			//条码规则类型
			List<ConfigDictionary> barcodeRuleDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.CONFIG_BARCODE_RULE.getValue());
			modelAndView.addObject("barcodeRuleDicList", barcodeRuleDicList);
			//取物品集合
			ProductMainParamVo productVo= new ProductMainParamVo();
			List<ProductMain> productMainList = clientProductMainService.selectListByParamVo(productVo, this.getCommonParam(null));
			modelAndView.addObject("productMainList", productMainList);
			//取状态集合
			List<ConfigDictionary> barcodeStatusList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BARCODE_STATUS.getValue());
			modelAndView.addObject("barcodeStatusList", barcodeStatusList);
			//单据类型
			List<ConfigDictionary> billTypeDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.BILL_TYPE.getValue());
			modelAndView.addObject("billTypeDicList", billTypeDicList);
		} catch (BusinessException | SQLException e) {
			
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("barcode/barcodeMain-list");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("barcode/barcodeMain-edit");
		BarcodeMainVo entity = new BarcodeMainVo();
		try {
			if (id != null) {
				entity = clientBarcodeMainService.getVoByID(id, this.getCommonParam(request));
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
	public ReturnPageInfo listJson(HttpServletRequest request, BarcodeMainParamVo barcodeMainParamVo,
			Integer pageIndex,Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber=0;
		if(pageSize != null) {
			pageNumber= pageSize;
		}else{
			pageNumber= Constants.SEARCH_PAGE_SIZE;
		}
		try {
			if (barcodeMainParamVo == null) {
				barcodeMainParamVo = new BarcodeMainParamVo();
			}
			pageInfo = clientBarcodeMainService.selectPageVoByParamVo(barcodeMainParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@ResponseBody
	@RequestMapping("/list/sum")
	public Double selectSumQtyByEntity(HttpServletRequest request, BarcodeMainParamVo paramVo)
			throws BusinessException, SQLException {
		return clientBarcodeMainService.selectSumQtyByEntity(paramVo, this.getCommonParam(request));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request, BarcodeMainParamVo barcodeMainParamVo) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			List<ConfigDictionary> selectListByParentId = clientConfigDictionaryService
					.selectListByParentId(EnumBarcodeStatus.NEW.getValue());
			if (selectListByParentId.get(0).getId() != null) {
				barcodeMainParamVo.setBarcodeStatusDictId(selectListByParentId.get(0).getId());
			}

		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		barcodeMainParamVo.setModifyUserId(getLoginUserId(request));
		resultMessage = clientBarcodeMainService.saveOrUpdate(barcodeMainParamVo, this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping(value = "/insertBarcodeMain", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage insertBarcodeMain(HttpServletRequest request, @RequestBody BarcodeMain[] barcodeMains) {
		ResultMessage resultMessage = new ResultMessage();
		List<BarcodeMain> barcodeMainList = new ArrayList<>();
		try {
		for (BarcodeMain barcodeMain : barcodeMains) {
			barcodeMain.setCreateUserId(getLoginUserId(request));
			barcodeMain.setModifyUserId(getLoginUserId(request));
			barcodeMainList.add(barcodeMain);
		}
		
			resultMessage = clientBarcodeMainService.batchInsertBarcodeMain(barcodeMainList,
					this.getCommonParam(request));

		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultMessage;
	}

	@RequestMapping("/print")
	public ModelAndView print(HttpServletRequest request, Long itemId, String codeRuleType) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("print/print");
		return modelAndView;
	}

	/**
	 * 根据仓库库单id查明细
	 * 
	 * @param request
	 *            包含有仓库id
	 * @param structWarehouseLocationParamVo
	 *            货位对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/billWarehouseItemById")
	public List<BillWarehouseItem> billWarehouseItemById(HttpServletRequest request,
			BillWarehouseItemParamVo billWarehouseItemParamVo) {
		if (billWarehouseItemParamVo == null) {
			billWarehouseItemParamVo = new BillWarehouseItemParamVo();
		}
		billWarehouseItemParamVo.setTenantId(getLoginTenantId(request));
		List<BillWarehouseItem> billWarehouseItemList = new ArrayList<BillWarehouseItem>();
		try {
			billWarehouseItemList = clientBillWarehouseItemService.selectListByParamVo(billWarehouseItemParamVo,
					this.getCommonParam(request));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billWarehouseItemList;
	}
	/**
	 * 根据标签模板id查询模板字段跟序号
	 * @param request
	 * @param billWarehouseItemParamVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectLabelItemById")
	public List<Map<String,String>>  selectLabelItemById(HttpServletRequest request,
			Long id,String configBarcodeRule,Integer quantity) {
		
		Map<String, Object> mapLableObject = new HashMap();
		List<Map<String,String>>  valueList=new ArrayList<>();
		List<ProductLabel> selectListByParamVo= new ArrayList<ProductLabel>();
		ProductMain productMain =null;
		FirmPartner firmPartner =null;
		WarehousePallet warehousePallet=null;
		StructFactory structFactory	=null;
		StructWarehouse structWarehouse=null;
		ProductMaterial productMaterial=null;
		ProductPackbox productPackbox=null;
		ProductLabelParamVo productLabelParamVo=new ProductLabelParamVo();
		Long lableId=null;
		try {
				
				if("10362".equals(configBarcodeRule)){//栈板标签
					//根据标签上面的字段信息来查询对应的类
					//栈板
					warehousePallet	=clientWarehousePalletService.selectById(id, this.getCommonParam(request));
					if(warehousePallet.getFactoryId()!=null&&warehousePallet.getFactoryId()!=0){
						structFactory = clientStructFactoryService.selectById(warehousePallet.getFactoryId(), this.getCommonParam(request));
					}
					if(warehousePallet!=null&&warehousePallet.getWarehouseId()!=0){
						//仓库
						structWarehouse=clientStructWarehouseService.selectById(warehousePallet.getWarehouseId(), this.getCommonParam(request));
					}
					if(warehousePallet.getProductId()!=null&&warehousePallet.getProductId()!=0){
						productMain =clientProductMainService.selectById(warehousePallet.getProductId(), this.getCommonParam(request));
					}
				
					if(productMain.getId()!=null&&productMain.getId()!=0){
						productLabelParamVo.setProductId(productMain.getId());
						productLabelParamVo.setBarcodeRuleDictId(Long.parseLong(configBarcodeRule));
					}
					//根据物品id查询模板id
					selectListByParamVo = clientProductLabelService.selectListByParamVo(productLabelParamVo, this.getCommonParam(request));
					if(selectListByParamVo.size()!=0&&selectListByParamVo.size()==1){
						lableId=selectListByParamVo.get(0).getLabelId();
					}
				
				}else if("10359".equals(configBarcodeRule)){//物料标签
					//根据物料编码查询
					productMaterial =clientProductMaterialService.selectById(id, this.getCommonParam(request));
					if(productMaterial.getProductId() !=null&&productMaterial.getProductId()!=0){
						//根据物料得到物品id查询
						 productMain = clientProductMainService.selectById(productMaterial.getProductId(),
								this.getCommonParam(request));
					}
					if(productMaterial!=null&&productMaterial.getSupplierId()!=0){
						//供应商
						firmPartner = clientFirmPartnerService.selectById(productMaterial.getSupplierId(), this.getCommonParam(request));
					}
					
					if(productMain.getId()!=null&&productMain.getId()!=0){
						productLabelParamVo.setProductId(productMain.getId());
						productLabelParamVo.setBarcodeRuleDictId(Long.parseLong(configBarcodeRule));
						//根据物品id查询模板id
						selectListByParamVo = clientProductLabelService.selectListByParamVo(productLabelParamVo, this.getCommonParam(request));
					}
					if(selectListByParamVo.size()!=0&&selectListByParamVo.size()==1){
						lableId=selectListByParamVo.get(0).getLabelId();
					}
					
					
				}else if("10360".equals(configBarcodeRule)){//包装箱标签
					//包装箱
					 productPackbox=clientProductPackboxService.selectById(id, getCommonParam(request));
					 productMain = clientProductMainService.selectById(productPackbox.getProductId(),
							this.getCommonParam(request));
					if(selectListByParamVo.size()!=0&&selectListByParamVo.size()==1){
						lableId=selectListByParamVo.get(0).getLabelId();
					}
					if(productPackbox!=null&&productPackbox.getMaterialId()!=0){
						//物料
						productMaterial =clientProductMaterialService.selectById(productPackbox.getMaterialId(), getCommonParam(request));
					}
					if(productMaterial!=null&&productMaterial.getSupplierId()!=0){
						//供应商
						firmPartner = clientFirmPartnerService.selectById(productMaterial.getSupplierId(), getCommonParam(request));
					}
					//根据物品id查询模板id
					if(productMain!=null&&productMain.getId()!=0){
						productLabelParamVo.setProductId(productMain.getId());
						productLabelParamVo.setBarcodeRuleDictId(Long.parseLong(configBarcodeRule));
						selectListByParamVo = clientProductLabelService.selectListByParamVo(productLabelParamVo, this.getCommonParam(request));
						
					}
				}
				
				
				if(productMain!=null){
					mapLableObject.put(ProductMain.class.getName(),productMain);//物品
				}
				if(productMaterial!=null){
					mapLableObject.put(ProductMaterial.class.getName(),productMaterial);//物料
				}
				if(productPackbox!=null){
					mapLableObject.put(ProductPackbox.class.getName(),productPackbox);//包装箱
				}
				if(firmPartner!=null){
					mapLableObject.put(FirmPartner.class.getName(),firmPartner);//供应商
				}
				if(warehousePallet!=null){
					mapLableObject.put(WarehousePallet.class.getName(),warehousePallet);//栈板
				}
				if(structFactory!=null){
					mapLableObject.put(StructFactory.class.getName(),structFactory);//工厂
				}
				if(structWarehouse!=null){
					mapLableObject.put(StructWarehouse.class.getName(),structWarehouse);//仓库
				}
				valueList = clientconfigLabelService.createValue(lableId, quantity, mapLableObject, this.getCommonParam(request));
			 
		
		} catch (SQLException | BusinessException e) {
			 
			e.printStackTrace();
		}
		return valueList;
	}
	
	
	@RequestMapping("/printOpen")
	public ModelAndView openWinProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("print/printOpen");
		return modelAndView;
	}
}
