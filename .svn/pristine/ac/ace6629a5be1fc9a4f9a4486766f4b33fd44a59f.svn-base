package com.techsoft.service.track;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumBillStatus;
import com.techsoft.common.enums.EnumBillType;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.utils.zklock.DistributedLock;
import com.techsoft.utils.zklock.LockManager;
import com.techsoft.dao.track.TrackBarcodeDao;

@Service
public class TrackBarcodeServiceImpl extends BaseServiceImpl<TrackBarcode> implements TrackBarcodeService {
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	
	@Override
	public BaseDao<TrackBarcode> getBaseDao() {
		return trackBarcodeDao;
	}	
	
	@Override
	public Class<TrackBarcode> getEntityClass() {
		return TrackBarcode.class;
	}
	
	@Override
	protected TrackBarcode insertEntity(TrackBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected TrackBarcode updatePartEntity(TrackBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected TrackBarcode updateEntity(TrackBarcode entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public TrackBarcode insertSnlist(TrackBarcodeParamVo paramVo, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackBarcode trackBarcode = new TrackBarcode();
		paramVo.cloneProperties(trackBarcode);
		trackBarcodeDao.insertSnlist(paramVo, commonParam);
		return trackBarcode;
	}

	@Override
	public TrackBarcode updateBatchTrack(List<TrackBarcode> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		trackBarcodeDao.updateBatchTrack(list, commonParam);
		return null;
	}	
	
	@Override
	public TrackBarcode insertBillSnBatch(List<TrackBarcode> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		
		DecimalFormat df=new DecimalFormat("0000");
		Integer index = 0;
		String idString = "";
		Long idLong = 0L;
		Long bilItemId=trackBarcodeDao.getIdValue();
		
		for (TrackBarcode TrackBarcode : list) {
			index++;
			idString=df.format(index);
			idLong = Long.valueOf(bilItemId.toString() + idString);
			TrackBarcode.setId(idLong);
		}
		trackBarcodeDao.insertBatchSn(list, commonParam);
		return null;
	}

	@Override
	public List<TrackBarcode> exchangeBarcode(List<BarcodeMain> list,String insertOrUpdate, CommonParam commonParam)
			throws BusinessException, SQLException {
		return trackBarcodeDao.exchangeBarcode(list,insertOrUpdate,commonParam);
	}
	
	@Override
	public void updateTrackStatus(Long billId, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException {
		    //查询标签信息ID更新
				List<TrackBarcode> list =new ArrayList<TrackBarcode>();
				TrackBarcodeParamVo paramVo =new TrackBarcodeParamVo();
				paramVo.setBillId(billId);
				list=trackBarcodeDao.selectListByParamVo(paramVo);
				
				List<Long> ids = new ArrayList<Long>();
				for (TrackBarcode trackBarcode : list) {
						//updateSaveCheck(item);
						trackBarcode.setBillStatusDictId(billStatusDictId);
						trackBarcode.setCreateUserId(Long.valueOf(commonParam.getUserId()));
						trackBarcode.setModifyUserId(Long.valueOf(commonParam.getUserId()));
						ids.add(trackBarcode.getId());
					}
				List<DistributedLock> listlock = LockManager.getLongZKDistributedLock(TrackBarcode.class.getName(), ids);
				LockManager.lockList(listlock);
				try {
					this.trackBarcodeDao.updateBatchTrack(list, commonParam);
				} finally {
					LockManager.unLockList(listlock);
				}
				
		
	}
	
	
	
}
