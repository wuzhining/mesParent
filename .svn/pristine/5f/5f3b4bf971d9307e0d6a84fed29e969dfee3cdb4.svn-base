package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaDfldip;
import com.techsoft.mapper.scada.ScadaDfldipMapper;

@Repository
public class ScadaDfldipDaoImpl extends BaseDaoImpl<ScadaDfldip> implements ScadaDfldipDao {
	@Resource
	protected ScadaDfldipMapper scadaDfldipMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaDfldip> getEntityClass() {
		return ScadaDfldip.class;
	}	
	
	@Override
	public BaseMapper<ScadaDfldip> getBaseMapper() {
		return this.scadaDfldipMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_DFLDIP";
	}
	
	@Override
	public void insertSaveCheck(ScadaDfldip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaDfldip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaDfldip value) throws BusinessException, SQLException {
	
	}
			
}
