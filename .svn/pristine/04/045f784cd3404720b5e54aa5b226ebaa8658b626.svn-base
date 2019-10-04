package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcedureWorkstation;
import com.techsoft.dao.struct.StructProcedureWorkstationDao;

@Service
public class StructProcedureWorkstationServiceImpl extends BaseServiceImpl<StructProcedureWorkstation> implements StructProcedureWorkstationService {
	@Autowired
	private StructProcedureWorkstationDao structProcedureWorkstationDao;
	
	@Override
	public BaseDao<StructProcedureWorkstation> getBaseDao() {
		return structProcedureWorkstationDao;
	}	
	
	@Override
	public Class<StructProcedureWorkstation> getEntityClass() {
		return StructProcedureWorkstation.class;
	}
	
	@Override
	protected StructProcedureWorkstation insertEntity(StructProcedureWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureWorkstation updatePartEntity(StructProcedureWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureWorkstation updateEntity(StructProcedureWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
