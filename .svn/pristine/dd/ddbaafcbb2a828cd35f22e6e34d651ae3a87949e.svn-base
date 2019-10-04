package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.dao.struct.StructWarehouseDao;

@Service
public class StructWarehouseServiceImpl extends BaseServiceImpl<StructWarehouse> implements StructWarehouseService {
	@Autowired
	private StructWarehouseDao structWarehouseDao;
	
	@Override
	public BaseDao<StructWarehouse> getBaseDao() {
		return structWarehouseDao;
	}	
	
	@Override
	public Class<StructWarehouse> getEntityClass() {
		return StructWarehouse.class;
	}
	
	@Override
	protected StructWarehouse insertEntity(StructWarehouse entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWarehouse updatePartEntity(StructWarehouse entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWarehouse updateEntity(StructWarehouse entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
