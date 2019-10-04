package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;
import com.techsoft.entity.bill.BillPurchaseItemParamVo;

public interface ClientBillPurchaseItemService extends BaseClientService<BillPurchaseItem> {

	public BillPurchaseItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillPurchaseItemVo> selectListVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillPurchaseItemVo> selectPageVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillPurchaseItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillPurchaseItemVo> selectListExtendVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillPurchaseItemVo> selectPageExtendVoByParamVo(BillPurchaseItemParamVo billPurchaseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillPurchaseItemParamVo billPurchaseItemParamVo, CommonParam commonParam);
	
	public PageInfo<BillPurchaseItemVo> updateAudit(BillPurchaseItemParamVo vo, CommonParam commonParam,int pageNo, int pageSize)
			throws BusinessException,SQLException;

}
