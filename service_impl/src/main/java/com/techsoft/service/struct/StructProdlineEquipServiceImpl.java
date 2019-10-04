package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructProdlineEquip;
import com.techsoft.dao.struct.StructProdlineEquipDao;

@Service
public class StructProdlineEquipServiceImpl extends BaseServiceImpl<StructProdlineEquip> implements StructProdlineEquipService {
	@Autowired
	private StructProdlineEquipDao structProdlineEquipDao;
	
	@Override
	public BaseDao<StructProdlineEquip> getBaseDao() {
		return structProdlineEquipDao;
	}	
	
	@Override
	public Class<StructProdlineEquip> getEntityClass() {
		return StructProdlineEquip.class;
	}
	
	@Override
	protected StructProdlineEquip insertEntity(StructProdlineEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineEquip updatePartEntity(StructProdlineEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProdlineEquip updateEntity(StructProdlineEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
