package com.techsoft.client.service.struct;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.StructWorkCalendar;
import com.techsoft.entity.struct.StructWorkCalendarVo;
import com.techsoft.entity.struct.StructWorkCalendarParamVo;

public interface ClientStructWorkCalendarService extends BaseClientService<StructWorkCalendar> {
	
	public StructWorkCalendarVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructWorkCalendarVo>  selectListVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructWorkCalendarVo>  selectPageVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public StructWorkCalendarVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;
	
	public List<StructWorkCalendarVo>  selectListExtendVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam) throws BusinessException, SQLException;
	
	public PageInfo<StructWorkCalendarVo>  selectPageExtendVoByParamVo(StructWorkCalendarParamVo structWorkCalendar, CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;
	
	public ResultMessage saveOrUpdate(StructWorkCalendarParamVo structWorkCalendarParamVo, CommonParam commonParam);		
}
