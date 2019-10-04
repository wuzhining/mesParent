package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.dao.warehouse.WarehouseStrategyUpshelfDao;

@Service
public class WarehouseStrategyUpshelfServiceImpl extends BaseServiceImpl<WarehouseStrategyUpshelf> implements WarehouseStrategyUpshelfService {
	@Autowired
	private WarehouseStrategyUpshelfDao warehouseStrategyUpshelfDao;
	
	@Override
	public BaseDao<WarehouseStrategyUpshelf> getBaseDao() {
		return warehouseStrategyUpshelfDao;
	}	
	
	@Override
	public Class<WarehouseStrategyUpshelf> getEntityClass() {
		return WarehouseStrategyUpshelf.class;
	}
	
	@Override
	protected WarehouseStrategyUpshelf insertEntity(WarehouseStrategyUpshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyUpshelf updatePartEntity(WarehouseStrategyUpshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseStrategyUpshelf updateEntity(WarehouseStrategyUpshelf entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
