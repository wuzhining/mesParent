package com.techsoft.client.service.alarm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AlarmLevel;
import com.techsoft.entity.alarm.AlarmLevelVo;
import com.techsoft.entity.alarm.AlarmLevelParamVo;

public interface ClientAlarmLevelService extends BaseClientService<AlarmLevel> {

	public AlarmLevelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmLevelVo> selectListVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmLevelVo> selectPageVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AlarmLevelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmLevelVo> selectListExtendVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmLevelVo> selectPageExtendVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AlarmLevelParamVo alarmLevelParamVo, CommonParam commonParam);
}
