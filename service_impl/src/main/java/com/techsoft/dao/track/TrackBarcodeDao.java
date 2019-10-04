package com.techsoft.dao.track;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillDeliveryItem;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeParamVo;

public interface TrackBarcodeDao extends BaseDao<TrackBarcode> {
	
	public void insertBatchSn(List<TrackBarcode> listsns, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Chenzj
	*@version:2019年5月4日下午10:14:51
	*@param  list 条码list
	*@description 批量更新条码数据
	*/
	public void updateBatchTrack(List<TrackBarcode> list,CommonParam commonParam)  throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月15日上午9:09:04
	*@param:list 条码对象list
	*@description  将条码对象list转换成历史条码对象list
	*/
	public List<TrackBarcode> exchangeBarcode(List<BarcodeMain> barCodeList, String string, CommonParam commonParam)throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年5月29日上午8:50:53
	*@description
	*/
	public void insertSnlist(TrackBarcodeParamVo paramVo, CommonParam commonParam)throws BusinessException, SQLException;

	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午3:12:12
	*@param list   调拨标签LIST集合
	*@description  批量新增调拨单主表的下架标签
	*/
	public List<TrackBarcode> insertAllocationSnList(List<BarcodeMain> list, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年5月29日上午8:50:36
	*@param  billId              单据ID
	*@param  billType            单据类别
	*@param  billStatus          单据状态
	*@param  barcodeStatus       标签状态
	*@param  list                处理传回的条码追踪表LIST
	*@param  itemList            处理传回的单据明细LIST
	*@param  type                单据出入库类别（IN入库，OUT出库，CHECK质检）
	*@description  根据传回的条码list批量新增出/入单单的单据条码
	*/
	public List<TrackBarcode> insertAllocationInOrOutSnList(Long billId, Long billType, Long billStatus, Long barcodeStatus,
			List<TrackBarcode> list, List<BillWarehouseItem> itemList, String type, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年5月29日上午8:50:33
	*@param billId               单据ID
	*@param billStatusDictId     单据状态
	*@description 用于更新条码追踪表的单据状态
	*/
	public void updateTrackStatus(Long billId, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;

	
	/**
	*@auther:Chen
	*@version:2019年5月29日下午4:43:56
	*@param arrivalBillId   来料单ID
	*@param list            质检单明细List
	*@param commonParam
	*@return TrackBarcode  单据条码对象
	*@throws BusinessException
	*@throws SQLException
	*@description  根据来料单批量新增质检单标签
	*/
	public TrackBarcode insertIqcSnlist(Long arrivalBillId, List<BillInspect> list, CommonParam commonParam)
			throws BusinessException, SQLException;

	
	/**
	*@auther:Chen
	*@version:2019年6月3日下午1:36:16
	*@param itemList     发货明细单List
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description   根据发货单明细新增条码
	*/
	public List<TrackBarcode> insertDeliveryToSuplierSnList(List<BillDeliveryItem> itemList, CommonParam commonParam)
			throws BusinessException, SQLException;
	
	public void updateCheckTrackStatus(Long billId, Long billStatusDictId, CommonParam commonParam)
			throws BusinessException, SQLException;


	/**
	*@auther:Chen
	*@version:2019年6月5日下午1:37:50
	*@param itemList
	*@param deliveryCode
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public List<TrackBarcode> insertArrivalSnList(List<BillWarehouseItem> itemList,Long deliveryCode, CommonParam commonParam)
			throws BusinessException, SQLException;

	


}
