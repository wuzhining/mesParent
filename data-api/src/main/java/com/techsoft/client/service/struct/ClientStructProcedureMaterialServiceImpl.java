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
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcedureMaterial;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.struct.StructProcedureMaterialVo;
import com.techsoft.entity.struct.StructProcedureMaterialParamVo;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcedureMaterialService;
import com.techsoft.service.struct.StructProcessNodeService;

@org.springframework.stereotype.Service
public class ClientStructProcedureMaterialServiceImpl extends BaseClientServiceImpl<StructProcedureMaterial> implements ClientStructProcedureMaterialService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureMaterialService structProcedureMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	
	@Override
	public BaseService<StructProcedureMaterial> getBaseService() {
		return structProcedureMaterialService;
	}	    	
    
	private StructProcedureMaterialVo getVo(StructProcedureMaterial structProcedureMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureMaterialVo vo = new StructProcedureMaterialVo(structProcedureMaterial);
		// TODO 此处填充其它关联字段的处理代码
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode structProcessNode = structProcessNodeService.selectById(vo.getProcessNodeId(), commonParam);
			if (structProcessNode != null) {
				vo.setStructProcessNode(structProcessNode);
			}
		}
		if (vo.getInstructId() != null && vo.getInstructId() > 0L) {
			StructProcedureInstruct structProcedureInstruct = structProcedureInstructService.selectById(vo.getInstructId(), commonParam);
			if (structProcedureInstruct != null) {
				vo.setStructProcedureInstruct(structProcedureInstruct);
			}
		}
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
		return vo;
	} 
	
	private StructProcedureMaterialVo getExtendVo(StructProcedureMaterial structProcedureMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureMaterialVo vo = this.getVo(structProcedureMaterial, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructProcedureMaterialVo> getVoList(List<StructProcedureMaterial> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureMaterialVo> voList = new ArrayList<StructProcedureMaterialVo>();
		for (StructProcedureMaterial entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructProcedureMaterialVo> getExtendVoList(List<StructProcedureMaterial> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureMaterialVo> voList = new ArrayList<StructProcedureMaterialVo>();
		for (StructProcedureMaterial entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructProcedureMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureMaterial entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructProcedureMaterialVo>  selectListVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		if(structProcedureMaterial==null){
			structProcedureMaterial = new StructProcedureMaterialParamVo();
		}
		structProcedureMaterial.setTenantId(commonParam.getTenantId());	
	
		List<StructProcedureMaterial> list = (List<StructProcedureMaterial>) this.getBaseService().selectListByParamVo(structProcedureMaterial, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureMaterialVo> selectPageVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureMaterial==null){
			structProcedureMaterial = new StructProcedureMaterialParamVo();
		}
		structProcedureMaterial.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureMaterial> list  = (PageInfo<StructProcedureMaterial>) this.getBaseService().selectPageByParamVo(structProcedureMaterial, commonParam, pageNo, pageSize);
		List<StructProcedureMaterialVo> volist = new ArrayList<StructProcedureMaterialVo>();
		
		Iterator<StructProcedureMaterial> iter = list.getList().iterator();
		StructProcedureMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureMaterialVo> vpage = new Page<StructProcedureMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructProcedureMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureMaterial entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructProcedureMaterialVo>  selectListExtendVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structProcedureMaterial==null){
			structProcedureMaterial = new StructProcedureMaterialParamVo();
		}
		structProcedureMaterial.setTenantId(commonParam.getTenantId());	
					
		List<StructProcedureMaterial> list = (List<StructProcedureMaterial>) this.getBaseService().selectListByParamVo(structProcedureMaterial, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureMaterialVo> selectPageExtendVoByParamVo(StructProcedureMaterialParamVo structProcedureMaterial, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureMaterial==null){
			structProcedureMaterial = new StructProcedureMaterialParamVo();
		}
		structProcedureMaterial.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureMaterial> list  = (PageInfo<StructProcedureMaterial>) this.getBaseService().selectPageByParamVo(structProcedureMaterial, commonParam, pageNo, pageSize);
		List<StructProcedureMaterialVo> volist = new ArrayList<StructProcedureMaterialVo>();
		
		Iterator<StructProcedureMaterial> iter = list.getList().iterator();
		StructProcedureMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureMaterialVo> vpage = new Page<StructProcedureMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructProcedureMaterialParamVo structProcedureMaterialParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructProcedureMaterial structProcedureMaterial = null;
		try {
			if (structProcedureMaterialParamVo.getId() == null) {//新增
			 
				structProcedureMaterialParamVo.setTenantId(commonParam.getTenantId());
				structProcedureMaterial = structProcedureMaterialService.saveOrUpdate(structProcedureMaterialParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				StructProcedureMaterial structProcedureMaterialVoTemp = this.selectById(structProcedureMaterialParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcedureMaterialVoTemp,
						structProcedureMaterialParamVo);
  
				structProcedureMaterial = structProcedureMaterialService.saveOrUpdate(
						structProcedureMaterialVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structProcedureMaterial);
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
