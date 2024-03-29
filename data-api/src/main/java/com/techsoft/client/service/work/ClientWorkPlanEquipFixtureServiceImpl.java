package com.techsoft.client.service.work;

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
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.EquipSpecsFixture;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcedureInstruct;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanEquipFixture;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.work.WorkPlanEquipFixtureVo;
import com.techsoft.entity.work.WorkPlanEquipFixtureParamVo;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureService;
import com.techsoft.service.equip.EquipSpecsFixtureService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcedureInstructService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.work.WorkPlanEquipFixtureService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientWorkPlanEquipFixtureServiceImpl extends BaseClientServiceImpl<WorkPlanEquipFixture> implements ClientWorkPlanEquipFixtureService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanEquipFixtureService workPlanEquipFixtureService;
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
	private EquipFixtureService equipFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructProcedureInstructService structProcedureInstructService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipSpecsFixtureService equipSpecsFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
    
	@Override
	public BaseService<WorkPlanEquipFixture> getBaseService() {
		return workPlanEquipFixtureService;
	}	    	
    
	private WorkPlanEquipFixtureVo getVo(WorkPlanEquipFixture workPlanEquipFixture, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipFixtureVo vo = new WorkPlanEquipFixtureVo(workPlanEquipFixture);
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
		if (vo.getEquipFixtureId() != null && vo.getEquipFixtureId() > 0L) {
			EquipFixture equipFixture=equipFixtureService.selectById(vo.getEquipFixtureId(), commonParam);
			if (equipFixture != null) {
				vo.setEquipFixture(equipFixture);
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
		if (vo.getEquipSpecsFixtureId() != null && vo.getEquipSpecsFixtureId() > 0L) {
			EquipSpecsFixture equipSpecsFixture=equipSpecsFixtureService.selectById(vo.getEquipSpecsFixtureId(), commonParam);
			if (equipSpecsFixture != null) {
				vo.setEquipSpecsFixture(equipSpecsFixture);
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
	
	private WorkPlanEquipFixtureVo getExtendVo(WorkPlanEquipFixture workPlanEquipFixture, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipFixtureVo vo = this.getVo(workPlanEquipFixture, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WorkPlanEquipFixtureVo> getVoList(List<WorkPlanEquipFixture> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanEquipFixtureVo> voList = new ArrayList<WorkPlanEquipFixtureVo>();
		for (WorkPlanEquipFixture entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WorkPlanEquipFixtureVo> getExtendVoList(List<WorkPlanEquipFixture> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanEquipFixtureVo> voList = new ArrayList<WorkPlanEquipFixtureVo>();
		for (WorkPlanEquipFixture entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WorkPlanEquipFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipFixture entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WorkPlanEquipFixtureVo>  selectListVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam) throws BusinessException, SQLException {
		if(workPlanEquipFixture==null){
			workPlanEquipFixture = new WorkPlanEquipFixtureParamVo();
		}
		workPlanEquipFixture.setTenantId(commonParam.getTenantId());	
	
		List<WorkPlanEquipFixture> list = (List<WorkPlanEquipFixture>) this.getBaseService().selectListByParamVo(workPlanEquipFixture, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanEquipFixtureVo> selectPageVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanEquipFixture==null){
			workPlanEquipFixture = new WorkPlanEquipFixtureParamVo();
		}
		workPlanEquipFixture.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanEquipFixture> list  = (PageInfo<WorkPlanEquipFixture>) this.getBaseService().selectPageByParamVo(workPlanEquipFixture, commonParam, pageNo, pageSize);
		List<WorkPlanEquipFixtureVo> volist = new ArrayList<WorkPlanEquipFixtureVo>();
		
		Iterator<WorkPlanEquipFixture> iter = list.getList().iterator();
		WorkPlanEquipFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanEquipFixtureVo> vpage = new Page<WorkPlanEquipFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WorkPlanEquipFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanEquipFixture entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WorkPlanEquipFixtureVo>  selectListExtendVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(workPlanEquipFixture==null){
			workPlanEquipFixture = new WorkPlanEquipFixtureParamVo();
		}
		workPlanEquipFixture.setTenantId(commonParam.getTenantId());	
					
		List<WorkPlanEquipFixture> list = (List<WorkPlanEquipFixture>) this.getBaseService().selectListByParamVo(workPlanEquipFixture, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanEquipFixtureVo> selectPageExtendVoByParamVo(WorkPlanEquipFixtureParamVo workPlanEquipFixture, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanEquipFixture==null){
			workPlanEquipFixture = new WorkPlanEquipFixtureParamVo();
		}
		workPlanEquipFixture.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanEquipFixture> list  = (PageInfo<WorkPlanEquipFixture>) this.getBaseService().selectPageByParamVo(workPlanEquipFixture, commonParam, pageNo, pageSize);
		List<WorkPlanEquipFixtureVo> volist = new ArrayList<WorkPlanEquipFixtureVo>();
		
		Iterator<WorkPlanEquipFixture> iter = list.getList().iterator();
		WorkPlanEquipFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanEquipFixtureVo> vpage = new Page<WorkPlanEquipFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WorkPlanEquipFixtureParamVo workPlanEquipFixtureParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WorkPlanEquipFixture workPlanEquipFixture = null;
		try {
			if (workPlanEquipFixtureParamVo.getId() == null) {//新增
			 
				workPlanEquipFixtureParamVo.setTenantId(commonParam.getTenantId());
				workPlanEquipFixture = workPlanEquipFixtureService.saveOrUpdate(workPlanEquipFixtureParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WorkPlanEquipFixture workPlanEquipFixtureVoTemp = this.selectById(workPlanEquipFixtureParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(workPlanEquipFixtureVoTemp,
						workPlanEquipFixtureParamVo);
  
				workPlanEquipFixture = workPlanEquipFixtureService.saveOrUpdate(
						workPlanEquipFixtureVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(workPlanEquipFixture);
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
