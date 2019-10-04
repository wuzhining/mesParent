package com.techsoft.client.service.history;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.HistoryBillEquipStatus;
import com.techsoft.entity.history.HistoryBillEquipStatusVo;
import com.techsoft.entity.history.HistoryBillEquipStatusParamVo;

public interface ClientHistoryBillEquipStatusService extends BaseClientService<HistoryBillEquipStatus> {
	
	public HistoryBillEquipStatusVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryBillEquipStatusVo>  selectListVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryBillEquipStatusVo>  selectPageVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public HistoryBillEquipStatusVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryBillEquipStatusVo>  selectListExtendVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryBillEquipStatusVo>  selectPageExtendVoByParamVo(HistoryBillEquipStatusParamVo historyBillEquipStatus, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(HistoryBillEquipStatusParamVo historyBillEquipStatusParamVo, CommonParam commonParam);		
}
