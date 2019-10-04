package com.techsoft.client.service.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
import com.techsoft.entity.config.ConfigDictionaryParamVo;
import com.techsoft.entity.config.ConfigDictionaryVo;
import com.techsoft.service.config.ConfigDictionaryService;

@org.springframework.stereotype.Service
public class ClientConfigDictionaryServiceImpl extends BaseClientServiceImpl<ConfigDictionary>
		implements ClientConfigDictionaryService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<ConfigDictionary> getBaseService() {
		return configDictionaryService;
	}

	private ConfigDictionaryVo getVo(ConfigDictionary configDictionary, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigDictionaryVo vo = new ConfigDictionaryVo(configDictionary);
		if (configDictionary.getParentId() != null) {
			vo.setParentConfigDictionary(
					configDictionaryService.selectById(configDictionary.getParentId(), commonParam));
		}
		return vo;
	}

	private ConfigDictionaryVo getExtendVo(ConfigDictionary configDictionary, CommonParam commonParam)
			throws BusinessException, SQLException {
		ConfigDictionaryVo vo = this.getVo(configDictionary, commonParam);

		return vo;
	}

	private List<ConfigDictionaryVo> getVoList(List<ConfigDictionary> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigDictionaryVo> voList = new ArrayList<ConfigDictionaryVo>();
		for (ConfigDictionary entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ConfigDictionaryVo> getExtendVoList(List<ConfigDictionary> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ConfigDictionaryVo> voList = new ArrayList<ConfigDictionaryVo>();
		for (ConfigDictionary entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ConfigDictionaryVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigDictionary entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ConfigDictionaryVo> selectListVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configDictionary == null) {
			configDictionary = new ConfigDictionaryParamVo();
		}
		configDictionary.setTenantId(commonParam.getTenantId());

		List<ConfigDictionary> list = (List<ConfigDictionary>) this.getBaseService()
				.selectListByParamVo(configDictionary, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigDictionaryVo> selectPageVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configDictionary == null) {
			configDictionary = new ConfigDictionaryParamVo();
		}
		configDictionary.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigDictionary> list = (PageInfo<ConfigDictionary>) this.getBaseService()
				.selectPageByParamVo(configDictionary, commonParam, pageNo, pageSize);
		List<ConfigDictionaryVo> volist = new ArrayList<ConfigDictionaryVo>();

		Iterator<ConfigDictionary> iter = list.getList().iterator();
		ConfigDictionaryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigDictionaryVo> vpage = new Page<ConfigDictionaryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ConfigDictionaryVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ConfigDictionary entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ConfigDictionaryVo> selectListExtendVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (configDictionary == null) {
			configDictionary = new ConfigDictionaryParamVo();
		}
		configDictionary.setTenantId(commonParam.getTenantId());

		List<ConfigDictionary> list = (List<ConfigDictionary>) this.getBaseService()
				.selectListByParamVo(configDictionary, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ConfigDictionaryVo> selectPageExtendVoByParamVo(ConfigDictionaryParamVo configDictionary,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (configDictionary == null) {
			configDictionary = new ConfigDictionaryParamVo();
		}
		configDictionary.setTenantId(commonParam.getTenantId());

		PageInfo<ConfigDictionary> list = (PageInfo<ConfigDictionary>) this.getBaseService()
				.selectPageByParamVo(configDictionary, commonParam, pageNo, pageSize);
		List<ConfigDictionaryVo> volist = new ArrayList<ConfigDictionaryVo>();

		Iterator<ConfigDictionary> iter = list.getList().iterator();
		ConfigDictionaryVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ConfigDictionaryVo> vpage = new Page<ConfigDictionaryVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ConfigDictionaryParamVo configDictionaryParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		ConfigDictionary configDictionary = null;
		try {

			if (StringUtils.isBlank(configDictionaryParamVo.getDictCode())) {
				resultMessage.addErr("数据字典编码不能为空");
				return resultMessage;
			}

			if (StringUtils.isBlank(configDictionaryParamVo.getDictName())) {
				resultMessage.addErr("数据字典名称不能为空");
				return resultMessage;
			}

			if (StringUtils.isBlank(configDictionaryParamVo.getDictValue())) {
				resultMessage.addErr("数据字典值不能为空");
				return resultMessage;
			}

			configDictionaryParamVo.setDictCode(configDictionaryParamVo.getDictCode().toUpperCase());
			ConfigDictionaryVo configDictionaryTemp = getByCode(configDictionaryParamVo.getDictCode(), commonParam);
			if (configDictionaryTemp != null) {
				if (configDictionaryParamVo.getParentId().equals(1l)) {
					if (configDictionaryParamVo.getId() == null) {

						if (configDictionaryParamVo.getParentId() == null) {
							configDictionaryParamVo.setParentId(1l);
						}
						resultMessage.addErr("数据字典编码已经存在!");
						return resultMessage;

					} else {
						if (!configDictionaryParamVo.getId().equals(configDictionaryTemp.getId())) {
							resultMessage.addErr("数据字典编码已经存在!");
							return resultMessage;

						}
					}
				}
			}

			if (configDictionaryParamVo.getId() == null) {// 新增
				if (configDictionaryParamVo.getParentId() == null) {
					configDictionaryParamVo.setParentId(1l);
				}
				configDictionaryParamVo.setTenantId(commonParam.getTenantId());

				configDictionary = configDictionaryService.saveOrUpdate(configDictionaryParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改

				ConfigDictionary configDictionaryVoTemp = this.selectById(configDictionaryParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(configDictionaryVoTemp, configDictionaryParamVo);

				configDictionary = configDictionaryService.saveOrUpdate(configDictionaryVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(configDictionary);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	public List<ConfigDictionary> selectListByParentId(Long parentId) throws BusinessException, SQLException {
		return configDictionaryService.selectListByParentId(parentId);
	}

	public List<ConfigDictionary> selectListByParentCode(String dictCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		return configDictionaryService.selectListByParentCode(dictCode, commonParam);
	}

	public ConfigDictionaryVo getByCode(String dictCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		return configDictionaryService.getByCode(dictCode, commonParam);
	}

}
