package com.techsoft.dao.work;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.mapper.work.WorkTaskProcedureMapper;

@Repository
public class WorkTaskProcedureDaoImpl extends BaseDaoImpl<WorkTaskProcedure> implements WorkTaskProcedureDao {
	@Resource
	protected WorkTaskProcedureMapper workTaskProcedureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WorkTaskProcedure> getEntityClass() {
		return WorkTaskProcedure.class;
	}	
	
	@Override
	public BaseMapper<WorkTaskProcedure> getBaseMapper() {
		return this.workTaskProcedureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WORK_TASK_PROCEDURE";
	}
	
	@Override
	public void insertSaveCheck(WorkTaskProcedure value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WorkTaskProcedure value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WorkTaskProcedure value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatch(List<WorkTaskProcedure> items, CommonParam commonParam)
			throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		int rows = workTaskProcedureMapper.insertBatch(items);
		if (rows != items.size()) {
			throw new BusinessException("新增行数不一致！请检查");
		}
	}
			
}
