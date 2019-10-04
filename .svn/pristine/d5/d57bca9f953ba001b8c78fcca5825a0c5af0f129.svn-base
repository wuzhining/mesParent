package com.techsoft.dao.alarm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.AlarmInforFlow;
import com.techsoft.mapper.alarm.AlarmInforFlowMapper;

@Repository
public class AlarmInforFlowDaoImpl extends BaseDaoImpl<AlarmInforFlow> implements AlarmInforFlowDao {
	@Resource
	protected AlarmInforFlowMapper alarmInforFlowMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<AlarmInforFlow> getEntityClass() {
		return AlarmInforFlow.class;
	}	
	
	@Override
	public BaseMapper<AlarmInforFlow> getBaseMapper() {
		return this.alarmInforFlowMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "ALARM_INFOR_FLOW";
	}
	
	@Override
	public void insertSaveCheck(AlarmInforFlow value) throws BusinessException, SQLException {
		if(value.getEquipWorkId() == null && value.getEquipWorkId().equals(0L)){
			 throw new BusinessException("生产设备名称不能为空！");
		}
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			throw new BusinessException("报警问题ID不能为空");
		}
		
		if(value.getAlarmLevelId() == null && value.getAlarmLevelId().equals(0L)){
			throw new BusinessException("报警等级ID不能为空");
		}
		
		if(value.getAlarmTypeDictId() == null && value.getAlarmTypeDictId().equals(0L)){
			throw new BusinessException("报警类型不能为空");
		}
		
		if(value.getStatusDictId() == null && value.getStatusDictId().equals(0L)){
			throw new BusinessException("报警状态不能为空");
		}
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("创建人不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(AlarmInforFlow value) throws BusinessException, SQLException {
		if(value.getEquipWorkId() == null && value.getEquipWorkId().equals(0L)){
			 throw new BusinessException("生产设备名称不能为空！");
		}
		if(value.getProblemId() == null && value.getProblemId().equals(0L)){
			throw new BusinessException("报警问题ID不能为空");
		}
		
		if(value.getAlarmLevelId() == null && value.getAlarmLevelId().equals(0L)){
			throw new BusinessException("报警等级ID不能为空");
		}
		
		if(value.getAlarmTypeDictId() == null && value.getAlarmTypeDictId().equals(0L)){
			throw new BusinessException("报警类型不能为空");
		}
		
		if(value.getStatusDictId() == null && value.getStatusDictId().equals(0L)){
			throw new BusinessException("报警状态不能为空");
		}
		if (value.getModifyUserId() == null || value.getModifyUserId().equals(0L)) {
			throw new BusinessException("修改人不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(AlarmInforFlow value) throws BusinessException, SQLException {
	
	}
			
}
