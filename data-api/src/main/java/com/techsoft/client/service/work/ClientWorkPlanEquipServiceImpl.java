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
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.work.WorkPlanEquipParamVo;
import com.techsoft.entity.work.WorkPlanEquipVo;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipSpecsWorkService;
import com.techsoft.service.equip.EquipWorkService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.work.WorkPlanEquipService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientWorkPlanEquipServiceImpl extends BaseClientServiceImpl<WorkPlanEquip> implements ClientWorkPlanEquipService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanEquipService workPlanEquipService;
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
	private EquipWorkService equipWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsWorkService equipSpecsWorkService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	   
	@Override
	public BaseService<WorkPlanEquip> getBaseService() {
		return workPlanEquipService;
	}	    	
    
	private WorkPlanEquipVo getVo(WorkPlanEquip workPlanEquip, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipVo vo = new WorkPlanEquipVo(workPlanEquip);
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
		if (vo.getEquipWorkId() != null && vo.getEquipWorkId() > 0L) {
			EquipWork equipWork=equipWorkService.selectById(vo.getEquipWorkId(), commonParam);
			if (equipWork != null) {
				vo.setEquipWork(equipWork);
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
		if (vo.getEquipSpecsWorkId() != null && vo.getEquipSpecsWorkId() > 0L) {
			EquipSpecsWork equipSpecsWork=equipSpecsWorkService.selectById(vo.getEquipSpecsWorkId(), commonParam);
			if (equipSpecsWork != null) {
				vo.setEquipSpecsWork(equipSpecsWork);
			}
		}
		if (vo.getWorkshopAreaId() != null && vo.getWorkshopAreaId() > 0L) {
			StructWorkshopArea structWorkshopArea=structWorkshopAreaService.selectById(vo.getWorkshopAreaId(), commonParam);
			if (structWorkshopArea != null) {
				vo.setStructWorkshopArea(structWorkshopArea);
			}
		}
		if (vo.getWorkstationId() != null && vo.getWorkstationId() > 0L) {
			StructWorkstation structWorkstation=structWorkstationService.selectById(vo.getWorkstationId(), commonParam);
			if (structWorkstation != null) {
				vo.setStructWorkstation(structWorkstation);
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
				vo.setModifyUser(modifyUser);
			}
		}
		return vo;
	} 
	
	private WorkPlanEquipVo getExtendVo(WorkPlanEquip workPlanEquip, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipVo vo = this.getVo(workPlanEquip, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WorkPlanEquipVo> getVoList(List<WorkPlanEquip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanEquipVo> voList = new ArrayList<WorkPlanEquipVo>();
		for (WorkPlanEquip entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WorkPlanEquipVo> getExtendVoList(List<WorkPlanEquip> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanEquipVo> voList = new ArrayList<WorkPlanEquipVo>();
		for (WorkPlanEquip entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WorkPlanEquipVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WorkPlanEquipVo>  selectListVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam) throws BusinessException, SQLException {
		if(workPlanEquip==null){
			workPlanEquip = new WorkPlanEquipParamVo();
		}
		workPlanEquip.setTenantId(commonParam.getTenantId());	
	
		List<WorkPlanEquip> list = (List<WorkPlanEquip>) this.getBaseService().selectListByParamVo(workPlanEquip, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanEquipVo> selectPageVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanEquip==null){
			workPlanEquip = new WorkPlanEquipParamVo();
		}
		workPlanEquip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanEquip> list  = (PageInfo<WorkPlanEquip>) this.getBaseService().selectPageByParamVo(workPlanEquip, commonParam, pageNo, pageSize);
		List<WorkPlanEquipVo> volist = new ArrayList<WorkPlanEquipVo>();
		
		Iterator<WorkPlanEquip> iter = list.getList().iterator();
		WorkPlanEquipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanEquipVo> vpage = new Page<WorkPlanEquipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WorkPlanEquipVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquip entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WorkPlanEquipVo>  selectListExtendVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(workPlanEquip==null){
			workPlanEquip = new WorkPlanEquipParamVo();
		}
		workPlanEquip.setTenantId(commonParam.getTenantId());	
					
		List<WorkPlanEquip> list = (List<WorkPlanEquip>) this.getBaseService().selectListByParamVo(workPlanEquip, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanEquipVo> selectPageExtendVoByParamVo(WorkPlanEquipParamVo workPlanEquip, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanEquip==null){
			workPlanEquip = new WorkPlanEquipParamVo();
		}
		workPlanEquip.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanEquip> list  = (PageInfo<WorkPlanEquip>) this.getBaseService().selectPageByParamVo(workPlanEquip, commonParam, pageNo, pageSize);
		List<WorkPlanEquipVo> volist = new ArrayList<WorkPlanEquipVo>();
		
		Iterator<WorkPlanEquip> iter = list.getList().iterator();
		WorkPlanEquipVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanEquipVo> vpage = new Page<WorkPlanEquipVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WorkPlanEquipParamVo workPlanEquipParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WorkPlanEquip workPlanEquip = null;
		try {
			if (workPlanEquipParamVo.getId() == null) {//新增
			 
				workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
				workPlanEquip = workPlanEquipService.saveOrUpdate(workPlanEquipParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WorkPlanEquip workPlanEquipVoTemp = this.selectById(workPlanEquipParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(workPlanEquipVoTemp,
						workPlanEquipParamVo);
  
				workPlanEquip = workPlanEquipService.saveOrUpdate(
						workPlanEquipVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(workPlanEquip);
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
