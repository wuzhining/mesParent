package com.techsoft.client.service.product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ProductBomZTree;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.product.ProductBomParamVo;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductBomService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;

@org.springframework.stereotype.Service
public class ClientProductBomServiceImpl extends BaseClientServiceImpl<ProductBom> implements ClientProductBomService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductBomService productBomService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService productClassesService;
	private Map<Long, ConfigDictionary> configDictionaryMap = new HashMap<Long, ConfigDictionary>();
	private Map<Long, ProductMain> productMainMap = new HashMap<Long, ProductMain>();
	private Map<Long, ProductClasses> productClassesMap = new HashMap<Long, ProductClasses>();
	private Map<Long, ProductMaterial> productMaterialMap = new HashMap<Long, ProductMaterial>();

	@Override
	public BaseService<ProductBom> getBaseService() {
		return productBomService;
	}

	private ProductBomVo getVo(ProductBom productBom, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBomVo vo = new ProductBomVo(productBom);

		ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
		// System.out.println(" productMain.getId()==" + productMain.getId() +"
		// productMain.getProductTypeDictId()==" +
		// productMain.getProductTypeDictId());

		if (productMain != null) {
			vo.setProductMain(productMain);
			productMainMap.put(vo.getProductId(), productMain);
		}

		// 物品类型
		if (productMain.getProductTypeDictId() != null && productMain.getProductTypeDictId() > 0L) {
			ConfigDictionary productType = configDictionaryService.selectById(productMain.getProductTypeDictId(),
					commonParam);

			if (productType != null) {
				vo.setProductType(productType);
				configDictionaryMap.put(productMain.getProductTypeDictId(), productType);
			}

		}

		// for(Long key:productClassesMap.keySet()){
		// if(productClassesMap.get(key).getId().equals(productMain.getClassesId())){
		//
		// };
		// if((productClassesMap.get(key).getId().equals(productMain.getClassesId()))){
		// vo.setProductClasses(productClassesMap.get(key));
		// }
		// }
		// 物品分类
		if (productMain.getClassesId() != null && productMain.getClassesId() > 0L) {
			ProductClasses productClasses = productClassesService.selectById(productMain.getClassesId(), commonParam);
			if (productClasses != null) {
				vo.setProductClasses(productClasses);
				productClassesMap.put(productMain.getClassesId(), productClasses);
			}
		}

		// 物品规格
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				ProductMaterialVo productMateriaVo = new ProductMaterialVo();
				productMateriaVo.setSkuValue(productMaterial.getSkuValue());
				vo.setProductMaterialVo(productMateriaVo);
				productMaterialMap.put(vo.getMaterialId(), productMaterial);
			}
			vo.setProductMaterial(productMaterial);
			// System.out.println(" productMaterial.getId()==" +
			// productMaterial.getId() +"
			// productMaterial.getProductTypeDictId()==" +
			// productMaterial.getProductTypeDictId());

			// 物品类型
			if (productMaterial.getProductTypeDictId() != null && productMaterial.getProductTypeDictId() > 0L) {
				ConfigDictionary productType = configDictionaryService
						.selectById(productMaterial.getProductTypeDictId(), commonParam);

				if (productType != null) {
					vo.setProductType(productType);
					configDictionaryMap.put(productMain.getProductTypeDictId(), productType);
				}

			}
		}

		// bom状态
		if (vo.getBomStatusDictId() != null && vo.getBomStatusDictId() > 0L) {
			ConfigDictionary bomStatusType = configDictionaryService.selectById(vo.getBomStatusDictId(), commonParam);
			if (bomStatusType != null) {
				vo.setBomStatusType(bomStatusType);
				configDictionaryMap.put(vo.getBomStatusDictId(), bomStatusType);
			}
		}
		return vo;
	}

	private ProductBomVo getExtendVo(ProductBom productBom, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductBomVo vo = this.getVo(productBom, commonParam);

		return vo;
	}

	private List<ProductBomVo> getVoList(List<ProductBom> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductBomVo> voList = new ArrayList<ProductBomVo>();
		for (ProductBom entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ProductBomVo> getExtendVoList(List<ProductBom> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductBomVo> voList = new ArrayList<ProductBomVo>();
		for (ProductBom entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ProductBomVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBom entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ProductBomVo> selectListVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productBom == null) {
			productBom = new ProductBomParamVo();
		}
		productBom.setTenantId(commonParam.getTenantId());

		List<ProductBom> list = (List<ProductBom>) this.getBaseService().selectListByParamVo(productBom, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductBomVo> selectPageVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productBom == null) {
			productBom = new ProductBomParamVo();
		}
		productBom.setTenantId(commonParam.getTenantId());

		PageInfo<ProductBom> list = (PageInfo<ProductBom>) this.getBaseService().selectPageByParamVo(productBom,
				commonParam, pageNo, pageSize);
		List<ProductBomVo> volist = new ArrayList<ProductBomVo>();

		Iterator<ProductBom> iter = list.getList().iterator();
		ProductBomVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductBomVo> vpage = new Page<ProductBomVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ProductBomVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductBom entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ProductBomVo> selectListExtendVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productBom == null) {
			productBom = new ProductBomParamVo();
		}
		productBom.setTenantId(commonParam.getTenantId());

		List<ProductBom> list = (List<ProductBom>) this.getBaseService().selectListByParamVo(productBom, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductBomVo> selectPageExtendVoByParamVo(ProductBomParamVo productBom, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productBom == null) {
			productBom = new ProductBomParamVo();
		}
		productBom.setTenantId(commonParam.getTenantId());

		PageInfo<ProductBom> list = (PageInfo<ProductBom>) this.getBaseService().selectPageByParamVo(productBom,
				commonParam, pageNo, pageSize);
		List<ProductBomVo> volist = new ArrayList<ProductBomVo>();

		Iterator<ProductBom> iter = list.getList().iterator();
		ProductBomVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductBomVo> vpage = new Page<ProductBomVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ProductBomParamVo productBomParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (commonParam.getUserId() != null) {
			productBomParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		}
		if (commonParam.getTenantId() != null) {
			productBomParamVo.setTenantId(commonParam.getTenantId());
		}
		if (productBomParamVo.getCreateUserId() == null) {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}

		if (productBomParamVo.getProductId() == null) {
			resultMessage.addErr("物品ID不能为空");
			return resultMessage;
		}
		if (productBomParamVo.getBomStatusDictId() == null) {
			resultMessage.addErr("bom状态不能为空");
			return resultMessage;
		}
		if (StringUtils.isBlank(productBomParamVo.getRemark())) {
			if (productBomParamVo.getRemark().length() > 128) {
				resultMessage.addErr("备注不能超过128个字符");
				return resultMessage;
			}
		}
		ProductBom productBom = null;
		try {
			if (productBomParamVo.getId() == null) {// 新增
				// 生成编码
				String bomCode = productBomParamVo.getBomCode();
				if (StringUtils.isBlank(bomCode)) {
					bomCode = configCodeRuleService.createCode(ProductBom.class.getName(), null, null, commonParam);
					productBomParamVo.setBomCode(bomCode);
				}
				if (StringUtils.isBlank(bomCode)) {
					resultMessage.addErr("产品BOM编码不能为空");
					return resultMessage;
				}
				// 检验编码是否存在
				ProductBomParamVo productBomSearch = new ProductBomParamVo();
				productBomSearch.setBomCode(bomCode);
				List<ProductBom> list = productBomService.selectListByParamVo(productBomSearch, commonParam);
				if ((list != null) && (!list.isEmpty())) {
					resultMessage.addErr("产品BOM编码已存在");
					return resultMessage;
				}

				int randomInt = (int) ((Math.random() * 9 + 1) * 10000);
				Long idLong = Long.valueOf(productBomParamVo.getParentId().toString() + randomInt);
				productBomParamVo.setTenantId(commonParam.getTenantId());
				ProductBom listBom = productBomService.selectById(productBomParamVo.getParentId(), commonParam);
				if (listBom == null) {
					productBomParamVo.setParentIdes(String.valueOf(idLong));
				} else {
					productBomParamVo.setParentIdes(idLong + "," + listBom.getParentIdes());
				}
				productBomParamVo.setId(idLong);
				productBom = productBomService.saveOrUpdate(productBomParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ProductBom productBomVoTemp = this.selectById(productBomParamVo.getId(), commonParam);
				ProductBom listBom = productBomService.selectById(productBomParamVo.getParentId(), commonParam);
				if (listBom == null) {
					productBomParamVo.setParentIdes(String.valueOf(productBomParamVo.getId()));
				} else {
					productBomParamVo.setParentIdes(productBomParamVo.getId() + "," + listBom.getParentIdes());
				}
				BeanUtil.copyNotNullProperties(productBomVoTemp, productBomParamVo);

				productBom = productBomService.saveOrUpdate(productBomVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(productBom);
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
	public List<ProductBomZTree> loadZtree(ProductBomParamVo productBomParamVo, CommonParam commonParam) {

		List<ProductBomZTree> parentItemList = new ArrayList<ProductBomZTree>();
		try {
			// 拿到所有产品BOM
			List<ProductBom> selectListByParamVo = productBomService.selectListByParamVo(productBomParamVo,
					commonParam);

			if (selectListByParamVo != null) {
				for (ProductBom productBom : selectListByParamVo) {
					ProductBomZTree productBomZTree = new ProductBomZTree();
					if (productBom.getProductId() != null && productBom.getProductId() > 0L) {
						ProductMain productMain = productMainService.selectById(productBom.getProductId(), commonParam);
						if (productMain != null) {
							if (productMain.getProductTypeDictId() != null && productMain.getProductTypeDictId() > 0L) {
								// 物品类型
								ConfigDictionary productType = configDictionaryService
										.selectById(productMain.getProductTypeDictId(), commonParam);
								// 物品分类
								ProductClasses productClasses = productClassesService
										.selectById(productMain.getClassesId(), commonParam);
								if (productType != null) {
									productBomZTree.setProductTypeName(productType.getDictName());
								}
								if (productClasses != null) {
									productBomZTree.setProductClassesName(productClasses.getClassesName());
								}
							}
						}
						productBomZTree.setBomName(productMain.getProductName());
					}
					productBomZTree.setId(productBom.getId());
					productBomZTree.setProductId(productBom.getProductId());
					productBomZTree.setParentId((long) 0);
					parentItemList.add(productBomZTree);
				}
			}
			/*
			 * if (listByParamVo != null) { for (ProductBomItem productBomItem :
			 * listByParamVo) { ProductBomZTree productBomItemZTree = new
			 * ProductBomZTree();
			 * productBomItemZTree.setId(productBomItem.getId());
			 * productBomItemZTree.setParentId(productBomItem.getBomId());
			 * productBomItemZTree.setQuantity(productBomItem.getQuantity()); //
			 * 拿到物料名称 ProductMaterial productMaterial =
			 * productMaterialService.selectById(productBomItem.getMaterialId(),
			 * null); if(productMaterial.getSkuValue()!=null&&productMaterial.
			 * getSkuValue()!=""){ ProductMaterialVo productMateriaVo=new
			 * ProductMaterialVo();
			 * productMateriaVo.setSkuValue(productMaterial.getSkuValue());
			 * productBomItemZTree.setSku(productMateriaVo.getSku()); }
			 * if(productBomItem.getProductId()!=null&&productBomItem.
			 * getProductId()>0L){ ProductMain
			 * productMain=productMainService.selectById(productBomItem.
			 * getProductId(), commonParam); if(productMain!=null){ if
			 * (productMain.getProductTypeDictId() != null &&
			 * productMain.getProductTypeDictId() > 0L) { //物品类型
			 * ConfigDictionary productType =
			 * configDictionaryService.selectById(productMain.
			 * getProductTypeDictId(), commonParam); if (productType != null) {
			 * productBomItemZTree.setProductTypeName(productType.getDictName())
			 * ; } //物品分类 ProductClasses productClasses =
			 * productClassesService.selectById(productMain.getClassesId(),
			 * commonParam); if(productClasses!=null){
			 * productBomItemZTree.setProductClassesName(productClasses.
			 * getClassesName()); } } } }
			 * productBomItemZTree.setBomName(productMaterial.getMaterialName())
			 * ; parentItemList.add(productBomItemZTree); } }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return parentItemList;
	}

	@Override
	public List<ProductBomVo> selectListBomTree(Long id, CommonParam commonParam) {
		// TODO Auto-generated method stub
		List<ProductBom> listTree = new ArrayList<ProductBom>();
		List<ProductBomVo> volist = new ArrayList<ProductBomVo>();
		try {
			listTree = productBomService.selectListBomTree(id, commonParam);
			ProductBomVo vo = null;
			for (ProductBom productBom : listTree) {
				vo = this.getExtendVo(productBom, commonParam);
				volist.add(vo);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volist;
	}

	@Override
	public ResultMessage synGospellBom() throws BusinessException, SQLException {
		ResultMessage resultMessage = new ResultMessage();
		productBomService.insertGospellBom();
		return resultMessage;
	}
}
