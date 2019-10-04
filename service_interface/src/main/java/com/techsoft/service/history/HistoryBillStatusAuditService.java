package com.techsoft.service.history;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.HistoryBillStatusAudit;

public interface HistoryBillStatusAuditService extends BaseService<HistoryBillStatusAudit> {
	/**
	 * 单据审核历史状态插入方法
	 * @auther:Xiang
	 * @param billType
	 * @param billStatus
	 * @param billId
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public ResultMessage billAuditHistoryInsert(Long billType, Long billStatus, Long billId,String billCode, CommonParam commonParam)throws BusinessException, SQLException;


}
