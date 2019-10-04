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
import com.techsoft.dao.equip.EquipWorkStackDao;
import com.techsoft.entity.common.EquipWorkStack;
import com.techsoft.entity.equip.EquipWorkStackParamVo;

@Service
public class EquipWorkStackServiceImpl extends BaseServiceImpl<EquipWorkStack> implements EquipWorkStackService {
	@Autowired
	private EquipWorkStackDao equipWorkStackDao;

	@Override
	public BaseDao<EquipWorkStack> getBaseDao() {
		return equipWorkStackDao;
	}

	@Override
	public Class<EquipWorkStack> getEntityClass() {
		return EquipWorkStack.class;
	}

	@Override
	protected EquipWorkStack insertEntity(EquipWorkStack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkStack updatePartEntity(EquipWorkStack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected EquipWorkStack updateEntity(EquipWorkStack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public EquipWorkStack getByStackCode(String stackCode, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkStack> list = new ArrayList<EquipWorkStack>();
		EquipWorkStackParamVo param = new EquipWorkStackParamVo();
		param.setTenantId(commonParam.getTenantId());
		param.setEquipStackCode(stackCode);
		list = equipWorkStackDao.selectListByParamVo(param);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
