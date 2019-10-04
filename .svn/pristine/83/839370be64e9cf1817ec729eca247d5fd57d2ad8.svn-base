package com.techsoft.client.service.alarm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AlarmInforFlow;
import com.techsoft.entity.alarm.AlarmInforFlowVo;
import com.techsoft.entity.alarm.AlarmInforFlowParamVo;

public interface ClientAlarmInforFlowService extends BaseClientService<AlarmInforFlow> {

	public AlarmInforFlowVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmInforFlowVo> selectListVoByParamVo(AlarmInforFlowParamVo alarmInforFlow, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmInforFlowVo> selectPageVoByParamVo(AlarmInforFlowParamVo alarmInforFlow,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public AlarmInforFlowVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmInforFlowVo> selectListExtendVoByParamVo(AlarmInforFlowParamVo alarmInforFlow,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<AlarmInforFlowVo> selectPageExtendVoByParamVo(AlarmInforFlowParamVo alarmInforFlow,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AlarmInforFlowParamVo alarmInforFlowParamVo, CommonParam commonParam);
}
