package com.techsoft.service.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.warehouse.WarehousePalletDao;
import com.techsoft.entity.common.WarehousePallet;

@Service
public class WarehousePalletServiceImpl extends BaseServiceImpl<WarehousePallet> implements WarehousePalletService {
	@Autowired
	private WarehousePalletDao warehousePalletDao;
	
	@Override
	public BaseDao<WarehousePallet> getBaseDao() {
		return warehousePalletDao;
	}	
	
	@Override
	public Class<WarehousePallet> getEntityClass() {
		return WarehousePallet.class;
	}
	
	@Override
	protected WarehousePallet insertEntity(WarehousePallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehousePallet updatePartEntity(WarehousePallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehousePallet updateEntity(WarehousePallet entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public int updatePallet(List<Map> list, CommonParam commonParam) throws BusinessException, SQLException {
		Map<Object,Object> joinPallet = new HashMap<Object,Object>();
		Map<Object,Object> waitJoinPallet = new HashMap<Object,Object>();
		Map<Object,Object> barcode = new HashMap<Object,Object>();
		Map<Object,Object> trackBarcode = new HashMap<Object,Object>();
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				joinPallet.put("id", list.get(i).get("id"));
				joinPallet.put("quantityPackbox", list.get(i).get("quantityPackbox"));
				joinPallet.put("quantitySn", list.get(i).get("quantitySn"));
				joinPallet.put("isValid", list.get(i).get("isValid"));
				joinPallet.put("palletStatusDictId", list.get(i).get("palletStatusDictId"));
			}else if(i==1){
				waitJoinPallet.put("id", list.get(i).get("id"));
				waitJoinPallet.put("quantityPackbox", list.get(i).get("quantityPackbox"));
				waitJoinPallet.put("quantitySn", list.get(i).get("quantitySn"));
				waitJoinPallet.put("isValid", list.get(i).get("isValid"));
				waitJoinPallet.put("palletStatusDictId", list.get(i).get("palletStatusDictId"));
			}else if(i==2) {
				barcode.put("palletId", list.get(i).get("palletId"));
				barcode.put("quantity", list.get(i).get("quantity"));
			}else{
				trackBarcode.put("palletId", list.get(i).get("palletId"));
				trackBarcode.put("quantity", list.get(i).get("quantity"));
			}
		}
		int result=0;
		int pallet= warehousePalletDao.updatePallet(joinPallet, commonParam);
		int waitPl= warehousePalletDao.updatePallet(waitJoinPallet, commonParam);
		int barcd= warehousePalletDao.updateBarcodeMain(barcode, commonParam);
		int track= warehousePalletDao.updateTrackBarcode(trackBarcode, commonParam);
		if(pallet>0 && waitPl>0 && barcd>0 && track>0){
			result=1;
		}
		return result;
	}

	@Override
	public int updateBarcodeMain(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		//条码主表改变
		return warehousePalletDao.updateBarcodeMain(map, commonParam);
	}

	@Override
	public int updateTrackBarcode(Map<Object, Object> map, CommonParam commonParam)
			throws BusinessException, SQLException {
		//条码追踪
		return warehousePalletDao.updateTrackBarcode(map, commonParam);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updatePalletPull(List<Map> list, CommonParam commonParam) throws BusinessException, SQLException {
		WarehousePallet warehousePallet = new WarehousePallet();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			if(i == 0){
				warehousePallet.setIsValid(list.get(i).get("isValid")+"");
				warehousePallet.setPalletCode(list.get(i).get("palletCode")+"");
				warehousePallet.setFactoryId(Long.parseLong(list.get(i).get("factoryId")+""));
				warehousePallet.setPalletStatusDictId(Long.parseLong(list.get(i).get("palletStatusDictId")+""));
				warehousePallet.setProductId(Long.parseLong(list.get(i).get("productId")+""));
				if(list.get(i).get("quantityPackbox") != null){
					warehousePallet.setQuantityPackbox(Integer.parseInt(list.get(i).get("quantityPackbox")+""));
				}
				if(list.get(i).get("quantitySn") !=null){
					warehousePallet.setQuantitySn(Integer.parseInt(list.get(i).get("quantitySn")+""));
				}
				warehousePallet.setRemark(list.get(i).get("remark")+"");
				warehousePallet.setWarehouseId(Long.parseLong(list.get(i).get("warehouseId")+""));
				warehousePallet.setTenantId(Long.parseLong(list.get(i).get("tenantId")+""));
				warehousePallet.setModifyUserId(Long.parseLong(list.get(i).get("modifyUserId")+""));
			}
		}
		WarehousePallet insertPallet = warehousePalletDao.insertEntity(warehousePallet, commonParam);//生成新栈板
		Map<Object,Object> Pallet = new HashMap<Object,Object>();
		if(list.size()>0){
		Pallet=list.get(1);
		int updatePalletPull = warehousePalletDao.updatePalletPull(Pallet, commonParam);//原栈板数量等相应减少
		Pallet.clear();
		
		Pallet = list.get(2);//条码主表
		int barcd = warehousePalletDao.updateBarcodeMain(Pallet, commonParam);
		Pallet.clear();
		
		Pallet = list.get(3);//条码追踪
		int  track = warehousePalletDao.updateTrackBarcode(Pallet, commonParam);
		
		
		if(insertPallet != null && updatePalletPull >0 && barcd >0 && track >0) {
			result =1;
		}
		}else{
			throw new BusinessException("请先采集栈板");
		}
		return result;
	}					
}
