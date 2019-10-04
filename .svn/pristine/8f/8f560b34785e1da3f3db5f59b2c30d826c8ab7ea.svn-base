package com.techsoft.dao.bill;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillInspectVo;
import com.techsoft.entity.common.BillInspect;

public interface BillInspectDao extends BaseDao<BillInspect> {
	/**
	*@auther:Chenzj
	*@version:2019年5月15日下午3:46:39
	*@param:List<BillInspect> 检验单明细集合
	*@description 用于检验单明细批量新增
	*/
	public void insertBillInspectBatch(List<BillInspect> items, CommonParam commonParam) throws BusinessException, SQLException;

	public void updateInspectBillStatus(BillInspectParamVo billInspectVo, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillInspect> selectIQCIncomeScreen()throws BusinessException, SQLException;



}
