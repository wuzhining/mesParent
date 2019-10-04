package com.techsoft.dao.history;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.common.HistoryBillStatusAudit;
import com.techsoft.entity.history.HistoryBillStatusAuditParamVo;
import com.techsoft.entity.history.HistoryBillStatusParamVo;
import com.techsoft.mapper.history.HistoryBillStatusAuditMapper;

@Repository
public class HistoryBillStatusAuditDaoImpl extends BaseDaoImpl<HistoryBillStatusAudit> implements HistoryBillStatusAuditDao {
	@Resource
	protected HistoryBillStatusAuditMapper historyBillStatusAuditMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<HistoryBillStatusAudit> getEntityClass() {
		return HistoryBillStatusAudit.class;
	}	
	
	@Override
	public BaseMapper<HistoryBillStatusAudit> getBaseMapper() {
		return this.historyBillStatusAuditMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "HISTORY_BILL_STATUS_AUDIT";
	}
	
	@Override
	public void insertSaveCheck(HistoryBillStatusAudit value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(HistoryBillStatusAudit value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(HistoryBillStatusAudit value) throws BusinessException, SQLException {
	
	}

	@Override
	public ResultMessage billHistoryInsert(Long billType, Long billStatus, Long billId,String billCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		 
		ResultMessage resultMessage = new ResultMessage();

		List<HistoryBillStatusAudit> list=new ArrayList<HistoryBillStatusAudit>();
		HistoryBillStatusAuditParamVo paramVo=new HistoryBillStatusAuditParamVo();
		paramVo.setBillId(billId);
		paramVo.setAuditStatusDictId(billStatus);
		paramVo.setBillTypeDictId(billType);
		list=historyBillStatusAuditMapper.selectListByEntityParamVo(paramVo);
		if (list.size()==0) {
			HistoryBillStatusAudit temp =new HistoryBillStatusAudit();
			temp.setId(historyBillStatusAuditMapper.getIDValue());
			temp.setBillId(billId);
			temp.setBillCode(billCode);
			temp.setAuditStatusDictId(billStatus);
			temp.setBillTypeDictId(billType);
			temp.setTenantId(commonParam.getTenantId());
			temp.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			temp.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			historyBillStatusAuditMapper.insertEntity(temp);
		}
		
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}
			
}
