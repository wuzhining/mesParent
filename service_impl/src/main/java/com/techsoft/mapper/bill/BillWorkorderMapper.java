package com.techsoft.mapper.bill;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BillWorkorder;

public interface BillWorkorderMapper extends BaseMapper<BillWorkorder> {
	
	public int updateBatch(BillWorkorder BillWorkorder) throws BusinessException, SQLException;
	
}
