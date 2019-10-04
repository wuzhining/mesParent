package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProdlineEquipFixture;
import com.techsoft.dao.struct.StructProdlineEquipFixtureDao;

@Service
public class StructProdlineEquipFixtureServiceImpl extends BaseServiceImpl<StructProdlineEquipFixture> implements StructProdlineEquipFixtureService {
	@Autowired
	private StructProdlineEquipFixtureDao structProdlineEquipFixtureDao;
	
	@Override
	public BaseDao<StructProdlineEquipFixture> getBaseDao() {
		return structProdlineEquipFixtureDao;
	}	
	
	@Override
	public Class<StructProdlineEquipFixture> getEntityClass() {
		return StructProdlineEquipFixture.class;
	}
	
	@Override
	protected StructProdlineEquipFixture insertEntity(StructProdlineEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineEquipFixture updatePartEntity(StructProdlineEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineEquipFixture updateEntity(StructProdlineEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
