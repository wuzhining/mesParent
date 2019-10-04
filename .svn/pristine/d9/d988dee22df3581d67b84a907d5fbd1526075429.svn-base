package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProdlineEquip;
import com.techsoft.mapper.struct.StructProdlineEquipMapper;

@Repository
public class StructProdlineEquipDaoImpl extends BaseDaoImpl<StructProdlineEquip> implements StructProdlineEquipDao {
	@Resource
	protected StructProdlineEquipMapper structProdlineEquipMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProdlineEquip> getEntityClass() {
		return StructProdlineEquip.class;
	}	
	
	@Override
	public BaseMapper<StructProdlineEquip> getBaseMapper() {
		return this.structProdlineEquipMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PRODLINE_EQUIP";
	}
	
	@Override
	public void insertSaveCheck(StructProdlineEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProdlineEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProdlineEquip value) throws BusinessException, SQLException {
	
	}
			
}
