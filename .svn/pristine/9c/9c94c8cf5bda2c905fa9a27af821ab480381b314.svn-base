package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.dao.struct.StructProcedureMaterialDao;

@Service
public class StructProcedureMaterialServiceImpl extends BaseServiceImpl<StructProcedureMaterial> implements StructProcedureMaterialService {
	@Autowired
	private StructProcedureMaterialDao structProcedureMaterialDao;
	
	@Override
	public BaseDao<StructProcedureMaterial> getBaseDao() {
		return structProcedureMaterialDao;
	}	
	
	@Override
	public Class<StructProcedureMaterial> getEntityClass() {
		return StructProcedureMaterial.class;
	}
	
	@Override
	protected StructProcedureMaterial insertEntity(StructProcedureMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureMaterial updatePartEntity(StructProcedureMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureMaterial updateEntity(StructProcedureMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
