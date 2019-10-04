package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseProductStock;
import com.techsoft.dao.warehouse.WarehouseProductStockDao;

@Service
public class WarehouseProductStockServiceImpl extends BaseServiceImpl<WarehouseProductStock> implements WarehouseProductStockService {
	@Autowired
	private WarehouseProductStockDao warehouseProductStockDao;
	
	@Override
	public BaseDao<WarehouseProductStock> getBaseDao() {
		return warehouseProductStockDao;
	}	
	
	@Override
	public Class<WarehouseProductStock> getEntityClass() {
		return WarehouseProductStock.class;
	}
	
	@Override
	protected WarehouseProductStock insertEntity(WarehouseProductStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseProductStock updatePartEntity(WarehouseProductStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseProductStock updateEntity(WarehouseProductStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
