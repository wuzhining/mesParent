package com.techsoft.client.service.warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehouseLocationStockService;
import com.techsoft.service.warehouse.WarehouseRackService;

@org.springframework.stereotype.Service
public class ClientWarehouseLocationStockServiceImpl extends BaseClientServiceImpl<WarehouseLocationStock>
		implements ClientWarehouseLocationStockService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationStockService warehouseLocationStockService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService warehouseRackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	
	@Override
	public BaseService<WarehouseLocationStock> getBaseService() {
		return warehouseLocationStockService;
	}

	private WarehouseLocationStockVo getVo(WarehouseLocationStock warehouseLocationStock, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocationStockVo vo = new WarehouseLocationStockVo(warehouseLocationStock);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = structWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				vo.setStructWarehouse(structWarehouse);
			}
		}
		
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				if(productMaterial.getSkuValue()!=null&&productMaterial.getSkuValue()!=""){
					ProductMaterialVo productMateriaVo=new ProductMaterialVo();
					productMateriaVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMateriaVo);
					
				}
				vo.setProductMaterial(productMaterial);
			}
		}
		
		if (vo.getAreaId() != null && vo.getAreaId() > 0L) {
			WarehouseArea warehouseArea = warehouseAreaService.selectById(vo.getAreaId(), commonParam);
			if (warehouseArea != null) {
				vo.setWarehouseArea(warehouseArea);
			}
		}
		
		if (vo.getRackId() != null && vo.getRackId() > 0L) {
			WarehouseRack warehouseRack = warehouseRackService.selectById(vo.getRackId(), commonParam);
			if (warehouseRack != null) {
				vo.setWarehouseRack(warehouseRack);
			}
		}
		
		if (vo.getLocationId() != null && vo.getLocationId() > 0L) {
			WarehouseLocation warehouseLocation = warehouseLocationService.selectById(vo.getLocationId(), commonParam);
			if (warehouseLocation != null) {
				vo.setWarehouseLocation(warehouseLocation);
			}
		}
		//物品类型
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				ConfigDictionary dictionary = configDictionaryService.selectById(materialCode.getProductTypeDictId(), commonParam);
				vo.setProductType(dictionary);
			}
		}
		if(vo.getCreateUserId() != null && vo.getCreateUserId() > 0L){
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if(userPassport != null){
				vo.setUserPassport(userPassport);
			}
		}
		if(vo.getModifyUserId() != null && vo.getModifyUserId() > 0L){
			UserPassport modifyUser = userPassportService.selectById(vo.getModifyUserId(), commonParam);
			if(modifyUser != null){
				vo.setModifyUser(modifyUser);
			}
		}
		return vo;
	}

	private WarehouseLocationStockVo getExtendVo(WarehouseLocationStock warehouseLocationStock, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocationStockVo vo = this.getVo(warehouseLocationStock, commonParam);

		return vo;
	}

	private List<WarehouseLocationStockVo> getVoList(List<WarehouseLocationStock> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseLocationStockVo> voList = new ArrayList<WarehouseLocationStockVo>();
		for (WarehouseLocationStock entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseLocationStockVo> getExtendVoList(List<WarehouseLocationStock> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseLocationStockVo> voList = new ArrayList<WarehouseLocationStockVo>();
		for (WarehouseLocationStock entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseLocationStockVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseLocationStock entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseLocationStockVo> selectListVoByParamVo(WarehouseLocationStockParamVo warehouseLocationStock,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehouseLocationStock == null) {
			warehouseLocationStock = new WarehouseLocationStockParamVo();
		}
		warehouseLocationStock.setTenantId(commonParam.getTenantId());

		List<WarehouseLocationStock> list = (List<WarehouseLocationStock>) this.getBaseService()
				.selectListByParamVo(warehouseLocationStock, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationStockVo> selectPageVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (warehouseLocationStock == null) {
			warehouseLocationStock = new WarehouseLocationStockParamVo();
		}
		warehouseLocationStock.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseLocationStock> list = (PageInfo<WarehouseLocationStock>) this.getBaseService()
				.selectPageByParamVo(warehouseLocationStock, commonParam, pageNo, pageSize);
		List<WarehouseLocationStockVo> volist = new ArrayList<WarehouseLocationStockVo>();

		Iterator<WarehouseLocationStock> iter = list.getList().iterator();
		WarehouseLocationStockVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseLocationStockVo> vpage = new Page<WarehouseLocationStockVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseLocationStockVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocationStock entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseLocationStockVo> selectListExtendVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseLocationStock == null) {
			warehouseLocationStock = new WarehouseLocationStockParamVo();
		}
		warehouseLocationStock.setTenantId(commonParam.getTenantId());

		List<WarehouseLocationStock> list = (List<WarehouseLocationStock>) this.getBaseService()
				.selectListByParamVo(warehouseLocationStock, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationStockVo> selectPageExtendVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (warehouseLocationStock == null) {
			warehouseLocationStock = new WarehouseLocationStockParamVo();
		}
		warehouseLocationStock.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseLocationStock> list = (PageInfo<WarehouseLocationStock>) this.getBaseService()
				.selectPageByParamVo(warehouseLocationStock, commonParam, pageNo, pageSize);
		List<WarehouseLocationStockVo> volist = new ArrayList<WarehouseLocationStockVo>();

		Iterator<WarehouseLocationStock> iter = list.getList().iterator();
		WarehouseLocationStockVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseLocationStockVo> vpage = new Page<WarehouseLocationStockVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseLocationStockParamVo warehouseLocationStockParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseLocationStock warehouseLocationStock = null;
		try {
			if (warehouseLocationStockParamVo.getId() == null) {// 新增

				warehouseLocationStockParamVo.setTenantId(commonParam.getTenantId());
				warehouseLocationStock = warehouseLocationStockService.saveOrUpdate(warehouseLocationStockParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseLocationStock warehouseLocationStockVoTemp = this
						.selectById(warehouseLocationStockParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseLocationStockVoTemp, warehouseLocationStockParamVo);

				warehouseLocationStock = warehouseLocationStockService.saveOrUpdate(warehouseLocationStockVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseLocationStock);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationStockVo> selectPageBarcodeVoByParamVo(WarehouseLocationStockVo barcodeMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		if (barcodeMain == null) {
			barcodeMain = new WarehouseLocationStockVo();
		}
		barcodeMain.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseLocationStockVo> list = (PageInfo<WarehouseLocationStockVo>) warehouseLocationStockService.selectPageByParamVo(barcodeMain,
				commonParam, pageNo, pageSize);
		List<WarehouseLocationStockVo> volist = new ArrayList<WarehouseLocationStockVo>();

		Iterator<WarehouseLocationStockVo> iter = list.getList().iterator();
		WarehouseLocationStockVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseLocationStockVo> vpage = new Page<WarehouseLocationStockVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}
}
