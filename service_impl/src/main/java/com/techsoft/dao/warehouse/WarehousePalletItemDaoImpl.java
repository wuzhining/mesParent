package com.techsoft.dao.warehouse;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.WarehousePalletItem;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.mapper.warehouse.WarehousePalletItemMapper;

@Repository
public class WarehousePalletItemDaoImpl extends BaseDaoImpl<WarehousePalletItem> implements WarehousePalletItemDao {
	@Resource
	protected WarehousePalletItemMapper warehousePalletItemMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehousePalletItem> getEntityClass() {
		return WarehousePalletItem.class;
	}	
	
	@Override
	public BaseMapper<WarehousePalletItem> getBaseMapper() {
		return this.warehousePalletItemMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_PALLET_ITEM";
	}
	
	@Override
	public void insertSaveCheck(WarehousePalletItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehousePalletItem value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehousePalletItem value) throws BusinessException, SQLException {
	
	}
		
	@Override
	public int updateBarcodeMainByBarcode(Map<Object,Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		int result=0;
		
		try {
			result= warehousePalletItemMapper.updateBarcodeMainByBarcode(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	@Override
	public int updateTrackBarcodeByBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		
		return warehousePalletItemMapper.updateTrackBarcodeByBarcode(map);
	}
}
