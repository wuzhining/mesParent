package com.techsoft.mapper.stats;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;

public interface StatsProductMaterialMapper extends BaseMapper<StatsProductMaterial> {
	
	public List<StatsProductMaterial> selectListByProductSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException;
	
	public List<StatsProductMaterial> selectListByMaterialSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException;
	
	public List<StatsProductMaterial> selectListByDataSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException;
	
}
