package com.techsoft.controller.warehouse;

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
import com.techsoft.client.service.barcode.ClientBarcodeMainService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductMaterialService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWarehouseService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.client.service.warehouse.ClientWarehouseLocationService;
import com.techsoft.client.service.warehouse.ClientWarehousePalletItemService;
import com.techsoft.client.service.warehouse.ClientWarehousePalletService;
import com.techsoft.client.service.warehouse.ClientWarehouseRackService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.product.ProductMaterialParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.entity.warehouse.WarehousePalletItemParamVo;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;

@Controller
@RequestMapping("/warehouse/warehousePullOrJoin")
public class WarehousePullOrJoinController extends BaseController {
	@Autowired
	private ClientWarehouseLocationService clientWarehouseLocationService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructFactoryService ClientStructFactoryService;
	@Autowired
	private ClientWarehouseRackService ClientWarehouseRackService;
	@Autowired
	private ClientStructWarehouseService ClientStructWarehouseService;
	@Autowired
	private ClientProductMaterialService ClientProductMaterialService;
	@Autowired
	private ClientWarehousePalletItemService clientWarehousePalletItemService;
	@Autowired
	private ClientWarehousePalletService clientWarehousePalletService;
	@Autowired
	private ClientBarcodeMainService clientBarcodeMainService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = ClientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList); 
			
			//取仓库集合
			StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = ClientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("warehouseList", warehouseList);
			
			//取货架集合
			WarehouseRackParamVo ParamVorack = new WarehouseRackParamVo();
			List<WarehouseRack> rackList = ClientWarehouseRackService.selectListByParamVo(ParamVorack,this.getCommonParam(null));
			modelAndView.addObject("rackList", rackList);
			
			//取物料集合
			ProductMaterialParamVo ParamVoMaterial = new ProductMaterialParamVo();
			List<ProductMaterial> materialList = ClientProductMaterialService.selectListByParamVo(ParamVoMaterial,this.getCommonParam(null));
			modelAndView.addObject("materialList", materialList);
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
		modelAndView.setViewName("warehouse/warehousePullOrJoin-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//取仓库集合
			StructWarehouseParamVo ParamVowarehosue = new StructWarehouseParamVo();
			List<StructWarehouse> warehouseList = ClientStructWarehouseService.selectListByParamVo(ParamVowarehosue,this.getCommonParam(null));
			modelAndView.addObject("warehouseList", warehouseList);
			
			//取工厂集合
			StructFactoryParamVo ParamVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = ClientStructFactoryService.selectListByParamVo(ParamVo,this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
				
			WarehouseLocationVo entity = new WarehouseLocationVo();
			if (id != null) {;
				entity = clientWarehouseLocationService.getVoByID(id, this.getCommonParam(request));
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("warehouse/warehouseLocation-edit");
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
			WarehousePalletItemParamVo warehousePalletItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}			
		try {
            if(warehousePalletItemParamVo==null){
            	warehousePalletItemParamVo = new WarehousePalletItemParamVo();
            }
            //warehousePalletItemParamVo.setTenantId(getLoginTenantId(request)); 
			pageInfo = clientWarehousePalletItemService.selectPageVoByParamVo(
					warehousePalletItemParamVo, this.getCommonParam(request),
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
			WarehouseLocationParamVo warehouseLocationParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    warehouseLocationParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientWarehouseLocationService.saveOrUpdate(warehouseLocationParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	/**
	 * 栈板合并
	 * @param request
	 * @param palletId 栈板号
	 * @param waitPalletId 待合并栈板号
	 * @return
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage palletJoin(HttpServletRequest request,
			String palletId,String waitPalletId) {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainParamVo barcode = new BarcodeMainParamVo();
		barcode.setPalletId(Long.parseLong(palletId));
		TrackBarcodeParamVo trackBarcodeParmVo= new TrackBarcodeParamVo();
		trackBarcodeParmVo.setPalletId(Long.parseLong(palletId));
		try {
			//查询待合并栈板号,获取它的箱数等
			WarehousePallet waitWarehousePallet = clientWarehousePalletService.selectById(Long.parseLong(waitPalletId), this.getCommonParam(request));
			//查询合并栈板号,获取它的信息
			WarehousePallet joinWarehousePallet = clientWarehousePalletService.selectById(Long.parseLong(palletId), this.getCommonParam(request));
			//根据栈板id查询条码主表信息
			  List<BarcodeMain> selectListBarcodeMain = clientBarcodeMainService.selectListByParamVo(barcode, this.getCommonParam(request));
			//根据栈板id查询条码追踪
			 List<TrackBarcode> selectListtrackBarcode = clientTrackBarcodeService.selectListByParamVo(trackBarcodeParmVo, this.getCommonParam(request));
			if(waitWarehousePallet.getPalletStatusDictId() != 10417 && !palletId.equals(waitPalletId)){//如果待合并栈板状态不是废弃,并且栈板号不是同一个，才能合并
			//先修改合并栈板的数量
				List<Map> list = new ArrayList<Map>();
				Map<Object,Object> map= new HashMap<Object,Object>();
				map.put("id", palletId);//栈板id
				map.put("quantityPackbox",waitWarehousePallet.getQuantityPackbox()+joinWarehousePallet.getQuantityPackbox());//合并栈板号箱数叠加
				map.put("quantitySn",waitWarehousePallet.getQuantitySn()+joinWarehousePallet.getQuantitySn());//sn数叠加
				map.put("isValid", joinWarehousePallet.getIsValid());//是否有效
				map.put("palletStatusDictId", joinWarehousePallet.getPalletStatusDictId());
				list.add(map);
				
				//修改待合并栈板的信息
				Map<Object,Object> map1= new HashMap<Object,Object>();
				map1.put("id", waitPalletId);//待合并栈板id
				map1.put("quantityPackbox", 0);
				map1.put("quantitySn", 0);//sn数
				map1.put("isValid", 0);//是否有效
				map1.put("palletStatusDictId", 10417);//报废
				list.add(map1);
				
				//修改条码主表的数量
				Map<Object,Object> map2= new HashMap<Object,Object>();
				if(selectListBarcodeMain.size()>0){
					map2.put("palletId", palletId);
					map2.put("quantity", waitWarehousePallet.getQuantityPackbox()+selectListBarcodeMain.get(0).getQuantity());
				list.add(map2);
				}
				
				//条码追踪历史的数量加上待合并栈板箱数
				Map<Object,Object> map3= new HashMap<Object,Object>();
				if(selectListtrackBarcode.size()>0){
					map3.put("palletId", palletId);
					map3.put("quantity", waitWarehousePallet.getQuantityPackbox()+selectListtrackBarcode.get(0).getQuantity());
				list.add(map3);
				}
			int joinPallet = clientWarehousePalletService.updatePallet(list, this.getCommonParam(request));
			
			if(joinPallet >0 ) {
				resultMessage.setIsSuccess(true);
			}
		 }
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	/**
	 * 栈板拆除
	 * @param request
	 * @param palletId要拆除的栈板号
	 * @param packbox 拆除的箱数
	 * @param palletCode  新栈板编码
	 * @return
	 */
	@RequestMapping(value = "/pull", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage palletPull(HttpServletRequest request,
			String palletId,String packbox,String palletCode,String quantitySn,String remark) {
		ResultMessage resultMessage = new ResultMessage();
		BarcodeMainParamVo barcode = new BarcodeMainParamVo();
		barcode.setPalletId(Long.parseLong(palletId));
		TrackBarcodeParamVo trackBarcodeParmVo= new TrackBarcodeParamVo();
		trackBarcodeParmVo.setPalletId(Long.parseLong(palletId));
		try {
			//根据栈板id查询条码主表信息
			List<BarcodeMain> selectListBarcodeMain = clientBarcodeMainService.selectListByParamVo(barcode, this.getCommonParam(request));
			//根据栈板id查询条码追踪
			List<TrackBarcode> selectListtrackBarcode = clientTrackBarcodeService.selectListByParamVo(trackBarcodeParmVo, this.getCommonParam(request));
			List<Map> list = new ArrayList<Map>();
			//查询合并栈板号,获取它的信息
			WarehousePallet pullWarehousePallet = clientWarehousePalletService.selectById(Long.parseLong(palletId), this.getCommonParam(request));
			if(packbox !=null){
				if(Integer.parseInt(packbox) > pullWarehousePallet.getQuantityPackbox()) {
				throw new BusinessException("拆除箱数不能大于原有箱数");
			}
			}else{
				throw new BusinessException("箱数不能为空");
			}
			if(quantitySn !=null){
				if(Integer.parseInt(quantitySn) > pullWarehousePallet.getQuantitySn()) {
				throw new BusinessException("拆除sn数不能大于原有sn数");
			}
			}else{
				throw new BusinessException("sn数不能为空");
			}
			//生成新的栈板
			if(pullWarehousePallet != null){
				Map<Object,Object> map= new HashMap<Object,Object>();
				map.put("isValid",pullWarehousePallet.getIsValid());
			    map.put("palletCode",palletCode);
			    map.put("factoryId",pullWarehousePallet.getFactoryId());
			    map.put("palletStatusDictId",pullWarehousePallet.getPalletStatusDictId());
			    map.put("productId",pullWarehousePallet.getProductId());
			    map.put("quantityPackbox",packbox);
			    map.put("quantitySn",quantitySn);
			    map.put("remark",remark);
			    map.put("modifyUserId",getLoginUserId(request));
			    map.put("warehouseId",pullWarehousePallet.getWarehouseId());
			    map.put("tenantId",this.getCommonParam(request).getTenantId()); 
				list.add(map);
				
			//被拆除的栈板数量等相应改变
				Map<Object,Object> map1= new HashMap<Object,Object>();
				map1.put("id", palletId);
				map1.put("quantityPackbox", pullWarehousePallet.getQuantityPackbox()-Integer.parseInt(packbox));
				map1.put("quantitySn", pullWarehousePallet.getQuantitySn()-Integer.parseInt(quantitySn));
				list.add(map1);
				
				//修改条码主表的数量
				Map<Object,Object> map2= new HashMap<Object,Object>();
				if(selectListBarcodeMain.size()>0){
					map2.put("palletId", palletId);
					map2.put("quantity", selectListBarcodeMain.get(0).getQuantity()-Integer.parseInt(packbox));
					list.add(map2);
				}
				
				//条码追踪历史的数量减去拆除箱数
				Map<Object,Object> map3= new HashMap<Object,Object>();
				if(selectListtrackBarcode.size()>0){
					map3.put("palletId", palletId);
					map3.put("quantity", selectListtrackBarcode.get(0).getQuantity()-Integer.parseInt(packbox));
				list.add(map3);
				}
			int result = clientWarehousePalletService.updatePalletPull(list, this.getCommonParam(request));
			if(result > 0){
				resultMessage.setIsSuccess(true);
			}
			
		  }
		} catch (NumberFormatException | BusinessException | SQLException e) {
			e.printStackTrace();
		}
				return resultMessage;
	}
}
