package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.bill.BillWorkorderVo;
import com.techsoft.entity.bill.BillSaleorderParamVo;

public interface ClientBillSaleorderService extends BaseClientService<BillSaleorder> {

	public BillSaleorderVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillSaleorderVo> selectListVoByParamVo(BillSaleorderParamVo billSaleorder, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillSaleorderVo> selectPageVoByParamVo(BillSaleorderParamVo billSaleorder, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillSaleorderVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillSaleorderVo> selectListExtendVoByParamVo(BillSaleorderParamVo billSaleorder,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillSaleorderVo> selectPageExtendVoByParamVo(BillSaleorderParamVo billSaleorder,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillSaleorderParamVo billSaleorderParamVo, CommonParam commonParam,String SP);
}
