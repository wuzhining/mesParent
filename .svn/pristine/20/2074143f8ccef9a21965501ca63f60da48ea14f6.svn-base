package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillWarehouseItem;
import com.techsoft.entity.bill.BillWarehouseItemVo;
import com.techsoft.entity.bill.BillWarehouseItemParamVo;

public interface ClientBillWarehouseItemService extends BaseClientService<BillWarehouseItem> {

	public BillWarehouseItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWarehouseItemVo> selectListVoByParamVo(BillWarehouseItemParamVo billWarehouseItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillWarehouseItemVo> selectPageVoByParamVo(BillWarehouseItemParamVo billWarehouseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillWarehouseItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWarehouseItemVo> selectListExtendVoByParamVo(BillWarehouseItemParamVo billWarehouseItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillWarehouseItemVo> selectPageExtendVoByParamVo(BillWarehouseItemParamVo billWarehouseItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillWarehouseItemParamVo billWarehouseItemVo, CommonParam commonParam);

	public ResultMessage updateBillStatus(BillWarehouseItemVo billWarehouseItemParamVo, CommonParam commonParam);
}
