package com.techsoft.service.struct;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.StructWorkCalendar;
import com.techsoft.dao.struct.StructWorkCalendarDao;

@Service
public class StructWorkCalendarServiceImpl extends BaseServiceImpl<StructWorkCalendar> implements StructWorkCalendarService {
	@Autowired
	private StructWorkCalendarDao structWorkCalendarDao;
	
	@Override
	public BaseDao<StructWorkCalendar> getBaseDao() {
		return structWorkCalendarDao;
	}	
	
	@Override
	public Class<StructWorkCalendar> getEntityClass() {
		return StructWorkCalendar.class;
	}
	
	@Override
	protected StructWorkCalendar insertEntity(StructWorkCalendar entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWorkCalendar updatePartEntity(StructWorkCalendar entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWorkCalendar updateEntity(StructWorkCalendar entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
