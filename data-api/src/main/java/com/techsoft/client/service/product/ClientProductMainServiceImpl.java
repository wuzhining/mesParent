package com.techsoft.client.service.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
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
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.entity.product.ProductMainParamVo;
import com.techsoft.entity.product.ProductMainVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmPartnerService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.warehouse.WarehouseStrategyDownshelfService;
import com.techsoft.service.warehouse.WarehouseStrategyUpshelfService;

@org.springframework.stereotype.Service
public class ClientProductMainServiceImpl extends BaseClientServiceImpl<ProductMain>
		implements ClientProductMainService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPartnerService firmPartnerService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService productClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService; 
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseStrategyDownshelfService warehouseStrategyDownshelfService ;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseStrategyUpshelfService warehouseStrategyUpshelfService ;

	@Override
	public BaseService<ProductMain> getBaseService() {
		return productMainService;
	}

	private ProductMainVo getVo(ProductMain productMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductMainVo vo = new ProductMainVo(productMain);
		// 供应商
		if (vo.getSupplierId() != null && vo.getSupplierId() > 0L) {
			FirmPartner supplierName = firmPartnerService.selectById(vo.getSupplierId(), commonParam);
			if (supplierName != null) {
				vo.setFirmPartner(supplierName);
			}
		}

		// 物品分类
		if (vo.getClassesId() != null && vo.getClassesId() > 0L) {
			ProductClasses productClasses = productClassesService.selectById(vo.getClassesId(), commonParam);
			if (productClasses != null) {
				vo.setProductClasses(productClasses);

			}
		}
		// 物品状态
		if (vo.getProductStatusDictId() != null && vo.getProductStatusDictId() > 0L) {
			ConfigDictionary productStatus = configDictionaryService.selectById(vo.getProductStatusDictId(),
					commonParam);
			if (productStatus != null) {
				vo.setProductStatus(productStatus);
			}
		}

		// 物品来源
		if (vo.getProductSourceDictId() != null && vo.getProductSourceDictId() > 0L) {
			ConfigDictionary productSourse = configDictionaryService.selectById(vo.getProductSourceDictId(),
					commonParam);
			if (productSourse != null) {
				vo.setProductSourse(productSourse);
				;
			}
		}
		// 物品类型
		if (vo.getProductTypeDictId() != null && vo.getProductTypeDictId() > 0L) {
			ConfigDictionary productType = configDictionaryService.selectById(vo.getProductTypeDictId(), commonParam);
			if (productType != null) {
				vo.setProductType(productType);
			}
		}
		// 下架策略
		if (vo.getStrategyDownshelfId() != null && vo.getStrategyDownshelfId() > 0L) {
			 WarehouseStrategyDownshelf warehouseStrategyDownshelf = warehouseStrategyDownshelfService.selectById(vo.getStrategyDownshelfId(), commonParam);
			if (warehouseStrategyDownshelf != null) {
				vo.setWarehouseStrategyDownshelf(warehouseStrategyDownshelf);
			}
		}
		// 上架策略
		if (vo.getStrategyUpshelfId() != null && vo.getStrategyUpshelfId() > 0L) {
			WarehouseStrategyUpshelf warehouseStrategyUpshelf = warehouseStrategyUpshelfService.selectById(vo.getStrategyUpshelfId(), commonParam);
			if (warehouseStrategyUpshelf != null) {
				vo.setWarehouseStrategyUpshelf(warehouseStrategyUpshelf);
			}
		}
		// 半成品类型
		if (vo.getSemiProductTypeDictId() != null && vo.getSemiProductTypeDictId() > 0L) {
			ConfigDictionary semiProductType = configDictionaryService.selectById(vo.getSemiProductTypeDictId(), commonParam);
			if (semiProductType != null) {
				vo.setSemiProductType(semiProductType);
			}
		}
		
		// 检验类型
		/*
		 * if (vo.getInspectModeDictId()!= null && vo.getInspectModeDictId() >
		 * 0L) { ConfigDictionary inspectModeDict =
		 * configDictionaryService.selectById(vo.getInspectModeDictId(),
		 * commonParam); if (inspectModeDict != null) {
		 * vo.setInspectModeDict(inspectModeDict); } }
		 */
		return vo;
	}

	private ProductMainVo getExtendVo(ProductMain productMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductMainVo vo = this.getVo(productMain, commonParam);

		return vo;
	}

	private List<ProductMainVo> getVoList(List<ProductMain> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductMainVo> voList = new ArrayList<ProductMainVo>();
		for (ProductMain entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ProductMainVo> getExtendVoList(List<ProductMain> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductMainVo> voList = new ArrayList<ProductMainVo>();
		for (ProductMain entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ProductMainVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductMain entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ProductMainVo> selectListVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productMain == null) {
			productMain = new ProductMainParamVo();
		}
		productMain.setTenantId(commonParam.getTenantId());

		List<ProductMain> list = (List<ProductMain>) this.getBaseService().selectListByParamVo(productMain,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductMainVo> selectPageVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productMain == null) {
			productMain = new ProductMainParamVo();
		}
		productMain.setTenantId(commonParam.getTenantId());

		PageInfo<ProductMain> list = (PageInfo<ProductMain>) this.getBaseService().selectPageByParamVo(productMain,
				commonParam, pageNo, pageSize);
		List<ProductMainVo> volist = new ArrayList<ProductMainVo>();

		Iterator<ProductMain> iter = list.getList().iterator();
		ProductMainVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductMainVo> vpage = new Page<ProductMainVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ProductMainVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductMain entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ProductMainVo> selectListExtendVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productMain == null) {
			productMain = new ProductMainParamVo();
		}
		productMain.setTenantId(commonParam.getTenantId());

		List<ProductMain> list = (List<ProductMain>) this.getBaseService().selectListByParamVo(productMain,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductMainVo> selectPageExtendVoByParamVo(ProductMainParamVo productMain, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productMain == null) {
			productMain = new ProductMainParamVo();
		}
		productMain.setTenantId(commonParam.getTenantId());

		PageInfo<ProductMain> list = (PageInfo<ProductMain>) this.getBaseService().selectPageByParamVo(productMain,
				commonParam, pageNo, pageSize);
		List<ProductMainVo> volist = new ArrayList<ProductMainVo>();

		Iterator<ProductMain> iter = list.getList().iterator();
		ProductMainVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductMainVo> vpage = new Page<ProductMainVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ProductMainParamVo productMainParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (commonParam.getUserId() != null) {
			productMainParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		}
		if (commonParam.getTenantId() != null) {
			productMainParamVo.setTenantId(commonParam.getTenantId());
		}
		if (productMainParamVo.getCreateUserId() == null) {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}
		if (productMainParamVo.getProductName() == null) {
			resultMessage.addErr("物品名称不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getProductName().length() > 32) {
			resultMessage.addErr("物品名称不能超过32个字符");
			return resultMessage;
		}
		if (productMainParamVo.getSpecification() == null) {
			resultMessage.addErr("物品型号不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getSpecification().length() > 128) {
			resultMessage.addErr("物品型号不能超过128个字符");
			return resultMessage;
		}
		/*if (productMainParamVo.getVolume() == null) {
			resultMessage.addErr("体积限制不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getWeight() == null) {
			resultMessage.addErr("重量限制不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getSizeLength() == null) {
			resultMessage.addErr("尺寸-长不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getSizeHeight() == null) {
			resultMessage.addErr("尺寸-高不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getSizeWidth() == null) {
			resultMessage.addErr("尺寸-宽不能为空");
			return resultMessage;
		}*/
		if (productMainParamVo.getStrategyDownshelfId() == null) {
			resultMessage.addErr("下架策略不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getStrategyUpshelfId() == null) {
			resultMessage.addErr("上架策略不能为空");
			return resultMessage;
		}
		if (productMainParamVo.getRemark() != null) {
			if (productMainParamVo.getRemark().length() > 128) {
				resultMessage.addErr("备注不能超过128个字符");
				return resultMessage;
			}
		}
		ProductMain productMain = null;
		try {
			if (productMainParamVo.getId() == null) {// 新增

				// 自动生成编码
				String code = productMainParamVo.getProductCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(ProductMain.class.getName(), null, null, commonParam);
					productMainParamVo.setProductCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr(code);
					return resultMessage;
				}
				//检验编码是否已存在
				ProductMainParamVo productMainSearch = new ProductMainParamVo();
				productMainSearch.setProductCode(code);
				List<ProductMain> list = productMainService.selectListByParamVo(productMainSearch, commonParam);
				if((list != null)&&(!list.isEmpty())){
					resultMessage.addErr("物品编码已存在");
				}
				productMainParamVo.setTenantId(commonParam.getTenantId());
				productMain = productMainService.saveOrUpdate(productMainParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ProductMain productMainVoTemp = this.selectById(productMainParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(productMainVoTemp, productMainParamVo);

				productMain = productMainService.saveOrUpdate(productMainVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(productMain);
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
	public ResultMessage synGospellMat() throws BusinessException, SQLException {
		ResultMessage resultMessage=new ResultMessage();
		productMainService.insertGospellMat();
		return resultMessage;
	}
}
