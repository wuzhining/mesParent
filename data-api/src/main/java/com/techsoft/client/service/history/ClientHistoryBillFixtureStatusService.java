package com.techsoft.client.service.history;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.HistoryBillFixtureStatus;
import com.techsoft.entity.history.HistoryBillFixtureStatusVo;
import com.techsoft.entity.history.HistoryBillFixtureStatusParamVo;

public interface ClientHistoryBillFixtureStatusService extends BaseClientService<HistoryBillFixtureStatus> {

	public HistoryBillFixtureStatusVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<HistoryBillFixtureStatusVo> selectListVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<HistoryBillFixtureStatusVo> selectPageVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public HistoryBillFixtureStatusVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<HistoryBillFixtureStatusVo> selectListExtendVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<HistoryBillFixtureStatusVo> selectPageExtendVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(HistoryBillFixtureStatusParamVo historyBillFixtureStatusParamVo,
			CommonParam commonParam);
}
