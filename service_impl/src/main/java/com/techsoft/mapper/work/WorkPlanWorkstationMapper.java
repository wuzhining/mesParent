package com.techsoft.mapper.work;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkPlanWorkstation;

public interface WorkPlanWorkstationMapper extends BaseMapper<WorkPlanWorkstation> {
	public int insertBatch(List<WorkPlanWorkstation> list) throws BusinessException, SQLException;
}
