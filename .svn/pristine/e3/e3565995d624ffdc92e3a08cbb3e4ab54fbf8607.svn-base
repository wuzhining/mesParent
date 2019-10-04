package com.techsoft.service.history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.history.HistoryBillStatusParamVo;
import com.techsoft.dao.history.HistoryBillStatusDao;

@Service
public class HistoryBillStatusServiceImpl extends BaseServiceImpl<HistoryBillStatus> implements HistoryBillStatusService {
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;
	
	@Override
	public BaseDao<HistoryBillStatus> getBaseDao() {
		return historyBillStatusDao;
	}	
	
	@Override
	public Class<HistoryBillStatus> getEntityClass() {
		return HistoryBillStatus.class;
	}
	
	@Override
	protected HistoryBillStatus insertEntity(HistoryBillStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillStatus updatePartEntity(HistoryBillStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected HistoryBillStatus updateEntity(HistoryBillStatus entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}
	
	
	@Override
	public  ResultMessage billHistoryInsert(Long billType,Long billStatus,Long billId,String billCode, CommonParam commonParam) throws BusinessException, SQLException  {
		ResultMessage resultMessage = new ResultMessage();
		List<HistoryBillStatus> list=new ArrayList<HistoryBillStatus>();
		HistoryBillStatusParamVo paramVo=new HistoryBillStatusParamVo();
		paramVo.setBillId(billId);
		paramVo.setBillCode(billCode);
		paramVo.setBillStatusDictId(billStatus);
		paramVo.setBillTypeDictId(billType);
		list=historyBillStatusDao.selectListByParamVo(paramVo);
		
		if (list.size()==0) {
			HistoryBillStatus temp =new HistoryBillStatus();
			temp.setId(historyBillStatusDao.getIdValue());
			temp.setBillId(billId);
			temp.setBillCode(billCode);
			temp.setBillStatusDictId(billStatus);
			temp.setBillTypeDictId(billType);
			temp.setTenantId(commonParam.getTenantId());
			temp.setCreateUserId(Long.valueOf(commonParam.getUserId()));
			temp.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			historyBillStatusDao.insertEntity(temp, commonParam);
		}
		
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}
}
