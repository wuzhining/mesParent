package com.techsoft.mapper.work;

import java.util.List;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanMaterial;

public interface WorkPlanMaterialMapper extends BaseMapper<WorkPlanMaterial> {
	public void updateBacth(List<WorkPlanMaterial> list) throws BusinessException, SQLException;
	
	public int insertBatch(List<WorkPlanMaterial> list) throws BusinessException, SQLException;
}
