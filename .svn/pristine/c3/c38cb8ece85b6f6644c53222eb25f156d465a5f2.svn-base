package com.techsoft.dao.alarm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.mapper.alarm.AlarmProblemMapper;

@Repository
public class AlarmProblemDaoImpl extends BaseDaoImpl<AlarmProblem> implements AlarmProblemDao {
	@Resource
	protected AlarmProblemMapper alarmProblemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AlarmProblem> getEntityClass() {
		return AlarmProblem.class;
	}	
	
	@Override
	public BaseMapper<AlarmProblem> getBaseMapper() {
		return this.alarmProblemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ALARM_PROBLEM";
	}
	
	@Override
	public void insertSaveCheck(AlarmProblem value) throws BusinessException, SQLException {
		if(value.getProblem() == null && value.getProblem().equals(0L)){
			 throw new BusinessException("报警问题不能为空！");
		}
		if(value.getAlarmTypeDictId() == null && value.getAlarmTypeDictId().equals(0L)){
			throw new BusinessException("报警类型不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	
	}
	
	@Override
	public void updateSaveCheck(AlarmProblem value) throws BusinessException, SQLException {
		if(value.getProblem() == null && value.getProblem().equals(0L)){
			 throw new BusinessException("报警问题不能为空！");
		}
		if(value.getAlarmTypeDictId() == null && value.getAlarmTypeDictId().equals(0L)){
			throw new BusinessException("报警类型不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(AlarmProblem value) throws BusinessException, SQLException {
	
	}
			
}
