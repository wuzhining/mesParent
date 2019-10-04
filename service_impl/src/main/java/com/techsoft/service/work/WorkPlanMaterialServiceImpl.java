package com.techsoft.service.work;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.dao.work.WorkPlanMaterialDao;

@Service
public class WorkPlanMaterialServiceImpl extends BaseServiceImpl<WorkPlanMaterial> implements WorkPlanMaterialService {
	@Autowired
	private WorkPlanMaterialDao workPlanMaterialDao;
	
	@Override
	public BaseDao<WorkPlanMaterial> getBaseDao() {
		return workPlanMaterialDao;
	}	
	
	@Override
	public Class<WorkPlanMaterial> getEntityClass() {
		return WorkPlanMaterial.class;
	}
	
	@Override
	protected WorkPlanMaterial insertEntity(WorkPlanMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanMaterial updatePartEntity(WorkPlanMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanMaterial updateEntity(WorkPlanMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
