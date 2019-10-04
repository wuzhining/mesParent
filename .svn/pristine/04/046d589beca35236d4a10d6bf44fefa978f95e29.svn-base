package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipFixtureConfig;
import com.techsoft.dao.equip.EquipFixtureConfigDao;

@Service
public class EquipFixtureConfigServiceImpl extends BaseServiceImpl<EquipFixtureConfig> implements EquipFixtureConfigService {
	@Autowired
	private EquipFixtureConfigDao equipFixtureConfigDao;
	
	@Override
	public BaseDao<EquipFixtureConfig> getBaseDao() {
		return equipFixtureConfigDao;
	}	
	
	@Override
	public Class<EquipFixtureConfig> getEntityClass() {
		return EquipFixtureConfig.class;
	}
	
	@Override
	protected EquipFixtureConfig insertEntity(EquipFixtureConfig entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureConfig updatePartEntity(EquipFixtureConfig entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureConfig updateEntity(EquipFixtureConfig entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
