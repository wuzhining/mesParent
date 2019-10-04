package com.techsoft.service.equip;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipWorkClasses;
import com.techsoft.dao.equip.EquipWorkClassesDao;

@Service
public class EquipWorkClassesServiceImpl extends BaseServiceImpl<EquipWorkClasses> implements EquipWorkClassesService {
	@Autowired
	private EquipWorkClassesDao equipWorkClassesDao;
	
	@Override
	public BaseDao<EquipWorkClasses> getBaseDao() {
		return equipWorkClassesDao;
	}	
	
	@Override
	public Class<EquipWorkClasses> getEntityClass() {
		return EquipWorkClasses.class;
	}
	
	@Override
	protected EquipWorkClasses insertEntity(EquipWorkClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkClasses updatePartEntity(EquipWorkClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkClasses updateEntity(EquipWorkClasses entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
