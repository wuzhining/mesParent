package com.techsoft.mapper.barcode;

import java.util.List;

import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.BarcodeMain;

public interface BarcodeMainMapper extends BaseMapper<BarcodeMain> {
	public int insertPrintBarcodeMain(List<BarcodeMain> barcodeMainList) throws BusinessException, SQLException;

	public int updateBatch(List<BarcodeMain> list);

	public Double selectSumQtyByEntity(BarcodeMainParamVo paramVo);

	public BarcodeMain selectByBarCode(String barCode);
	
	public List<BarcodeMainVo> selectSumQtyByCondition(BarcodeMainParamVo paramVo) throws BusinessException, SQLException;
}
