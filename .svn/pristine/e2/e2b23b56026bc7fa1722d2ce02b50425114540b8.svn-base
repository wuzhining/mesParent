package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.equip.EquipSpecsWorkVo;
import com.techsoft.entity.equip.EquipSpecsWorkParamVo;

public interface ClientEquipSpecsWorkService extends BaseClientService<EquipSpecsWork> {
	
	public EquipSpecsWorkVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsWorkVo>  selectListVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsWorkVo>  selectPageVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipSpecsWorkVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipSpecsWorkVo>  selectListExtendVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipSpecsWorkVo>  selectPageExtendVoByParamVo(EquipSpecsWorkParamVo equipSpecsWork, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipSpecsWorkParamVo equipSpecsWorkParamVo, CommonParam commonParam);		
}
