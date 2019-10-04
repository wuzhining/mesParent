package com.techsoft.client.service.barcode;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BarcodeBatchNumber;
import com.techsoft.entity.barcode.BarcodeBatchNumberVo;
import com.techsoft.entity.barcode.BarcodeBatchNumberParamVo;

public interface ClientBarcodeBatchNumberService extends BaseClientService<BarcodeBatchNumber> {
	
	public BarcodeBatchNumberVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BarcodeBatchNumberVo>  selectListVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BarcodeBatchNumberVo>  selectPageVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public BarcodeBatchNumberVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<BarcodeBatchNumberVo>  selectListExtendVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<BarcodeBatchNumberVo>  selectPageExtendVoByParamVo(BarcodeBatchNumberParamVo barcodeBatchNumber, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(BarcodeBatchNumberParamVo barcodeBatchNumberParamVo, CommonParam commonParam);		
}
