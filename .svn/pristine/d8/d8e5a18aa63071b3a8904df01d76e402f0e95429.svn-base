package com.techsoft.mapper.track;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.track.TrackBarcodeParamVo;

public interface TrackBarcodeMapper extends BaseMapper<TrackBarcode> {

	public int insertBatchSn(List<TrackBarcode> listsns);
	
	public int updateBatchTrack(List<TrackBarcode> list);
	
	public List<TrackBarcode> selectSumQtyByCondition(TrackBarcodeParamVo paramVo) throws BusinessException, SQLException;
}
