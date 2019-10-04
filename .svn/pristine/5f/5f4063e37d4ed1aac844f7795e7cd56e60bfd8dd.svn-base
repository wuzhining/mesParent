package com.techsoft.service.scada;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.ScadaAoiLine;
import com.techsoft.dao.scada.ScadaAoiLineDao;

@Service
public class ScadaAoiLineServiceImpl extends BaseServiceImpl<ScadaAoiLine> implements ScadaAoiLineService {
	@Autowired
	private ScadaAoiLineDao scadaAoiLineDao;
	
	@Override
	public BaseDao<ScadaAoiLine> getBaseDao() {
		return scadaAoiLineDao;
	}	
	
	@Override
	public Class<ScadaAoiLine> getEntityClass() {
		return ScadaAoiLine.class;
	}
	
	@Override
	protected ScadaAoiLine insertEntity(ScadaAoiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiLine updatePartEntity(ScadaAoiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ScadaAoiLine updateEntity(ScadaAoiLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}					
}
