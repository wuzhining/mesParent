package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoiWindow;
import com.techsoft.mapper.scada.ScadaAoiWindowMapper;

@Repository
public class ScadaAoiWindowDaoImpl extends BaseDaoImpl<ScadaAoiWindow> implements ScadaAoiWindowDao {
	@Resource
	protected ScadaAoiWindowMapper scadaAoiWindowMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoiWindow> getEntityClass() {
		return ScadaAoiWindow.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoiWindow> getBaseMapper() {
		return this.scadaAoiWindowMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI_WINDOW";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoiWindow value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoiWindow value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoiWindow value) throws BusinessException, SQLException {
	
	}
			
}
