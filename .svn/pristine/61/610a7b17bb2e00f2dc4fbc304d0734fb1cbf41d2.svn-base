package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipFixtureProduct;
import com.techsoft.mapper.equip.EquipFixtureProductMapper;

@Repository
public class EquipFixtureProductDaoImpl extends BaseDaoImpl<EquipFixtureProduct> implements EquipFixtureProductDao {
	@Resource
	protected EquipFixtureProductMapper equipFixtureProductMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipFixtureProduct> getEntityClass() {
		return EquipFixtureProduct.class;
	}	
	
	@Override
	public BaseMapper<EquipFixtureProduct> getBaseMapper() {
		return this.equipFixtureProductMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_FIXTURE_PRODUCT";
	}
	
	@Override
	public void insertSaveCheck(EquipFixtureProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipFixtureProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipFixtureProduct value) throws BusinessException, SQLException {
	
	}
			
}
