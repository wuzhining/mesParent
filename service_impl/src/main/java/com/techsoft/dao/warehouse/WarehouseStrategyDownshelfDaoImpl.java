package com.techsoft.dao.warehouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.mapper.warehouse.WarehouseStrategyDownshelfMapper;

@Repository
public class WarehouseStrategyDownshelfDaoImpl extends BaseDaoImpl<WarehouseStrategyDownshelf> implements WarehouseStrategyDownshelfDao {
	@Resource
	protected WarehouseStrategyDownshelfMapper warehouseStrategyDownshelfMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehouseStrategyDownshelf> getEntityClass() {
		return WarehouseStrategyDownshelf.class;
	}	
	
	@Override
	public BaseMapper<WarehouseStrategyDownshelf> getBaseMapper() {
		return this.warehouseStrategyDownshelfMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_STRATEGY_DOWNSHELF";
	}
	
	@Override
	public void insertSaveCheck(WarehouseStrategyDownshelf value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehouseStrategyDownshelf value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehouseStrategyDownshelf value) throws BusinessException, SQLException {
	
	}
			
}
