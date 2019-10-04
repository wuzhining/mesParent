package com.techsoft.mapper.bill;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;

public interface BillWarehouseMapper extends BaseMapper<BillWarehouse> {
	public int insertBatch(List<BillWarehouse> list) throws BusinessException, SQLException;

	public List<BillWarehouse> selectPrepareMaterialsScreen(BillWarehouseParamVo billWarehouseParamVo) throws BusinessException, SQLException;
}
