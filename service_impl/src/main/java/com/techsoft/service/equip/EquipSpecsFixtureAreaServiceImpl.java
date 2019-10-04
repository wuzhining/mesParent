package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.dao.equip.EquipSpecsFixtureAreaDao;

@Service
public class EquipSpecsFixtureAreaServiceImpl extends BaseServiceImpl<EquipSpecsFixtureArea> implements EquipSpecsFixtureAreaService {
	@Autowired
	private EquipSpecsFixtureAreaDao equipSpecsFixtureAreaDao;
	
	@Override
	public BaseDao<EquipSpecsFixtureArea> getBaseDao() {
		return equipSpecsFixtureAreaDao;
	}	
	
	@Override
	public Class<EquipSpecsFixtureArea> getEntityClass() {
		return EquipSpecsFixtureArea.class;
	}
	
	@Override
	protected EquipSpecsFixtureArea insertEntity(EquipSpecsFixtureArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsFixtureArea updatePartEntity(EquipSpecsFixtureArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsFixtureArea updateEntity(EquipSpecsFixtureArea entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
