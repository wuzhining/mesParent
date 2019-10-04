package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoiWindow;
import com.techsoft.entity.scada.ScadaAoiWindowVo;
import com.techsoft.entity.scada.ScadaAoiWindowParamVo;

public interface ClientScadaAoiWindowService extends BaseClientService<ScadaAoiWindow> {
	
	public ScadaAoiWindowVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiWindowVo>  selectListVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiWindowVo>  selectPageVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiWindowVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiWindowVo>  selectListExtendVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiWindowVo>  selectPageExtendVoByParamVo(ScadaAoiWindowParamVo scadaAoiWindow, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiWindowParamVo scadaAoiWindowParamVo, CommonParam commonParam);		
}
