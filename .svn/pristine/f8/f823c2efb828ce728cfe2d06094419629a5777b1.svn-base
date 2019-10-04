package com.techsoft.dao.history;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.HistoryBillEquipStatus;
import com.techsoft.mapper.history.HistoryBillEquipStatusMapper;

@Repository
public class HistoryBillEquipStatusDaoImpl extends BaseDaoImpl<HistoryBillEquipStatus> implements HistoryBillEquipStatusDao {
	@Resource
	protected HistoryBillEquipStatusMapper historyBillEquipStatusMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<HistoryBillEquipStatus> getEntityClass() {
		return HistoryBillEquipStatus.class;
	}	
	
	@Override
	public BaseMapper<HistoryBillEquipStatus> getBaseMapper() {
		return this.historyBillEquipStatusMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "HISTORY_BILL_EQUIP_STATUS";
	}
	
	@Override
	public void insertSaveCheck(HistoryBillEquipStatus value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(HistoryBillEquipStatus value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(HistoryBillEquipStatus value) throws BusinessException, SQLException {
	
	}
			
}
