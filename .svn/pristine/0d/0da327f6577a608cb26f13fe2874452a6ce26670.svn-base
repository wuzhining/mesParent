package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructFactory;
import com.techsoft.dao.struct.StructFactoryDao;

@Service
public class StructFactoryServiceImpl extends BaseServiceImpl<StructFactory> implements StructFactoryService {
	@Autowired
	private StructFactoryDao structFactoryDao;
	
	@Override
	public BaseDao<StructFactory> getBaseDao() {
		return structFactoryDao;
	}	
	
	@Override
	public Class<StructFactory> getEntityClass() {
		return StructFactory.class;
	}
	
	@Override
	protected StructFactory insertEntity(StructFactory entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructFactory updatePartEntity(StructFactory entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructFactory updateEntity(StructFactory entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
