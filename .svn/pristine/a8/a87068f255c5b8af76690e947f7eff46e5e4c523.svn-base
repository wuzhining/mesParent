package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseStrategyDownshelfItem;
import com.techsoft.dao.warehouse.WarehouseStrategyDownshelfItemDao;

@Service
public class WarehouseStrategyDownshelfItemServiceImpl extends BaseServiceImpl<WarehouseStrategyDownshelfItem> implements WarehouseStrategyDownshelfItemService {
	@Autowired
	private WarehouseStrategyDownshelfItemDao warehouseStrategyDownshelfItemDao;
	
	@Override
	public BaseDao<WarehouseStrategyDownshelfItem> getBaseDao() {
		return warehouseStrategyDownshelfItemDao;
	}	
	
	@Override
	public Class<WarehouseStrategyDownshelfItem> getEntityClass() {
		return WarehouseStrategyDownshelfItem.class;
	}
	
	@Override
	protected WarehouseStrategyDownshelfItem insertEntity(WarehouseStrategyDownshelfItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyDownshelfItem updatePartEntity(WarehouseStrategyDownshelfItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyDownshelfItem updateEntity(WarehouseStrategyDownshelfItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
