package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.bill.BillDeliveryVo;
import com.techsoft.entity.bill.BillPurchaseItemVo;
import com.techsoft.entity.bill.BillDeliveryParamVo;

public interface ClientBillDeliveryService extends BaseClientService<BillDelivery> {

	public BillDeliveryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillDeliveryVo> selectListVoByParamVo(BillDeliveryParamVo billDelivery, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillDeliveryVo> selectPageVoByParamVo(BillDeliveryParamVo billDelivery, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillDeliveryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillDeliveryVo> selectListExtendVoByParamVo(BillDeliveryParamVo billDelivery, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillDeliveryVo> selectPageExtendVoByParamVo(BillDeliveryParamVo billDelivery,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillDeliveryParamVo billDeliveryParamVo, CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午4:47:48
	 * @param list
	 *            退货单据List
	 * @param commonParam
	 * @return
	 * @description 根据前端传回选择的单据List批量处理
	 */
	public ResultMessage rejectBatchSaveOrUpdate(List<BillWarehouse> list, CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午4:56:14
	 * @param list
	 *            采购明细信息List
	 * @param commonParam
	 * @return ResultMessage
	 * @description 根据采购明细信息生成送货单
	 */
	public ResultMessage purchaseBatchSaveOrUpdate(List<BillPurchaseItemVo> list, CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年6月4日下午1:35:28
	 * @param list
	 * @param commonParam
	 * @return
	 * @description
	 */
	public ResultMessage purchaseCheckAndPrint(BillDelivery billDelivery, CommonParam commonParam);
}
