package com.techsoft.mapper.track;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.entity.common.TrackBarcodeUnpack;

public interface TrackBarcodeUnpackMapper extends BaseMapper<TrackBarcodeUnpack> {

	public int insertBatchSn(List<TrackBarcodeUnpack> listsns);
	
}
