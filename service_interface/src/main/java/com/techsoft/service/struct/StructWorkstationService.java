package com.techsoft.service.struct;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StructWorkstation;

public interface StructWorkstationService extends BaseService<StructWorkstation> {

	public StructWorkstation getByCode(String workstationCode, CommonParam commonParam) throws BusinessException, SQLException;
}
