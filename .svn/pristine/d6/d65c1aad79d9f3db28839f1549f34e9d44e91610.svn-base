package com.techsoft.client.service.stats;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.stats.StatsProductMaterialVo;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;

public interface ClientStatsProductMaterialService extends BaseClientService<StatsProductMaterial> {
	
	public StatsProductMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StatsProductMaterialVo>  selectListVoByParamVo(StatsProductMaterialParamVo statsProductMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StatsProductMaterialVo>  selectPageVoByParamVo(StatsProductMaterialParamVo statsProductMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StatsProductMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StatsProductMaterialVo>  selectListExtendVoByParamVo(StatsProductMaterialParamVo statsProductMaterial, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StatsProductMaterialVo>  selectPageExtendVoByParamVo(StatsProductMaterialParamVo statsProductMaterial, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StatsProductMaterialParamVo statsProductMaterialParamVo, CommonParam commonParam);		

	public List<StatsProductMaterialVo> selectListByProductSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo,CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StatsProductMaterialVo> selectListByMaterialSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo,CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StatsProductMaterial> selectListByDataSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo,CommonParam commonParam) throws BusinessException, SQLException;

}
