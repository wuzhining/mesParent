package com.techsoft.client.service.warehouse;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WarehouseProductStock;
import com.techsoft.entity.warehouse.WarehouseProductStockVo;
import com.techsoft.entity.warehouse.WarehouseProductStockParamVo;

public interface ClientWarehouseProductStockService extends BaseClientService<WarehouseProductStock> {
	
	public WarehouseProductStockVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WarehouseProductStockVo>  selectListVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WarehouseProductStockVo>  selectPageVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WarehouseProductStockVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WarehouseProductStockVo>  selectListExtendVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WarehouseProductStockVo>  selectPageExtendVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WarehouseProductStockParamVo warehouseProductStockParamVo, CommonParam commonParam);		
}
