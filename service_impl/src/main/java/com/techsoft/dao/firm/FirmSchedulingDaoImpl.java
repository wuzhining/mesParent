package com.techsoft.dao.firm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.FirmScheduling;
import com.techsoft.mapper.firm.FirmSchedulingMapper;

@Repository
public class FirmSchedulingDaoImpl extends BaseDaoImpl<FirmScheduling> implements FirmSchedulingDao {
	@Resource
	protected FirmSchedulingMapper firmSchedulingMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<FirmScheduling> getEntityClass() {
		return FirmScheduling.class;
	}	
	
	@Override
	public BaseMapper<FirmScheduling> getBaseMapper() {
		return this.firmSchedulingMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "FIRM_SCHEDULING";
	}
	
	@Override
	public void insertSaveCheck(FirmScheduling value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(FirmScheduling value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(FirmScheduling value) throws BusinessException, SQLException {
	
	}
			
}
