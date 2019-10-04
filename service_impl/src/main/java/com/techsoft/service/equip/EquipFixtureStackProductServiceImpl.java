package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipFixtureStackProduct;
import com.techsoft.dao.equip.EquipFixtureStackProductDao;

@Service
public class EquipFixtureStackProductServiceImpl extends BaseServiceImpl<EquipFixtureStackProduct> implements EquipFixtureStackProductService {
	@Autowired
	private EquipFixtureStackProductDao equipFixtureStackProductDao;
	
	@Override
	public BaseDao<EquipFixtureStackProduct> getBaseDao() {
		return equipFixtureStackProductDao;
	}	
	
	@Override
	public Class<EquipFixtureStackProduct> getEntityClass() {
		return EquipFixtureStackProduct.class;
	}
	
	@Override
	protected EquipFixtureStackProduct insertEntity(EquipFixtureStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureStackProduct updatePartEntity(EquipFixtureStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureStackProduct updateEntity(EquipFixtureStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
