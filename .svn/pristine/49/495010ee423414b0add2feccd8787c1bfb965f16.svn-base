package com.techsoft.dao.warehouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.mapper.warehouse.WarehouseAreaMapper;

@Repository
public class WarehouseAreaDaoImpl extends BaseDaoImpl<WarehouseArea> implements WarehouseAreaDao {
	@Resource
	protected WarehouseAreaMapper warehouseAreaMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehouseArea> getEntityClass() {
		return WarehouseArea.class;
	}	
	
	@Override
	public BaseMapper<WarehouseArea> getBaseMapper() {
		return this.warehouseAreaMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_AREA";
	}
	
	@Override
	public void insertSaveCheck(WarehouseArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehouseArea value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehouseArea value) throws BusinessException, SQLException {
	
	}
			
}
