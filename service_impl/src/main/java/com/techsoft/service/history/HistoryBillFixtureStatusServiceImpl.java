package com.techsoft.service.history;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.HistoryBillFixtureStatus;
import com.techsoft.dao.history.HistoryBillFixtureStatusDao;

@Service
public class HistoryBillFixtureStatusServiceImpl extends BaseServiceImpl<HistoryBillFixtureStatus> implements HistoryBillFixtureStatusService {
	@Autowired
	private HistoryBillFixtureStatusDao historyBillFixtureStatusDao;
	
	@Override
	public BaseDao<HistoryBillFixtureStatus> getBaseDao() {
		return historyBillFixtureStatusDao;
	}	
	
	@Override
	public Class<HistoryBillFixtureStatus> getEntityClass() {
		return HistoryBillFixtureStatus.class;
	}
	
	@Override
	protected HistoryBillFixtureStatus insertEntity(HistoryBillFixtureStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillFixtureStatus updatePartEntity(HistoryBillFixtureStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillFixtureStatus updateEntity(HistoryBillFixtureStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
