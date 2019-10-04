package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoiVersion;
import com.techsoft.entity.scada.ScadaAoiVersionVo;
import com.techsoft.entity.scada.ScadaAoiVersionParamVo;

public interface ClientScadaAoiVersionService extends BaseClientService<ScadaAoiVersion> {
	
	public ScadaAoiVersionVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiVersionVo>  selectListVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiVersionVo>  selectPageVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiVersionVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiVersionVo>  selectListExtendVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiVersionVo>  selectPageExtendVoByParamVo(ScadaAoiVersionParamVo scadaAoiVersion, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiVersionParamVo scadaAoiVersionParamVo, CommonParam commonParam);		
}
