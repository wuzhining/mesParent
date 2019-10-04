package com.techsoft.dao.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BillFixtureItem;
import com.techsoft.mapper.bill.BillFixtureItemMapper;

@Repository
public class BillFixtureItemDaoImpl extends BaseDaoImpl<BillFixtureItem> implements BillFixtureItemDao {
	@Resource
	protected BillFixtureItemMapper billFixtureItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillFixtureItem> getEntityClass() {
		return BillFixtureItem.class;
	}	
	
	@Override
	public BaseMapper<BillFixtureItem> getBaseMapper() {
		return this.billFixtureItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_FIXTURE_ITEM";
	}
	
	@Override
	public void insertSaveCheck(BillFixtureItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(BillFixtureItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(BillFixtureItem value) throws BusinessException, SQLException {
	
	}
			
}
