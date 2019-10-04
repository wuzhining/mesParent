package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipFixtureProduct;
import com.techsoft.dao.equip.EquipFixtureProductDao;

@Service
public class EquipFixtureProductServiceImpl extends BaseServiceImpl<EquipFixtureProduct> implements EquipFixtureProductService {
	@Autowired
	private EquipFixtureProductDao equipFixtureProductDao;
	
	@Override
	public BaseDao<EquipFixtureProduct> getBaseDao() {
		return equipFixtureProductDao;
	}	
	
	@Override
	public Class<EquipFixtureProduct> getEntityClass() {
		return EquipFixtureProduct.class;
	}
	
	@Override
	protected EquipFixtureProduct insertEntity(EquipFixtureProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureProduct updatePartEntity(EquipFixtureProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureProduct updateEntity(EquipFixtureProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
