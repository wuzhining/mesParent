package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructWarehouseLocation;
import com.techsoft.dao.struct.StructWarehouseLocationDao;

@Service
public class StructWarehouseLocationServiceImpl extends BaseServiceImpl<StructWarehouseLocation> implements StructWarehouseLocationService {
	@Autowired
	private StructWarehouseLocationDao structWarehouseLocationDao;
	
	@Override
	public BaseDao<StructWarehouseLocation> getBaseDao() {
		return structWarehouseLocationDao;
	}	
	
	@Override
	public Class<StructWarehouseLocation> getEntityClass() {
		return StructWarehouseLocation.class;
	}
	
	@Override
	protected StructWarehouseLocation insertEntity(StructWarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWarehouseLocation updatePartEntity(StructWarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWarehouseLocation updateEntity(StructWarehouseLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
