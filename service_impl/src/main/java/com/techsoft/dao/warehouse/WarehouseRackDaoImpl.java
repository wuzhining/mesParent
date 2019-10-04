package com.techsoft.dao.warehouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.mapper.warehouse.WarehouseRackMapper;

@Repository
public class WarehouseRackDaoImpl extends BaseDaoImpl<WarehouseRack> implements WarehouseRackDao {
	@Resource
	protected WarehouseRackMapper warehouseRackMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehouseRack> getEntityClass() {
		return WarehouseRack.class;
	}	
	
	@Override
	public BaseMapper<WarehouseRack> getBaseMapper() {
		return this.warehouseRackMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_RACK";
	}
	
	@Override
	public void insertSaveCheck(WarehouseRack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehouseRack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehouseRack value) throws BusinessException, SQLException {
	
	}
			
}
