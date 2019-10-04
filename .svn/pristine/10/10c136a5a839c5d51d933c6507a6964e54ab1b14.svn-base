package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipFixtureStackProduct;
import com.techsoft.mapper.equip.EquipFixtureStackProductMapper;

@Repository
public class EquipFixtureStackProductDaoImpl extends BaseDaoImpl<EquipFixtureStackProduct> implements EquipFixtureStackProductDao {
	@Resource
	protected EquipFixtureStackProductMapper equipFixtureStackProductMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipFixtureStackProduct> getEntityClass() {
		return EquipFixtureStackProduct.class;
	}	
	
	@Override
	public BaseMapper<EquipFixtureStackProduct> getBaseMapper() {
		return this.equipFixtureStackProductMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_FIXTURE_STACK_PRODUCT";
	}
	
	@Override
	public void insertSaveCheck(EquipFixtureStackProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipFixtureStackProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipFixtureStackProduct value) throws BusinessException, SQLException {
	
	}
			
}
