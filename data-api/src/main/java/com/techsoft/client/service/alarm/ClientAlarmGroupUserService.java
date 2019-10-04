package com.techsoft.client.service.alarm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AlarmGroupUser;
import com.techsoft.entity.alarm.AlarmGroupUserVo;
import com.techsoft.entity.alarm.AlarmGroupUserParamVo;

public interface ClientAlarmGroupUserService extends BaseClientService<AlarmGroupUser> {

	public AlarmGroupUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmGroupUserVo> selectListVoByParamVo(AlarmGroupUserParamVo alarmGroupUser, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmGroupUserVo> selectPageVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public AlarmGroupUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmGroupUserVo> selectListExtendVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AlarmGroupUserVo> selectPageExtendVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AlarmGroupUserParamVo alarmGroupUserParamVo, CommonParam commonParam);
}
