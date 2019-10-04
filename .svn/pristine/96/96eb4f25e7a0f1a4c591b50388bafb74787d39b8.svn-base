package com.techsoft.client.service.equip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixtureConfig;
import com.techsoft.entity.equip.EquipFixtureConfigParamVo;
import com.techsoft.entity.equip.EquipFixtureConfigVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureConfigService;

@org.springframework.stereotype.Service
public class ClientEquipFixtureConfigServiceImpl extends BaseClientServiceImpl<EquipFixtureConfig>
		implements ClientEquipFixtureConfigService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureConfigService equipFixtureConfigService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<EquipFixtureConfig> getBaseService() {
		return equipFixtureConfigService;
	}

	private EquipFixtureConfigVo getVo(EquipFixtureConfig equipFixtureConfig, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipFixtureConfigVo vo = new EquipFixtureConfigVo(equipFixtureConfig);
		if (vo.getFixtureTypeDictId() != null && vo.getFixtureTypeDictId() > 0L) {
			ConfigDictionary fixtureTypeDict = configDictionaryService.selectById(vo.getFixtureTypeDictId(),
					commonParam);
			if (fixtureTypeDict != null) {
				vo.setConfigFixtureTypeDict(fixtureTypeDict);
			}
		}
		if (vo.getCorrectTypeDictId() != null && vo.getCorrectTypeDictId() > 0L) {
			ConfigDictionary correctTypeDict = configDictionaryService.selectById(vo.getCorrectTypeDictId(),
					commonParam);
			if (correctTypeDict != null) {
				vo.setConfigCorrectTypeDict(correctTypeDict);
			}
		}
		if (vo.getScrapTypeDictId() != null && vo.getScrapTypeDictId() > 0L) {
			ConfigDictionary scrapTypeDict = configDictionaryService.selectById(vo.getScrapTypeDictId(), commonParam);
			if (scrapTypeDict != null) {
				vo.setConfigScrapTypeDict(scrapTypeDict);
			}
		}
		return vo;
	}

	private EquipFixtureConfigVo getExtendVo(EquipFixtureConfig equipFixtureConfig, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipFixtureConfigVo vo = this.getVo(equipFixtureConfig, commonParam);

		return vo;
	}

	private List<EquipFixtureConfigVo> getVoList(List<EquipFixtureConfig> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipFixtureConfigVo> voList = new ArrayList<EquipFixtureConfigVo>();
		for (EquipFixtureConfig entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<EquipFixtureConfigVo> getExtendVoList(List<EquipFixtureConfig> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipFixtureConfigVo> voList = new ArrayList<EquipFixtureConfigVo>();
		for (EquipFixtureConfig entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public EquipFixtureConfigVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureConfig entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<EquipFixtureConfigVo> selectListVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipFixtureConfig == null) {
			equipFixtureConfig = new EquipFixtureConfigParamVo();
		}
		equipFixtureConfig.setTenantId(commonParam.getTenantId());

		List<EquipFixtureConfig> list = (List<EquipFixtureConfig>) this.getBaseService()
				.selectListByParamVo(equipFixtureConfig, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipFixtureConfigVo> selectPageVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipFixtureConfig == null) {
			equipFixtureConfig = new EquipFixtureConfigParamVo();
		}
		equipFixtureConfig.setTenantId(commonParam.getTenantId());

		PageInfo<EquipFixtureConfig> list = (PageInfo<EquipFixtureConfig>) this.getBaseService()
				.selectPageByParamVo(equipFixtureConfig, commonParam, pageNo, pageSize);
		List<EquipFixtureConfigVo> volist = new ArrayList<EquipFixtureConfigVo>();

		Iterator<EquipFixtureConfig> iter = list.getList().iterator();
		EquipFixtureConfigVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipFixtureConfigVo> vpage = new Page<EquipFixtureConfigVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public EquipFixtureConfigVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipFixtureConfig entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<EquipFixtureConfigVo> selectListExtendVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipFixtureConfig == null) {
			equipFixtureConfig = new EquipFixtureConfigParamVo();
		}
		equipFixtureConfig.setTenantId(commonParam.getTenantId());

		List<EquipFixtureConfig> list = (List<EquipFixtureConfig>) this.getBaseService()
				.selectListByParamVo(equipFixtureConfig, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipFixtureConfigVo> selectPageExtendVoByParamVo(EquipFixtureConfigParamVo equipFixtureConfig,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipFixtureConfig == null) {
			equipFixtureConfig = new EquipFixtureConfigParamVo();
		}
		equipFixtureConfig.setTenantId(commonParam.getTenantId());

		PageInfo<EquipFixtureConfig> list = (PageInfo<EquipFixtureConfig>) this.getBaseService()
				.selectPageByParamVo(equipFixtureConfig, commonParam, pageNo, pageSize);
		List<EquipFixtureConfigVo> volist = new ArrayList<EquipFixtureConfigVo>();

		Iterator<EquipFixtureConfig> iter = list.getList().iterator();
		EquipFixtureConfigVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipFixtureConfigVo> vpage = new Page<EquipFixtureConfigVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(EquipFixtureConfigParamVo equipFixtureConfigParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		EquipFixtureConfig equipFixtureConfig = null;
		if (equipFixtureConfigParamVo.getNumberScrapPeriod() == null) {
			resultMessage.addErr("校正周期次数不能为空");
			return resultMessage;
		}
		try {
			if (equipFixtureConfigParamVo.getId() == null) {// 新增

				equipFixtureConfigParamVo.setTenantId(commonParam.getTenantId());
				equipFixtureConfig = equipFixtureConfigService.saveOrUpdate(equipFixtureConfigParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				EquipFixtureConfig equipFixtureConfigVoTemp = this.selectById(equipFixtureConfigParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(equipFixtureConfigVoTemp, equipFixtureConfigParamVo);

				equipFixtureConfig = equipFixtureConfigService.saveOrUpdate(equipFixtureConfigVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(equipFixtureConfig);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
