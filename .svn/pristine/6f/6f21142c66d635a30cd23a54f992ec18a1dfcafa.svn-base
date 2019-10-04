package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructProdlineWorkstation;
import com.techsoft.mapper.struct.StructProdlineWorkstationMapper;

@Repository
public class StructProdlineWorkstationDaoImpl extends BaseDaoImpl<StructProdlineWorkstation> implements StructProdlineWorkstationDao {
	@Resource
	protected StructProdlineWorkstationMapper structProdlineWorkstationMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructProdlineWorkstation> getEntityClass() {
		return StructProdlineWorkstation.class;
	}	
	
	@Override
	public BaseMapper<StructProdlineWorkstation> getBaseMapper() {
		return this.structProdlineWorkstationMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_PRODLINE_WORKSTATION";
	}
	
	@Override
	public void insertSaveCheck(StructProdlineWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructProdlineWorkstation value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructProdlineWorkstation value) throws BusinessException, SQLException {
	
	}
			
}
