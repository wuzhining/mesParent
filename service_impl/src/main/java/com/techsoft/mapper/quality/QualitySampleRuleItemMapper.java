package com.techsoft.mapper.quality;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.common.WarehouseLocation;

public interface QualitySampleRuleItemMapper extends BaseMapper<QualitySampleRuleItem> {
	//批量新增AQL明细
	public int insertBatch(List<QualitySampleRuleItem> sampleRuleItem);
	
	//批量修改AQL明细
	public int updateBatch(List<QualitySampleRuleItem> sampleRuleItem);
}
