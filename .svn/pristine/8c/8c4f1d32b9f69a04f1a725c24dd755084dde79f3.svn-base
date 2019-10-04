package com.techsoft.service.warehouse;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseService;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;

public interface WarehouseLocationStockService extends BaseService<WarehouseLocationStock> {

	/**
	*@auther:Chen
	*@version:2019年6月28日下午2:01:01
	*@param Vo                仓库库存条件对象
	*@param commonParam
	*@param pageNo    首页
	*@param pageSize  分页规格
	*@return
	*@throws SQLException
	*@description   查询仓库库存数据并进行分页处理
	*/
	public PageInfo<WarehouseLocationStockVo> selectPageByParamVo(WarehouseLocationStockVo Vo, CommonParam commonParam, int pageNo, int pageSize)
			throws SQLException;

}
