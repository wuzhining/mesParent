package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillEquipItem;
import com.techsoft.entity.bill.BillEquipItemVo;
import com.techsoft.entity.bill.BillEquipItemParamVo;

public interface ClientBillEquipItemService extends BaseClientService<BillEquipItem> {
	
	public BillEquipItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillEquipItemVo>  selectListVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillEquipItemVo>  selectPageVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public BillEquipItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillEquipItemVo>  selectListExtendVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillEquipItemVo>  selectPageExtendVoByParamVo(BillEquipItemParamVo billEquipItem, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(BillEquipItemParamVo billEquipItemParamVo, CommonParam commonParam);		
}
