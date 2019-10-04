package com.techsoft.client.service.bill;

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
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.bill.BillDeliveryParamVo;
import com.techsoft.entity.bill.BillPurchaseItemParamVo;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.service.bill.BillPurchaseItemService;
import com.techsoft.service.bill.BillPurchaseService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;

@org.springframework.stereotype.Service
public class ClientBillPurchaseItemServiceImpl extends BaseClientServiceImpl<BillPurchaseItem>
		implements ClientBillPurchaseItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseItemService billPurchaseItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillPurchaseService billPurchaseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService ProductmainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;

	@Override
	public BaseService<BillPurchaseItem> getBaseService() {
		return billPurchaseItemService;
	}

	private BillPurchaseItemVo getVo(BillPurchaseItem billPurchaseItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillPurchaseItemVo vo = new BillPurchaseItemVo(billPurchaseItem);
		if (vo.getBillPurchaseId() != null && vo.getBillPurchaseId() > 0L) {
			BillPurchase billPurchase = billPurchaseService.selectById(vo.getBillPurchaseId(), commonParam);
			
			if (billPurchase != null) {
				//过滤审核未通过的采购单
			/*	if (billPurchase.getAuditStatusDictId().equals(EnumAuditStatus.NONAPPROVAL.getValue())) {
					return null;
				}*/
				vo.setBillPurchase(billPurchase);
			}
			
		}
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = ProductmainService.selectById(vo.getProductId(), commonParam);
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
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if (vo.getQuantity()!=null && vo.getBillStatusDictId() > 0L&&vo.getQuantityFinish()!=null) {
			vo.setQuantityNeed(vo.getQuantity() - vo.getQuantityFinish());
		}
		//物品规格编码
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				vo.setMaterialCode(materialCode);
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
		
		return vo;
	}

	private BillPurchaseItemVo getExtendVo(BillPurchaseItem billPurchaseItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillPurchaseItemVo vo = this.getVo(billPurchaseItem, commonParam);

		return vo;
	}

	private List<BillPurchaseItemVo> getVoList(List<BillPurchaseItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillPurchaseItemVo> voList = new ArrayList<BillPurchaseItemVo>();
		for (BillPurchaseItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillPurchaseItemVo> getExtendVoList(List<BillPurchaseItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillPurchaseItemVo> voList = new ArrayList<BillPurchaseItemVo>();
		for (BillPurchaseItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillPurchaseItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillPurchaseItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillPurchaseItemVo> selectListVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billPurchaseItem == null) {
			billPurchaseItem = new BillPurchaseItemParamVo();
		}
		billPurchaseItem.setTenantId(commonParam.getTenantId());

		List<BillPurchaseItem> list = (List<BillPurchaseItem>) this.getBaseService()
				.selectListByParamVo(billPurchaseItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillPurchaseItemVo> selectPageVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billPurchaseItem == null) {
			billPurchaseItem = new BillPurchaseItemParamVo();
		}
		billPurchaseItem.setTenantId(commonParam.getTenantId());

	
		if (billPurchaseItem.getBillPurchase()!=null) {
			//先从来源单找到单据ID
			BillPurchaseParamVo paramVo=new BillPurchaseParamVo();
			paramVo.setBillCodeLike(billPurchaseItem.getBillPurchase());
			List<BillPurchase> frombill = billPurchaseService.selectListByParamVo(paramVo, commonParam);
			
			if(frombill.size()>0){
			List<Long> ids = new ArrayList<Long>();
			for (BillPurchase bill : frombill) {
				ids.add(bill.getId());
			}
			billPurchaseItem.setIds(ids);
			}
		}
		
		
		PageInfo<BillPurchaseItem> list = (PageInfo<BillPurchaseItem>) this.getBaseService()
				.selectPageByParamVo(billPurchaseItem, commonParam, pageNo, pageSize);
		List<BillPurchaseItemVo> volist = new ArrayList<BillPurchaseItemVo>();

		Iterator<BillPurchaseItem> iter = list.getList().iterator();
		BillPurchaseItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			if (vo !=null) {
				volist.add(vo);
			}
		}

		Page<BillPurchaseItemVo> vpage = new Page<BillPurchaseItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillPurchaseItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillPurchaseItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillPurchaseItemVo> selectListExtendVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billPurchaseItem == null) {
			billPurchaseItem = new BillPurchaseItemParamVo();
		}
		billPurchaseItem.setTenantId(commonParam.getTenantId());

		List<BillPurchaseItem> list = (List<BillPurchaseItem>) this.getBaseService()
				.selectListByParamVo(billPurchaseItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillPurchaseItemVo> selectPageExtendVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billPurchaseItem == null) {
			billPurchaseItem = new BillPurchaseItemParamVo();
		}
		billPurchaseItem.setTenantId(commonParam.getTenantId());

		PageInfo<BillPurchaseItem> list = (PageInfo<BillPurchaseItem>) this.getBaseService()
				.selectPageByParamVo(billPurchaseItem, commonParam, pageNo, pageSize);
		List<BillPurchaseItemVo> volist = new ArrayList<BillPurchaseItemVo>();

		Iterator<BillPurchaseItem> iter = list.getList().iterator();
		BillPurchaseItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillPurchaseItemVo> vpage = new Page<BillPurchaseItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillPurchaseItemParamVo billPurchaseItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillPurchaseItem billPurchaseItem = null;
		try {
			if (billPurchaseItemParamVo.getId() == null) {// 新增

				billPurchaseItemParamVo.setTenantId(commonParam.getTenantId());
				billPurchaseItemParamVo.setQuantityFinish(0.0);
				billPurchaseItemParamVo.setQuantityScan(0.0);
				billPurchaseItem = billPurchaseItemService.saveOrUpdate(billPurchaseItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				BillPurchaseItem billPurchaseItemVoTemp = this.selectById(billPurchaseItemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billPurchaseItemVoTemp, billPurchaseItemParamVo);

				billPurchaseItem = billPurchaseItemService.saveOrUpdate(billPurchaseItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billPurchaseItem);
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
	public PageInfo<BillPurchaseItemVo> updateAudit(BillPurchaseItemParamVo billPurchaseItem, CommonParam commonParam
			,int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billPurchaseItem == null) {
			billPurchaseItem = new BillPurchaseItemParamVo();
		}
		billPurchaseItem.setTenantId(commonParam.getTenantId());
		
		
		
			//BillPurchaseItemParamVo billPurchaseItem =new BillPurchaseItemParamVo();
			List<BillPurchaseItem> billPurchaseItemList=new ArrayList<>();
			List<BillPurchaseItemVo> volist = new ArrayList<BillPurchaseItemVo>();
			
				BillPurchaseParamVo billPurchaseParamVo= new BillPurchaseParamVo();
				 	List<BillPurchase> billPurchaseList = billPurchaseService.selectListByParamVo(billPurchaseParamVo, commonParam);
				 		for (BillPurchase billPurchase : billPurchaseList) {
				 			if(EnumAuditStatus.AUDITED.getValue().equals(billPurchase.getAuditStatusDictId())
				 					&& !EnumBillStatus.FINISHED.getValue().equals(billPurchase.getBillStatusDictId())){
				 				BillPurchaseItemParamVo billPurchaseItemVo= new BillPurchaseItemParamVo();
				 				billPurchaseItemVo.setBillPurchaseId(billPurchase.getId());
				 				List<BillPurchaseItem>	billPurchaseItemList1=	 billPurchaseItemService.selectListByParamVo(billPurchaseItemVo, commonParam);
				 			for(BillPurchaseItem billPurchaseItem2 :billPurchaseItemList1){
				 				billPurchaseItemList.add(billPurchaseItem2);
				 			}
				 				
				 			}
						}
				 		List<BillPurchaseItem> afterPurchaseItemList=new ArrayList<>();
				 		Iterator<BillPurchaseItem> iter;
				 		if(billPurchaseItem.getBillPurchaseId()!=null && (billPurchaseItem.getBillPurchase()==null || billPurchaseItem.getBillPurchase().equals(""))){
				 			for(BillPurchaseItem item:billPurchaseItemList){
				 			if(item.getBillPurchaseId().longValue()==billPurchaseItem.getBillPurchaseId().longValue()){
				 				afterPurchaseItemList.add(item);
				 			}
				 		}
				 		}else if(billPurchaseItem.getBillPurchaseId()==null && billPurchaseItem.getBillPurchase()!=null){
				 			billPurchaseParamVo.setBillCode(billPurchaseItem.getBillPurchase());
				 			List<BillPurchase> billPurchaseList2 = billPurchaseService.selectListByParamVo(billPurchaseParamVo, commonParam);
				 			BillPurchaseItemParamVo billPurchaseItemVo= new BillPurchaseItemParamVo();
				 			billPurchaseItemVo.setBillPurchaseId(billPurchaseList2.get(0).getId());
				 			List<BillPurchaseItem> vo = billPurchaseItemService.selectListByParamVo(billPurchaseItemVo, commonParam);
				 			for(BillPurchaseItem bill:vo){
				 				afterPurchaseItemList.add(bill);
				 			}
				 		}else if(billPurchaseItem.getBillPurchaseId()!=null && billPurchaseItem.getBillPurchase()!=null){ //两个都不是空
				 			billPurchaseParamVo.setBillCode(billPurchaseItem.getBillPurchase());
				 			List<BillPurchase> billPurchaseList2 = billPurchaseService.selectListByParamVo(billPurchaseParamVo, commonParam);
				 			BillPurchaseItemParamVo billPurchaseItemVo= new BillPurchaseItemParamVo();
				 			if(billPurchaseList2.get(0).getId().longValue()==billPurchaseItem.getBillPurchaseId().longValue()){
				 				billPurchaseItemVo.setBillPurchaseId(billPurchaseList2.get(0).getId());
				 				List<BillPurchaseItem> vo = billPurchaseItemService.selectListByParamVo(billPurchaseItemVo, commonParam);
					 			for(BillPurchaseItem bill:vo){
					 				afterPurchaseItemList.add(bill);
					 			}
				 			}
				 		}
				 		
				 		if(billPurchaseItem.getBillPurchaseId()!=null || billPurchaseItem.getBillPurchase()!=null){
				 			
					 		
					 		iter =afterPurchaseItemList.iterator();
				 		}else{
				 			iter =billPurchaseItemList.iterator();
				 		}
				 		
				 		BillPurchaseItemVo vo = null;
							while(iter.hasNext()){
								vo = this.getExtendVo(iter.next(), commonParam);
								volist.add(vo);
							}
						
							Page<BillPurchaseItemVo> vpage = new Page<BillPurchaseItemVo>();
							vpage.addAll(volist);
							vpage.setPageNum(1);
							vpage.setPageSize(30);
							vpage.setTotal(billPurchaseItemList.size());
				
				
			
							return new PageInfo<BillPurchaseItemVo>(vpage);
	}
}
