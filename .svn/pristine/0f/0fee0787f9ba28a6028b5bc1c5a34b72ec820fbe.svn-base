package com.techsoft.client.service.history;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.HistoryInventoryLocation;
import com.techsoft.entity.history.HistoryInventoryLocationVo;
import com.techsoft.entity.history.HistoryInventoryLocationParamVo;

public interface ClientHistoryInventoryLocationService extends BaseClientService<HistoryInventoryLocation> {
	
	public HistoryInventoryLocationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryInventoryLocationVo>  selectListVoByParamVo(HistoryInventoryLocationParamVo historyInventoryLocation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryInventoryLocationVo>  selectPageVoByParamVo(HistoryInventoryLocationParamVo historyInventoryLocation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public HistoryInventoryLocationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<HistoryInventoryLocationVo>  selectListExtendVoByParamVo(HistoryInventoryLocationParamVo historyInventoryLocation, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<HistoryInventoryLocationVo>  selectPageExtendVoByParamVo(HistoryInventoryLocationParamVo historyInventoryLocation, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(HistoryInventoryLocationParamVo historyInventoryLocationParamVo, CommonParam commonParam);		
}
