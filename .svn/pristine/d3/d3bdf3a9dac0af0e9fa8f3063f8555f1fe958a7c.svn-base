package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipWorkProduct;
import com.techsoft.dao.equip.EquipWorkProductDao;

@Service
public class EquipWorkProductServiceImpl extends BaseServiceImpl<EquipWorkProduct> implements EquipWorkProductService {
	@Autowired
	private EquipWorkProductDao equipWorkProductDao;
	
	@Override
	public BaseDao<EquipWorkProduct> getBaseDao() {
		return equipWorkProductDao;
	}	
	
	@Override
	public Class<EquipWorkProduct> getEntityClass() {
		return EquipWorkProduct.class;
	}
	
	@Override
	protected EquipWorkProduct insertEntity(EquipWorkProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkProduct updatePartEntity(EquipWorkProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkProduct updateEntity(EquipWorkProduct entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
