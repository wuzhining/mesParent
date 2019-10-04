package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.ProductMaterial;

public interface BillWarehouseService extends BaseService<BillWarehouse> {
	
	/**
	*@auther:Wang
	*@version:2019年5月15日下午3:16:12
	*@param:list 条码主表list
	*@param fromBillId 来源单
	*@description 根据传进来的条码自动生成各仓库对应的出库单据
	*/
	public void insertBatchEntityAndItem(List<BarcodeMain> totalBarcodeList,Long fromBillId,CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月29日下午4:13:16
	*@param:billWarehouseVo 主表对象
	*@param:list 选择的工单list对象
	*@description 生产领料单新增
	*/
	/*public void insertPickBatch(BillWarehouseVo billWarehouseVo,List<BillWorkorderBomVo> list, CommonParam commonParam) throws BusinessException, SQLException;*/

	/**
	*@auther:Wang
	*@version:2019年5月29日下午4:13:16
	*@param:billWarehouseVo 主表对象
	*@param:list 选择的物料list对象
	*@description 非生产领料单新增
	*/
	public void insertUnPickBatch(BillWarehouseVo billWarehouseVo,List<ProductMaterial> list, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWarehouse> selectPrepareMaterialsScreen() throws BusinessException, SQLException;

	/**
	*@auther:Wang
	*@version:2019年6月25日下午1:19:52
	*@param:billWarehouseVo 主表对象
	*@param:list 选择的销售单list对象
	*@description 销售出库单新增
	*/
	public void insertShipBatch(BillWarehouseVo billWarehouseVo, List<BillSaleorderItem> list, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Wang
	*@version:2019年6月27日上午9:24:21
	*@param:
	*@description 定时任务的生产领料单新增方法
	*/
	public void insertPickTimeTask() throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年8月28日下午6:03:50
	*@param:billWorkId 工单id
	*@description 传入工单id 自动生成该工单的领料单信息
	*/
	public void insertPickTkFromWorkId(Long billWorkId, CommonParam commonParam) throws BusinessException, SQLException;

}
