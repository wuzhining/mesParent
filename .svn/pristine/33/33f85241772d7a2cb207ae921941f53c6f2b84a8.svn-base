package com.techsoft.dao.alarm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AlarmReason;
import com.techsoft.mapper.alarm.AlarmReasonMapper;

@Repository
public class AlarmReasonDaoImpl extends BaseDaoImpl<AlarmReason> implements AlarmReasonDao {
	@Resource
	protected AlarmReasonMapper alarmReasonMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AlarmReason> getEntityClass() {
		return AlarmReason.class;
	}	
	
	@Override
	public BaseMapper<AlarmReason> getBaseMapper() {
		return this.alarmReasonMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ALARM_REASON";
	}
	
	@Override
	public void insertSaveCheck(AlarmReason value) throws BusinessException, SQLException {
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			 throw new BusinessException("报警问题名称不能为空！");
		}
		if(value.getReason() == null && value.getReason().equals(0L)){
			throw new BusinessException("原因描述不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(AlarmReason value) throws BusinessException, SQLException {
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			 throw new BusinessException("报警问题名称不能为空！");
		}
		if(value.getReason() == null && value.getReason().equals(0L)){
			throw new BusinessException("原因描述不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(AlarmReason value) throws BusinessException, SQLException {
	
	}
			
}
