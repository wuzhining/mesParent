package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaSpiBarcode;
import com.techsoft.entity.scada.ScadaSpiBarcodeVo;
import com.techsoft.entity.scada.ScadaSpiBarcodeParamVo;

public interface ClientScadaSpiBarcodeService extends BaseClientService<ScadaSpiBarcode> {
	
	public ScadaSpiBarcodeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiBarcodeVo>  selectListVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiBarcodeVo>  selectPageVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaSpiBarcodeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaSpiBarcodeVo>  selectListExtendVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaSpiBarcodeVo>  selectPageExtendVoByParamVo(ScadaSpiBarcodeParamVo scadaSpiBarcode, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaSpiBarcodeParamVo scadaSpiBarcodeParamVo, CommonParam commonParam);		
}
