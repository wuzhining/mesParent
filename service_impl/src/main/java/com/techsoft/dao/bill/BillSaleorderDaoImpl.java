package com.techsoft.dao.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.mapper.bill.BillSaleorderMapper;

@Repository
public class BillSaleorderDaoImpl extends BaseDaoImpl<BillSaleorder> implements BillSaleorderDao {
	@Resource
	protected BillSaleorderMapper billSaleorderMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillSaleorder> getEntityClass() {
		return BillSaleorder.class;
	}	
	
	@Override
	public BaseMapper<BillSaleorder> getBaseMapper() {
		return this.billSaleorderMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_SALEORDER";
	}
	
	@Override
	public void insertSaveCheck(BillSaleorder value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getPlanTime() == null  ) {
			throw new BusinessException("计划生产时间不能为空 ");
		}
		if (value.getDeliveryTime() == null  ) {
			throw new BusinessException("预估发货时间不能为空 ");
		}
	 
		
	
	}
	
	@Override
	public void updateSaveCheck(BillSaleorder value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getPlanTime() == null  ) {
			throw new BusinessException("计划生产时间不能为空 ");
		}
		if (value.getDeliveryTime() == null  ) {
			throw new BusinessException("预估发货时间不能为空 ");
		}
	}
	
	@Override
	public void deleteSaveCheck(BillSaleorder value) throws BusinessException, SQLException {
	
	}
			
}
