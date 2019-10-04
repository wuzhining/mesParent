package com.techsoft.service.warehouse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;

import com.techsoft.entity.common.WarehousePalletItem;
import com.techsoft.entity.warehouse.WarehousePalletItemParamVo;
import com.techsoft.dao.warehouse.WarehousePalletItemDao;

@Service
public class WarehousePalletItemServiceImpl extends BaseServiceImpl<WarehousePalletItem> implements WarehousePalletItemService {
	@Autowired
	private WarehousePalletItemDao warehousePalletItemDao;
	
	@Override
	public BaseDao<WarehousePalletItem> getBaseDao() {
		return warehousePalletItemDao;
	}	
	
	@Override
	public Class<WarehousePalletItem> getEntityClass() {
		return WarehousePalletItem.class;
	}
	
	@Override
	protected WarehousePalletItem insertEntity(WarehousePalletItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehousePalletItem updatePartEntity(WarehousePalletItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehousePalletItem updateEntity(WarehousePalletItem entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}	
	
	@Override
	public int updateBarcodeMainByBarcode(Map<Object,Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		int barcodeMain = warehousePalletItemDao.updateBarcodeMainByBarcode(map, commonParam);
		int trackBarcode = updateTrackBarcodeByBarcode(map, commonParam);
		int result=0;
		if(barcodeMain>0 && trackBarcode>0){
			result=1;
		}
		return result;
	}

	@Override
	public int updateTrackBarcodeByBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		
		return warehousePalletItemDao.updateTrackBarcodeByBarcode(map, commonParam);
	}
}
