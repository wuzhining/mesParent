package com.techsoft.service.history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.dao.history.HistoryBillStatusAuditDao;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.common.HistoryBillStatusAudit;
import com.techsoft.entity.history.HistoryBillStatusAuditParamVo;

@Service
public class HistoryBillStatusAuditServiceImpl extends BaseServiceImpl<HistoryBillStatusAudit> implements HistoryBillStatusAuditService {
	@Autowired
	private HistoryBillStatusAuditDao historyBillStatusAuditDao;
	
	@Override
	public BaseDao<HistoryBillStatusAudit> getBaseDao() {
		return historyBillStatusAuditDao;
	}	
	
	@Override
	public Class<HistoryBillStatusAudit> getEntityClass() {
		return HistoryBillStatusAudit.class;
	}
	
	@Override
	protected HistoryBillStatusAudit insertEntity(HistoryBillStatusAudit entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillStatusAudit updatePartEntity(HistoryBillStatusAudit entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillStatusAudit updateEntity(HistoryBillStatusAudit entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public ResultMessage billAuditHistoryInsert(Long billType, Long billStatus, Long billId,String billCode, CommonParam commonParam)
			throws BusinessException, SQLException {
	
		ResultMessage resultMessage = new ResultMessage();
		List<HistoryBillStatusAudit> list=new ArrayList<HistoryBillStatusAudit>();
		HistoryBillStatusAuditParamVo paramVo=new HistoryBillStatusAuditParamVo();
		paramVo.setBillId(billId);
		paramVo.setAuditStatusDictId(billStatus);
		paramVo.setBillTypeDictId(billType);
		list=historyBillStatusAuditDao.selectListByParamVo(paramVo);
		
		if (list.size()==0) {
			HistoryBillStatusAudit temp =new HistoryBillStatusAudit();
			temp.setId(historyBillStatusAuditDao.getIdValue());
			temp.setBillId(billId);
			temp.setBillCode(billCode);
			temp.setAuditStatusDictId(billStatus);
			temp.setBillTypeDictId(billType);
			temp.setTenantId(commonParam.getTenantId());
			temp.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			temp.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			historyBillStatusAuditDao.insertEntity(temp, commonParam);
		}
		
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}					
}
