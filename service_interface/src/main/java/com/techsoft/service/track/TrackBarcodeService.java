package com.techsoft.service.track;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeParamVo;

public interface TrackBarcodeService extends BaseService<TrackBarcode> {
	public TrackBarcode insertSnlist(TrackBarcodeParamVo paramVo,CommonParam commonParam) throws BusinessException, SQLException;
	public TrackBarcode updateBatchTrack(List<TrackBarcode> list,CommonParam commonParam)throws BusinessException, SQLException;
	public TrackBarcode insertBillSnBatch(List<TrackBarcode> list, CommonParam commonParam)throws BusinessException, SQLException;

	/**
	*@auther:Wang
	*@version:2019年5月15日上午9:09:04
	*@param:list 条码对象list
	*@description  将条码对象list转换成历史条码对象list
	*/
	public List<TrackBarcode> exchangeBarcode(List<BarcodeMain> list,String insertOrUpdate,CommonParam commonParam)throws BusinessException, SQLException;
	
	public void updateTrackStatus(Long billId, Long billStatusDictId, CommonParam commonParam) throws BusinessException, SQLException;
}
