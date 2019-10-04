package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.bill.BillDeliveryItemVo;
import com.techsoft.entity.bill.BillDeliveryItemParamVo;

public interface ClientBillDeliveryItemService extends BaseClientService<BillDeliveryItem> {

	public BillDeliveryItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillDeliveryItemVo> selectListVoByParamVo(BillDeliveryItemParamVo billDeliveryItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillDeliveryItemVo> selectPageVoByParamVo(BillDeliveryItemParamVo billDeliveryItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillDeliveryItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillDeliveryItemVo> selectListExtendVoByParamVo(BillDeliveryItemParamVo billDeliveryItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillDeliveryItemVo> selectPageExtendVoByParamVo(BillDeliveryItemParamVo billDeliveryItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillDeliveryItemParamVo billDeliveryItemParamVo, CommonParam commonParam);

	public ResultMessage endBill(Long billId, CommonParam commonParam);
}
