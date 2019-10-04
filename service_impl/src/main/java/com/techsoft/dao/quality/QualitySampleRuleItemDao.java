package com.techsoft.dao.quality;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;

public interface QualitySampleRuleItemDao extends BaseDao<QualitySampleRuleItem> {
	
	/**
	 * @author yang
	 * @param sampleRuleItem
	 * @throws BusinessException
	 * @throws SQLException
	 * 批量新增AQL抽样明细
	 */
	public void insertBatch(QualitySampleRuleItemVo qualitySampleRuleItemVo, List<QualitySampleRuleItem> sampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public void updateBatch(QualitySampleRuleItem qualitySampleRuleItemVo, List<QualitySampleRuleItem> sampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException;

}
