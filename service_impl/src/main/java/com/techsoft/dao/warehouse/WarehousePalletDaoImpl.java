package com.techsoft.dao.warehouse;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WarehousePallet;
import com.techsoft.mapper.warehouse.WarehousePalletMapper;

@Repository
public class WarehousePalletDaoImpl extends BaseDaoImpl<WarehousePallet> implements WarehousePalletDao {
	@Resource
	protected WarehousePalletMapper warehousePalletMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WarehousePallet> getEntityClass() {
		return WarehousePallet.class;
	}	
	
	@Override
	public BaseMapper<WarehousePallet> getBaseMapper() {
		return this.warehousePalletMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WAREHOUSE_PALLET";
	}
	
	@Override
	public void insertSaveCheck(WarehousePallet value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WarehousePallet value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WarehousePallet value) throws BusinessException, SQLException {
	
	}

	
	public int updatePallet(Map<Object,Object> map, CommonParam commonParam) throws BusinessException, SQLException {
		//合并栈板号数量等改变
		int pallet= warehousePalletMapper.updatePallet(map);
		if(pallet < 1) {
			throw new BusinessException("栈板合并失败");
		}
		return pallet;
	}

	@Override
	public int updateBarcodeMain(Map<Object, Object> map, CommonParam commonParam) throws BusinessException, SQLException {
		//条码主表改变
		int result= warehousePalletMapper.updateBarcodeMain(map);
		if(result <1 ){
			throw new BusinessException("条码主表操作失败");
		}
		return result;
	}

	@Override
	public int updateTrackBarcode(Map<Object, Object> map, CommonParam commonParam) throws BusinessException, SQLException {
		//条码追踪
				int result= warehousePalletMapper.updateTrackBarcode(map);
				if(result <1 ){
					throw new BusinessException("条码追踪操作失败");
				}
		return result;
	}

	@Override
	public int updatePalletPull(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		int result = warehousePalletMapper.updatePalletPull(map);
		if(result < 1) {
			throw new BusinessException("栈板拆除失败");
		}
		return result;
	}
			
}
