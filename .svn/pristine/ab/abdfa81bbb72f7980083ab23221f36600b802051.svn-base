package com.techsoft.client.service.quality;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.QualitySampleRule;
import com.techsoft.entity.quality.QualitySampleRuleVo;
import com.techsoft.entity.quality.QualitySampleRuleParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.quality.QualitySampleRuleService;

@org.springframework.stereotype.Service
public class ClientQualitySampleRuleServiceImpl extends BaseClientServiceImpl<QualitySampleRule>
		implements ClientQualitySampleRuleService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualitySampleRuleService qualitySampleRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<QualitySampleRule> getBaseService() {
		return qualitySampleRuleService;
	}

	private QualitySampleRuleVo getVo(QualitySampleRule qualitySampleRule, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRuleVo vo = new QualitySampleRuleVo(qualitySampleRule);

		if (vo.getInspectModeDictId() != null && vo.getInspectModeDictId() > 0L) {
			ConfigDictionary configDictionaryList = configDictionaryService.selectById(vo.getInspectModeDictId(),
					commonParam);
			if (configDictionaryList != null) {
				vo.setConfigDictionary(configDictionaryList);
			}
		}

		return vo;
	}

	private QualitySampleRuleVo getExtendVo(QualitySampleRule qualitySampleRule, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRuleVo vo = this.getVo(qualitySampleRule, commonParam);

		return vo;
	}

	private List<QualitySampleRuleVo> getVoList(List<QualitySampleRule> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleRuleVo> voList = new ArrayList<QualitySampleRuleVo>();
		for (QualitySampleRule entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualitySampleRuleVo> getExtendVoList(List<QualitySampleRule> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleRuleVo> voList = new ArrayList<QualitySampleRuleVo>();
		for (QualitySampleRule entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualitySampleRuleVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		QualitySampleRule entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualitySampleRuleVo> selectListVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleRule == null) {
			qualitySampleRule = new QualitySampleRuleParamVo();
		}
		qualitySampleRule.setTenantId(commonParam.getTenantId());

		List<QualitySampleRule> list = (List<QualitySampleRule>) this.getBaseService()
				.selectListByParamVo(qualitySampleRule, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleRuleVo> selectPageVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualitySampleRule == null) {
			qualitySampleRule = new QualitySampleRuleParamVo();
		}
		qualitySampleRule.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleRule> list = (PageInfo<QualitySampleRule>) this.getBaseService()
				.selectPageByParamVo(qualitySampleRule, commonParam, pageNo, pageSize);
		List<QualitySampleRuleVo> volist = new ArrayList<QualitySampleRuleVo>();

		Iterator<QualitySampleRule> iter = list.getList().iterator();
		QualitySampleRuleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleRuleVo> vpage = new Page<QualitySampleRuleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualitySampleRuleVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRule entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualitySampleRuleVo> selectListExtendVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleRule == null) {
			qualitySampleRule = new QualitySampleRuleParamVo();
		}
		qualitySampleRule.setTenantId(commonParam.getTenantId());

		List<QualitySampleRule> list = (List<QualitySampleRule>) this.getBaseService()
				.selectListByParamVo(qualitySampleRule, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleRuleVo> selectPageExtendVoByParamVo(QualitySampleRuleParamVo qualitySampleRule,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualitySampleRule == null) {
			qualitySampleRule = new QualitySampleRuleParamVo();
		}
		qualitySampleRule.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleRule> list = (PageInfo<QualitySampleRule>) this.getBaseService()
				.selectPageByParamVo(qualitySampleRule, commonParam, pageNo, pageSize);
		List<QualitySampleRuleVo> volist = new ArrayList<QualitySampleRuleVo>();

		Iterator<QualitySampleRule> iter = list.getList().iterator();
		QualitySampleRuleVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleRuleVo> vpage = new Page<QualitySampleRuleVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualitySampleRuleParamVo qualitySampleRuleParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualitySampleRule qualitySampleRule = null;
		try {
			if (qualitySampleRuleParamVo.getId() == null) {// 新增

				qualitySampleRuleParamVo.setTenantId(commonParam.getTenantId());
				qualitySampleRule = qualitySampleRuleService.saveOrUpdate(qualitySampleRuleParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				QualitySampleRule qualitySampleRuleVoTemp = this.selectById(qualitySampleRuleParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(qualitySampleRuleVoTemp, qualitySampleRuleParamVo);

				qualitySampleRule = qualitySampleRuleService.saveOrUpdate(qualitySampleRuleVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualitySampleRule);
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
