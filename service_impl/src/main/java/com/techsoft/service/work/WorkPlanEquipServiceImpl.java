package com.techsoft.service.work;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumWorkPlanStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.dao.work.WorkPlanEquipDao;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.work.WorkPlanEquipParamVo;

@Service
public class WorkPlanEquipServiceImpl extends BaseServiceImpl<WorkPlanEquip> implements WorkPlanEquipService {
	@Autowired
	private WorkPlanEquipDao workPlanEquipDao;
	
	@Override
	public BaseDao<WorkPlanEquip> getBaseDao() {
		return workPlanEquipDao;
	}	
	
	@Override
	public Class<WorkPlanEquip> getEntityClass() {
		return WorkPlanEquip.class;
	}
	
	@Override
	protected WorkPlanEquip insertEntity(WorkPlanEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanEquip updatePartEntity(WorkPlanEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanEquip updateEntity(WorkPlanEquip entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public List<WorkPlanEquip> selectListCanWorking(WorkPlanEquipParamVo workPlanEquipParamVo, CommonParam commonParam)
			throws BusinessException, SQLException {
	 
		return workPlanEquipDao.selectListCanWorking(workPlanEquipParamVo, commonParam);
	}					
}
