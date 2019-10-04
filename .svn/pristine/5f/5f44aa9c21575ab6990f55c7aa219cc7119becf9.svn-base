package com.techsoft.client.service.warehouse;

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
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WarehouseProductStock;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.warehouse.WarehouseProductStockVo;
import com.techsoft.entity.warehouse.WarehouseProductStockParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.warehouse.WarehouseProductStockService;

@org.springframework.stereotype.Service
public class ClientWarehouseProductStockServiceImpl extends BaseClientServiceImpl<WarehouseProductStock> implements ClientWarehouseProductStockService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseProductStockService warehouseProductStockService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	@Override
	public BaseService<WarehouseProductStock> getBaseService() {
		return warehouseProductStockService;
	}	    	
    
	private WarehouseProductStockVo getVo(WarehouseProductStock warehouseProductStock, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseProductStockVo vo = new WarehouseProductStockVo(warehouseProductStock);
		//物品类型
		if(vo.getMaterialId() != null && vo.getMaterialId() > 0L){
			ProductMaterial materialCode = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if(materialCode != null){
				ConfigDictionary dictionary = configDictionaryService.selectById(materialCode.getProductTypeDictId(), commonParam);
				vo.setProductType(dictionary);
			}
		}
		//工厂
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		//物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		//物品规格
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				if(productMaterial.getSkuValue()!=null&&productMaterial.getSkuValue()!=""){
					ProductMaterialVo productMateriaVo=new ProductMaterialVo();
					productMateriaVo.setSkuValue(productMaterial.getSkuValue());
					vo.setProductMaterialVo(productMateriaVo);
					
				}
				vo.setProductMaterial(productMaterial);
			}
		}
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassport(userPassport);
			}
		}
		if (vo.getModifyUserId() != null && vo.getModifyUserId() > 0L) {
			UserPassport modifyUser = userPassportService.selectById(vo.getModifyUserId(), commonParam);
			if (modifyUser != null) {
				vo.setModifyUser(modifyUser);;
			}
		}
		return vo;
	} 
	
	private WarehouseProductStockVo getExtendVo(WarehouseProductStock warehouseProductStock, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseProductStockVo vo = this.getVo(warehouseProductStock, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WarehouseProductStockVo> getVoList(List<WarehouseProductStock> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseProductStockVo> voList = new ArrayList<WarehouseProductStockVo>();
		for (WarehouseProductStock entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WarehouseProductStockVo> getExtendVoList(List<WarehouseProductStock> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WarehouseProductStockVo> voList = new ArrayList<WarehouseProductStockVo>();
		for (WarehouseProductStock entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WarehouseProductStockVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseProductStock entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WarehouseProductStockVo>  selectListVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam) throws BusinessException, SQLException {
		if(warehouseProductStock==null){
			warehouseProductStock = new WarehouseProductStockParamVo();
		}
		warehouseProductStock.setTenantId(commonParam.getTenantId());	
	
		List<WarehouseProductStock> list = (List<WarehouseProductStock>) this.getBaseService().selectListByParamVo(warehouseProductStock, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WarehouseProductStockVo> selectPageVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(warehouseProductStock==null){
			warehouseProductStock = new WarehouseProductStockParamVo();
		}
		warehouseProductStock.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WarehouseProductStock> list  = (PageInfo<WarehouseProductStock>) this.getBaseService().selectPageByParamVo(warehouseProductStock, commonParam, pageNo, pageSize);
		List<WarehouseProductStockVo> volist = new ArrayList<WarehouseProductStockVo>();
		
		Iterator<WarehouseProductStock> iter = list.getList().iterator();
		WarehouseProductStockVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WarehouseProductStockVo> vpage = new Page<WarehouseProductStockVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WarehouseProductStockVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseProductStock entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WarehouseProductStockVo>  selectListExtendVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(warehouseProductStock==null){
			warehouseProductStock = new WarehouseProductStockParamVo();
		}
		warehouseProductStock.setTenantId(commonParam.getTenantId());	
					
		List<WarehouseProductStock> list = (List<WarehouseProductStock>) this.getBaseService().selectListByParamVo(warehouseProductStock, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WarehouseProductStockVo> selectPageExtendVoByParamVo(WarehouseProductStockParamVo warehouseProductStock, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(warehouseProductStock==null){
			warehouseProductStock = new WarehouseProductStockParamVo();
		}
		warehouseProductStock.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WarehouseProductStock> list  = (PageInfo<WarehouseProductStock>) this.getBaseService().selectPageByParamVo(warehouseProductStock, commonParam, pageNo, pageSize);
		List<WarehouseProductStockVo> volist = new ArrayList<WarehouseProductStockVo>();
		
		Iterator<WarehouseProductStock> iter = list.getList().iterator();
		WarehouseProductStockVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WarehouseProductStockVo> vpage = new Page<WarehouseProductStockVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WarehouseProductStockParamVo warehouseProductStockParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WarehouseProductStock warehouseProductStock = null;
		try {
			if (warehouseProductStockParamVo.getId() == null) {//新增
			 
				warehouseProductStockParamVo.setTenantId(commonParam.getTenantId());
				warehouseProductStock = warehouseProductStockService.saveOrUpdate(warehouseProductStockParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WarehouseProductStock warehouseProductStockVoTemp = this.selectById(warehouseProductStockParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseProductStockVoTemp,
						warehouseProductStockParamVo);
  
				warehouseProductStock = warehouseProductStockService.saveOrUpdate(
						warehouseProductStockVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(warehouseProductStock);
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
