package com.techsoft.client.service.quality;

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
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.common.QualityInspectModuleRelation;
import com.techsoft.entity.quality.QualityInspectModuleRelationParamVo;
import com.techsoft.entity.quality.QualityInspectModuleRelationVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.quality.QualityInspectItemService;
import com.techsoft.service.quality.QualityInspectModuleRelationService;
import com.techsoft.service.quality.QualitySampleLevelService;

@org.springframework.stereotype.Service
public class ClientQualityInspectModuleRelationServiceImpl extends BaseClientServiceImpl<QualityInspectModuleRelation>
		implements ClientQualityInspectModuleRelationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualityInspectModuleRelationService qualityInspectModuleRelationService;
	// 模版检验
	@com.alibaba.dubbo.config.annotation.Reference
	private QualitySampleLevelService qualitySampleLevelService;
	// 模版检验
	@com.alibaba.dubbo.config.annotation.Reference
	private QualityInspectItemService qualityInspectItemService;
	// 供应商
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	// 物品
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	// 物品分类
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService productClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<QualityInspectModuleRelation> getBaseService() {
		return qualityInspectModuleRelationService;
	}

	private QualityInspectModuleRelationVo getVo(QualityInspectModuleRelation qualityInspectModuleRelation,
			CommonParam commonParam) throws BusinessException, SQLException {
		QualityInspectModuleRelationVo vo = new QualityInspectModuleRelationVo(qualityInspectModuleRelation);

		// 检验水平
		if (vo.getSampleLevelDictId() != null && vo.getSampleLevelDictId() > 0L) {
			ConfigDictionary sampleLevelList = configDictionaryService.selectById(vo.getSampleLevelDictId(),
					commonParam);
			if (sampleLevelList != null) {
				vo.setSampleLevel(sampleLevelList);
			}
		}

		// 检验等级
		if (vo.getSampleLevelRankDictId() != null && vo.getSampleLevelRankDictId() > 0L) {
			ConfigDictionary sampleLevelRankList = configDictionaryService.selectById(vo.getSampleLevelRankDictId(),
					commonParam);
			if (sampleLevelRankList != null) {
				vo.setSampleLevelRank(sampleLevelRankList);
			}
		}

		// 检验模板
		if (vo.getInspectItemId() != null && vo.getInspectItemId() > 0L) {
			QualityInspectItem inspectItemList = qualityInspectItemService.selectById(vo.getInspectItemId(),
					commonParam);
			if (inspectItemList != null) {
				vo.setInspectItem(inspectItemList);
			}
		}

		// 物品供应商
		if (vo.getSupplierId() != null && vo.getSupplierId() > 0L) {
			FirmPartner supplierList = firmPartnerService.selectById(vo.getSupplierId(), commonParam);
			if (supplierList != null) {
				vo.setSupplier(supplierList);
			}
		}

		// 物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productList = productMainService.selectById(vo.getProductId(), commonParam);
			if (productList != null) {
				//物品类型
				if(productList.getProductTypeDictId() != null && productList.getProductTypeDictId() > 0L){
					ConfigDictionary productType = configDictionaryService.selectById(productList.getProductTypeDictId(), commonParam);
					if(productType != null){
						vo.setProductType(productType);
					}
				}
				vo.setProductMain(productList);
			}
		}

		// 物品分类
		if (vo.getProductClassesId() != null && vo.getProductClassesId() > 0L) {
			ProductClasses classesList = productClassesService.selectById(vo.getProductClassesId(), commonParam);
			if (classesList != null) {
				vo.setProductClasses(classesList);
			}
		}

		return vo;
	}

	private QualityInspectModuleRelationVo getExtendVo(QualityInspectModuleRelation qualityInspectModuleRelation,
			CommonParam commonParam) throws BusinessException, SQLException {
		QualityInspectModuleRelationVo vo = this.getVo(qualityInspectModuleRelation, commonParam);

		return vo;
	}

	private List<QualityInspectModuleRelationVo> getVoList(List<QualityInspectModuleRelation> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<QualityInspectModuleRelationVo> voList = new ArrayList<QualityInspectModuleRelationVo>();
		for (QualityInspectModuleRelation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualityInspectModuleRelationVo> getExtendVoList(List<QualityInspectModuleRelation> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<QualityInspectModuleRelationVo> voList = new ArrayList<QualityInspectModuleRelationVo>();
		for (QualityInspectModuleRelation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualityInspectModuleRelationVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectModuleRelation entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualityInspectModuleRelationVo> selectListVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (qualityInspectModuleRelation == null) {
			qualityInspectModuleRelation = new QualityInspectModuleRelationParamVo();
		}
		qualityInspectModuleRelation.setTenantId(commonParam.getTenantId());

		List<QualityInspectModuleRelation> list = (List<QualityInspectModuleRelation>) this.getBaseService()
				.selectListByParamVo(qualityInspectModuleRelation, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectModuleRelationVo> selectPageVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (qualityInspectModuleRelation == null) {
			qualityInspectModuleRelation = new QualityInspectModuleRelationParamVo();
		}
		qualityInspectModuleRelation.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectModuleRelation> list = (PageInfo<QualityInspectModuleRelation>) this.getBaseService()
				.selectPageByParamVo(qualityInspectModuleRelation, commonParam, pageNo, pageSize);
		List<QualityInspectModuleRelationVo> volist = new ArrayList<QualityInspectModuleRelationVo>();

		Iterator<QualityInspectModuleRelation> iter = list.getList().iterator();
		QualityInspectModuleRelationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectModuleRelationVo> vpage = new Page<QualityInspectModuleRelationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualityInspectModuleRelationVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectModuleRelation entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualityInspectModuleRelationVo> selectListExtendVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (qualityInspectModuleRelation == null) {
			qualityInspectModuleRelation = new QualityInspectModuleRelationParamVo();
		}
		qualityInspectModuleRelation.setTenantId(commonParam.getTenantId());

		List<QualityInspectModuleRelation> list = (List<QualityInspectModuleRelation>) this.getBaseService()
				.selectListByParamVo(qualityInspectModuleRelation, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectModuleRelationVo> selectPageExtendVoByParamVo(
			QualityInspectModuleRelationParamVo qualityInspectModuleRelation, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (qualityInspectModuleRelation == null) {
			qualityInspectModuleRelation = new QualityInspectModuleRelationParamVo();
		}
		qualityInspectModuleRelation.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectModuleRelation> list = (PageInfo<QualityInspectModuleRelation>) this.getBaseService()
				.selectPageByParamVo(qualityInspectModuleRelation, commonParam, pageNo, pageSize);
		List<QualityInspectModuleRelationVo> volist = new ArrayList<QualityInspectModuleRelationVo>();

		Iterator<QualityInspectModuleRelation> iter = list.getList().iterator();
		QualityInspectModuleRelationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectModuleRelationVo> vpage = new Page<QualityInspectModuleRelationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualityInspectModuleRelationParamVo qualityInspectModuleRelationParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualityInspectModuleRelation qualityInspectModuleRelation = null;
		try {
			if (qualityInspectModuleRelationParamVo.getId() == null) {// 新增

				qualityInspectModuleRelationParamVo.setTenantId(commonParam.getTenantId());
				qualityInspectModuleRelation = qualityInspectModuleRelationService
						.saveOrUpdate(qualityInspectModuleRelationParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				QualityInspectModuleRelation qualityInspectModuleRelationVoTemp = this
						.selectById(qualityInspectModuleRelationParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(qualityInspectModuleRelationVoTemp, qualityInspectModuleRelationParamVo);

				qualityInspectModuleRelation = qualityInspectModuleRelationService
						.saveOrUpdate(qualityInspectModuleRelationVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualityInspectModuleRelation);
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
