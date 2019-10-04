package com.techsoft.service.history;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.HistoryInventoryLocation;
import com.techsoft.dao.history.HistoryInventoryLocationDao;

@Service
public class HistoryInventoryLocationServiceImpl extends BaseServiceImpl<HistoryInventoryLocation> implements HistoryInventoryLocationService {
	@Autowired
	private HistoryInventoryLocationDao historyInventoryLocationDao;
	
	@Override
	public BaseDao<HistoryInventoryLocation> getBaseDao() {
		return historyInventoryLocationDao;
	}	
	
	@Override
	public Class<HistoryInventoryLocation> getEntityClass() {
		return HistoryInventoryLocation.class;
	}
	
	@Override
	protected HistoryInventoryLocation insertEntity(HistoryInventoryLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected HistoryInventoryLocation updatePartEntity(HistoryInventoryLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected HistoryInventoryLocation updateEntity(HistoryInventoryLocation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
