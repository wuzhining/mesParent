package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipWorkStackProduct;
import com.techsoft.mapper.equip.EquipWorkStackProductMapper;

@Repository
public class EquipWorkStackProductDaoImpl extends BaseDaoImpl<EquipWorkStackProduct> implements EquipWorkStackProductDao {
	@Resource
	protected EquipWorkStackProductMapper equipWorkStackProductMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipWorkStackProduct> getEntityClass() {
		return EquipWorkStackProduct.class;
	}	
	
	@Override
	public BaseMapper<EquipWorkStackProduct> getBaseMapper() {
		return this.equipWorkStackProductMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_WORK_STACK_PRODUCT";
	}
	
	@Override
	public void insertSaveCheck(EquipWorkStackProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipWorkStackProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipWorkStackProduct value) throws BusinessException, SQLException {
	
	}
			
}
