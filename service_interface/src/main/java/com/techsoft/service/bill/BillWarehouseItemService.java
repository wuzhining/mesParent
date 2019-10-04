package com.techsoft.service.bill;

import java.util.List;

import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;
import com.techsoft.entity.common.BillWarehouseItem;

public interface BillWarehouseItemService extends BaseService<BillWarehouseItem> {
	
	public void updateInstore(Long id, Long billStatusDictId,Integer quality,CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月6日下午4:10:00
	*@param:id 明细ID
	*@param:billStatusDictId 状态(此处为处理中 数据字典)
	*@param:quality 扫描数量
	*@description  物料下架时修改领料明细扫描数量与状态
	*/
	public void updateOffStore(Long id, Long billStatusDictId,Double quality,CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月6日下午4:10:00
	*@param:id 明细ID
	*@param:billStatusDictId 状态(此处为完结 数据字典)
	*@param:quality 完成数量(已下架数量)
	*@description  领料出库时修改领料明细完成数量与状态
	*/
	public void updateOutStore(Long id, Long billStatusDictId,Double quality,CommonParam commonParam) throws BusinessException, SQLException;

	public void updateAllocationOutstore(Long id, Long billStatusDictId, Double quality, CommonParam commonParam) throws BusinessException, SQLException;
	
	public BillWarehouseItem insertBillItemBatch(List<BillWarehouseItem> list, CommonParam commonParam) throws BusinessException, SQLException;

	public void updateAllocationInstore(Long id, Long billStatusDictId, Double quality, CommonParam commonParam)throws BusinessException, SQLException;
	
	public void updateBillItemStatus(Long billId, Long billStatusDictId, CommonParam commonParam)throws BusinessException, SQLException;
	
	public void updateOutStoreBill(BillWarehouseItemParamVo paramVo,CommonParam commonParam) throws BusinessException, SQLException;
	
}
