package com.techsoft.dao.history;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.HistoryBillStatusAudit;

public interface HistoryBillStatusAuditDao extends BaseDao<HistoryBillStatusAudit> {
	/**
	 * 单据审批记录插入方法
	 * @author Xiang
	 * @param billType
	 * @param billStatus
	 * @param billId
	 * @param commonParam
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public ResultMessage billHistoryInsert(Long billType, Long billStatus, Long billId, String billCode,CommonParam commonParam)
			throws BusinessException, SQLException;


}
