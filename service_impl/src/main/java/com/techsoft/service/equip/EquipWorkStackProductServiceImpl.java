package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipWorkStackProduct;
import com.techsoft.dao.equip.EquipWorkStackProductDao;

@Service
public class EquipWorkStackProductServiceImpl extends BaseServiceImpl<EquipWorkStackProduct> implements EquipWorkStackProductService {
	@Autowired
	private EquipWorkStackProductDao equipWorkStackProductDao;
	
	@Override
	public BaseDao<EquipWorkStackProduct> getBaseDao() {
		return equipWorkStackProductDao;
	}	
	
	@Override
	public Class<EquipWorkStackProduct> getEntityClass() {
		return EquipWorkStackProduct.class;
	}
	
	@Override
	protected EquipWorkStackProduct insertEntity(EquipWorkStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkStackProduct updatePartEntity(EquipWorkStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkStackProduct updateEntity(EquipWorkStackProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
