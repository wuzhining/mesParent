package com.techsoft.service.struct;

import com.techsoft.common.BaseService;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StructProcedureInstruct;

public interface StructProcedureInstructService extends BaseService<StructProcedureInstruct> {
    public StructProcedureInstruct getByType(CommonParam commonParam,Long processNodeId,Long instructTypeDictId)  throws SQLException ;
}
