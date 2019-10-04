package com.techsoft.dao.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BillFixture;
import com.techsoft.mapper.bill.BillFixtureMapper;

@Repository
public class BillFixtureDaoImpl extends BaseDaoImpl<BillFixture> implements BillFixtureDao {
	@Resource
	protected BillFixtureMapper billFixtureMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillFixture> getEntityClass() {
		return BillFixture.class;
	}	
	
	@Override
	public BaseMapper<BillFixture> getBaseMapper() {
		return this.billFixtureMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_FIXTURE";
	}
	
	@Override
	public void insertSaveCheck(BillFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillFixture value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillFixture value) throws BusinessException, SQLException {
	
	}
			
}
