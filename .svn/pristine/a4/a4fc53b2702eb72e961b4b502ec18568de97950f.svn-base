package com.techsoft.dao.history;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.HistoryBillFixtureStatus;
import com.techsoft.mapper.history.HistoryBillFixtureStatusMapper;

@Repository
public class HistoryBillFixtureStatusDaoImpl extends BaseDaoImpl<HistoryBillFixtureStatus> implements HistoryBillFixtureStatusDao {
	@Resource
	protected HistoryBillFixtureStatusMapper historyBillFixtureStatusMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<HistoryBillFixtureStatus> getEntityClass() {
		return HistoryBillFixtureStatus.class;
	}	
	
	@Override
	public BaseMapper<HistoryBillFixtureStatus> getBaseMapper() {
		return this.historyBillFixtureStatusMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "HISTORY_BILL_FIXTURE_STATUS";
	}
	
	@Override
	public void insertSaveCheck(HistoryBillFixtureStatus value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(HistoryBillFixtureStatus value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(HistoryBillFixtureStatus value) throws BusinessException, SQLException {
	
	}
			
}
