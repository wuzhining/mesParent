package com.techsoft.client.service.equip;

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
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.EquipSpecsFixtureArea;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.EquipWorkStackProduct;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.equip.EquipWorkStackProductParamVo;
import com.techsoft.entity.equip.EquipWorkStackProductVo;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.work.WorkPlanEquipParamVo;
import com.techsoft.service.barcode.BarcodeMainService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipSpecsFixtureAreaService;
import com.techsoft.service.equip.EquipSpecsFixtureService;
import com.techsoft.service.equip.EquipWorkService;
import com.techsoft.service.equip.EquipWorkStackProductService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.work.WorkPlanEquipService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientEquipWorkStackProductServiceImpl extends BaseClientServiceImpl<EquipWorkStackProduct>
		implements ClientEquipWorkStackProductService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkStackProductService equipWorkStackProductService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkService equipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanEquipService workPlanEquipService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkTaskProcedureService workTaskProcedureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BarcodeMainService barcodeMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureAreaService equipSpecsFixtureAreaService;

	@Override
	public BaseService<EquipWorkStackProduct> getBaseService() {
		return equipWorkStackProductService;
	}

	private EquipWorkStackProductVo getVo(EquipWorkStackProduct equipWorkStackProduct, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkStackProductVo vo = new EquipWorkStackProductVo(equipWorkStackProduct);
		// TODO 此处填充其它关联字段的处理代码
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				if (productMaterial.getSkuValue() != null && productMaterial.getSkuValue() != "") {
					ProductMaterialVo productMaterialVo = new ProductMaterialVo();
					productMaterialVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMaterialVo);
				}
				vo.setProductMaterial(productMaterial);
			}
		}
		// 物品类型
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (materialCode != null) {
				ConfigDictionary dictionary = configDictionaryService.selectById(materialCode.getProductTypeDictId(),
						commonParam);
				vo.setProductType(dictionary);
			}
		}
		//原材料
		if(vo.getRawProductId() != null && vo.getRawProductId() > 0L){
			ProductMain rawProductMain = productMainService.selectById(vo.getRawProductId(), commonParam);
			if(rawProductMain != null){
				vo.setRawProductMain(rawProductMain);
			}
		}
		//原材料规格
		if(vo.getRawMaterialId() != null && vo.getRawMaterialId() > 0L){
			ProductMaterial rawProductMaterial = productMaterialService.selectById(vo.getRawMaterialId(), commonParam);
			if(rawProductMaterial != null){
				if(rawProductMaterial.getSkuValue() != null && rawProductMaterial.getSkuValue() != ""){
					ProductMaterialVo rawProductMaterialVo = new ProductMaterialVo();
					rawProductMaterialVo.setSkuValue(rawProductMaterial.getSkuValue());
					vo.setRawProductMaterialVo(rawProductMaterialVo);;
				}
				vo.setRawProductMaterial(rawProductMaterial);
			}
		}
		//工具品种规格
		if(vo.getSpecsFixtureId() != null && vo.getSpecsFixtureId() > 0L){
			EquipSpecsFixture equipSpecsFixture = equipSpecsFixtureService.selectById(vo.getSpecsFixtureId(), commonParam);
			if(equipSpecsFixture != null){
				vo.setEquipSpecsFixture(equipSpecsFixture);
			}
		}
		//工具品种规格区域
		if(vo.getSpecsFixtureAreaId()!= null && vo.getSpecsFixtureAreaId() > 0L){
			EquipSpecsFixtureArea equipSpecsFixtureArea = equipSpecsFixtureAreaService.selectById(vo.getSpecsFixtureAreaId(), commonParam);
			if(equipSpecsFixtureArea != null){
				vo.setEquipSpecsFixtureArea(equipSpecsFixtureArea);
			}
		}
		return vo;
	}

	private EquipWorkStackProductVo getExtendVo(EquipWorkStackProduct equipWorkStackProduct, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkStackProductVo vo = this.getVo(equipWorkStackProduct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	}

	private List<EquipWorkStackProductVo> getVoList(List<EquipWorkStackProduct> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkStackProductVo> voList = new ArrayList<EquipWorkStackProductVo>();
		for (EquipWorkStackProduct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<EquipWorkStackProductVo> getExtendVoList(List<EquipWorkStackProduct> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkStackProductVo> voList = new ArrayList<EquipWorkStackProductVo>();
		for (EquipWorkStackProduct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public EquipWorkStackProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkStackProduct entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<EquipWorkStackProductVo> selectListVoByParamVo(EquipWorkStackProductParamVo equipWorkStackProduct,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipWorkStackProduct == null) {
			equipWorkStackProduct = new EquipWorkStackProductParamVo();
		}
		equipWorkStackProduct.setTenantId(commonParam.getTenantId());

		List<EquipWorkStackProduct> list = (List<EquipWorkStackProduct>) this.getBaseService()
				.selectListByParamVo(equipWorkStackProduct, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkStackProductVo> selectPageVoByParamVo(EquipWorkStackProductParamVo equipWorkStackProduct,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipWorkStackProduct == null) {
			equipWorkStackProduct = new EquipWorkStackProductParamVo();
		}
		equipWorkStackProduct.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkStackProduct> list = (PageInfo<EquipWorkStackProduct>) this.getBaseService()
				.selectPageByParamVo(equipWorkStackProduct, commonParam, pageNo, pageSize);
		List<EquipWorkStackProductVo> volist = new ArrayList<EquipWorkStackProductVo>();

		Iterator<EquipWorkStackProduct> iter = list.getList().iterator();
		EquipWorkStackProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			vo.setProductMain(productMainService.selectById(vo.getProductId(), commonParam));
			vo.setProductMaterial(productMaterialService.selectById(vo.getMaterialId(), commonParam));
			volist.add(vo);
		}

		Page<EquipWorkStackProductVo> vpage = new Page<EquipWorkStackProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public EquipWorkStackProductVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkStackProduct entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<EquipWorkStackProductVo> selectListExtendVoByParamVo(EquipWorkStackProductParamVo equipWorkStackProduct,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipWorkStackProduct == null) {
			equipWorkStackProduct = new EquipWorkStackProductParamVo();
		}
		equipWorkStackProduct.setTenantId(commonParam.getTenantId());

		List<EquipWorkStackProduct> list = (List<EquipWorkStackProduct>) this.getBaseService()
				.selectListByParamVo(equipWorkStackProduct, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkStackProductVo> selectPageExtendVoByParamVo(
			EquipWorkStackProductParamVo equipWorkStackProduct, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (equipWorkStackProduct == null) {
			equipWorkStackProduct = new EquipWorkStackProductParamVo();
		}
		equipWorkStackProduct.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkStackProduct> list = (PageInfo<EquipWorkStackProduct>) this.getBaseService()
				.selectPageByParamVo(equipWorkStackProduct, commonParam, pageNo, pageSize);
		List<EquipWorkStackProductVo> volist = new ArrayList<EquipWorkStackProductVo>();

		Iterator<EquipWorkStackProduct> iter = list.getList().iterator();
		EquipWorkStackProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipWorkStackProductVo> vpage = new Page<EquipWorkStackProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(EquipWorkStackProductParamVo equipWorkStackProductParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		EquipWorkStackProduct equipWorkStackProduct = null;
		try {
			if (equipWorkStackProductParamVo.getId() == null) {// 新增

				equipWorkStackProductParamVo.setTenantId(commonParam.getTenantId());
				equipWorkStackProduct = equipWorkStackProductService.saveOrUpdate(equipWorkStackProductParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				EquipWorkStackProduct equipWorkStackProductVoTemp = this
						.selectById(equipWorkStackProductParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipWorkStackProductVoTemp, equipWorkStackProductParamVo);

				equipWorkStackProduct = equipWorkStackProductService.saveOrUpdate(equipWorkStackProductVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(equipWorkStackProduct);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public List<EquipWorkStackProductVo> listRawMaterial(CommonParam commonParam, Long factoryId, String equipCode) {
		List<EquipWorkStackProductVo> list = new ArrayList();
		if (factoryId == null) {
			return null;
		}

		if (StringUtils.isBlank(equipCode)) {
			return null;
		}
		try {
			EquipWork equipWork = equipWorkService.getByEquipCode(equipCode, commonParam);
			if (equipWork != null) {

				if (equipWork != null) {
 
					WorkPlanEquipParamVo workPlanEquipParamVo = new WorkPlanEquipParamVo();
					workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
					workPlanEquipParamVo.setFactoryId(factoryId);
					workPlanEquipParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
					workPlanEquipParamVo.setEquipWorkId(equipWork.getId());
					WorkPlanEquip workPlanEquip = null;
					List<WorkPlanEquip> workPlanEquipList = workPlanEquipService
							.selectListCanWorking(workPlanEquipParamVo, commonParam);
					if ((workPlanEquipList != null) && (!workPlanEquipList.isEmpty())) {
						for (WorkPlanEquip tempWorkPlanEquip : workPlanEquipList) {
							// 暂时只支持一个设备同时间只进行一个工序任务
							workPlanEquip = tempWorkPlanEquip;
						}
					}

					if (workPlanEquip != null) {
 
						WorkTaskProcedure workTaskProcedure = workTaskProcedureService
								.selectById(workPlanEquip.getTaskId(), commonParam);
					 
						EquipWorkStackProductParamVo equipWorkStackProductParamVo = new EquipWorkStackProductParamVo();
						equipWorkStackProductParamVo.setTenantId(commonParam.getTenantId());
						equipWorkStackProductParamVo.setEquipWorkId(equipWork.getId());
						equipWorkStackProductParamVo.setMaterialId(workTaskProcedure.getMaterialId());
						List<EquipWorkStackProduct> equipWorkStackProductList = equipWorkStackProductService
								.selectListByParamVo(equipWorkStackProductParamVo, commonParam);

						if ((equipWorkStackProductList != null) && (!equipWorkStackProductList.isEmpty())) {

							List<BarcodeMain> barcodeMainList = new ArrayList<BarcodeMain>();
							BarcodeMainParamVo barcodeMainParamVo = new BarcodeMainParamVo();
							barcodeMainParamVo.setTenantId(commonParam.getTenantId());
							barcodeMainParamVo.setFactoryId(factoryId);
							barcodeMainParamVo.setEquipWorkId(equipWork.getId());
							barcodeMainList = barcodeMainService.selectListByParamVo(barcodeMainParamVo, commonParam);
 
							for (EquipWorkStackProduct equipWorkStackProduct : equipWorkStackProductList) {
								EquipWorkStackProductVo equipWorkStackProductVo = getVo(equipWorkStackProduct,
										commonParam);
								equipWorkStackProductVo.setIsBind(EnumYesOrNo.NO.getValue());
								if ((equipWorkStackProductList != null) && (!equipWorkStackProductList.isEmpty())) {
									for (BarcodeMain barcodeMain : barcodeMainList) {
										if (barcodeMain.getMaterialId()
												.equals(equipWorkStackProduct.getRawMaterialId())) {
											equipWorkStackProductVo.setIsBind(EnumYesOrNo.YES.getValue());
										}
									}
								}
								list.add(equipWorkStackProductVo);

							}
						}
					}
				}
			}
		} catch (BusinessException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
