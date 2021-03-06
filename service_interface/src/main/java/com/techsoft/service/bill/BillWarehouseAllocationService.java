package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeVo;

/**
 * @auther:chen
 * @version:2019年5月27日下午2:49:09
 * @param:
 * @description
 */
public interface BillWarehouseAllocationService extends BaseService<BillWarehouse> {

	/**
	*@auther:Chen
	*@version:2019年5月28日上午9:31:34
	*@param  trackBarcodeVo 追踪条码对象
	*@description 根据调拨上架单扫描标签入库上架
	*/
	public ResultMessage allocationnBillBarcodeInput(TrackBarcodeVo trackBarcodeVo, CommonParam commonParam) throws BusinessException, SQLException ;

	/**
	*@auther:Chen
	*@version:2019年5月27日下午5:29:55
	*@param list               条码数据集合
	*@param fromWarehouseId    源仓库ID
	*@param toWarehouseId      目标仓库ID
	*@description 根据调拨单扫描标签下架生成调拨出库单和调拨入库单
	*@return  返回入库上架单号
	*/
	public String allocationOutput(List<BarcodeMain> list, Long fromWarehouseId, Long toWarehouseId,Long factoryId, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年5月30日下午1:47:53
	*@param barcodeMain   标签移位封装的对象
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  扫描标签以及货位进行库内移位
	*/
	public ResultMessage barcodeTransposition(BarcodeMain barcodeMain, CommonParam commonParam)
			throws BusinessException, SQLException;

}
