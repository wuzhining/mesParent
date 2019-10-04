package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillPurchase;
import com.techsoft.entity.common.BillPurchaseItem;
import com.techsoft.entity.bill.BillPurchaseVo;
import com.techsoft.entity.bill.BillSaleorderVo;
import com.techsoft.entity.bill.BillPurchaseParamVo;

public interface ClientBillPurchaseService extends BaseClientService<BillPurchase> {

	public BillPurchaseVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillPurchaseVo> selectListVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillPurchaseVo> selectPageVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillPurchaseVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillPurchaseVo> selectListExtendVoByParamVo(BillPurchaseParamVo billPurchase, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillPurchaseVo> selectPageExtendVoByParamVo(BillPurchaseParamVo billPurchase,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillPurchaseParamVo billPurchaseParamVo, CommonParam commonParam ,String SP);

}
