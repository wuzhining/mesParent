package com.techsoft.mapper.warehouse;

import java.util.Map;

import com.techsoft.common.BaseMapper;
import com.techsoft.entity.common.WarehousePalletItem;

public interface WarehousePalletItemMapper extends BaseMapper<WarehousePalletItem> {
	public int updateBarcodeMainByBarcode(Map<Object,Object> map);
	
	public int updateTrackBarcodeByBarcode(Map<Object,Object> map);
}
