package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillInspectVo;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouseItem;

public interface BillInspectService extends BaseService<BillInspect> {
	

	public ResultMessage updateInspectOKorNG(BillInspectParamVo billInspectVo, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillInspect> selectIQCIncomeScreen()throws BusinessException, SQLException;

}
