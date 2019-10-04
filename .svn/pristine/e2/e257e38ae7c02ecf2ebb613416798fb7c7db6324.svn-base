package com.techsoft.dao.warehouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehouseStrategyDownshelfItem;
import com.techsoft.mapper.warehouse.WarehouseStrategyDownshelfItemMapper;

@Repository
public class WarehouseStrategyDownshelfItemDaoImpl extends BaseDaoImpl<WarehouseStrategyDownshelfItem> implements WarehouseStrategyDownshelfItemDao {
	@Resource
	protected WarehouseStrategyDownshelfItemMapper warehouseStrategyDownshelfItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehouseStrategyDownshelfItem> getEntityClass() {
		return WarehouseStrategyDownshelfItem.class;
	}	
	
	@Override
	public BaseMapper<WarehouseStrategyDownshelfItem> getBaseMapper() {
		return this.warehouseStrategyDownshelfItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_STRATEGY_DOWNSHELF_ITEM";
	}
	
	@Override
	public void insertSaveCheck(WarehouseStrategyDownshelfItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehouseStrategyDownshelfItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehouseStrategyDownshelfItem value) throws BusinessException, SQLException {
	
	}
			
}
