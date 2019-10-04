package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.entity.equip.EquipClassesWorkVo;
import com.techsoft.entity.equip.EquipClassesWorkParamVo;

public interface ClientEquipClassesWorkService extends BaseClientService<EquipClassesWork> {
	
	public EquipClassesWorkVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipClassesWorkVo>  selectListVoByParamVo(EquipClassesWorkParamVo equipClassesWork, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipClassesWorkVo>  selectPageVoByParamVo(EquipClassesWorkParamVo equipClassesWork, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipClassesWorkVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipClassesWorkVo>  selectListExtendVoByParamVo(EquipClassesWorkParamVo equipClassesWork, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipClassesWorkVo>  selectPageExtendVoByParamVo(EquipClassesWorkParamVo equipClassesWork, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipClassesWorkParamVo equipClassesWorkParamVo, CommonParam commonParam);		
}
