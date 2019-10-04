package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcedure;
import com.techsoft.dao.struct.StructProcedureDao;

@Service
public class StructProcedureServiceImpl extends BaseServiceImpl<StructProcedure> implements StructProcedureService {
	@Autowired
	private StructProcedureDao structProcedureDao;
	
	@Override
	public BaseDao<StructProcedure> getBaseDao() {
		return structProcedureDao;
	}	
	
	@Override
	public Class<StructProcedure> getEntityClass() {
		return StructProcedure.class;
	}
	
	@Override
	protected StructProcedure insertEntity(StructProcedure entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcedure updatePartEntity(StructProcedure entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcedure updateEntity(StructProcedure entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
