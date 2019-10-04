package com.techsoft.service.equip;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.equip.EquipFixtureStackDao;
import com.techsoft.entity.common.EquipFixtureStack;
import com.techsoft.entity.equip.EquipFixtureStackParamVo;

@Service
public class EquipFixtureStackServiceImpl extends BaseServiceImpl<EquipFixtureStack> implements EquipFixtureStackService {
	@Autowired
	private EquipFixtureStackDao equipFixtureStackDao;
	
	@Override
	public BaseDao<EquipFixtureStack> getBaseDao() {
		return equipFixtureStackDao;
	}	
	
	@Override
	public Class<EquipFixtureStack> getEntityClass() {
		return EquipFixtureStack.class;
	}
	
	@Override
	protected EquipFixtureStack insertEntity(EquipFixtureStack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureStack updatePartEntity(EquipFixtureStack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipFixtureStack updateEntity(EquipFixtureStack entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public EquipFixtureStack getByStackCode(String stackCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipFixtureStack> list = new ArrayList<EquipFixtureStack>();
		EquipFixtureStackParamVo param = new EquipFixtureStackParamVo();
		param.setTenantId(commonParam.getTenantId());
		param.setFixtureStackCode(stackCode);
		list = equipFixtureStackDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}					
}
