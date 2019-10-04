package com.techsoft.dao.equip;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.mapper.equip.EquipSpecsWorkMapper;

@Repository
public class EquipSpecsWorkDaoImpl extends BaseDaoImpl<EquipSpecsWork> implements EquipSpecsWorkDao {
	@Resource
	protected EquipSpecsWorkMapper equipSpecsWorkMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<EquipSpecsWork> getEntityClass() {
		return EquipSpecsWork.class;
	}	
	
	@Override
	public BaseMapper<EquipSpecsWork> getBaseMapper() {
		return this.equipSpecsWorkMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "EQUIP_SPECS_WORK";
	}
	
	@Override
	public void insertSaveCheck(EquipSpecsWork value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(EquipSpecsWork value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(EquipSpecsWork value) throws BusinessException, SQLException {
	
	}
			
}
