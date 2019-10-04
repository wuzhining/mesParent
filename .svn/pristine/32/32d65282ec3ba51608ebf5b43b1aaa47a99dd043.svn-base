package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillInventoryParamVo;
import com.techsoft.entity.common.BillInventoryItem;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;

public interface BillInventoryItemService extends BaseService<BillInventoryItem> {

	/**
	*@auther:Chen
	*@version:2019年7月1日上午10:37:00
	*@param stockList  选择的盘点物料List
	*@param billId     盘点单ID
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description 新增选择盘点的物料明细及条码
	*/
	public ResultMessage addInventoryItem(List<WarehouseLocationStockVo> stockList, Long billId, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午2:38:57
	*@param Id   盘点明细ID
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  根据盘点单删除相应的明细及标签
	*/
	public ResultMessage deleteItem(Long Id, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日上午9:25:46
	*@param billInventoryParamVo 盘点单据对象
	*@param commonParam
	*@description 根据选择的盘点单生成该盘点仓库的所有物料盘点明细及条码
	*/
	public ResultMessage billInventoryCheck(BillInventoryParamVo billInventoryParamVo, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午2:39:01
	*@param trackBarcodeVo 盘点标签对象
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  扫描标签进行盘点
	*/
	public ResultMessage barcodeInventory(TrackBarcodeParamVo paramVo, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午4:58:04
	*@param billId 盘点单ID
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  根据传回的盘点单，进行完结
	*/
	public ResultMessage endBill(Long billId, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午5:21:24
	*@param paramVo  新增条码对象
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description 新增盘入条码至盘点单
	*/
	public ResultMessage insertBarcode(TrackBarcodeParamVo paramVo, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月2日下午5:21:27
	*@param paramVo  更改标签的对象
	*@param commonParam
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description  修改盘点标签数量
	*/
	public ResultMessage updateBarcodeQty(TrackBarcodeParamVo paramVo, CommonParam commonParam) throws BusinessException, SQLException;

}
