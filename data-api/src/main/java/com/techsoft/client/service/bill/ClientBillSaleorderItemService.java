package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.bill.BillSaleorderItemVo;
import com.techsoft.entity.bill.BillSaleorderItemParamVo;

public interface ClientBillSaleorderItemService extends BaseClientService<BillSaleorderItem> {

	public BillSaleorderItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillSaleorderItemVo> selectListVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillSaleorderItemVo> selectPageVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillSaleorderItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillSaleorderItemVo> selectListExtendVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillSaleorderItemVo> selectPageExtendVoByParamVo(BillSaleorderItemParamVo billSaleorderItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillSaleorderItemParamVo billSaleorderItemParamVo, CommonParam commonParam);
}
