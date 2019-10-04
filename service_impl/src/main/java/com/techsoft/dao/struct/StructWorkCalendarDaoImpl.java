package com.techsoft.dao.struct;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.StructWorkCalendar;
import com.techsoft.mapper.struct.StructWorkCalendarMapper;

@Repository
public class StructWorkCalendarDaoImpl extends BaseDaoImpl<StructWorkCalendar> implements StructWorkCalendarDao {
	@Resource
	protected StructWorkCalendarMapper structWorkCalendarMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<StructWorkCalendar> getEntityClass() {
		return StructWorkCalendar.class;
	}	
	
	@Override
	public BaseMapper<StructWorkCalendar> getBaseMapper() {
		return this.structWorkCalendarMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "STRUCT_WORK_CALENDAR";
	}
	
	@Override
	public void insertSaveCheck(StructWorkCalendar value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(StructWorkCalendar value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(StructWorkCalendar value) throws BusinessException, SQLException {
	
	}
			
}
