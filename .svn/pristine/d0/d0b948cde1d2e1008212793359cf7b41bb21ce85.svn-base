package com.techsoft.client.service.equip;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.equip.EquipFixtureVo;
import com.techsoft.entity.equip.EquipFixtureParamVo;

public interface ClientEquipFixtureService extends BaseClientService<EquipFixture> {

	public EquipFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipFixtureVo> selectListVoByParamVo(EquipFixtureParamVo equipFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<EquipFixtureVo> selectPageVoByParamVo(EquipFixtureParamVo equipFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public EquipFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<EquipFixtureVo> selectListExtendVoByParamVo(EquipFixtureParamVo equipFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<EquipFixtureVo> selectPageExtendVoByParamVo(EquipFixtureParamVo equipFixture,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(EquipFixtureParamVo equipFixtureParamVo, CommonParam commonParam);
}
