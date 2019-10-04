package com.techsoft.client.service.alarm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.entity.alarm.AlarmProblemVo;
import com.techsoft.entity.alarm.AlarmProblemParamVo;

public interface ClientAlarmProblemService extends BaseClientService<AlarmProblem> {

	public AlarmProblemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmProblemVo> selectListVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmProblemVo> selectPageVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public AlarmProblemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<AlarmProblemVo> selectListExtendVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<AlarmProblemVo> selectPageExtendVoByParamVo(AlarmProblemParamVo alarmProblem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(AlarmProblemParamVo alarmProblemParamVo, CommonParam commonParam);
}
