package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipClassesFixture;
import com.techsoft.dao.equip.EquipClassesFixtureDao;

@Service
public class EquipClassesFixtureServiceImpl extends BaseServiceImpl<EquipClassesFixture> implements EquipClassesFixtureService {
	@Autowired
	private EquipClassesFixtureDao equipClassesFixtureDao;
	
	@Override
	public BaseDao<EquipClassesFixture> getBaseDao() {
		return equipClassesFixtureDao;
	}	
	
	@Override
	public Class<EquipClassesFixture> getEntityClass() {
		return EquipClassesFixture.class;
	}
	
	@Override
	protected EquipClassesFixture insertEntity(EquipClassesFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipClassesFixture updatePartEntity(EquipClassesFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipClassesFixture updateEntity(EquipClassesFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
