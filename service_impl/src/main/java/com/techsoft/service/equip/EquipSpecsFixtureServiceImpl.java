package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.dao.equip.EquipSpecsFixtureDao;

@Service
public class EquipSpecsFixtureServiceImpl extends BaseServiceImpl<EquipSpecsFixture> implements EquipSpecsFixtureService {
	@Autowired
	private EquipSpecsFixtureDao equipSpecsFixtureDao;
	
	@Override
	public BaseDao<EquipSpecsFixture> getBaseDao() {
		return equipSpecsFixtureDao;
	}	
	
	@Override
	public Class<EquipSpecsFixture> getEntityClass() {
		return EquipSpecsFixture.class;
	}
	
	@Override
	protected EquipSpecsFixture insertEntity(EquipSpecsFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsFixture updatePartEntity(EquipSpecsFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsFixture updateEntity(EquipSpecsFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
