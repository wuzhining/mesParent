package com.techsoft.dao.stats;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.utils.Arith;
import com.techsoft.common.utils.StringUtil;
import com.techsoft.entity.common.StatsProductMaterial;
import com.techsoft.entity.stats.StatsProductMaterialParamVo;
import com.techsoft.mapper.stats.StatsProductMaterialMapper;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;

@Repository
public class StatsProductMaterialDaoImpl extends BaseDaoImpl<StatsProductMaterial> implements StatsProductMaterialDao {
	@Resource
	protected StatsProductMaterialMapper statsProductMaterialMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<StatsProductMaterial> getEntityClass() {
		return StatsProductMaterial.class;
	}

	@Override
	public BaseMapper<StatsProductMaterial> getBaseMapper() {
		return this.statsProductMaterialMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "STATS_PRODUCT_MATERIAL";
	}

	@Override
	public void insertSaveCheck(StatsProductMaterial value) throws BusinessException, SQLException {

	}

	@Override
	public void updateSaveCheck(StatsProductMaterial value) throws BusinessException, SQLException {

	}

	@Override
	public void deleteSaveCheck(StatsProductMaterial value) throws BusinessException, SQLException {

	}

	@Override
	public List<StatsProductMaterial> selectListByProductSumStats(
			StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException {
		return statsProductMaterialMapper.selectListByProductSumStats(statsProductMaterialParamVo);
	}

	@Override
	public List<StatsProductMaterial> selectListByMaterialSumStats(
			StatsProductMaterialParamVo statsProductMaterialParamVo) throws BusinessException, SQLException {
		return statsProductMaterialMapper.selectListByMaterialSumStats(statsProductMaterialParamVo);
	}

	@Override
	public List<StatsProductMaterial> selectListByDataSumStats(StatsProductMaterialParamVo statsProductMaterialParamVo)
			throws BusinessException, SQLException {
		return statsProductMaterialMapper.selectListByDataSumStats(statsProductMaterialParamVo);
	}

	@Override
	public StatsProductMaterial saveOrUpdate(StatsProductMaterial statsProductMaterial, CommonParam commonParam)
			throws BusinessException, SQLException {

		if (commonParam == null) {
			throw new BusinessException("param不能为空 ");
		}
		if (commonParam.getTenantId() == null) {
			throw new BusinessException("param不能为空 ");
		}
		if (statsProductMaterial == null) {
			throw new BusinessException("对象不能为空 ");
		}
		if (statsProductMaterial.getProductId() == null) {
			throw new BusinessException("物品ID不能为空 ");
		}
		if (statsProductMaterial.getMaterialId() == null) {
			throw new BusinessException("物品规格ID不能为空 ");
		}
		if (statsProductMaterial.getBillTypeDictId() == null) {
			throw new BusinessException("单据ID不能为空 ");
		}
		if (statsProductMaterial.getQuantity() == null) {
			throw new BusinessException("数量不能为空 ");
		}

		DistributedLock distributedLock = LockManager.getZKDistributedLock(this.getEntityClass().getName(),
				statsProductMaterial.getMaterialId().toString());
		distributedLock.lock();
		try {
			Calendar cal = Calendar.getInstance();// 使用日历类
			int year = cal.get(Calendar.YEAR);// 得到年
			int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
			int day = cal.get(Calendar.DAY_OF_MONTH);// 得到天
			//int hour = cal.get(Calendar.HOUR);// 得到小时
			statsProductMaterial.setYear(year);
			statsProductMaterial.setMonth(month);
			statsProductMaterial.setDay(day);
			StatsProductMaterialParamVo statsProductMaterialParamVo = new StatsProductMaterialParamVo(
					statsProductMaterial);
			statsProductMaterialParamVo.setTenantId(commonParam.getTenantId());
			List<StatsProductMaterial> list = statsProductMaterialMapper
					.selectListByMaterialSumStats(statsProductMaterialParamVo);
			if ((list != null) && (!list.isEmpty())) {
				StatsProductMaterial entity = list.get(0);
				if (statsProductMaterial.getQuantity() != null) {
					entity.setQuantity(Arith.add(entity.getQuantity(), statsProductMaterial.getQuantity()));
				}

				if (statsProductMaterial.getQuantityOther() != null) {
					entity.setQuantityOther(
							Arith.add(entity.getQuantityOther(), statsProductMaterial.getQuantityOther()));
				}

				statsProductMaterialMapper.updateEntity(entity);

				return entity;

			} else {
				statsProductMaterialMapper.insertEntity(statsProductMaterial);
			}
		} finally {
			distributedLock.unlock();
		}
		
		return statsProductMaterial;
	}
}
