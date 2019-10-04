package com.techsoft.dao.firm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.mapper.firm.FirmPostMapper;

@Repository
public class FirmPostDaoImpl extends BaseDaoImpl<FirmPost> implements FirmPostDao {
	@Resource
	protected FirmPostMapper firmPostMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<FirmPost> getEntityClass() {
		return FirmPost.class;
	}	
	
	@Override
	public BaseMapper<FirmPost> getBaseMapper() {
		return this.firmPostMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "FIRM_POST";
	}
	
	@Override
	public void insertSaveCheck(FirmPost value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(FirmPost value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(FirmPost value) throws BusinessException, SQLException {
	
	}
			
}
