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
import com.techsoft.dao.work.WorkPlanWorkstationDao;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;

@Service
public class WorkPlanWorkstationServiceImpl extends BaseServiceImpl<WorkPlanWorkstation>
		implements WorkPlanWorkstationService {
	@Autowired
	private WorkPlanWorkstationDao workPlanWorkstationDao;

	@Override
	public BaseDao<WorkPlanWorkstation> getBaseDao() {
		return workPlanWorkstationDao;
	}

	@Override
	public Class<WorkPlanWorkstation> getEntityClass() {
		return WorkPlanWorkstation.class;
	}

	@Override
	protected WorkPlanWorkstation insertEntity(WorkPlanWorkstation entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanWorkstation updatePartEntity(WorkPlanWorkstation entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WorkPlanWorkstation updateEntity(WorkPlanWorkstation entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public List<WorkPlanWorkstation> selectListCanWorking(WorkPlanWorkstationParamVo workPlanWorkstationParamVo,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (workPlanWorkstationParamVo == null) {
			workPlanWorkstationParamVo = new WorkPlanWorkstationParamVo();
			workPlanWorkstationParamVo.setTenantId(commonParam.getTenantId());
		}
		List<WorkPlanWorkstation> list = new ArrayList<WorkPlanWorkstation>();
		workPlanWorkstationParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
		workPlanWorkstationParamVo.setPlanStatusDictId(EnumWorkPlanStatus.NOTSTARTED.getValue());// 未开始
		List<WorkPlanWorkstation> list1 = workPlanWorkstationDao.selectListByParamVo(workPlanWorkstationParamVo);
		if ((list1 != null) && (!list1.isEmpty())) {
			list.addAll(list1);
		}

		workPlanWorkstationParamVo.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());// 进行中的
		List<WorkPlanWorkstation> list2 = workPlanWorkstationDao.selectListByParamVo(workPlanWorkstationParamVo);
		if ((list2 != null) && (!list2.isEmpty())) {
			list.addAll(list2);
		}
		return list;
	}
}
