package com.techsoft.dao.firm;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.mapper.firm.FirmPartnerMapper;

@Repository
public class FirmPartnerDaoImpl extends BaseDaoImpl<FirmPartner> implements FirmPartnerDao {
	@Resource
	protected FirmPartnerMapper firmPartnerMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<FirmPartner> getEntityClass() {
		return FirmPartner.class;
	}	
	
	@Override
	public BaseMapper<FirmPartner> getBaseMapper() {
		return this.firmPartnerMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "FIRM_PARTNER";
	}
	
	@Override
	public void insertSaveCheck(FirmPartner value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(FirmPartner value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(FirmPartner value) throws BusinessException, SQLException {
	
	}
			
}
