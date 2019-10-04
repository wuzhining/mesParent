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
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.QualityInspectType;
import com.techsoft.entity.quality.QualityInspectTypeVo;
import com.techsoft.entity.quality.QualityInspectTypeParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.quality.QualityInspectTypeService;

@org.springframework.stereotype.Service
public class ClientQualityInspectTypeServiceImpl extends BaseClientServiceImpl<QualityInspectType>
		implements ClientQualityInspectTypeService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualityInspectTypeService qualityInspectTypeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@Override
	public BaseService<QualityInspectType> getBaseService() {
		return qualityInspectTypeService;
	}

	private QualityInspectTypeVo getVo(QualityInspectType qualityInspectType, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectTypeVo vo = new QualityInspectTypeVo(qualityInspectType);

		// QC类型list
		if (vo.getInspectTypeQcDictId() != null && vo.getInspectTypeQcDictId() > 0L) {
			ConfigDictionary dictIdList = configDictionaryService.selectById(vo.getInspectTypeQcDictId(), commonParam);
			if (dictIdList != null) {
				vo.setTypeQcList(dictIdList);
			}
		}
		// 检验项类型list
		if (vo.getInspectItemTypeDictId() != null && vo.getInspectItemTypeDictId() > 0L) {
			ConfigDictionary itemTypeDictList = configDictionaryService.selectById(vo.getInspectItemTypeDictId(),
					commonParam);
			if (itemTypeDictList != null) {
				vo.setItemTypeList(itemTypeDictList);
			}
		}
		return vo;
	}

	private QualityInspectTypeVo getExtendVo(QualityInspectType qualityInspectType, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectTypeVo vo = this.getVo(qualityInspectType, commonParam);

		return vo;
	}

	private List<QualityInspectTypeVo> getVoList(List<QualityInspectType> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualityInspectTypeVo> voList = new ArrayList<QualityInspectTypeVo>();
		for (QualityInspectType entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualityInspectTypeVo> getExtendVoList(List<QualityInspectType> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualityInspectTypeVo> voList = new ArrayList<QualityInspectTypeVo>();
		for (QualityInspectType entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualityInspectTypeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		QualityInspectType entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualityInspectTypeVo> selectListVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualityInspectType == null) {
			qualityInspectType = new QualityInspectTypeParamVo();
		}
		qualityInspectType.setTenantId(commonParam.getTenantId());

		List<QualityInspectType> list = (List<QualityInspectType>) this.getBaseService()
				.selectListByParamVo(qualityInspectType, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectTypeVo> selectPageVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualityInspectType == null) {
			qualityInspectType = new QualityInspectTypeParamVo();
		}
		qualityInspectType.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectType> list = (PageInfo<QualityInspectType>) this.getBaseService()
				.selectPageByParamVo(qualityInspectType, commonParam, pageNo, pageSize);
		List<QualityInspectTypeVo> volist = new ArrayList<QualityInspectTypeVo>();

		Iterator<QualityInspectType> iter = list.getList().iterator();
		QualityInspectTypeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectTypeVo> vpage = new Page<QualityInspectTypeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualityInspectTypeVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectType entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualityInspectTypeVo> selectListExtendVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualityInspectType == null) {
			qualityInspectType = new QualityInspectTypeParamVo();
		}
		qualityInspectType.setTenantId(commonParam.getTenantId());

		List<QualityInspectType> list = (List<QualityInspectType>) this.getBaseService()
				.selectListByParamVo(qualityInspectType, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectTypeVo> selectPageExtendVoByParamVo(QualityInspectTypeParamVo qualityInspectType,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualityInspectType == null) {
			qualityInspectType = new QualityInspectTypeParamVo();
		}
		qualityInspectType.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectType> list = (PageInfo<QualityInspectType>) this.getBaseService()
				.selectPageByParamVo(qualityInspectType, commonParam, pageNo, pageSize);
		List<QualityInspectTypeVo> volist = new ArrayList<QualityInspectTypeVo>();

		Iterator<QualityInspectType> iter = list.getList().iterator();
		QualityInspectTypeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectTypeVo> vpage = new Page<QualityInspectTypeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualityInspectTypeParamVo qualityInspectTypeParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualityInspectType qualityInspectType = null;
		try {
			if (qualityInspectTypeParamVo.getId() == null) {// 新增
				//生成编码
				String code = configCodeRuleService.createCode(QualityInspectType.class.getName(), null, null, commonParam);
				if(code!=null&&code!=""){
					qualityInspectTypeParamVo.setInspectTypeCode(code);
					qualityInspectTypeParamVo.setTenantId(commonParam.getTenantId());
					qualityInspectType = qualityInspectTypeService.saveOrUpdate(qualityInspectTypeParamVo, commonParam);
					resultMessage.setIsSuccess(true);
				}else{
					resultMessage.addErr("请维护检验类型编码再添加");
					return resultMessage;
				}
				
			} else { // 修改
				QualityInspectType qualityInspectTypeVoTemp = this.selectById(qualityInspectTypeParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(qualityInspectTypeVoTemp, qualityInspectTypeParamVo);

				qualityInspectType = qualityInspectTypeService.saveOrUpdate(qualityInspectTypeVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualityInspectType);
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
