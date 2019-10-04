package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.dao.warehouse.WarehouseStrategyDownshelfDao;

@Service
public class WarehouseStrategyDownshelfServiceImpl extends BaseServiceImpl<WarehouseStrategyDownshelf> implements WarehouseStrategyDownshelfService {
	@Autowired
	private WarehouseStrategyDownshelfDao warehouseStrategyDownshelfDao;
	
	@Override
	public BaseDao<WarehouseStrategyDownshelf> getBaseDao() {
		return warehouseStrategyDownshelfDao;
	}	
	
	@Override
	public Class<WarehouseStrategyDownshelf> getEntityClass() {
		return WarehouseStrategyDownshelf.class;
	}
	
	@Override
	protected WarehouseStrategyDownshelf insertEntity(WarehouseStrategyDownshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyDownshelf updatePartEntity(WarehouseStrategyDownshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyDownshelf updateEntity(WarehouseStrategyDownshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
