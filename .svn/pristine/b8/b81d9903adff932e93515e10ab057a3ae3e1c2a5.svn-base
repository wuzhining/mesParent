package com.techsoft.dao.alarm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AlarmGroupUser;
import com.techsoft.mapper.alarm.AlarmGroupUserMapper;

@Repository
public class AlarmGroupUserDaoImpl extends BaseDaoImpl<AlarmGroupUser> implements AlarmGroupUserDao {
	@Resource
	protected AlarmGroupUserMapper alarmGroupUserMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AlarmGroupUser> getEntityClass() {
		return AlarmGroupUser.class;
	}	
	
	@Override
	public BaseMapper<AlarmGroupUser> getBaseMapper() {
		return this.alarmGroupUserMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ALARM_GROUP_USER";
	}
	
	@Override
	public void insertSaveCheck(AlarmGroupUser value) throws BusinessException, SQLException {
		if(value.getUserId() == null && value.getUserId().equals(0L)){
			throw new BusinessException("用户id不能为空");
		}
		
		if(value.getAlarmGroupDictId() == null && value.getAlarmGroupDictId().equals(0L)){
			throw new BusinessException("报警群组岗位不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(AlarmGroupUser value) throws BusinessException, SQLException {
		if(value.getUserId() == null && value.getUserId().equals(0L)){
			throw new BusinessException("用户id不能为空");
		}
		
		if(value.getAlarmGroupDictId() == null && value.getAlarmGroupDictId().equals(0L)){
			throw new BusinessException("报警群组岗位不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(AlarmGroupUser value) throws BusinessException, SQLException {
	
	}
			
}
