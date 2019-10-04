package com.techsoft.dao.warehouse;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.mapper.warehouse.WarehouseLocationMapper;

@Repository
public class WarehouseLocationDaoImpl extends BaseDaoImpl<WarehouseLocation> implements WarehouseLocationDao {
	@Resource
	protected WarehouseLocationMapper warehouseLocationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;

	@Override
	public Class<WarehouseLocation> getEntityClass() {
		return WarehouseLocation.class;
	}

	@Override
	public BaseMapper<WarehouseLocation> getBaseMapper() {
		return this.warehouseLocationMapper;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}

	@Override
	public String getTableName() {
		return "WAREHOUSE_LOCATION";
	}

	@Override
	public void insertSaveCheck(WarehouseLocation value) throws BusinessException, SQLException {

	}

	@Override
	public void updateSaveCheck(WarehouseLocation value) throws BusinessException, SQLException {

	}

	@Override
	public void deleteSaveCheck(WarehouseLocation value) throws BusinessException, SQLException {

	}

	@Override
	public void insertBatch(List<WarehouseLocation> locations, CommonParam commonParam)
			throws BusinessException, SQLException {
		try {
			for (WarehouseLocation item : locations) {
				item.setCreateUserId(Long.valueOf(commonParam.getUserId()));
				item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			}
			int rows = this.warehouseLocationMapper.insertBatch(locations);
			if (rows != locations.size()) {
				throw new BusinessException("批量增加的货位数据与传入的货位列表数量不一致， 请检查!");
			}

		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}
	}

}
