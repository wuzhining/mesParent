package com.techsoft.client.service.struct;

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
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.entity.struct.StructProcedureInstructVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipSpecsWorkService;
import com.techsoft.service.equip.EquipWorkClassesService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructProcessService;

@org.springframework.stereotype.Service
public class ClientStructProcedureInstructServiceImpl extends BaseClientServiceImpl<StructProcedureInstruct> implements ClientStructProcedureInstructService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessNodeService structProcessNodeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkClassesService equipWorkClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsWorkService equipSpecsWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService productMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcessService structProcessService;
	
	@Override
	public BaseService<StructProcedureInstruct> getBaseService() {
		return structProcedureInstructService;
	}	    	
    
	private StructProcedureInstructVo getVo(StructProcedureInstruct structProcedureInstruct, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureInstructVo vo = new StructProcedureInstructVo(structProcedureInstruct);
		// TODO 此处填充其它关联字段的处理代码
		
		if (vo.getProcessNodeId() != null && vo.getProcessNodeId() > 0L) {
			StructProcessNode structProcessNode = structProcessNodeService.selectById(vo.getProcessNodeId(), commonParam);
			if (structProcessNode != null) {
				//工艺流程
				if(structProcessNode.getProcessId() != null && structProcessNode.getProcessId() > 0L){
					StructProcess structProcess = structProcessService.selectById(structProcessNode.getProcessId(), commonParam);
					if(structProcess != null){
						vo.setStructProcess(structProcess);
					}
				}
				vo.setStructProcessNode(structProcessNode);
			}
		}
		if (vo.getInstructTypeDictId() != null && vo.getInstructTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getInstructTypeDictId(), commonParam);
			if (configDictionary != null) {
				vo.setListDictionary(configDictionary);
			}
		}
 
		if (vo.getEquipSpecsWorkId() != null && vo.getEquipSpecsWorkId() > 0L) {
			EquipSpecsWork equipSpecsWork = equipSpecsWorkService.selectById(vo.getEquipSpecsWorkId(), commonParam);
			if (equipSpecsWork != null) {
				vo.setEquipSpecsWork(equipSpecsWork);
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
		if(vo.getExecutiveTypeDictId() != null && vo.getExecutiveTypeDictId() > 0L){
			ConfigDictionary configDictionarylist = configDictionaryService.selectById(vo.getExecutiveTypeDictId(), commonParam);
			if(configDictionarylist != null){
				vo.setExecutive(configDictionarylist);
			}
		}
		return vo;
	} 
	
	private StructProcedureInstructVo getExtendVo(StructProcedureInstruct structProcedureInstruct, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureInstructVo vo = this.getVo(structProcedureInstruct, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<StructProcedureInstructVo> getVoList(List<StructProcedureInstruct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureInstructVo> voList = new ArrayList<StructProcedureInstructVo>();
		for (StructProcedureInstruct entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<StructProcedureInstructVo> getExtendVoList(List<StructProcedureInstruct> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<StructProcedureInstructVo> voList = new ArrayList<StructProcedureInstructVo>();
		for (StructProcedureInstruct entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public StructProcedureInstructVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureInstruct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<StructProcedureInstructVo>  selectListVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam) throws BusinessException, SQLException {
		if(structProcedureInstruct==null){
			structProcedureInstruct = new StructProcedureInstructParamVo();
		}
		structProcedureInstruct.setTenantId(commonParam.getTenantId());	
	
		List<StructProcedureInstruct> list = (List<StructProcedureInstruct>) this.getBaseService().selectListByParamVo(structProcedureInstruct, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureInstructVo> selectPageVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureInstruct==null){
			structProcedureInstruct = new StructProcedureInstructParamVo();
		}
		structProcedureInstruct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureInstruct> list  = (PageInfo<StructProcedureInstruct>) this.getBaseService().selectPageByParamVo(structProcedureInstruct, commonParam, pageNo, pageSize);
		List<StructProcedureInstructVo> volist = new ArrayList<StructProcedureInstructVo>();
		
		Iterator<StructProcedureInstruct> iter = list.getList().iterator();
		StructProcedureInstructVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureInstructVo> vpage = new Page<StructProcedureInstructVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public StructProcedureInstructVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructProcedureInstruct entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<StructProcedureInstructVo>  selectListExtendVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(structProcedureInstruct==null){
			structProcedureInstruct = new StructProcedureInstructParamVo();
		}
		structProcedureInstruct.setTenantId(commonParam.getTenantId());	
					
		List<StructProcedureInstruct> list = (List<StructProcedureInstruct>) this.getBaseService().selectListByParamVo(structProcedureInstruct, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<StructProcedureInstructVo> selectPageExtendVoByParamVo(StructProcedureInstructParamVo structProcedureInstruct, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(structProcedureInstruct==null){
			structProcedureInstruct = new StructProcedureInstructParamVo();
		}
		structProcedureInstruct.setTenantId(commonParam.getTenantId());	
					
		PageInfo<StructProcedureInstruct> list  = (PageInfo<StructProcedureInstruct>) this.getBaseService().selectPageByParamVo(structProcedureInstruct, commonParam, pageNo, pageSize);
		List<StructProcedureInstructVo> volist = new ArrayList<StructProcedureInstructVo>();
		
		Iterator<StructProcedureInstruct> iter = list.getList().iterator();
		StructProcedureInstructVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<StructProcedureInstructVo> vpage = new Page<StructProcedureInstructVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(StructProcedureInstructParamVo structProcedureInstructParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		StructProcedureInstruct structProcedureInstruct = null;
		try {
			if (structProcedureInstructParamVo.getId() == null) {//新增
				//生成编码
				String code = structProcedureInstructParamVo.getInstructCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(StructProcedureInstruct.class.getName(), null, null, commonParam);
					structProcedureInstructParamVo.setInstructCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("工序指令编码不能为空");
				}
				//检验编码是否已存在
				StructProcedureInstructParamVo structProcedureInstructSearch = new StructProcedureInstructParamVo();
				structProcedureInstructSearch.setInstructCode(code);
				List<StructProcedureInstruct> list = structProcedureInstructService.selectListByParamVo(structProcedureInstructSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("工序指令编码已存在");
					return resultMessage;
				}
					structProcedureInstructParamVo.setTenantId(commonParam.getTenantId());
					structProcedureInstruct = structProcedureInstructService.saveOrUpdate(structProcedureInstructParamVo,commonParam);
					resultMessage.setIsSuccess(true);
			} else {  //修改
				StructProcedureInstruct structProcedureInstructVoTemp = this.selectById(structProcedureInstructParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structProcedureInstructVoTemp,
						structProcedureInstructParamVo);
  
				structProcedureInstruct = structProcedureInstructService.saveOrUpdate(
						structProcedureInstructVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(structProcedureInstruct);
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
