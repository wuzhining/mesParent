package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipFixtureConfig;
import com.techsoft.entity.equip.EquipFixtureConfigVo;
import com.techsoft.entity.equip.EquipFixtureConfigParamVo;

public interface ClientEquipFixtureConfigService extends BaseClientService<EquipFixtureConfig> {

	public EquipFixtureConfigVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipFixtureConfigVo> selectListVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<EquipFixtureConfigVo> selectPageVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public EquipFixtureConfigVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<EquipFixtureConfigVo> selectListExtendVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<EquipFixtureConfigVo> selectPageExtendVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(EquipFixtureConfigParamVo equipFixtureConfigParamVo, CommonParam commonParam);
}
