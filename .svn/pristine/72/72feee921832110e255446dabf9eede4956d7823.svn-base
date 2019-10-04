package com.techsoft.client.service.scada;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.ScadaAoiEntity;
import com.techsoft.entity.scada.ScadaAoiEntityVo;
import com.techsoft.entity.scada.ScadaAoiEntityParamVo;

public interface ClientScadaAoiEntityService extends BaseClientService<ScadaAoiEntity> {
	
	public ScadaAoiEntityVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiEntityVo>  selectListVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiEntityVo>  selectPageVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ScadaAoiEntityVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<ScadaAoiEntityVo>  selectListExtendVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<ScadaAoiEntityVo>  selectPageExtendVoByParamVo(ScadaAoiEntityParamVo scadaAoiEntity, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(ScadaAoiEntityParamVo scadaAoiEntityParamVo, CommonParam commonParam);		
}
