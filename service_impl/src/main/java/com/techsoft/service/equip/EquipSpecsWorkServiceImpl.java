package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.dao.equip.EquipSpecsWorkDao;

@Service
public class EquipSpecsWorkServiceImpl extends BaseServiceImpl<EquipSpecsWork> implements EquipSpecsWorkService {
	@Autowired
	private EquipSpecsWorkDao equipSpecsWorkDao;
	
	@Override
	public BaseDao<EquipSpecsWork> getBaseDao() {
		return equipSpecsWorkDao;
	}	
	
	@Override
	public Class<EquipSpecsWork> getEntityClass() {
		return EquipSpecsWork.class;
	}
	
	@Override
	protected EquipSpecsWork insertEntity(EquipSpecsWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsWork updatePartEntity(EquipSpecsWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipSpecsWork updateEntity(EquipSpecsWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
