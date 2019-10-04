package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoi;
import com.techsoft.entity.scada.ScadaAoiVo;
import com.techsoft.entity.scada.ScadaAoiParamVo;

public interface ClientScadaAoiService extends BaseClientService<ScadaAoi> {
	
	public ScadaAoiVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiVo>  selectListVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiVo>  selectPageVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiVo>  selectListExtendVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiVo>  selectPageExtendVoByParamVo(ScadaAoiParamVo scadaAoi, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiParamVo scadaAoiParamVo, CommonParam commonParam);		
}
