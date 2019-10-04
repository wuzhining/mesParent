package com.techsoft.client.service.struct;

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
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessProduct;
import com.techsoft.entity.struct.StructProcessProductVo;
import com.techsoft.entity.struct.StructProcessProductParamVo;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessProductService;
import com.techsoft.service.struct.StructProcessService;

@org.springframework.stereotype.Service
public class ClientStructProcessProductServiceImpl extends BaseClientServiceImpl<StructProcessProduct> implements ClientStructProcessProductService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessProductService structProcessProductService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	
	
	@Override
	public BaseService<StructProcessProduct> getBaseService() {
		return structProcessProductService;
	}	    	
    
	private StructProcessProductVo getVo(StructProcessProduct structProcessProduct, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessProductVo vo = new StructProcessProductVo(structProcessProduct);
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
				vo.setProductMaterial(productMaterial);
			}
		}
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getProcessId() != null && vo.getProcessId() > 0L) {
			StructProcess structProcess = structProcessService.selectById(vo.getProcessId(), commonParam);
			if (structProcess != null) {
				vo.setStructProcess(structProcess);
			}
		}
		
		return vo;
	} 
	
	private StructProcessProductVo getExtendVo(StructProcessProduct structProcessProduct, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessProductVo vo = this.getVo(structProcessProduct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructProcessProductVo> getVoList(List<StructProcessProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcessProductVo> voList = new ArrayList<StructProcessProductVo>();
		for (StructProcessProduct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructProcessProductVo> getExtendVoList(List<StructProcessProduct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcessProductVo> voList = new ArrayList<StructProcessProductVo>();
		for (StructProcessProduct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructProcessProductVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructProcessProductVo>  selectListVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam) throws BusinessException, SQLException {
		if(structProcessProduct==null){
			structProcessProduct = new StructProcessProductParamVo();
		}
		structProcessProduct.setTenantId(commonParam.getTenantId());	
	
		List<StructProcessProduct> list = (List<StructProcessProduct>) this.getBaseService().selectListByParamVo(structProcessProduct, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcessProductVo> selectPageVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcessProduct==null){
			structProcessProduct = new StructProcessProductParamVo();
		}
		structProcessProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcessProduct> list  = (PageInfo<StructProcessProduct>) this.getBaseService().selectPageByParamVo(structProcessProduct, commonParam, pageNo, pageSize);
		List<StructProcessProductVo> volist = new ArrayList<StructProcessProductVo>();
		
		Iterator<StructProcessProduct> iter = list.getList().iterator();
		StructProcessProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcessProductVo> vpage = new Page<StructProcessProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructProcessProductVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcessProduct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructProcessProductVo>  selectListExtendVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structProcessProduct==null){
			structProcessProduct = new StructProcessProductParamVo();
		}
		structProcessProduct.setTenantId(commonParam.getTenantId());	
					
		List<StructProcessProduct> list = (List<StructProcessProduct>) this.getBaseService().selectListByParamVo(structProcessProduct, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcessProductVo> selectPageExtendVoByParamVo(StructProcessProductParamVo structProcessProduct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcessProduct==null){
			structProcessProduct = new StructProcessProductParamVo();
		}
		structProcessProduct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcessProduct> list  = (PageInfo<StructProcessProduct>) this.getBaseService().selectPageByParamVo(structProcessProduct, commonParam, pageNo, pageSize);
		List<StructProcessProductVo> volist = new ArrayList<StructProcessProductVo>();
		
		Iterator<StructProcessProduct> iter = list.getList().iterator();
		StructProcessProductVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcessProductVo> vpage = new Page<StructProcessProductVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructProcessProductParamVo structProcessProductParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructProcessProduct structProcessProduct = null;
		try {
			if (structProcessProductParamVo.getId() == null) {//新增
			 
				structProcessProductParamVo.setTenantId(commonParam.getTenantId());
				structProcessProduct = structProcessProductService.saveOrUpdate(structProcessProductParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				StructProcessProduct structProcessProductVoTemp = this.selectById(structProcessProductParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcessProductVoTemp,
						structProcessProductParamVo);
  
				structProcessProduct = structProcessProductService.saveOrUpdate(
						structProcessProductVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structProcessProduct);
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
