package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillEquip;
import com.techsoft.entity.bill.BillEquipVo;
import com.techsoft.entity.bill.BillEquipParamVo;

public interface ClientBillEquipService extends BaseClientService<BillEquip> {
	
	public BillEquipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillEquipVo>  selectListVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillEquipVo>  selectPageVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public BillEquipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BillEquipVo>  selectListExtendVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BillEquipVo>  selectPageExtendVoByParamVo(BillEquipParamVo billEquip, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(BillEquipParamVo billEquipParamVo, CommonParam commonParam);		
}
