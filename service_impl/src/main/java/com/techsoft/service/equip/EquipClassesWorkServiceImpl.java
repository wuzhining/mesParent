package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.dao.equip.EquipClassesWorkDao;

@Service
public class EquipClassesWorkServiceImpl extends BaseServiceImpl<EquipClassesWork> implements EquipClassesWorkService {
	@Autowired
	private EquipClassesWorkDao equipClassesWorkDao;
	
	@Override
	public BaseDao<EquipClassesWork> getBaseDao() {
		return equipClassesWorkDao;
	}	
	
	@Override
	public Class<EquipClassesWork> getEntityClass() {
		return EquipClassesWork.class;
	}
	
	@Override
	protected EquipClassesWork insertEntity(EquipClassesWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipClassesWork updatePartEntity(EquipClassesWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipClassesWork updateEntity(EquipClassesWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
