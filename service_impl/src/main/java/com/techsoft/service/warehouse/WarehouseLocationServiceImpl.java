package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.dao.warehouse.WarehouseLocationDao;

@Service
public class WarehouseLocationServiceImpl extends BaseServiceImpl<WarehouseLocation> implements WarehouseLocationService {
	@Autowired
	private WarehouseLocationDao warehouseLocationDao;
	
	@Override
	public BaseDao<WarehouseLocation> getBaseDao() {
		return warehouseLocationDao;
	}	
	
	@Override
	public Class<WarehouseLocation> getEntityClass() {
		return WarehouseLocation.class;
	}
	
	@Override
	protected WarehouseLocation insertEntity(WarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseLocation updatePartEntity(WarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseLocation updateEntity(WarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
