package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipWorkClasses;
import com.techsoft.mapper.equip.EquipWorkClassesMapper;

@Repository
public class EquipWorkClassesDaoImpl extends BaseDaoImpl<EquipWorkClasses> implements EquipWorkClassesDao {
	@Resource
	protected EquipWorkClassesMapper equipWorkClassesMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipWorkClasses> getEntityClass() {
		return EquipWorkClasses.class;
	}	
	
	@Override
	public BaseMapper<EquipWorkClasses> getBaseMapper() {
		return this.equipWorkClassesMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_WORK_CLASSES";
	}
	
	@Override
	public void insertSaveCheck(EquipWorkClasses value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipWorkClasses value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipWorkClasses value) throws BusinessException, SQLException {
	
	}
			
}
