package com.techsoft.dao.work;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.mapper.work.WorkPlanEquipFixtureMapper;

@Repository
public class WorkPlanEquipFixtureDaoImpl extends BaseDaoImpl<WorkPlanEquipFixture> implements WorkPlanEquipFixtureDao {
	@Resource
	protected WorkPlanEquipFixtureMapper workPlanEquipFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WorkPlanEquipFixture> getEntityClass() {
		return WorkPlanEquipFixture.class;
	}	
	
	@Override
	public BaseMapper<WorkPlanEquipFixture> getBaseMapper() {
		return this.workPlanEquipFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WORK_PLAN_EQUIP_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(WorkPlanEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WorkPlanEquipFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WorkPlanEquipFixture value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatch(List<WorkPlanEquipFixture> items, CommonParam commonParam) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		int rows = workPlanEquipFixtureMapper.insertBatch(items);
		if (rows != items.size()) {
			throw new BusinessException("新增行数不一致！请检查");
		}
	}		
}
