package com.techsoft.service.work;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.dao.work.WorkPlanEquipFixtureDao;

@Service
public class WorkPlanEquipFixtureServiceImpl extends BaseServiceImpl<WorkPlanEquipFixture> implements WorkPlanEquipFixtureService {
	@Autowired
	private WorkPlanEquipFixtureDao workPlanEquipFixtureDao;
	
	@Override
	public BaseDao<WorkPlanEquipFixture> getBaseDao() {
		return workPlanEquipFixtureDao;
	}	
	
	@Override
	public Class<WorkPlanEquipFixture> getEntityClass() {
		return WorkPlanEquipFixture.class;
	}
	
	@Override
	protected WorkPlanEquipFixture insertEntity(WorkPlanEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanEquipFixture updatePartEntity(WorkPlanEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanEquipFixture updateEntity(WorkPlanEquipFixture entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
