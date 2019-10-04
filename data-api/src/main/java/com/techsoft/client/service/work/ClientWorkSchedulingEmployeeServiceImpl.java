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

import com.techsoft.entity.common.WorkSchedulingEmployee;
import com.techsoft.entity.work.WorkSchedulingEmployeeVo;
import com.techsoft.entity.work.WorkSchedulingEmployeeParamVo;
import com.techsoft.service.work.WorkSchedulingEmployeeService;

@org.springframework.stereotype.Service
public class ClientWorkSchedulingEmployeeServiceImpl extends BaseClientServiceImpl<WorkSchedulingEmployee> implements ClientWorkSchedulingEmployeeService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WorkSchedulingEmployeeService workSchedulingEmployeeService;
    
	@Override
	public BaseService<WorkSchedulingEmployee> getBaseService() {
		return workSchedulingEmployeeService;
	}	    	
    
	private WorkSchedulingEmployeeVo getVo(WorkSchedulingEmployee workSchedulingEmployee, CommonParam commonParam) throws BusinessException, SQLException {
		WorkSchedulingEmployeeVo vo = new WorkSchedulingEmployeeVo(workSchedulingEmployee);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
	
	private WorkSchedulingEmployeeVo getExtendVo(WorkSchedulingEmployee workSchedulingEmployee, CommonParam commonParam) throws BusinessException, SQLException {
		WorkSchedulingEmployeeVo vo = this.getVo(workSchedulingEmployee, commonParam);
		// TODO 此处填充其它关联字段的处理代码
		return vo;
	} 
		
	private List<WorkSchedulingEmployeeVo> getVoList(List<WorkSchedulingEmployee> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkSchedulingEmployeeVo> voList = new ArrayList<WorkSchedulingEmployeeVo>();
		for (WorkSchedulingEmployee entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	private List<WorkSchedulingEmployeeVo> getExtendVoList(List<WorkSchedulingEmployee> list, CommonParam commonParam) throws BusinessException, SQLException {
		List<WorkSchedulingEmployeeVo> voList = new ArrayList<WorkSchedulingEmployeeVo>();
		for (WorkSchedulingEmployee entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}
		
		return voList;
	}	
	
	public WorkSchedulingEmployeeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkSchedulingEmployee entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getVo(entity, commonParam);
	}
	
	public List<WorkSchedulingEmployeeVo>  selectListVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam) throws BusinessException, SQLException {
		if(workSchedulingEmployee==null){
			workSchedulingEmployee = new WorkSchedulingEmployeeParamVo();
		}
		workSchedulingEmployee.setTenantId(commonParam.getTenantId());	
	
		List<WorkSchedulingEmployee> list = (List<WorkSchedulingEmployee>) this.getBaseService().selectListByParamVo(workSchedulingEmployee, commonParam);
		
		return getVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkSchedulingEmployeeVo> selectPageVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workSchedulingEmployee==null){
			workSchedulingEmployee = new WorkSchedulingEmployeeParamVo();
		}
		workSchedulingEmployee.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkSchedulingEmployee> list  = (PageInfo<WorkSchedulingEmployee>) this.getBaseService().selectPageByParamVo(workSchedulingEmployee, commonParam, pageNo, pageSize);
		List<WorkSchedulingEmployeeVo> volist = new ArrayList<WorkSchedulingEmployeeVo>();
		
		Iterator<WorkSchedulingEmployee> iter = list.getList().iterator();
		WorkSchedulingEmployeeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkSchedulingEmployeeVo> vpage = new Page<WorkSchedulingEmployeeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public WorkSchedulingEmployeeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WorkSchedulingEmployee entity = this.getBaseService().selectById(id, commonParam);
		
		return this.getExtendVo(entity, commonParam);
	}
	
	public List<WorkSchedulingEmployeeVo>  selectListExtendVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam) 
			throws BusinessException, SQLException {
		if(workSchedulingEmployee==null){
			workSchedulingEmployee = new WorkSchedulingEmployeeParamVo();
		}
		workSchedulingEmployee.setTenantId(commonParam.getTenantId());	
					
		List<WorkSchedulingEmployee> list = (List<WorkSchedulingEmployee>) this.getBaseService().selectListByParamVo(workSchedulingEmployee, commonParam);
		
		return this.getExtendVoList(list, commonParam);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	public PageInfo<WorkSchedulingEmployeeVo> selectPageExtendVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam, int pageNo, int pageSize) 
			throws BusinessException, SQLException {
		if(workSchedulingEmployee==null){
			workSchedulingEmployee = new WorkSchedulingEmployeeParamVo();
		}
		workSchedulingEmployee.setTenantId(commonParam.getTenantId());	
					
		PageInfo<WorkSchedulingEmployee> list  = (PageInfo<WorkSchedulingEmployee>) this.getBaseService().selectPageByParamVo(workSchedulingEmployee, commonParam, pageNo, pageSize);
		List<WorkSchedulingEmployeeVo> volist = new ArrayList<WorkSchedulingEmployeeVo>();
		
		Iterator<WorkSchedulingEmployee> iter = list.getList().iterator();
		WorkSchedulingEmployeeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}
		
		Page<WorkSchedulingEmployeeVo> vpage = new Page<WorkSchedulingEmployeeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());
		
		return new PageInfo(vpage);
	}	
	
	public ResultMessage saveOrUpdate(WorkSchedulingEmployeeParamVo workSchedulingEmployeeParamVo, CommonParam commonParam) { 
		ResultMessage resultMessage = new ResultMessage(); 
		WorkSchedulingEmployee workSchedulingEmployee = null;
		try {
			if (workSchedulingEmployeeParamVo.getId() == null) {//新增
			 
				workSchedulingEmployeeParamVo.setTenantId(commonParam.getTenantId());
				workSchedulingEmployee = workSchedulingEmployeeService.saveOrUpdate(workSchedulingEmployeeParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else {  //修改
				WorkSchedulingEmployee workSchedulingEmployeeVoTemp = this.selectById(workSchedulingEmployeeParamVo
						.getId(), commonParam);

				BeanUtil.copyNotNullProperties(workSchedulingEmployeeVoTemp,
						workSchedulingEmployeeParamVo);
  
				workSchedulingEmployee = workSchedulingEmployeeService.saveOrUpdate(
						workSchedulingEmployeeVoTemp, commonParam); 
  
				resultMessage.setIsSuccess(true);
			}
			
			resultMessage.setBaseEntity(workSchedulingEmployee);
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
