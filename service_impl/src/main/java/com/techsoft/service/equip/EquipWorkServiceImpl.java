package com.techsoft.service.equip;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.equip.EquipWorkDao;
import com.techsoft.entity.common.EquipWork;
import com.techsoft.entity.equip.EquipWorkParamVo;

@Service
public class EquipWorkServiceImpl extends BaseServiceImpl<EquipWork> implements EquipWorkService {
	@Autowired
	private EquipWorkDao equipWorkDao;
	
	@Override
	public BaseDao<EquipWork> getBaseDao() {
		return equipWorkDao;
	}	
	
	@Override
	public Class<EquipWork> getEntityClass() {
		return EquipWork.class;
	}
	
	@Override
	protected EquipWork insertEntity(EquipWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipWork updatePartEntity(EquipWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipWork updateEntity(EquipWork entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public EquipWork getByEquipCode( String equipCode, CommonParam commonParam) throws BusinessException, SQLException {
		List<EquipWork> list = new ArrayList<EquipWork>();
		EquipWorkParamVo param = new EquipWorkParamVo();
		param.setTenantId(commonParam.getTenantId()); 
		param.setEquipCode(equipCode);
		list = equipWorkDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public EquipWork getByMacaddress(String macaddress, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWork> list = new ArrayList<EquipWork>();
		EquipWorkParamVo param = new EquipWorkParamVo();
		param.setTenantId(commonParam.getTenantId()); 
		param.setMacaddress(macaddress);
		list = equipWorkDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}					
}
