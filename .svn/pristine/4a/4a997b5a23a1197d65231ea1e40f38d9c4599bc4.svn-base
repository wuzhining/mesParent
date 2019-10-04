package com.techsoft.client.service.history;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.HistoryBillStatusAudit;
import com.techsoft.entity.history.HistoryBillStatusAuditVo;
import com.techsoft.entity.history.HistoryBillStatusAuditParamVo;

public interface ClientHistoryBillStatusAuditService extends BaseClientService<HistoryBillStatusAudit> {
	
	public HistoryBillStatusAuditVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryBillStatusAuditVo>  selectListVoByParamVo(HistoryBillStatusAuditParamVo historyBillStatusAudit, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryBillStatusAuditVo>  selectPageVoByParamVo(HistoryBillStatusAuditParamVo historyBillStatusAudit, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public HistoryBillStatusAuditVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryBillStatusAuditVo>  selectListExtendVoByParamVo(HistoryBillStatusAuditParamVo historyBillStatusAudit, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryBillStatusAuditVo>  selectPageExtendVoByParamVo(HistoryBillStatusAuditParamVo historyBillStatusAudit, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(HistoryBillStatusAuditParamVo historyBillStatusAuditParamVo, CommonParam commonParam);		
}
