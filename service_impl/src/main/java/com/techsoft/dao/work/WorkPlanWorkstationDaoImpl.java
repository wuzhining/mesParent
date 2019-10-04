package com.techsoft.dao.work;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.mapper.work.WorkPlanWorkstationMapper;

@Repository
public class WorkPlanWorkstationDaoImpl extends BaseDaoImpl<WorkPlanWorkstation> implements WorkPlanWorkstationDao {
	@Resource
	protected WorkPlanWorkstationMapper workPlanWorkstationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WorkPlanWorkstation> getEntityClass() {
		return WorkPlanWorkstation.class;
	}	
	
	@Override
	public BaseMapper<WorkPlanWorkstation> getBaseMapper() {
		return this.workPlanWorkstationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WORK_PLAN_WORKSTATION";
	}
	
	@Override
	public void insertSaveCheck(WorkPlanWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WorkPlanWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WorkPlanWorkstation value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatch(List<WorkPlanWorkstation> items, CommonParam commonParam)
			throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		int rows = workPlanWorkstationMapper.insertBatch(items);
		if (rows != items.size()) {
			throw new BusinessException("新增行数不一致！请检查");
		}
	}
			
}
