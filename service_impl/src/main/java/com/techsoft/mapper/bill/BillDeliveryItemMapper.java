package com.techsoft.mapper.bill;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillDeliveryItemParamVo;
import com.techsoft.entity.bill.BillDeliveryItemVo;
import com.techsoft.entity.common.BillDeliveryItem;

public interface BillDeliveryItemMapper extends BaseMapper<BillDeliveryItem> {
	
    public int insertBatch(List<BillDeliveryItem> items) throws BusinessException, SQLException;
	
	public int updateBatchBillItem(List<BillDeliveryItem> items) throws BusinessException, SQLException;
	
	public List<BillDeliveryItemVo> selectSumQtyByBillId(BillDeliveryItemParamVo billDeliveryItemParamVo) throws BusinessException, SQLException;
}
