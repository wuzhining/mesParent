package com.techsoft.service.stats;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;

public interface StatsProductMaterialService extends BaseService<StatsProductMaterial> {

	public List<StatsProductMaterial> selectListByProductSumStats(
			StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException;

	public List<StatsProductMaterial> selectListByMaterialSumStats(
			StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException;

	public List<StatsProductMaterial> selectListByDataSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo)
			throws BusinessException, SQLException;


	 /** 每个单据结束后，调用该方法统计汇总
	 *  （ tenant_id,  productId,   materialId,   billTypeDictId,  quantity） 为必传参数
	 *   factoryId在销售单、采购单等不需要传，其它单 为必传参数
	 *   quantityOther 可选参数
	 */
	public StatsProductMaterial saveOrUpdate(StatsProductMaterial statsProductMaterial,CommonParam commonParam) throws BusinessException, SQLException;
}
