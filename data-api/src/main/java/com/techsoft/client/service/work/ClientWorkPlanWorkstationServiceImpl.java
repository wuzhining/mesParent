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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.WorkPlanWorkstation;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.work.WorkPlanWorkstationVo;
import com.techsoft.entity.work.WorkPlanWorkstationParamVo;
import com.techsoft.service.bill.BillWorkorderService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructProcessNodeService;
import com.techsoft.service.struct.StructWorkshopAreaService;
import com.techsoft.service.struct.StructWorkshopService;
import com.techsoft.service.struct.StructWorkstationService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.work.WorkPlanWorkstationService;
import com.techsoft.service.work.WorkTaskProcedureService;

@org.springframework.stereotype.Service
public class ClientWorkPlanWorkstationServiceImpl extends BaseClientServiceImpl<WorkPlanWorkstation> implements ClientWorkPlanWorkstationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkPlanWorkstationService workPlanWorkstationService;
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
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkshopAreaService structWorkshopAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWorkstationService structWorkstationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	@Override
	public BaseService<WorkPlanWorkstation> getBaseService() {
		return workPlanWorkstationService;
	}	    	
    
	private WorkPlanWorkstationVo getVo(WorkPlanWorkstation workPlanWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanWorkstationVo vo = new WorkPlanWorkstationVo(workPlanWorkstation);
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
		if (vo.getPlanStatusDictId() != null && vo.getPlanStatusDictId() > 0L) {
			ConfigDictionary planStatusDic=configDictionaryService.selectById(vo.getPlanStatusDictId(), commonParam);
			if (planStatusDic != null) {
				vo.setPlanStatusDic(planStatusDic);
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
	
	private WorkPlanWorkstationVo getExtendVo(WorkPlanWorkstation workPlanWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanWorkstationVo vo = this.getVo(workPlanWorkstation, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WorkPlanWorkstationVo> getVoList(List<WorkPlanWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanWorkstationVo> voList = new ArrayList<WorkPlanWorkstationVo>();
		for (WorkPlanWorkstation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WorkPlanWorkstationVo> getExtendVoList(List<WorkPlanWorkstation> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkPlanWorkstationVo> voList = new ArrayList<WorkPlanWorkstationVo>();
		for (WorkPlanWorkstation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WorkPlanWorkstationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WorkPlanWorkstationVo>  selectListVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam) throws BusinessException, SQLException {
		if(workPlanWorkstation==null){
			workPlanWorkstation = new WorkPlanWorkstationParamVo();
		}
		workPlanWorkstation.setTenantId(commonParam.getTenantId());	
	
		List<WorkPlanWorkstation> list = (List<WorkPlanWorkstation>) this.getBaseService().selectListByParamVo(workPlanWorkstation, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanWorkstationVo> selectPageVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanWorkstation==null){
			workPlanWorkstation = new WorkPlanWorkstationParamVo();
		}
		workPlanWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanWorkstation> list  = (PageInfo<WorkPlanWorkstation>) this.getBaseService().selectPageByParamVo(workPlanWorkstation, commonParam, pageNo, pageSize);
		List<WorkPlanWorkstationVo> volist = new ArrayList<WorkPlanWorkstationVo>();
		
		Iterator<WorkPlanWorkstation> iter = list.getList().iterator();
		WorkPlanWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanWorkstationVo> vpage = new Page<WorkPlanWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WorkPlanWorkstationVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkPlanWorkstation entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WorkPlanWorkstationVo>  selectListExtendVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(workPlanWorkstation==null){
			workPlanWorkstation = new WorkPlanWorkstationParamVo();
		}
		workPlanWorkstation.setTenantId(commonParam.getTenantId());	
					
		List<WorkPlanWorkstation> list = (List<WorkPlanWorkstation>) this.getBaseService().selectListByParamVo(workPlanWorkstation, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkPlanWorkstationVo> selectPageExtendVoByParamVo(WorkPlanWorkstationParamVo workPlanWorkstation, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workPlanWorkstation==null){
			workPlanWorkstation = new WorkPlanWorkstationParamVo();
		}
		workPlanWorkstation.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkPlanWorkstation> list  = (PageInfo<WorkPlanWorkstation>) this.getBaseService().selectPageByParamVo(workPlanWorkstation, commonParam, pageNo, pageSize);
		List<WorkPlanWorkstationVo> volist = new ArrayList<WorkPlanWorkstationVo>();
		
		Iterator<WorkPlanWorkstation> iter = list.getList().iterator();
		WorkPlanWorkstationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkPlanWorkstationVo> vpage = new Page<WorkPlanWorkstationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WorkPlanWorkstationParamVo workPlanWorkstationParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WorkPlanWorkstation workPlanWorkstation = null;
		try {
			if (workPlanWorkstationParamVo.getId() == null) {//新增
			 
				workPlanWorkstationParamVo.setTenantId(commonParam.getTenantId());
				workPlanWorkstation = workPlanWorkstationService.saveOrUpdate(workPlanWorkstationParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WorkPlanWorkstation workPlanWorkstationVoTemp = this.selectById(workPlanWorkstationParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(workPlanWorkstationVoTemp,
						workPlanWorkstationParamVo);
  
				workPlanWorkstation = workPlanWorkstationService.saveOrUpdate(
						workPlanWorkstationVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(workPlanWorkstation);
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
