package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.dao.warehouse.WarehouseAreaDao;

@Service
public class WarehouseAreaServiceImpl extends BaseServiceImpl<WarehouseArea> implements WarehouseAreaService {
	@Autowired
	private WarehouseAreaDao warehouseAreaDao;
	
	@Override
	public BaseDao<WarehouseArea> getBaseDao() {
		return warehouseAreaDao;
	}	
	
	@Override
	public Class<WarehouseArea> getEntityClass() {
		return WarehouseArea.class;
	}
	
	@Override
	protected WarehouseArea insertEntity(WarehouseArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseArea updatePartEntity(WarehouseArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseArea updateEntity(WarehouseArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
