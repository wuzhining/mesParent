package com.techsoft.service.struct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.struct.StructWorkstationDao;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.struct.StructWorkstationParamVo;

@Service
public class StructWorkstationServiceImpl extends BaseServiceImpl<StructWorkstation> implements StructWorkstationService {
	@Autowired
	private StructWorkstationDao structWorkstationDao;
	
	@Override
	public BaseDao<StructWorkstation> getBaseDao() {
		return structWorkstationDao;
	}	
	
	@Override
	public Class<StructWorkstation> getEntityClass() {
		return StructWorkstation.class;
	}
	
	@Override
	protected StructWorkstation insertEntity(StructWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructWorkstation updatePartEntity(StructWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructWorkstation updateEntity(StructWorkstation entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public StructWorkstation getByCode(String workstationCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWorkstation> list = new ArrayList<StructWorkstation>();
		StructWorkstationParamVo param = new StructWorkstationParamVo();
		param.setTenantId(commonParam.getTenantId()); 
		param.setWorkstationCode(workstationCode);
		list = structWorkstationDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}					
}
