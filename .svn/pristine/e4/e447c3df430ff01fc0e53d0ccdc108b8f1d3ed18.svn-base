package com.techsoft.dao.scada;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.ScadaAoiLine;
import com.techsoft.mapper.scada.ScadaAoiLineMapper;

@Repository
public class ScadaAoiLineDaoImpl extends BaseDaoImpl<ScadaAoiLine> implements ScadaAoiLineDao {
	@Resource
	protected ScadaAoiLineMapper scadaAoiLineMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<ScadaAoiLine> getEntityClass() {
		return ScadaAoiLine.class;
	}	
	
	@Override
	public BaseMapper<ScadaAoiLine> getBaseMapper() {
		return this.scadaAoiLineMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "SCADA_AOI_LINE";
	}
	
	@Override
	public void insertSaveCheck(ScadaAoiLine value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(ScadaAoiLine value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(ScadaAoiLine value) throws BusinessException, SQLException {
	
	}
			
}
