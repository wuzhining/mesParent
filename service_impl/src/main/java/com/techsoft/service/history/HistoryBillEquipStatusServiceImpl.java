package com.techsoft.service.history;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.HistoryBillEquipStatus;
import com.techsoft.dao.history.HistoryBillEquipStatusDao;

@Service
public class HistoryBillEquipStatusServiceImpl extends BaseServiceImpl<HistoryBillEquipStatus> implements HistoryBillEquipStatusService {
	@Autowired
	private HistoryBillEquipStatusDao historyBillEquipStatusDao;
	
	@Override
	public BaseDao<HistoryBillEquipStatus> getBaseDao() {
		return historyBillEquipStatusDao;
	}	
	
	@Override
	public Class<HistoryBillEquipStatus> getEntityClass() {
		return HistoryBillEquipStatus.class;
	}
	
	@Override
	protected HistoryBillEquipStatus insertEntity(HistoryBillEquipStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillEquipStatus updatePartEntity(HistoryBillEquipStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillEquipStatus updateEntity(HistoryBillEquipStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
