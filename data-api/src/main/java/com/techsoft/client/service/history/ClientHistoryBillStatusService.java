package com.techsoft.client.service.history;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.history.HistoryBillStatusVo;
import com.techsoft.entity.history.HistoryBillStatusParamVo;

public interface ClientHistoryBillStatusService extends BaseClientService<HistoryBillStatus> {

	public HistoryBillStatusVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<HistoryBillStatusVo> selectListVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<HistoryBillStatusVo> selectPageVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public HistoryBillStatusVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<HistoryBillStatusVo> selectListExtendVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<HistoryBillStatusVo> selectPageExtendVoByParamVo(HistoryBillStatusParamVo historyBillStatus,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(HistoryBillStatusParamVo historyBillStatusParamVo, CommonParam commonParam);
}
