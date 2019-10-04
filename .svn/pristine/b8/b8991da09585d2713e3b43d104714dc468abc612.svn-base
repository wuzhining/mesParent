package com.techsoft.client.service.track;

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
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillInventory;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.TrackMaterial;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.track.TrackMaterialParamVo;
import com.techsoft.entity.track.TrackMaterialVo;
import com.techsoft.service.bill.BillDeliveryService;
import com.techsoft.service.bill.BillInspectService;
import com.techsoft.service.bill.BillInventoryService;
import com.techsoft.service.bill.BillPurchaseService;
import com.techsoft.service.bill.BillSaleorderService;
import com.techsoft.service.bill.BillWarehouseService;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.track.TrackMaterialService;

@org.springframework.stereotype.Service
public class ClientTrackMaterialServiceImpl extends BaseClientServiceImpl<TrackMaterial>
		implements ClientTrackMaterialService {
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackMaterialService trackMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	// 仓库
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;
	// 物品
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	//操作人
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	//-工厂名称
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	//单据
	@com.alibaba.dubbo.config.annotation.Reference
	private BillDeliveryService billDeliveryService;//发货单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderService billSaleorderService;//销售单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseService billPurchaseService;//采购单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInspectService billInspectService;//检验单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWorkorderService billWorkorderService;//工单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillInventoryService billInventoryService;//盘点单
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWarehouseService billWarehouseService;//仓库库单

	
	@Override
	public BaseService<TrackMaterial> getBaseService() {
		return trackMaterialService;
	}

	private TrackMaterialVo getVo(TrackMaterial trackMaterial, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackMaterialVo vo = new TrackMaterialVo(trackMaterial);
		// 获取物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		// 获取物料
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
		// 单据类型
		if (vo.getBillTypeDictId() != null && vo.getBillTypeDictId() > 0L) {
			ConfigDictionary billTypeDicList = configDictionaryService.selectById(vo.getBillTypeDictId(), commonParam);
			if (billTypeDicList != null) {
				vo.setBillTypeDicList(billTypeDicList);
				 //单据
				if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_DELIVERY.getValue()) || 
						vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_DELIVERY_SUPPLIER.getValue()) ) {//发货单和供应商发货单
				        BillDelivery billDelivery = billDeliveryService.selectById(vo.getBillId(), commonParam);
				        vo.setBillCode(billDelivery.getBillCode());
				}else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_SALEORDER.getValue())) {//销售单
					    BillSaleorder billSaleorder = billSaleorderService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billSaleorder.getBillCode());    
				}else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_PURCHASE.getValue())) {//采购单
				    BillPurchase billPurchase = billPurchaseService.selectById(vo.getBillId(), commonParam);
				    if (billPurchase!=null) {
				    	 vo.setBillCode(billPurchase.getBillCode());
					}
				} else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_EXAMINE.getValue())) {//检验单
					    BillInspect billInspect = billInspectService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billInspect.getInspectCode()); 
		        } else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_WORKORDER.getValue())){//工单
		        	    BillWorkorder billWorkorder = billWorkorderService.selectById(vo.getBillId(), commonParam);
					    vo.setBillCode(billWorkorder.getWorkorderCode()); 
		        } else if (vo.getBillTypeDictId().equals(EnumBillType.BILL_TYPE_INVENTORY.getValue())){//盘点单
		        	BillInventory billInventory = billInventoryService.selectById(vo.getBillId(), commonParam);
				    vo.setBillCode(billInventory.getBillCode()); 
	            }else{//仓库库单
		        	    BillWarehouse billWarehouse =billWarehouseService.selectById(vo.getBillId(), commonParam);
		        	    if(billWarehouse != null){
						    vo.setBillCode(billWarehouse.getBillCode()); 
		        	    }
		        }
				
			}
		}

		// 状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary billStatusDicList = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (billStatusDicList != null) {
				vo.setBillStatusDicList(billStatusDicList);
			}
		}
		
		//操作人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassportList(userPassport);
			}
		}
		
		//工厂名称
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactorylist(structFactory);
			}
		}
		// 仓库
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = structWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				vo.setStructWarehouseList(structWarehouse);
			}
		}
		return vo;
	}

	private TrackMaterialVo getExtendVo(TrackMaterial trackMaterial, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackMaterialVo vo = this.getVo(trackMaterial, commonParam);

		return vo;
	}

	private List<TrackMaterialVo> getVoList(List<TrackMaterial> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackMaterialVo> voList = new ArrayList<TrackMaterialVo>();
		for (TrackMaterial entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<TrackMaterialVo> getExtendVoList(List<TrackMaterial> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackMaterialVo> voList = new ArrayList<TrackMaterialVo>();
		for (TrackMaterial entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public TrackMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackMaterial entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<TrackMaterialVo> selectListVoByParamVo(TrackMaterialParamVo trackMaterial, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackMaterial == null) {
			trackMaterial = new TrackMaterialParamVo();
		}
		trackMaterial.setTenantId(commonParam.getTenantId());

		List<TrackMaterial> list = (List<TrackMaterial>) this.getBaseService().selectListByParamVo(trackMaterial,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackMaterialVo> selectPageVoByParamVo(TrackMaterialParamVo trackMaterial, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackMaterial == null) {
			trackMaterial = new TrackMaterialParamVo();
		}
		trackMaterial.setTenantId(commonParam.getTenantId());

		PageInfo<TrackMaterial> list = (PageInfo<TrackMaterial>) this.getBaseService()
				.selectPageByParamVo(trackMaterial, commonParam, pageNo, pageSize);
		List<TrackMaterialVo> volist = new ArrayList<TrackMaterialVo>();

		Iterator<TrackMaterial> iter = list.getList().iterator();
		TrackMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackMaterialVo> vpage = new Page<TrackMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public TrackMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackMaterial entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<TrackMaterialVo> selectListExtendVoByParamVo(TrackMaterialParamVo trackMaterial,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (trackMaterial == null) {
			trackMaterial = new TrackMaterialParamVo();
		}
		trackMaterial.setTenantId(commonParam.getTenantId());

		List<TrackMaterial> list = (List<TrackMaterial>) this.getBaseService().selectListByParamVo(trackMaterial,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackMaterialVo> selectPageExtendVoByParamVo(TrackMaterialParamVo trackMaterial,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackMaterial == null) {
			trackMaterial = new TrackMaterialParamVo();
		}
		trackMaterial.setTenantId(commonParam.getTenantId());

		PageInfo<TrackMaterial> list = (PageInfo<TrackMaterial>) this.getBaseService()
				.selectPageByParamVo(trackMaterial, commonParam, pageNo, pageSize);
		List<TrackMaterialVo> volist = new ArrayList<TrackMaterialVo>();

		Iterator<TrackMaterial> iter = list.getList().iterator();
		TrackMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackMaterialVo> vpage = new Page<TrackMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(TrackMaterialParamVo trackMaterialParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		TrackMaterial trackMaterial = null;
		try {
			if (trackMaterialParamVo.getId() == null) {// 新增

				trackMaterialParamVo.setTenantId(commonParam.getTenantId());
				trackMaterial = trackMaterialService.saveOrUpdate(trackMaterialParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				TrackMaterial trackMaterialVoTemp = this.selectById(trackMaterialParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(trackMaterialVoTemp, trackMaterialParamVo);

				trackMaterial = trackMaterialService.saveOrUpdate(trackMaterialVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(trackMaterial);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
