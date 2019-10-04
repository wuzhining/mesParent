package com.techsoft.service.equip;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.EquipWork;

public interface EquipWorkService extends BaseService<EquipWork> {

	public EquipWork getByEquipCode(String equipCode, CommonParam commonParam) throws BusinessException, SQLException;
	

	public EquipWork getByMacaddress(String macaddress, CommonParam commonParam) throws BusinessException, SQLException;
}
