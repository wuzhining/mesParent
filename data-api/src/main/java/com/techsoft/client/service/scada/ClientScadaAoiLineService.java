package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoiLine;
import com.techsoft.entity.scada.ScadaAoiLineVo;
import com.techsoft.entity.scada.ScadaAoiLineParamVo;

public interface ClientScadaAoiLineService extends BaseClientService<ScadaAoiLine> {
	
	public ScadaAoiLineVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiLineVo>  selectListVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiLineVo>  selectPageVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiLineVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiLineVo>  selectListExtendVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiLineVo>  selectPageExtendVoByParamVo(ScadaAoiLineParamVo scadaAoiLine, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiLineParamVo scadaAoiLineParamVo, CommonParam commonParam);		
}
