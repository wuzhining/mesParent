package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipWorkProduct;
import com.techsoft.entity.equip.EquipWorkProductVo;
import com.techsoft.entity.equip.EquipWorkProductParamVo;

public interface ClientEquipWorkProductService extends BaseClientService<EquipWorkProduct> {
	
	public EquipWorkProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipWorkProductVo>  selectListVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipWorkProductVo>  selectPageVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public EquipWorkProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<EquipWorkProductVo>  selectListExtendVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<EquipWorkProductVo>  selectPageExtendVoByParamVo(EquipWorkProductParamVo equipWorkProduct, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(EquipWorkProductParamVo equipWorkProductParamVo, CommonParam commonParam);		
}
