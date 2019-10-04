package com.techsoft.service.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;
import com.techsoft.dao.stats.StatsProductMaterialDao;

@Service
public class StatsProductMaterialServiceImpl extends BaseServiceImpl<StatsProductMaterial> implements StatsProductMaterialService {
	@Autowired
	private StatsProductMaterialDao statsProductMaterialDao;
	
	@Override
	public BaseDao<StatsProductMaterial> getBaseDao() {
		return statsProductMaterialDao;
	}	
	
	@Override
	public Class<StatsProductMaterial> getEntityClass() {
		return StatsProductMaterial.class;
	}
	
	@Override
	protected StatsProductMaterial insertEntity(StatsProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StatsProductMaterial updatePartEntity(StatsProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StatsProductMaterial updateEntity(StatsProductMaterial entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
	
	@Override
	public List<StatsProductMaterial> selectListByProductSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException{
		return statsProductMaterialDao.selectListByProductSumStats(statsProductMaterialParamVo);
	}
	
	@Override
	public List<StatsProductMaterial> selectListByMaterialSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException{
		return statsProductMaterialDao.selectListByMaterialSumStats(statsProductMaterialParamVo);
	}
	
	@Override
	public List<StatsProductMaterial> selectListByDataSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException{
		return statsProductMaterialDao.selectListByDataSumStats(statsProductMaterialParamVo);
	}
	
	@Override
	public StatsProductMaterial saveOrUpdate(StatsProductMaterial statsProductMaterial,CommonParam commonParam) throws BusinessException, SQLException{
		return statsProductMaterialDao.saveOrUpdate(statsProductMaterial, commonParam);
		
	}
					
}
