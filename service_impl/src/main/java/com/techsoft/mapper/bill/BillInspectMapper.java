package com.techsoft.mapper.bill;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.common.BillInspect;

public interface BillInspectMapper extends BaseMapper<BillInspect> {
	public int insertBillInspectBatch(List<BillInspect> items) throws BusinessException, SQLException;
	//mine
	public List<BillInspect> selectIQCIncomeScreen(BillInspectParamVo billInspectParamVo) throws BusinessException, SQLException;

	
}
