package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipWorkProduct;
import com.techsoft.mapper.equip.EquipWorkProductMapper;

@Repository
public class EquipWorkProductDaoImpl extends BaseDaoImpl<EquipWorkProduct> implements EquipWorkProductDao {
	@Resource
	protected EquipWorkProductMapper equipWorkProductMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipWorkProduct> getEntityClass() {
		return EquipWorkProduct.class;
	}	
	
	@Override
	public BaseMapper<EquipWorkProduct> getBaseMapper() {
		return this.equipWorkProductMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_WORK_PRODUCT";
	}
	
	@Override
	public void insertSaveCheck(EquipWorkProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipWorkProduct value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipWorkProduct value) throws BusinessException, SQLException {
	
	}
			
}
