package com.techsoft.service.equip;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.EquipFixture; 
import com.techsoft.entity.equip.EquipFixtureParamVo;
import com.techsoft.dao.equip.EquipFixtureDao;

@Service
public class EquipFixtureServiceImpl extends BaseServiceImpl<EquipFixture> implements EquipFixtureService {
	@Autowired
	private EquipFixtureDao equipFixtureDao;
	
	@Override
	public BaseDao<EquipFixture> getBaseDao() {
		return equipFixtureDao;
	}	
	
	@Override
	public Class<EquipFixture> getEntityClass() {
		return EquipFixture.class;
	}
	
	@Override
	protected EquipFixture insertEntity(EquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipFixture updatePartEntity(EquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipFixture updateEntity(EquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public EquipFixture getByFixtureCode(String fixtureCode, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixture> list = new ArrayList<EquipFixture>();
		EquipFixtureParamVo param = new EquipFixtureParamVo();
		param.setTenantId(commonParam.getTenantId());
		param.setFixtureCode(fixtureCode);
		list = equipFixtureDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}					
}
