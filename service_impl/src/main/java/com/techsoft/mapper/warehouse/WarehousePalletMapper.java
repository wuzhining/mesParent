package com.techsoft.mapper.warehouse;

import java.util.Map;

import com.techsoft.common.BaseMapper;
import com.techsoft.entity.common.WarehousePallet;

public interface WarehousePalletMapper extends BaseMapper<WarehousePallet> {
	public int updatePallet(Map<Object,Object> map);
	
	public int updateBarcodeMain(Map<Object,Object> map);
	
	public int updateTrackBarcode(Map<Object,Object> map);
	
	public int updatePalletPull(Map<Object,Object> map);
}
