package com.techsoft.dao.alarm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AlarmLevel;
import com.techsoft.mapper.alarm.AlarmLevelMapper;

@Repository
public class AlarmLevelDaoImpl extends BaseDaoImpl<AlarmLevel> implements AlarmLevelDao {
	@Resource
	protected AlarmLevelMapper alarmLevelMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AlarmLevel> getEntityClass() {
		return AlarmLevel.class;
	}	
	
	@Override
	public BaseMapper<AlarmLevel> getBaseMapper() {
		return this.alarmLevelMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ALARM_LEVEL";
	}
	
	@Override
	public void insertSaveCheck(AlarmLevel value) throws BusinessException, SQLException {
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			 throw new BusinessException("报警问题名称不能为空！");
		}
		if(value.getMinuteRespond() == null){
			throw new BusinessException("响应分钟数不能为空");
		}
		
		if(value.getMinuteDeal() == null){
			throw new BusinessException("处理分钟数不能为空");
		}
		
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	
	}
	
	@Override
	public void updateSaveCheck(AlarmLevel value) throws BusinessException, SQLException {
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			 throw new BusinessException("报警问题名称不能为空！");
		}
		if(value.getMinuteRespond() == null){
			throw new BusinessException("响应分钟数不能为空");
		}
		
		if(value.getMinuteDeal() == null){
			throw new BusinessException("处理分钟数不能为空");
		}
		
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(AlarmLevel value) throws BusinessException, SQLException {
	
	}
			
}
