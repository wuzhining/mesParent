package com.techsoft.mapper.warehouse;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.warehouse.WarehouseLocationStockParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;

public interface WarehouseLocationStockMapper extends BaseMapper<WarehouseLocationStock> {
	
	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:58:51
	*@param paramVo     仓库库存查询条件对象
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description    根据条件汇总物料的库存数量
	*/
	public List<WarehouseLocationStockVo> selectSumQtyByWarehouse(WarehouseLocationStockParamVo paramVo) throws BusinessException, SQLException;
	
}
