package com.techsoft.dao.firm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.firm.FirmEmployeeParamVo;
import com.techsoft.mapper.firm.FirmEmployeeMapper;
import com.techsoft.mapper.sys.MycatSequenceMapper;

@Repository
public class FirmEmployeeDaoImpl extends BaseDaoImpl<FirmEmployee> implements FirmEmployeeDao {
	@Resource
	protected FirmEmployeeMapper firmEmployeeMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<FirmEmployee> getEntityClass() {
		return FirmEmployee.class;
	}	
	
	@Override
	public BaseMapper<FirmEmployee> getBaseMapper() {
		return this.firmEmployeeMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "FIRM_EMPLOYEE";
	}
	
	@Override
	public void insertSaveCheck(FirmEmployee value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(FirmEmployee value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(FirmEmployee value) throws BusinessException, SQLException {
	
	}

	@Override
	public FirmEmployee getByUserId(Long userId) throws SQLException {
		if (userId==null) {
			return null;
		}
		FirmEmployeeParamVo firmEmployee = new FirmEmployeeParamVo();
		firmEmployee.setUserId(userId);
		List<FirmEmployee> list = (List<FirmEmployee>) selectListByParamVo(firmEmployee);
		if ((list != null) && (!list.isEmpty())) {
			return list.get(0);
		}
		return null;
	}
			
}
