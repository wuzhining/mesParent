package com.techsoft.service.bill;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.dao.bill.BillDeliveryDao;
import com.techsoft.dao.bill.BillDeliveryItemDao;
import com.techsoft.dao.history.HistoryBillStatusDao;
import com.techsoft.dao.track.TrackBarcodeDao;

@Service
public class BillDeliveryItemServiceImpl extends BaseServiceImpl<BillDeliveryItem> implements BillDeliveryItemService {
	@Autowired
	private BillDeliveryItemDao billDeliveryItemDao;
	@Autowired
	private BillDeliveryDao billDeliveryDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	@Autowired
	private HistoryBillStatusDao historyBillStatusDao;
	
	@Override
	public BaseDao<BillDeliveryItem> getBaseDao() {
		return billDeliveryItemDao;
	}	
	
	@Override
	public Class<BillDeliveryItem> getEntityClass() {
		return BillDeliveryItem.class;
	}
	
	@Override
	protected BillDeliveryItem insertEntity(BillDeliveryItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BillDeliveryItem updatePartEntity(BillDeliveryItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BillDeliveryItem updateEntity(BillDeliveryItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public ResultMessage endBill(Long billId, CommonParam commonParam) throws BusinessException, SQLException {
		  ResultMessage resultMessage = new ResultMessage();
		  //更新供应商发货单据状态
		  billDeliveryDao.updateBillStatusMain(billId, EnumBillStatus.FINISHED.getValue(), commonParam);
		  
		  //查询单据号
		  BillDelivery bill=billDeliveryDao.selectById(billId);
		  
		  //新增单据完结状态历史表
		  historyBillStatusDao.billHistoryInsert(EnumBillType.BILL_TYPE_DELIVERY_SUPPLIER.getValue(), EnumBillStatus.FINISHED.getValue(), billId,bill.getBillCode(), commonParam);
		  
		  //更新供应商发货单据明细状态
		  billDeliveryItemDao.updateBillItemStatusMain(billId, EnumBillStatus.FINISHED.getValue(), commonParam);
		  
		  //更新供应商发货单标签状态
		  trackBarcodeDao.updateTrackStatus(billId, EnumBillStatus.FINISHED.getValue(), commonParam); 
		  
		  resultMessage.setIsSuccess(true);
		  return resultMessage;
	}					
}
