package com.techsoft.service.equip;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.EquipWorkStack;

public interface EquipWorkStackService extends BaseService<EquipWorkStack> {

	public EquipWorkStack getByStackCode(String stackCode, CommonParam commonParam) throws BusinessException, SQLException;
}
