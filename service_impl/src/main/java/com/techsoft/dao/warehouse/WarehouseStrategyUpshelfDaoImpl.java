package com.techsoft.dao.warehouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.mapper.warehouse.WarehouseStrategyUpshelfMapper;

@Repository
public class WarehouseStrategyUpshelfDaoImpl extends BaseDaoImpl<WarehouseStrategyUpshelf> implements WarehouseStrategyUpshelfDao {
	@Resource
	protected WarehouseStrategyUpshelfMapper warehouseStrategyUpshelfMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehouseStrategyUpshelf> getEntityClass() {
		return WarehouseStrategyUpshelf.class;
	}	
	
	@Override
	public BaseMapper<WarehouseStrategyUpshelf> getBaseMapper() {
		return this.warehouseStrategyUpshelfMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_STRATEGY_UPSHELF";
	}
	
	@Override
	public void insertSaveCheck(WarehouseStrategyUpshelf value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehouseStrategyUpshelf value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehouseStrategyUpshelf value) throws BusinessException, SQLException {
	
	}
			
}
