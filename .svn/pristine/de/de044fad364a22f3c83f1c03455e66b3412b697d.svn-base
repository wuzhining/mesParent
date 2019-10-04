package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.warehouse.WarehouseLocationStockParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;

public interface ClientWarehouseLocationStockService extends BaseClientService<WarehouseLocationStock> {

	public WarehouseLocationStockVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WarehouseLocationStockVo> selectListVoByParamVo(WarehouseLocationStockParamVo warehouseLocationStock,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WarehouseLocationStockVo> selectPageVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public WarehouseLocationStockVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<WarehouseLocationStockVo> selectListExtendVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<WarehouseLocationStockVo> selectPageExtendVoByParamVo(
			WarehouseLocationStockParamVo warehouseLocationStock, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WarehouseLocationStockParamVo warehouseLocationStockParamVo,
			CommonParam commonParam);


	/**
	*@auther:Chen
	*@version:2019年7月3日下午4:53:38
	*@param warehouseLocationStockVo   仓库库存对象
	*@param commonParam
	*@param pageNo                     首页
	*@param pageSize                   分页规格
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description    查询仓库库存数据并进行分页处理
	*/
	public PageInfo<WarehouseLocationStockVo> selectPageBarcodeVoByParamVo(WarehouseLocationStockVo warehouseLocationStockVo,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
}
