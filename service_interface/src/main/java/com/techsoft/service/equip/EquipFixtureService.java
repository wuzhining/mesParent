package com.techsoft.service.equip;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.EquipFixture;

public interface EquipFixtureService extends BaseService<EquipFixture> {

	public EquipFixture getByFixtureCode(String fixtureCode, CommonParam commonParam) throws BusinessException, SQLException;
}
