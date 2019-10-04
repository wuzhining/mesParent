package com.techsoft.dao.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.MycatSequence;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;

@Repository
public class MycatSequenceDaoImpl extends BaseDaoImpl<MycatSequence> implements MycatSequenceDao {
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;
	
	@Override
	public Class<MycatSequence> getEntityClass() {
		return MycatSequence.class;
	}	
	
	@Override
	public BaseMapper<MycatSequence> getBaseMapper() {
		return this.mycatSequenceMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "MYCAT_SEQUENCE";
	}
	
	@Override
	public void insertSaveCheck(MycatSequence value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(MycatSequence value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(MycatSequence value) throws BusinessException, SQLException {
	
	}
			
}
