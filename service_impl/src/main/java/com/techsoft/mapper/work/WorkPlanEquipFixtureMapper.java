package com.techsoft.mapper.work;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanEquipFixture;

public interface WorkPlanEquipFixtureMapper extends BaseMapper<WorkPlanEquipFixture> {

	public void updateBacth(List<WorkPlanEquipFixture> list) throws BusinessException, SQLException;
	
	public int insertBatch(List<WorkPlanEquipFixture> list) throws BusinessException, SQLException;
}
