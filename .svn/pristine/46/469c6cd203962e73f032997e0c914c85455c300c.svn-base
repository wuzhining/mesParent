package com.techsoft.client.service.alarm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AlarmReason;
import com.techsoft.entity.alarm.AlarmReasonVo;
import com.techsoft.entity.alarm.AlarmReasonParamVo;

public interface ClientAlarmReasonService extends BaseClientService<AlarmReason> {

	public AlarmReasonVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmReasonVo> selectListVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmReasonVo> selectPageVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AlarmReasonVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmReasonVo> selectListExtendVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmReasonVo> selectPageExtendVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AlarmReasonParamVo alarmReasonParamVo, CommonParam commonParam);
}
