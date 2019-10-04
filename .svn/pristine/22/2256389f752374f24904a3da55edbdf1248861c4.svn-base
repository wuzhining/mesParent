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
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.bill.BillSaleorderItemParamVo;
import com.techsoft.entity.bill.BillSaleorderItemVo;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.service.bill.BillSaleorderItemService;
import com.techsoft.service.bill.BillSaleorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;

@org.springframework.stereotype.Service
public class ClientBillSaleorderItemServiceImpl extends BaseClientServiceImpl<BillSaleorderItem>
		implements ClientBillSaleorderItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderItemService billSaleorderItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillSaleorderService billSaleorderService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService ProductmainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;

	@Override
	public BaseService<BillSaleorderItem> getBaseService() {
		return billSaleorderItemService;
	}

	private BillSaleorderItemVo getVo(BillSaleorderItem billSaleorderItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillSaleorderItemVo vo = new BillSaleorderItemVo(billSaleorderItem);

		// 物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = ProductmainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		// 物料
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
		// 销售单状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if (vo.getBillSaleorderId() != null && vo.getBillSaleorderId() > 0L) {
			BillSaleorder billsaleorder = billSaleorderService.selectById(vo.getBillSaleorderId(), commonParam);
			if (billsaleorder != null) {
				vo.setBillSaleorder(billsaleorder);
				if (billsaleorder.getCustomerId() !=null ) {
					FirmPartner firmPartner=firmPartnerService.selectById(billsaleorder.getCustomerId(), commonParam);
					vo.setCustomerName(firmPartner.getCompanyName());
				}
			}
		}
		//销售单编码
		if(vo.getBillSaleorderId() != null && vo.getBillSaleorderId() > 0L){
			BillSaleorder saleorder =  billSaleorderService.selectById(vo.getBillSaleorderId(), commonParam);
			if(saleorder != null){
				vo.setSaleorder(saleorder);
			}
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

	private BillSaleorderItemVo getExtendVo(BillSaleorderItem billSaleorderItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillSaleorderItemVo vo = this.getVo(billSaleorderItem, commonParam);

		return vo;
	}

	private List<BillSaleorderItemVo> getVoList(List<BillSaleorderItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillSaleorderItemVo> voList = new ArrayList<BillSaleorderItemVo>();
		for (BillSaleorderItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillSaleorderItemVo> getExtendVoList(List<BillSaleorderItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillSaleorderItemVo> voList = new ArrayList<BillSaleorderItemVo>();
		for (BillSaleorderItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillSaleorderItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillSaleorderItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillSaleorderItemVo> selectListVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billSaleorderItem == null) {
			billSaleorderItem = new BillSaleorderItemParamVo();
		}
		billSaleorderItem.setTenantId(commonParam.getTenantId());

		List<BillSaleorderItem> list = (List<BillSaleorderItem>) this.getBaseService()
				.selectListByParamVo(billSaleorderItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillSaleorderItemVo> selectPageVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billSaleorderItem == null) {
			billSaleorderItem = new BillSaleorderItemParamVo();
		}
		billSaleorderItem.setTenantId(commonParam.getTenantId());

		PageInfo<BillSaleorderItem> list = (PageInfo<BillSaleorderItem>) this.getBaseService()
				.selectPageByParamVo(billSaleorderItem, commonParam, pageNo, pageSize);
		List<BillSaleorderItemVo> volist = new ArrayList<BillSaleorderItemVo>();

		Iterator<BillSaleorderItem> iter = list.getList().iterator();
		BillSaleorderItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillSaleorderItemVo> vpage = new Page<BillSaleorderItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillSaleorderItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillSaleorderItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillSaleorderItemVo> selectListExtendVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billSaleorderItem == null) {
			billSaleorderItem = new BillSaleorderItemParamVo();
		}
		billSaleorderItem.setTenantId(commonParam.getTenantId());

		List<BillSaleorderItem> list = (List<BillSaleorderItem>) this.getBaseService()
				.selectListByParamVo(billSaleorderItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillSaleorderItemVo> selectPageExtendVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billSaleorderItem == null) {
			billSaleorderItem = new BillSaleorderItemParamVo();
		}
		billSaleorderItem.setTenantId(commonParam.getTenantId());

		PageInfo<BillSaleorderItem> list = (PageInfo<BillSaleorderItem>) this.getBaseService()
				.selectPageByParamVo(billSaleorderItem, commonParam, pageNo, pageSize);
		List<BillSaleorderItemVo> volist = new ArrayList<BillSaleorderItemVo>();

		Iterator<BillSaleorderItem> iter = list.getList().iterator();
		BillSaleorderItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillSaleorderItemVo> vpage = new Page<BillSaleorderItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillSaleorderItemParamVo billSaleorderItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillSaleorderItem billSaleorderItem = null;

		if (commonParam.getUserId() != null) {
			billSaleorderItemParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		} else {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}
		if (commonParam.getTenantId() != null) {
			billSaleorderItemParamVo.setTenantId(commonParam.getTenantId());
		}
		if (billSaleorderItemParamVo.getProductId() == null) {
			resultMessage.addErr("物品不能为空");
			return resultMessage;
		}
		if (billSaleorderItemParamVo.getMaterialId() == null) {
			resultMessage.addErr("物料不能为空");
			return resultMessage;
		}
		if (billSaleorderItemParamVo.getQuantity() == null || billSaleorderItemParamVo.getQuantity() == 0) {
			resultMessage.addErr("单据数量不能为空或0");
			return resultMessage;
		}
		/*
		 * if (billSaleorderItemVo.getQuantityFinish()==
		 * null||billSaleorderItemVo.getQuantityFinish()==0) {
		 * resultMessage.addErr("完成数量不能为空或0"); return resultMessage; }
		 */
		if (billSaleorderItemParamVo.getRemark().length() > 128) {
			resultMessage.addErr("备注不能超过128个字符");
			return resultMessage;
		}

		try {
			if (billSaleorderItemParamVo.getId() == null) {// 新增

				billSaleorderItemParamVo.setTenantId(commonParam.getTenantId());
				billSaleorderItem = billSaleorderItemService.saveOrUpdate(billSaleorderItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				BillSaleorderItem billSaleorderItemVoTemp = this.selectById(billSaleorderItemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billSaleorderItemVoTemp, billSaleorderItemParamVo);

				billSaleorderItem = billSaleorderItemService.saveOrUpdate(billSaleorderItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billSaleorderItem);
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
