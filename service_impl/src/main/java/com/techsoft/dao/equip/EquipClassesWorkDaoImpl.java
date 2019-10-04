package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.mapper.equip.EquipClassesWorkMapper;

@Repository
public class EquipClassesWorkDaoImpl extends BaseDaoImpl<EquipClassesWork> implements EquipClassesWorkDao {
	@Resource
	protected EquipClassesWorkMapper equipClassesWorkMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipClassesWork> getEntityClass() {
		return EquipClassesWork.class;
	}	
	
	@Override
	public BaseMapper<EquipClassesWork> getBaseMapper() {
		return this.equipClassesWorkMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_CLASSES_WORK";
	}
	
	@Override
	public void insertSaveCheck(EquipClassesWork value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipClassesWork value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipClassesWork value) throws BusinessException, SQLException {
	
	}
			
}
