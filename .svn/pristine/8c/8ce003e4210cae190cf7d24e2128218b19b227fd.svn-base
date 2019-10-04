package com.techsoft.client.service.equip;

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
import com.techsoft.entity.common.EquipFixtureStackProduct;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.equip.EquipFixtureStackProductVo;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.equip.EquipFixtureStackProductParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureStackProductService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;

@org.springframework.stereotype.Service
public class ClientEquipFixtureStackProductServiceImpl extends BaseClientServiceImpl<EquipFixtureStackProduct> implements ClientEquipFixtureStackProductService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureStackProductService equipFixtureStackProductService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
    
	@Override
	public BaseService<EquipFixtureStackProduct> getBaseService() {
		return equipFixtureStackProductService;
	}	    	
    
	private EquipFixtureStackProductVo getVo(EquipFixtureStackProduct equipFixtureStackProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackProductVo vo = new EquipFixtureStackProductVo(equipFixtureStackProduct);
		// TODO 此处填充其它关联字段的处理代码
		//物品
		if(vo.getProductId() != null && vo.getProductId() > 0L){
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if(productMain != null){
				vo.setProductMain(productMain);
			}
		}
		//原材料
		if(vo.getRawProductId() != null && vo.getRawProductId() > 0L){
			ProductMain rawProductMain = productMainService.selectById(vo.getRawProductId(), commonParam);
			if(rawProductMain != null){
				vo.setRawProductMain(rawProductMain);
			}
		}
		//物品规格
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(productMaterial != null){
				if(productMaterial.getSkuValue() != null && productMaterial.getSkuValue() != ""){
					ProductMaterialVo productMaterialVo = new ProductMaterialVo();
					productMaterialVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMaterialVo);
				}
				vo.setProductMaterial(productMaterial);
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
		//物品类型
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				ConfigDictionary dictionary = configDictionaryService.selectById(materialCode.getProductTypeDictId(), commonParam);
				if(dictionary != null){
					vo.setProductType(dictionary);
				}	
				}
			}
		return vo;
	} 
	
	private EquipFixtureStackProductVo getExtendVo(EquipFixtureStackProduct equipFixtureStackProduct, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackProductVo vo = this.getVo(equipFixtureStackProduct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<EquipFixtureStackProductVo> getVoList(List<EquipFixtureStackProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureStackProductVo> voList = new ArrayList<EquipFixtureStackProductVo>();
		for (EquipFixtureStackProduct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<EquipFixtureStackProductVo> getExtendVoList(List<EquipFixtureStackProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipFixtureStackProductVo> voList = new ArrayList<EquipFixtureStackProductVo>();
		for (EquipFixtureStackProduct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public EquipFixtureStackProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<EquipFixtureStackProductVo>  selectListVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam) throws BusinessException, SQLException {
		if(equipFixtureStackProduct==null){
			equipFixtureStackProduct = new EquipFixtureStackProductParamVo();
		}
		equipFixtureStackProduct.setTenantId(commonParam.getTenantId());	
	
		List<EquipFixtureStackProduct> list = (List<EquipFixtureStackProduct>) this.getBaseService().selectListByParamVo(equipFixtureStackProduct, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureStackProductVo> selectPageVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureStackProduct==null){
			equipFixtureStackProduct = new EquipFixtureStackProductParamVo();
		}
		equipFixtureStackProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureStackProduct> list  = (PageInfo<EquipFixtureStackProduct>) this.getBaseService().selectPageByParamVo(equipFixtureStackProduct, commonParam, pageNo, pageSize);
		List<EquipFixtureStackProductVo> volist = new ArrayList<EquipFixtureStackProductVo>();
		
		Iterator<EquipFixtureStackProduct> iter = list.getList().iterator();
		EquipFixtureStackProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureStackProductVo> vpage = new Page<EquipFixtureStackProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public EquipFixtureStackProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipFixtureStackProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<EquipFixtureStackProductVo>  selectListExtendVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(equipFixtureStackProduct==null){
			equipFixtureStackProduct = new EquipFixtureStackProductParamVo();
		}
		equipFixtureStackProduct.setTenantId(commonParam.getTenantId());	
					
		List<EquipFixtureStackProduct> list = (List<EquipFixtureStackProduct>) this.getBaseService().selectListByParamVo(equipFixtureStackProduct, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<EquipFixtureStackProductVo> selectPageExtendVoByParamVo(EquipFixtureStackProductParamVo equipFixtureStackProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(equipFixtureStackProduct==null){
			equipFixtureStackProduct = new EquipFixtureStackProductParamVo();
		}
		equipFixtureStackProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<EquipFixtureStackProduct> list  = (PageInfo<EquipFixtureStackProduct>) this.getBaseService().selectPageByParamVo(equipFixtureStackProduct, commonParam, pageNo, pageSize);
		List<EquipFixtureStackProductVo> volist = new ArrayList<EquipFixtureStackProductVo>();
		
		Iterator<EquipFixtureStackProduct> iter = list.getList().iterator();
		EquipFixtureStackProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<EquipFixtureStackProductVo> vpage = new Page<EquipFixtureStackProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(EquipFixtureStackProductParamVo equipFixtureStackProductParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		EquipFixtureStackProduct equipFixtureStackProduct = null;
		try {
			if (equipFixtureStackProductParamVo.getId() == null) {//新增
			 
				equipFixtureStackProductParamVo.setTenantId(commonParam.getTenantId());
				equipFixtureStackProduct = equipFixtureStackProductService.saveOrUpdate(equipFixtureStackProductParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				EquipFixtureStackProduct equipFixtureStackProductVoTemp = this.selectById(equipFixtureStackProductParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipFixtureStackProductVoTemp,
						equipFixtureStackProductParamVo);
  
				equipFixtureStackProduct = equipFixtureStackProductService.saveOrUpdate(
						equipFixtureStackProductVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(equipFixtureStackProduct);
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
