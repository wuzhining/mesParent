package com.techsoft.service.warehouse;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;

public interface WarehouseRackService extends BaseService<WarehouseRack> {

	public WarehouseRack insertEntity(WarehouseRackParamVo entity, CommonParam commonParam)throws BusinessException, SQLException;


}
