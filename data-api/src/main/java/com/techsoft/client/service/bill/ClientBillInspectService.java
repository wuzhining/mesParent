package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillInspectParamVo;
import com.techsoft.entity.bill.BillInspectVo;
import com.techsoft.entity.common.BillInspect;
import com.techsoft.entity.common.BillWarehouseItem;

public interface ClientBillInspectService extends BaseClientService<BillInspect> {

	public BillInspectVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillInspectVo> selectListVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillInspectVo> selectPageVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillInspectVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillInspectVo> selectListExtendVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillInspectVo> selectPageExtendVoByParamVo(BillInspectParamVo billInspect, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillInspectParamVo billInspectParamVo, CommonParam commonParam);

	public List<BillWarehouseItem> getbillItemListBybillId(Long billId, CommonParam commonParam)
			throws BusinessException, SQLException;

	public ResultMessage inspectionOKorNG(BillInspectParamVo billInspectParamVo, CommonParam commonParam);

	// mine
	public PageInfo<BillInspectVo> selectIQCIncomeScreen(CommonParam commonParam)
			throws BusinessException, SQLException;

	public ResultMessage saveExamine(BillInspectParamVo billInspectParamVo, CommonParam commonParam);


}
