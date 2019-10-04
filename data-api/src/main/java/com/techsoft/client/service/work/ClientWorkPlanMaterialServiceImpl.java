package com.techsoft.client.service.work;

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
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanMaterial;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.product.ProductMaterialVo;
import com.techsoft.entity.work.WorkPlanMaterialParamVo;
import com.techsoft.entity.work.WorkPlanMaterialVo;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductBomService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.work.WorkPlanMaterialService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientWorkPlanMaterialServiceImpl extends BaseClientServiceImpl<WorkPlanMaterial> implements ClientWorkPlanMaterialService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanMaterialService workPlanMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillWorkorderService billWorkorderService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkTaskProcedureService workTaskProcedureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopService structWorkshopService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductBomService productBomService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService2;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService2;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	
	@Override
	public BaseService<WorkPlanMaterial> getBaseService() {
		return workPlanMaterialService;
	}	    	
    
	private WorkPlanMaterialVo getVo(WorkPlanMaterial workPlanMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanMaterialVo vo = new WorkPlanMaterialVo(workPlanMaterial);
		
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial = productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				ProductMaterialVo productMateriaVo=new ProductMaterialVo();
				if(productMaterial.getSkuValue()!=null&&productMaterial.getSkuValue()!=""){
					productMateriaVo.setSkuValue(productMaterial.getSkuValue());
					
				} 
				vo.setProductMaterialVo(productMateriaVo);
			}
		}
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory factory=structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (factory != null) {
				vo.setFactory(factory);
			}
		}
		if (vo.getBillWorkorderId() != null && vo.getBillWorkorderId() > 0L) {
			BillWorkorder billWorkorder=billWorkorderService.selectById(vo.getBillWorkorderId(), commonParam);
			if (billWorkorder != null) {
				vo.setBillWorkorder(billWorkorder);
			}
		}
		if (vo.getTaskId() != null && vo.getTaskId() > 0L) {
			WorkTaskProcedure task=workTaskProcedureService.selectById(vo.getTaskId(), commonParam);
			if (task != null) {
				vo.setTask(task);
			}
		}
		if (vo.getWorkshopId() != null && vo.getWorkshopId() > 0L) {
			StructWorkshop workshop=structWorkshopService.selectById(vo.getWorkshopId(), commonParam);
			if (workshop != null) {
				vo.setWorkshop(workshop);
			}
		}
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode processNode=structProcessNodeService.selectById(vo.getProcessNodeId(), commonParam);
			if (processNode != null) {
				vo.setProcessNode(processNode);
			}
		}
		if (vo.getBomId() != null && vo.getBomId() > 0L) {
			ProductBom productBom=productBomService.selectById(vo.getBomId(), commonParam);
			if (productBom != null) {
				vo.setProductBom(productBom);
			}
		}
		if (vo.getPlanStatusDictId() != null && vo.getPlanStatusDictId() > 0L) {
			ConfigDictionary planStatusDic=configDictionaryService.selectById(vo.getPlanStatusDictId(), commonParam);
			if (planStatusDic != null) {
				vo.setPlanStatusDic(planStatusDic);
			}
		}
		if (vo.getInstructId() != null && vo.getInstructId() > 0L) {
			StructProcedureInstruct structProcedureInstruct=structProcedureInstructService.selectById(vo.getInstructId(), commonParam);
			if (structProcedureInstruct != null) {
				vo.setStructProcedureInstruct(structProcedureInstruct);
			}
		}
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain=productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		if (vo.getMaterialId() != null && vo.getMaterialId() > 0L) {
			ProductMaterial productMaterial=productMaterialService.selectById(vo.getMaterialId(), commonParam);
			if (productMaterial != null) {
				//物品类型
				if(productMaterial.getProductTypeDictId() != null && productMaterial.getProductTypeDictId() >0L){
					ConfigDictionary productType = configDictionaryService.selectById(productMaterial.getProductTypeDictId(), commonParam);
					if(productType != null){
						vo.setProductType(productType);
					}
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
		if (vo.getModifyUserId()!= null && vo.getModifyUserId() > 0L) {
			UserPassport modifyUser = userPassportService.selectById(vo.getModifyUserId(), commonParam);
			if (modifyUser != null) {
				vo.setModifyUser(modifyUser);
			}
		}
		return vo;
	} 
	
	private WorkPlanMaterialVo getExtendVo(WorkPlanMaterial workPlanMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanMaterialVo vo = this.getVo(workPlanMaterial, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WorkPlanMaterialVo> getVoList(List<WorkPlanMaterial> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanMaterialVo> voList = new ArrayList<WorkPlanMaterialVo>();
		for (WorkPlanMaterial entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WorkPlanMaterialVo> getExtendVoList(List<WorkPlanMaterial> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanMaterialVo> voList = new ArrayList<WorkPlanMaterialVo>();
		for (WorkPlanMaterial entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WorkPlanMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanMaterial entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WorkPlanMaterialVo>  selectListVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam) throws BusinessException, SQLException {
		if(workPlanMaterial==null){
			workPlanMaterial = new WorkPlanMaterialParamVo();
		}
		workPlanMaterial.setTenantId(commonParam.getTenantId());	
	
		List<WorkPlanMaterial> list = (List<WorkPlanMaterial>) this.getBaseService().selectListByParamVo(workPlanMaterial, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanMaterialVo> selectPageVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanMaterial==null){
			workPlanMaterial = new WorkPlanMaterialParamVo();
		}
		workPlanMaterial.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanMaterial> list  = (PageInfo<WorkPlanMaterial>) this.getBaseService().selectPageByParamVo(workPlanMaterial, commonParam, pageNo, pageSize);
		List<WorkPlanMaterialVo> volist = new ArrayList<WorkPlanMaterialVo>();
		
		Iterator<WorkPlanMaterial> iter = list.getList().iterator();
		WorkPlanMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanMaterialVo> vpage = new Page<WorkPlanMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WorkPlanMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanMaterial entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WorkPlanMaterialVo>  selectListExtendVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(workPlanMaterial==null){
			workPlanMaterial = new WorkPlanMaterialParamVo();
		}
		workPlanMaterial.setTenantId(commonParam.getTenantId());	
					
		List<WorkPlanMaterial> list = (List<WorkPlanMaterial>) this.getBaseService().selectListByParamVo(workPlanMaterial, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanMaterialVo> selectPageExtendVoByParamVo(WorkPlanMaterialParamVo workPlanMaterial, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanMaterial==null){
			workPlanMaterial = new WorkPlanMaterialParamVo();
		}
		workPlanMaterial.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanMaterial> list  = (PageInfo<WorkPlanMaterial>) this.getBaseService().selectPageByParamVo(workPlanMaterial, commonParam, pageNo, pageSize);
		List<WorkPlanMaterialVo> volist = new ArrayList<WorkPlanMaterialVo>();
		
		Iterator<WorkPlanMaterial> iter = list.getList().iterator();
		WorkPlanMaterialVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanMaterialVo> vpage = new Page<WorkPlanMaterialVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WorkPlanMaterialParamVo workPlanMaterialParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WorkPlanMaterial workPlanMaterial = null;
		try {
			if (workPlanMaterialParamVo.getId() == null) {//新增
			 
				workPlanMaterialParamVo.setTenantId(commonParam.getTenantId());
				workPlanMaterial = workPlanMaterialService.saveOrUpdate(workPlanMaterialParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WorkPlanMaterial workPlanMaterialVoTemp = this.selectById(workPlanMaterialParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(workPlanMaterialVoTemp,
						workPlanMaterialParamVo);
  
				workPlanMaterial = workPlanMaterialService.saveOrUpdate(
						workPlanMaterialVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(workPlanMaterial);
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
