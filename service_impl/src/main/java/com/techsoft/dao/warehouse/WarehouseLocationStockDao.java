package com.techsoft.dao.warehouse;

import java.util.List;

import com.github.pagehelper.Page;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.warehouse.WarehouseLocationStockParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;

public interface WarehouseLocationStockDao extends BaseDao<WarehouseLocationStock> {


	/**
	*@auther:Chen
	*@version:2019年6月26日上午11:57:20
	*@param paramVo
	*@param qty
	*@param Type         IN:增加库存;OUT:减少库存
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public ResultMessage StockChange(WarehouseLocationStockParamVo paramVo, Double qty,String Type,CommonParam commonParam)
			throws BusinessException, SQLException;

	
	/**
	*@auther:Chen
	*@version:2019年6月28日下午1:56:00
	*@param Vo   仓库库存条件对象
	*@param pageNo  首页
	*@param pageSize  分页规格
	*@return
	*@throws SQLException
	*@description   查询仓库库存数据并进行分页处理
	*/
	public Page<WarehouseLocationStockVo> selectPageByParamVo(WarehouseLocationStockVo Vo, int pageNo, int pageSize) throws SQLException;


	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:58:16
	*@param Vo
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public List<WarehouseLocationStockVo> selectSumQtyByWarehouse(WarehouseLocationStockParamVo Vo, CommonParam commonParam)
			throws BusinessException, SQLException;

}
