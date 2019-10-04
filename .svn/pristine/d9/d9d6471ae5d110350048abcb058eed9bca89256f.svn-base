package com.techsoft.service.quality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.entity.quality.QualitySampleLevelVo;
import com.techsoft.dao.quality.QualitySampleLevelDao;

@Service
public class QualitySampleLevelServiceImpl extends BaseServiceImpl<QualitySampleLevel> implements QualitySampleLevelService {
	@Autowired
	private QualitySampleLevelDao qualitySampleLevelDao;
	
	@Override
	public BaseDao<QualitySampleLevel> getBaseDao() {
		return qualitySampleLevelDao;
	}	
	
	@Override
	public Class<QualitySampleLevel> getEntityClass() {
		return QualitySampleLevel.class;
	}
	
	@Override
	protected QualitySampleLevel insertEntity(QualitySampleLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleLevel updatePartEntity(QualitySampleLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected QualitySampleLevel updateEntity(QualitySampleLevel entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}
	/**
	 *@auther :Yang
	 *@version :2019年7月11日
	 *@param
	 *@return
	 *@description
	 */
	@Override
	public QualitySampleLevel saveBatchInsert(QualitySampleLevelParamVo qualitySampleLevelParamVo,
			CommonParam commonParam, List<QualitySampleLevel> qualitySampleLevelList)
			throws BusinessException, SQLException {
		    qualitySampleLevelDao.insertBatch(qualitySampleLevelParamVo, qualitySampleLevelList, commonParam);
		return null;
	}
	
	
	/**
	 *@auther :Yang
	 *@version :2019年7月12日
	 *@param
	 *@return
	 *@description： 删除表里的数据
	 */
	@Override
	public void deleteQualitySampleLevel() throws BusinessException, SQLException {
		
		qualitySampleLevelDao.deleteQualitySampleLevel();
	}
	/**
	 *@auther :Yang
	 *@version :2019年7月15日
	 *@param
	 *@return
	 *@description
	 */
	@Override
	public List<QualitySampleLevelVo> selectSampleLetter() throws BusinessException, SQLException {
		return qualitySampleLevelDao.selectSampleLetter();
	}
				
}
