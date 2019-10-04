package com.techsoft.dao.bill;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.mapper.bill.BillWorkorderMapper;
import com.techsoft.mapper.sys.MycatSequenceMapper;

@Repository
public class BillWorkorderDaoImpl extends BaseDaoImpl<BillWorkorder> implements BillWorkorderDao {
	@Resource
	protected BillWorkorderMapper billWorkorderMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<BillWorkorder> getEntityClass() {
		return BillWorkorder.class;
	}	
	
	@Override
	public BaseMapper<BillWorkorder> getBaseMapper() {
		return this.billWorkorderMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "BILL_WORKORDER";
	}
	
	@Override
	public void insertSaveCheck(BillWorkorder value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) {
			throw new BusinessException("请先登录 ");
		}
		if (value.getWorkorderCode()== null ) {
			throw new BusinessException("工单编码不能为空 ");
		}
	 
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		 
		if (value.getWorkorderStatusDictId() == null || value.getWorkorderStatusDictId().equals(0L)) {
			throw new BusinessException("工单状态不能为空 ");
		}
		if (value.getQuantity() == null || value.getQuantity()<1) {
			throw new BusinessException("工单数量不能为0");
		}
		if (value.getQuantityMaximumInput() == null || value.getQuantityMaximumInput()<1) {
			throw new BusinessException("最大入库数量不能为0");
		}
		 
		if (value.getRatioAllowover()== null ) {
			throw new BusinessException("允超比率不能为空 ");
		}
		if (value.getTimePlanStart()== null ) {
			throw new BusinessException("计划开始时间不能为空 ");
		}
		if (value.getTimePlanEnd()== null ) {
			throw new BusinessException("计划结束时间不能为空");
		}
	}
	
	@Override
	public void updateSaveCheck(BillWorkorder value) throws BusinessException, SQLException {
		if (value.getCreateUserId() == null || value.getCreateUserId().equals(0L)) { 
			throw new BusinessException("请先登录 ");
		}
		if (value.getWorkorderCode()== null ) {
			throw new BusinessException("工单编码不能为空 ");
		}
	 
		if (value.getProductId() == null || value.getProductId().equals(0L)) {
			throw new BusinessException("物品不能为空 ");
		}
		 
		if (value.getWorkorderStatusDictId() == null || value.getWorkorderStatusDictId().equals(0L)) {
			throw new BusinessException("工单状态不能为空 ");
		}
		if (value.getQuantity() == null || value.getQuantity()<1) {
			throw new BusinessException("工单数量不能为0");
		}
		if (value.getQuantityMaximumInput() == null || value.getQuantityMaximumInput()<1) {
			throw new BusinessException("最大入库数量不能为0");
		}
		 
		if (value.getRatioAllowover()== null ) {
			throw new BusinessException("允超比率不能为空 ");
		}
		if (value.getTimePlanStart()== null ) {
			throw new BusinessException("计划开始时间不能为空 ");
		}
		if (value.getTimePlanEnd()== null ) {
			throw new BusinessException("计划结束时间不能为空");
		}
	}
	
	@Override
	public void deleteSaveCheck(BillWorkorder value) throws BusinessException, SQLException {
	
	}

	@Override
	public void updateBatch(BillWorkorder BillWorkorder, CommonParam commonParam){
		// TODO Auto-generated method stub
		 try {
			billWorkorderMapper.updateBatch(BillWorkorder);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
