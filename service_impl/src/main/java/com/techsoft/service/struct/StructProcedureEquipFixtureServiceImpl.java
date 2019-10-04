package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProcedureEquipFixture;
import com.techsoft.dao.struct.StructProcedureEquipFixtureDao;

@Service
public class StructProcedureEquipFixtureServiceImpl extends BaseServiceImpl<StructProcedureEquipFixture> implements StructProcedureEquipFixtureService {
	@Autowired
	private StructProcedureEquipFixtureDao structProcedureEquipFixtureDao;
	
	@Override
	public BaseDao<StructProcedureEquipFixture> getBaseDao() {
		return structProcedureEquipFixtureDao;
	}	
	
	@Override
	public Class<StructProcedureEquipFixture> getEntityClass() {
		return StructProcedureEquipFixture.class;
	}
	
	@Override
	protected StructProcedureEquipFixture insertEntity(StructProcedureEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureEquipFixture updatePartEntity(StructProcedureEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcedureEquipFixture updateEntity(StructProcedureEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
