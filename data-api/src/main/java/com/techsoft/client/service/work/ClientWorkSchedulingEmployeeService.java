package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.WorkSchedulingEmployee;
import com.techsoft.entity.work.WorkSchedulingEmployeeVo;
import com.techsoft.entity.work.WorkSchedulingEmployeeParamVo;

public interface ClientWorkSchedulingEmployeeService extends BaseClientService<WorkSchedulingEmployee> {
	
	public WorkSchedulingEmployeeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkSchedulingEmployeeVo>  selectListVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkSchedulingEmployeeVo>  selectPageVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public WorkSchedulingEmployeeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<WorkSchedulingEmployeeVo>  selectListExtendVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<WorkSchedulingEmployeeVo>  selectPageExtendVoByParamVo(WorkSchedulingEmployeeParamVo workSchedulingEmployee, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(WorkSchedulingEmployeeParamVo workSchedulingEmployeeParamVo, CommonParam commonParam);		
}
