package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.HistoryBillStatus;
import com.techsoft.dao.bill.BillPurchaseDao;
import com.techsoft.dao.bill.BillPurchaseItemDao;
import com.techsoft.dao.history.HistoryBillStatusAuditDao;
import com.techsoft.dao.history.HistoryBillStatusDao;

@Service
public class BillPurchaseServiceImpl extends BaseServiceImpl<BillPurchase> implements BillPurchaseService {
	@Autowired
	private BillPurchaseDao billPurchaseDao;
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;
	@Autowired
	private HistoryBillStatusAuditDao historyBillStatusAuditDao;
	@Autowired
	private BillPurchaseItemDao billPurchaseItemDao;
	
	@Override
	public BaseDao<BillPurchase> getBaseDao() {
		return billPurchaseDao;
	}	
	
	@Override
	public Class<BillPurchase> getEntityClass() {
		return BillPurchase.class;
	}
	
	@Override
	protected BillPurchase insertEntity(BillPurchase entity, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillStatus historyBillStatus=new HistoryBillStatus();
		 BillPurchase insertEntity = super.insertEntity(entity, commonParam);
		//单据状态
		if(insertEntity.getBillStatusDictId()!=null&&insertEntity.getBillStatusDictId()>0L){
			historyBillStatus.setBillStatusDictId(insertEntity.getBillStatusDictId());
		}
		//单据id
		if(insertEntity.getId()!=null&&insertEntity.getId()>0L){
			historyBillStatus.setBillId(insertEntity.getId());
		}
		//销售单类型
		if(insertEntity!=null){
			//增加单据历史记录
			historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_PURCHASE.getValue(), insertEntity.getBillStatusDictId(), insertEntity.getId(),insertEntity.getBillCode(), commonParam);
			//增加单据审批记录
			historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_PURCHASE.getValue(),insertEntity.getAuditStatusDictId(), insertEntity.getId(),insertEntity.getBillCode(), commonParam);
		}
		return insertEntity;
	 
	}

	@Override
	protected BillPurchase updatePartEntity(BillPurchase entity, CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillStatus historyBillStatus=new HistoryBillStatus();
		if(entity.getBillStatusDictId()!=null&&entity.getBillStatusDictId()>0L){
			historyBillStatus.setBillStatusDictId(entity.getBillStatusDictId());
		}
		if(entity.getId()!=null&&entity.getId()>0L){
			historyBillStatus.setBillId(entity.getId());
		}
		 BillPurchase updatePartEntity = super.updatePartEntity(entity, commonParam);  
		
		if(updatePartEntity!=null){
			//增加单据历史记录
			historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_PURCHASE.getValue(), updatePartEntity.getBillStatusDictId(), updatePartEntity.getId(),updatePartEntity.getBillCode(), commonParam);
			//增加单据审批记录,审批id不为未审批状态时，表示已修改审批状态
			if(updatePartEntity.getAuditStatusDictId()!=EnumAuditStatus.UNAUDITED.getValue()){
				historyBillStatusAuditDao.billHistoryInsert(EnumBillType.BILL_TYPE_PURCHASE.getValue(),updatePartEntity.getAuditStatusDictId(), updatePartEntity.getId(),updatePartEntity.getBillCode(), commonParam);
			}
			//更新明细表
			billPurchaseItemDao.updatePurchaseBillStatusS(entity.getId(),updatePartEntity.getBillStatusDictId(), commonParam);
			
		}
		return updatePartEntity;
	}

	@Override
	protected BillPurchase updateEntity(BillPurchase entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
