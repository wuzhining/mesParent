package com.techsoft.mapper.work;

import java.util.List;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WorkTaskProcedure;

public interface WorkTaskProcedureMapper extends BaseMapper<WorkTaskProcedure> {
	
	public int insertBatch(List<WorkTaskProcedure> list) throws BusinessException, SQLException;
	
}
