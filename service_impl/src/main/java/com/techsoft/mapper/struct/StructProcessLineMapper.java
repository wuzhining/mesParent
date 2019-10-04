package com.techsoft.mapper.struct;

import java.util.List;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StructProcessLine;

public interface StructProcessLineMapper extends BaseMapper<StructProcessLine> {
	
	public int insertBatch(List<StructProcessLine> list) throws BusinessException, SQLException;
	
	public int updateBatch(List<StructProcessLine> list) throws BusinessException, SQLException;
}
